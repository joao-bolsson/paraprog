package view;

import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author João Bolsson (joaovictorbolsson@gmail.com)
 * @since 2017, 29 May.
 */
public class Viewer extends JPanel {

    private final JLabel lblWinner;

    /**
     * Default construct.
     *
     * The panel with number that indicates the winner.
     */
    public Viewer() {
        super();

        lblWinner = new JLabel("32");
        lblWinner.setFont(new Font("Serif", Font.BOLD, 48));

        iniComp();
    }

    private void iniComp() {
        setBorder(BorderFactory.createEtchedBorder());
        setAlignmentX(Component.CENTER_ALIGNMENT);
        setAlignmentY(Component.CENTER_ALIGNMENT);
        add(lblWinner);
    }

}
