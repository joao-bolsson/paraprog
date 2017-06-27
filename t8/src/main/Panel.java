package main;

import java.awt.BorderLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author João Bolsson (joaobolsson@animati.com.br)
 * @since 2017, 06 Jun.
 */
public class Panel extends JPanel {

    private JTable table;

    private final TableModel model;

    private final JPanel panelTable;

    /**
     * Default construct to build the main panel to edit a person.
     *
     * @param tableModel Table model that this panel will be associated.
     */
    public Panel(final TableModel tableModel) {
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

    private void prepareToEdit(final int row) {
        Object valueAt = table.getValueAt(row, TableModel.INDEX_FIELD);
        if (valueAt instanceof Person) {
            MainPanel.getInstance().editPerson((Field) valueAt);
        }
    }

    private JComponent createTable() {
        table = new JTable(model);

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(final ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) { // cada clique na tabela chama esse método duas vezes
                    prepareToEdit(table.getSelectedRow());
                }
            }
        });

        return table;
    }
}
