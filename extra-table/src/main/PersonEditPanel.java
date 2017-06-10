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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author João Bolsson (joaobolsson@animati.com.br)
 * @since 2017, 06 Jun.
 */
public class PersonEditPanel extends JPanel {

    private static final int PERSON_TO_ADD = -1;

    private final PersonTableModel tableModel;

    private static final int PADDING = 20;

    private final JTextField txtName, txtPhone, txtAge;

    private final JButton btnApply, btnReset;

    private int selectedRow = PERSON_TO_ADD;

    /**
     * Default construct to build the edit person panel.
     *
     * @param tableModel Refenced table model.
     */
    public PersonEditPanel(final PersonTableModel tableModel) {
        super(new BorderLayout());

        txtName = new JTextField(20);
        txtName.setLayout(new BorderLayout());
        txtName.add(new JLabel("Nome: "), BorderLayout.WEST);
        txtName.setHorizontalAlignment(SwingConstants.RIGHT);

        txtPhone = new JTextField(20);
        txtPhone.setLayout(new BorderLayout());
        txtPhone.add(new JLabel("Telefone: "), BorderLayout.WEST);
        txtPhone.setHorizontalAlignment(SwingConstants.RIGHT);

        txtAge = new JTextField(20);
        txtAge.setLayout(new BorderLayout());
        txtAge.add(new JLabel("Idade: "), BorderLayout.WEST);
        txtAge.setHorizontalAlignment(SwingConstants.RIGHT);

        btnApply = new JButton("Adicionar", new ImageIcon(PersonEditPanel.class.getResource("../resources/apply.png")));

        btnReset = new JButton("Limpar", new ImageIcon(PersonEditPanel.class.getResource("../resources/cancel.png")));
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                resetPanel();
            }
        });

        this.tableModel = tableModel;
        iniComp();
    }

    private void resetPanel() {
        selectedRow = PERSON_TO_ADD;
        txtAge.setText("");
        txtName.setText("");
        txtPhone.setText("");
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

        rootPanel.add(txtPhone, cons);
        cons.gridy++;

        rootPanel.add(txtAge, cons);

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

    public void prepareToEdit(final Person person, final int row) {
        selectedRow = row;
        txtName.setText(person.getName());
        txtPhone.setText(person.getPhone());
        txtAge.setText(Integer.toString(person.getAge()));
    }

}
