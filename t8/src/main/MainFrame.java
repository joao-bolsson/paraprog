package main;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author João Bolsson (joaobolsson@animati.com.br)
 * @since 2017, 06 Jun.
 */
public class MainFrame {

    private static final Dimension MIN_SIZE = new Dimension(600, 400);

    /**
     * Just initialize the main frame an its components.
     *
     * @param args Command line arguments. (not used here)
     */
    public static void main(final String[] args) {
        JFrame frame = new JFrame("Janela Principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(MainPanel.getInstance());

        frame.setMinimumSize(MIN_SIZE);
        frame.setVisible(true);
    }

}
