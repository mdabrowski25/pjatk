package pl.pjwstk.app.events;

import pl.pjwstk.app.components.main.LoserFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoserInit implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater(LoserFrame::new);
    }
}
