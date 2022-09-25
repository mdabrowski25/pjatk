package pl.pjwstk.app.events;

import pl.pjwstk.app.components.main.GameFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameInit implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater(GameFrame::new);
    }
}
