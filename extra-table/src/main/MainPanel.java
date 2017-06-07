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

    public MainPanel() {
        super(new BorderLayout());
        iniComp();
    }

    private void iniComp() {
        List<Person> initialList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            initialList.add(new Person("João " + i, "Telefone " + i, i));
        }

        PersonTableModel personTableModel = new PersonTableModel(initialList);

        add(new PersonEditPanel(personTableModel), BorderLayout.NORTH);

        add(new PersonPanel(personTableModel), BorderLayout.CENTER);
    }
}
