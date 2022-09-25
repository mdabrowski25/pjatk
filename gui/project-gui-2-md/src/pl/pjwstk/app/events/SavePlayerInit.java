package pl.pjwstk.app.events;

import pl.pjwstk.app.components.main.SavePlayerFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SavePlayerInit implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater(SavePlayerFrame::new);
    }
}
