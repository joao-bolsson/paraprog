package main;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
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

    private final PersonTableModel tableModel;

    private static final int PADDING = 20;

    private final JTextField txtName, txtPhone, txtAge;

    private final JButton btnApply, btnReset;

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

        btnApply = new JButton("Adicionar");

        btnReset = new JButton("Limpar");

        this.tableModel = tableModel;
        iniComp();
    }

    private void iniComp() {
        setBorder(BorderFactory.createTitledBorder("Painel de Edição"));

        add(buildFieldsPanel(), BorderLayout.NORTH);
    }

    private JPanel buildFieldsPanel() {
        JPanel rootPanel = new JPanel(new GridBagLayout());
        rootPanel.setBorder(BorderFactory.createEtchedBorder());

        GridBagConstraints cons = new GridBagConstraints();
        cons.anchor = GridBagConstraints.NORTH;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.insets = new Insets(PADDING / 2, 0, PADDING / 2, 0);
        cons.gridx = 0;
        cons.gridy = 0;

        rootPanel.add(txtName, cons);
        cons.gridy++;

        rootPanel.add(txtPhone, cons);
        cons.gridy++;

        rootPanel.add(txtAge, cons);

        return rootPanel;
    }

}
