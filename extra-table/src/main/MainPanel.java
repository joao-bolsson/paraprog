package main;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author João Bolsson (joaobolsson@animati.com.br)
 * @since 2017, 06 Jun.
 */
public class MainPanel extends JPanel {

    private static MainPanel INSTANCE;

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

    private PersonEditPanel personEditPanel;

    public void editPerson(final Person person, final int row) {
        personEditPanel.prepareToEdit(person, row);
    }

    private void iniComp() {
        List<Person> initialList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            initialList.add(new Person("João " + i, "Telefone " + i, i, Integer.toString(i)));
        }

        PersonTableModel personTableModel = new PersonTableModel(initialList);

        personEditPanel = new PersonEditPanel(personTableModel);

        add(personEditPanel, BorderLayout.NORTH);

        add(new PersonPanel(personTableModel), BorderLayout.CENTER);
    }
}
