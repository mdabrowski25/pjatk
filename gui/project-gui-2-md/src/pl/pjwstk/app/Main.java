package pl.pjwstk.app;


import pl.pjwstk.app.components.main.AppFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(AppFrame::new);
    }
}
