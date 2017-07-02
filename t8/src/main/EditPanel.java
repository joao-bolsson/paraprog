package main;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileFilter;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author João Bolsson (joaobolsson@animati.com.br)
 * @since 2017, 06 Jun.
 */
public class EditPanel extends JPanel {

    private final TableModel tableModel;

    private static final int PADDING = 20;

    private final JTextField txtLabel, txtID;

    private final JButton btnApply, btnReset, btnExport, btnImport, btnCreate;
    private final FileFilter filterXML;

    private File file, template;

    private static final String NEW_HTML = "index.html";

    /**
     * Default construct to build the edit person panel.
     *
     * @param tableModel Refenced table model.
     */
    public EditPanel(final TableModel tableModel) {
        super(new BorderLayout());

        this.tableModel = tableModel;

        filterXML = new FileFilter() {
            @Override
            public boolean accept(final File f) {
                return f.getName().endsWith(".xml") || f.isDirectory();
            }

            @Override
            public String getDescription() {
                return "XML Files";
            }
        };

        txtLabel = new JTextField(20);
        txtLabel.setLayout(new BorderLayout());
        txtLabel.add(new JLabel("Label: "), BorderLayout.WEST);
        txtLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        txtID = new JTextField(11);
        txtID.setLayout(new BorderLayout());
        txtID.add(new JLabel("ID: "), BorderLayout.WEST);
        txtID.setHorizontalAlignment(SwingConstants.RIGHT);

        btnApply = new JButton("Adicionar", new ImageIcon(EditPanel.class.getResource("../resources/apply.png")));
        btnApply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (txtID.isEnabled()) {
                    String cpf = txtID.getText();
                    if (cpf.isEmpty()) {
                        JOptionPane.showMessageDialog(EditPanel.this, "O campo precisa de um ID.");
                        return;
                    }
                    String id = txtID.getText();
                    Field field = new Field(Field.TYPE.TEXT, id, txtLabel.getText(), id);
                    EditPanel.this.tableModel.add(field);
                    EditPanel.this.tableModel.fireTableRowsInserted(EditPanel.this.tableModel.getRowCount() - 1,
                            EditPanel.this.tableModel.getRowCount());
                    resetPanel();
                } else {
                    // edição
                    String cpf = txtID.getText();
                    Field field = EditPanel.this.tableModel.getPerson(cpf);
                    field.setLabel(txtLabel.getText());
                    EditPanel.this.tableModel.fireTableRowsUpdated(0,
                            EditPanel.this.tableModel.getRowCount());
                    resetPanel();
                }
            }
        });

        btnReset = new JButton("Limpar", new ImageIcon(EditPanel.class.getResource("../resources/cancel.png")));
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                resetPanel();
            }
        });

        btnExport = new JButton("Exportar",
                new ImageIcon(EditPanel.class.getResource("../resources/export.png")));

        btnImport = new JButton("Importar",
                new ImageIcon(EditPanel.class.getResource("../resources/import.png")));

        btnCreate = new JButton("Criar",
                new ImageIcon(EditPanel.class.getResource("../resources/create.png")));

        addExportListener();

        addImportListener();

        addCreateListener();

        iniComp();
    }

    private String getPathToFile() {
        String path = NEW_HTML; // never must keep this value
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(final File f) {
                return f.getName().endsWith(".html") || f.isDirectory();
            }

            @Override
            public String getDescription() {
                return "HTML Files";
            }
        });
        chooser.setDialogTitle("Gerar Arquivo");
        int retorno = chooser.showSaveDialog(EditPanel.this);
        if (retorno == JFileChooser.APPROVE_OPTION) {
            path = chooser.getSelectedFile().getAbsolutePath();
        }
        return path;
    }

    private void createFile() throws IOException, URISyntaxException {
        URL resource = EditPanel.class.getResource("../resources/template.html");
        template = new File(resource.toURI());
        file = new File(getPathToFile());
        FileUtils.copyFile(template, file);
        System.out.print("file created: " + file + "\n");
    }

    private String getSaveFunction() {
        StringBuilder builder = new StringBuilder("function save() {\nvar seq=$('#seq').text();\n");
        builder.append("if ( isNaN(seq) ) { seq=0; }\nvar key=formId+\"_\"+seq;\nvar object={\n");

        List<Field> lines = tableModel.getLines();
        for (Field field : lines) {
            builder.append("\"").append(field.getId()).append("\": $(\"#").append(field.getId()).append("\").val(),\n");
        }
        builder.append("}\nlocalStorage.setItem(key, JSON.stringify(object));\n}\n");
        return builder.toString();
    }

    private String getOnclickTBody() {
        StringBuilder builder = new StringBuilder("$('#table tbody').on( 'click', '.glyphicon-edit', function () {\n");
        builder.append("$('#list').hide();\n");
        builder.append("var rows = $(this).parents('tr').children();\n");
        builder.append("$('#seq').text(rows[0].innerHTML);\n");

        List<Field> lines = tableModel.getLines();
        int i = 0;
        for (Field field : lines) {
            builder.append("$('#").append(field.getId()).append("').val(rows[").append(i + 2).append("].innerHTML);\n");
            i++;
        }
        builder.append("$('#formID').show()\n;} );");

        return builder.toString();
    }

    private String getTableConstruct() {
        StringBuilder builder = new StringBuilder("oTable=$('#table').dataTable({\n");
        builder.append("\"data\": dataSet,\n");
        builder.append("\"columns\": [\n");
        builder.append("{ \"title\": \"Seq\", \"class\": \"center\" },\n");
        builder.append("{ \"title\": \"\", \"class\": \"center\" },\n");

        List<Field> lines = tableModel.getLines();
        for (Field field : lines) {
            builder.append("{ \"title\": \"").append(field.getLabel()).append("\"},\n");
        }

        return builder.toString();
    }

    private String getDataSets() {
        StringBuilder builder = new StringBuilder("dataSet[seq]=[index,icons");
        List<Field> lines = tableModel.getLines();
        for (Field field : lines) {
            builder.append(", object.").append(field.getId());
        }
        builder.append("];\n");
        return builder.toString();
    }

    private String getFields() {
        StringBuilder builder = new StringBuilder();
        List<Field> lines = tableModel.getLines();
        for (Field field : lines) {
            builder.append("<div class=\"form-group\">\n");
            builder.append("<label for=\"").append(field.getId()).append("\" class=\"col-sm-2 control-label\">").append(field.getLabel()).append("</label>\n");
            builder.append("<div class=\"col-sm-6\">\n");
            builder.append("<input type=\"text\" class=\"form-control validate[required]\" id=\"").append(field.getId()).append("\" placeholder=\"").append(field.getLabel()).append("\">\n");
            builder.append("</div>\n");
            builder.append("</div>\n");
        }
        return builder.toString();
    }

    private void addCreateListener() {
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    createFile();

                    BufferedReader br = null;
                    BufferedWriter bw = null;
                    try {
                        br = new BufferedReader(new FileReader(template));
                        bw = new BufferedWriter(new FileWriter(file));
                        String line;
                        while ((line = br.readLine()) != null) {
                            if (line.contains(">>>1<<<")) {
                                line = line.replace(">>>1<<<", "<title>Título (TODO)</title>");
                            } else if (line.contains(">>>2<<<")) {
                                line = line.replace(">>>2<<<", "<h1>Título (TODO)</h1>");
                            } else if (line.contains(">>>3<<<")) {
                                line = line.replace(">>>3<<<", getFields());
                            } else if (line.contains(">>>4<<<")) {
                                line = line.replace(">>>4<<<", getDataSets());
                            } else if (line.contains(">>>5<<<")) {
                                line = line.replace(">>>5<<<", getTableConstruct());
                            } else if (line.contains(">>>6<<<")) {
                                line = line.replace(">>>6<<<", getOnclickTBody());
                            } else if (line.contains(">>>7<<<")) {
                                line = line.replace(">>>7<<<", getSaveFunction());
                            }

                            bw.write(line + "\n");
                        }
                    } catch (final IOException ex) {
                        System.out.println("Error on writing in file: " + ex.getMessage());
                    } finally {
                        try {
                            if (br != null) {
                                br.close();
                            }
                        } catch (final IOException ex) {
                            System.out.println("Error on trying close the file: " + ex.getMessage());
                        }
                        try {
                            if (bw != null) {
                                bw.close();
                            }
                        } catch (final IOException ex) {
                            System.out.println("Error on trying close the file: " + ex.getMessage());
                        }
                    }
                } catch (final IOException | URISyntaxException ex) {
                    System.out.println("Error on create file: " + ex.getMessage());
                }
            }
        });
    }

    private void addImportListener() {
        btnImport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setFileFilter(filterXML);
                chooser.setDialogTitle("Importar Projeto");
                int retorno = chooser.showSaveDialog(EditPanel.this);
                if (retorno == JFileChooser.APPROVE_OPTION) {
                    String path = chooser.getSelectedFile().getAbsolutePath();
                    tableModel.importPreferences(path);
                    // sempre que importar atalhos, reseta o painel de edição
                    resetPanel();
                }
            }
        });
    }

    private void addExportListener() {
        btnExport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                JFileChooser chooser = new JFileChooser() {
                    @Override
                    public void approveSelection() {
                        File file = getSelectedFile();
                        if (!file.getName().endsWith(".xml")) {
                            file = new File(file.getAbsolutePath() + ".xml");
                        }
                        setSelectedFile(file);
                        if (file.exists()) {
                            int confirm = JOptionPane.showConfirmDialog(
                                    getParent(),
                                    file.getName() + " já existe",
                                    "Confirmar",
                                    JOptionPane.YES_NO_OPTION);
                            if (confirm == JOptionPane.YES_OPTION) {
                                super.approveSelection();
                            }
                        } else {
                            super.approveSelection();
                        }
                    }
                };
                chooser.setFileFilter(filterXML);
                chooser.setDialogTitle("Salvar");
                int retorno = chooser.showSaveDialog(EditPanel.this);
                if (retorno == JFileChooser.APPROVE_OPTION) {
                    tableModel.exportProject(chooser.getSelectedFile().getAbsolutePath());
                }
            }
        });

    }

    private void resetPanel() {
        txtID.setText("");
        txtID.setEnabled(true);
        txtLabel.setText("");
        btnApply.setText("Adicionar");
    }

    private void iniComp() {
        setBorder(BorderFactory.createTitledBorder("Painel de Edição"));

        add(buildFieldsPanel(), BorderLayout.NORTH);

        add(buildButtonsPanel(), BorderLayout.CENTER);
    }

    private JPanel buildFieldsPanel() {
        JPanel rootPanel = new JPanel(new GridBagLayout());
        rootPanel.setBorder(BorderFactory.createEtchedBorder());

        GridBagConstraints cons = new GridBagConstraints();
        cons.anchor = GridBagConstraints.NORTH;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.insets = new Insets(PADDING / 2, PADDING, PADDING / 2, PADDING);
        cons.gridx = 0;
        cons.gridy = 0;

        rootPanel.add(txtLabel, cons);

        cons.gridy++;
        rootPanel.add(txtID, cons);

        return rootPanel;
    }

    private JPanel buildButtonsPanel() {
        JPanel rootPanel = new JPanel(new BorderLayout());
        rootPanel.setBorder(BorderFactory.createEtchedBorder());

        JPanel btnPanel = new JPanel(new GridBagLayout());
        GridBagConstraints cons = new GridBagConstraints();
        cons.anchor = GridBagConstraints.NORTH;
        cons.insets = new Insets(PADDING / 2, 0, PADDING / 2, 0);
        cons.gridx = 0;
        cons.gridy = 0;

        btnPanel.add(btnReset, cons);
        cons.gridx++;
        btnPanel.add(btnApply, cons);
        cons.gridx++;
        btnPanel.add(btnExport, cons);
        cons.gridx++;
        btnPanel.add(btnImport, cons);
        cons.gridx++;
        btnPanel.add(btnCreate, cons);

        rootPanel.add(btnPanel, BorderLayout.EAST);

        return rootPanel;
    }

    /**
     * Method called to prepare this panel to edit a field.
     *
     * @param fied Field to edit.
     */
    public void prepareToEdit(final Field fied) {
        txtID.setText(fied.getId());
        txtID.setEnabled(false);
        txtLabel.setText(fied.getLabel());
        btnApply.setText("Editar");
    }

}
