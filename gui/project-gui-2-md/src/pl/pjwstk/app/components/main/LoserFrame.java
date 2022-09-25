package pl.pjwstk.app.components.main;

import javax.swing.*;
import java.awt.*;

public class LoserFrame extends JFrame {
    public LoserFrame() throws HeadlessException {
        super();
        add(new JLabel("You lost"));
        basicConfig();
    }

    private void basicConfig() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(300, 100);
        setLocationRelativeTo(null);
    }
}
