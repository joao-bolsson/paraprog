package main;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author João Bolsson (joaobolsson@animati.com.br)
 * @since 2017, 06 Jun.
 */
public class EditPanel extends JPanel {

    private final TableModel tableModel;

    private static final int PADDING = 20;

    private final JTextField txtName, txtID;

    private final JButton btnApply, btnReset;

    /**
     * Default construct to build the edit person panel.
     *
     * @param tableModel Refenced table model.
     */
    public EditPanel(final TableModel tableModel) {
        super(new BorderLayout());

        this.tableModel = tableModel;

        txtName = new JTextField(20);
        txtName.setLayout(new BorderLayout());
        txtName.add(new JLabel("Label: "), BorderLayout.WEST);
        txtName.setHorizontalAlignment(SwingConstants.RIGHT);

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
                    Field field = new Field(Field.TYPE.TEXT, txtName.getText(), "ola", txtID.getText());
                    EditPanel.this.tableModel.add(field);
                    EditPanel.this.tableModel.fireTableRowsInserted(EditPanel.this.tableModel.getRowCount() - 1,
                            EditPanel.this.tableModel.getRowCount());
                    resetPanel();
                } else {
                    // edição
                    String cpf = txtID.getText();
                    Field person = EditPanel.this.tableModel.getPerson(cpf);
                    person.setName(txtName.getText());
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

        iniComp();
    }

    private void resetPanel() {
        txtID.setText("");
        txtID.setEnabled(true);
        txtName.setText("");
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

        rootPanel.add(txtName, cons);

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
        txtName.setText(fied.getName());
        btnApply.setText("Editar");
    }

}
