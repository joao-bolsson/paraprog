package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author João Bolsson (joaovictorbolsson@gmail.com)
 * @since 2017, 29 May.
 */
public class InputPanel extends JPanel {

    private final JTextField field;

    private final JButton resetButton;

    private final JLabel lblWinner;

    /**
     * Default construct.
     *
     * The panel with inputs.
     */
    public InputPanel() {
        super(new GridBagLayout());

        field = new JTextField(10);
        resetButton = new JButton("Reset");
        lblWinner = new JLabel("8º Ganhador");
        iniComp();
    }

    private void iniComp() {
        setBorder(BorderFactory.createEtchedBorder());
        final GridBagConstraints cons = new GridBagConstraints();
        cons.gridx = cons.gridy = 0;
        add(new JLabel("Participantes: "), cons);

        cons.gridx++;
        add(field, cons);

        cons.gridx++;
        add(resetButton, cons);

        cons.gridx = cons.gridy = 1;
        add(lblWinner, cons);
    }

}
