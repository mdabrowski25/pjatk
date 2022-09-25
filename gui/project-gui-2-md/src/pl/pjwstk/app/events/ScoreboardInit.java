package pl.pjwstk.app.events;

import pl.pjwstk.app.components.main.ScoreboardFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScoreboardInit implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater(ScoreboardFrame::new);
    }
}
