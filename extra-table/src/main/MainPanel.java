/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author joao
 */
public class MainPanel extends JPanel {

    public MainPanel() {
        super(new BorderLayout());
        iniComp();
    }

    private void iniComp() {
        List<Person> initialList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            initialList.add(new Person("João " + i, "Telefone " + i, i));
        }

        PersonTableModel personTableModel = new PersonTableModel(initialList);
        add(new PersonPanel(personTableModel), BorderLayout.NORTH);
    }
}
