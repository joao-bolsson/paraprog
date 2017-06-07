package main;

import java.awt.BorderLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author João Bolsson (joaobolsson@animati.com.br)
 * @since 2017, 06 Jun.
 */
public class PersonPanel extends JPanel {

    private JTable table;

    private final PersonTableModel model;

    private final JPanel panelTable;

    public PersonPanel(final PersonTableModel tableModel) {
        super(new BorderLayout());
        model = tableModel;
        panelTable = new JPanel(new BorderLayout());
        iniComp();
    }

    private void iniComp() {
        panelTable.add(new JScrollPane(createTable()), BorderLayout.CENTER);
        add(panelTable, BorderLayout.CENTER);

        panelTable.setVisible(true);
    }

    private JComponent createTable() {
        table = new JTable(model);

        return table;
    }
}
