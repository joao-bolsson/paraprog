package main;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author João Bolsson (joaobolsson@animati.com.br)
 * @since 2017, 06 Jun.
 */
public class PersonEditPanel extends JPanel {

    private final PersonTableModel tableModel;

    private static final int PADDING = 20;

    private final JTextField txtName, txtPhone, txtAge;

    /**
     * Default construct to build the edit person panel.
     *
     * @param tableModel Refenced table model.
     */
    public PersonEditPanel(final PersonTableModel tableModel) {
        super(new BorderLayout());

        txtName = new JTextField(20);
        txtPhone = new JTextField(20);
        txtAge = new JTextField(20);

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

        rootPanel.add(new JLabel("Nome: "), cons);
        cons.gridx++;
        rootPanel.add(txtName, cons);
        cons.gridx = 0;
        cons.gridy++;

        rootPanel.add(new JLabel("Telefone: "), cons);
        cons.gridx++;
        rootPanel.add(txtPhone, cons);
        cons.gridx = 0;
        cons.gridy++;

        rootPanel.add(new JLabel("Idade: "), cons);
        cons.gridx++;
        rootPanel.add(txtAge, cons);

        return rootPanel;
    }

}
