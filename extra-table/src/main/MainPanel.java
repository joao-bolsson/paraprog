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
    
    private PersonEditPanel personEditPanel;

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
     * Method that fires the event to edit a Person in edition panel.
     *
     * @param person Person to edit.
     */
    public void editPerson(final Person person) {
        personEditPanel.prepareToEdit(person);
    }

    private void iniComp() {
        PersonTableModel personTableModel = new PersonTableModel();

        personEditPanel = new PersonEditPanel(personTableModel);

        add(personEditPanel, BorderLayout.NORTH);

        add(new PersonPanel(personTableModel), BorderLayout.CENTER);
    }
}
