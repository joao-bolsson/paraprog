package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author João Bolsson (joaovictorbolsson@gmail.com)
 * @since 2017, 29 May.
 */
public class MainPanel extends JPanel {

    /**
     * The main dialog.
     */
    private JDialog dialog;

    /**
     * Best dimension for this panel.
     */
    private static final Dimension DIMENSION = new Dimension(620, 450);

    /**
     * Panel title.
     */
    private static final String TITLE = "Trabalho 7";

    /**
     * Default construct.
     */
    public MainPanel() {
        super(new GridBagLayout());
        iniComp();
    }

    /**
     * Initialize the components inside this panel.
     */
    private void iniComp() {
        setPreferredSize(DIMENSION);
        final GridBagConstraints cons = new GridBagConstraints();
        cons.gridx = cons.gridy = 0;
        cons.fill = GridBagConstraints.BOTH;
        add(new ImagePanel(), cons);

        cons.gridy++;
        add(new InputPanel(), cons);

        cons.gridy++;
        add(new Viewer(), cons);

        cons.gridy++;
        add(new JButton("Sortear"), cons);
    }

    /**
     * Show this panel as a dialog.
     */
    public void showAsDialog() {
        dialog = new JDialog();
        dialog.setTitle(TITLE);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        dialog.setPreferredSize(DIMENSION);
        dialog.setMinimumSize(DIMENSION);
        dialog.setMaximumSize(DIMENSION);

        dialog.add(this);

        dialog.setVisible(true);
    }

}
