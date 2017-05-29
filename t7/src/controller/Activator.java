package controller;

import view.MainPanel;

/**
 *
 * @author João Bolsson (joaovictorbolsson@gmail.com)
 * @since 2017, 29 May.
 */
public class Activator {

    public static void main(String[] args) {
        MainPanel mainPanel = new MainPanel();

        mainPanel.showAsDialog();
    }
}
