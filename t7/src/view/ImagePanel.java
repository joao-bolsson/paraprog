package view;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author João Bolsson (joaovictorbolsson@gmail.com)
 * @since 2017, 29 May.
 */
public class ImagePanel extends JPanel {

    /**
     * Default construct.
     *
     * The panel with header image.
     */
    public ImagePanel() {
        super(new BorderLayout());
        iniComp();
    }

    private void iniComp() {
        setBorder(BorderFactory.createEtchedBorder());
        add(new JLabel(new ImageIcon(ImagePanel.class.getResource("../resource/logo.png"))));
    }

}
