package pl.pjwstk.app.components.main;

import pl.pjwstk.app.events.Exit;
import pl.pjwstk.app.events.GameInit;
import pl.pjwstk.app.events.ScoreboardInit;

import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame {

    public AppFrame() throws HeadlessException {
        super();

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        JButton btn1 = new JButton("New Game");
        JButton btn2 = new JButton("High Scores");
        JButton btn3 = new JButton("Exit");

        addBtnActionListeners(btn1, btn2, btn3);

        gc.fill = GridBagConstraints.BOTH;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weighty = 1;
        gc.weightx = 1;
        gc.gridy = 0;
        addButtonsToLayout(gc, btn1, btn2, btn3);


        basicConfig();
    }

    private void basicConfig() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(300, 100);
        setLocationRelativeTo(null);
    }

    private void addButtonsToLayout(GridBagConstraints gc, JButton btn1, JButton btn2, JButton btn3) {
        gc.gridx = 0;
        add(btn1, gc);
        gc.gridx = 1;
        add(btn2, gc);
        gc.gridx = 2;
        add(btn3, gc);
    }

    private void addBtnActionListeners(JButton btn1, JButton btn2, JButton btn3) {
        btn1.addActionListener(new GameInit());
        btn2.addActionListener(new ScoreboardInit());
        btn3.addActionListener(new Exit());
    }
}
