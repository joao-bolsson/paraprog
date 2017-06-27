package main;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author João Bolsson (joaobolsson@animati.com.br)
 * @since 2017, 06 Jun.
 */
public class MainPanel extends JPanel {

    private static MainPanel INSTANCE;
    
    private EditPanel personEditPanel;

    /**
     * Class with singleton pattern.
     *
     * @return The only instance of this class to the all program.
     */
    public static MainPanel getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MainPanel();
        }
        return INSTANCE;
    }

    private MainPanel() {
        super(new BorderLayout());
        iniComp();
    }

    /**
     * Method that fires the event to edit a Field in edition panel.
     *
     * @param field Field to edit.
     */
    public void editPerson(final Field field) {
        personEditPanel.prepareToEdit(field);
    }

    private void iniComp() {
        TableModel personTableModel = new TableModel();

        personEditPanel = new EditPanel(personTableModel);

        add(personEditPanel, BorderLayout.NORTH);

        add(new Panel(personTableModel), BorderLayout.CENTER);
    }
}
