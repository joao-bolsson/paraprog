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
public class PersonPanel extends JPanel {

    private JTable table;

    private final PersonTableModel model;

    private final JPanel panelTable;

    private int rowSelected;

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

    private void prepareToEdit(final int row) {
        Object valueAt = table.getValueAt(row, PersonTableModel.INDEX_PERSON);
        if (valueAt instanceof Person) {
            MainPanel.getInstance().editPerson((Person) valueAt, row);
        }
    }

    private JComponent createTable() {
        table = new JTable(model);

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(final ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) { // cada clique na tabela chama esse método duas vezes
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow >= 0) { // evita ArrayIndexOutOfBounds
                        rowSelected = selectedRow;
                    }
                    prepareToEdit(rowSelected);
                }
            }
        });

        return table;
    }
}
