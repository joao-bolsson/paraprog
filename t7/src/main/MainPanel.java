package main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

    private final JButton resetButton, startButton, sortButton;

    private final JTextField field;

    private final JLabel lblWinner;

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

        resetButton = new JButton("Reset");
        sortButton = new JButton("Sortear");
        startButton = new JButton("Iniciar");
        field = new JTextField(10);
        lblWinner = new JLabel("8º Ganhador");

        // the initial state of panel
        start(false);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                String text = field.getText();
                field.setText("");
                if (text.isEmpty()) {
                    JOptionPane.showMessageDialog(MainPanel.this, "Digite um valor no campo",
                            "Mensagem", JOptionPane.WARNING_MESSAGE);
                } else {
                    try {
                        int intValue = Integer.parseInt(text);
                        start(true);
                    } catch (final NumberFormatException ex) {
                        showError("Somente inteiros maiores que 0");
                    }
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                start(false);
                field.setText("");
            }
        });

        iniComp();
    }

    private void showError(final String text) {
        JOptionPane.showMessageDialog(MainPanel.this, text, "Mensagem", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Change the state of this panel (its buttons).
     *
     * @param flag Reset and sort button state.
     */
    private void start(final boolean flag) {
        resetButton.setEnabled(flag);
        sortButton.setEnabled(flag);
        startButton.setEnabled(!flag);
    }

    /**
     * Initialize the components inside this panel.
     */
    private void iniComp() {
        setPreferredSize(DIMENSION);
        final GridBagConstraints cons = new GridBagConstraints();
        cons.gridx = cons.gridy = 0;
        cons.fill = GridBagConstraints.BOTH;
        add(createImagePanel(), cons);

        cons.gridy++;
        add(createInputPanel(), cons);

        cons.gridy++;
        add(createViewerPanel(), cons);

        cons.gridy++;
        add(sortButton, cons);
    }

    private JPanel createImagePanel() {
        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setBorder(BorderFactory.createEtchedBorder());

        imagePanel.add(new JLabel(new ImageIcon(MainPanel.class.getResource("../resource/logo.png"))));
        return imagePanel;
    }

    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createEtchedBorder());

        final GridBagConstraints cons = new GridBagConstraints();
        cons.gridx = cons.gridy = 0;

        inputPanel.add(new JLabel("Participantes: "), cons);

        cons.gridx++;
        inputPanel.add(field, cons);

        cons.gridx++;
        inputPanel.add(startButton, cons);

        cons.gridx++;
        inputPanel.add(resetButton, cons);

        cons.gridx = cons.gridy = 1;
        inputPanel.add(lblWinner, cons);

        return inputPanel;
    }

    private JPanel createViewerPanel() {
        JPanel viewer = new JPanel();

        JLabel lblWinner = new JLabel("32");
        lblWinner.setFont(new Font("Serif", Font.BOLD, 48));

        viewer.setBorder(BorderFactory.createEtchedBorder());
        viewer.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewer.setAlignmentY(Component.CENTER_ALIGNMENT);
        viewer.add(lblWinner);

        return viewer;
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
