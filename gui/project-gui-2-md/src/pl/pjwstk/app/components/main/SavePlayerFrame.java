package pl.pjwstk.app.components.main;

import pl.pjwstk.app.models.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SavePlayerFrame extends JFrame implements ActionListener {
    private JLabel playerName;
    private JTextField playerNameInput;
    private JButton saveToDatabase;

    public SavePlayerFrame() throws HeadlessException {
        super();
        playerName = new JLabel("Player name: ");
        playerNameInput = new JTextField(10);
        saveToDatabase = new JButton("Save");

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.weighty = 1;
        gc.weightx = 1;
        gc.gridx = 0;
        gc.gridy = 0;
        add(playerName, gc);
        gc.gridy = 1;
        add(playerNameInput);
        gc.gridy = 2;
        saveToDatabase.addActionListener(this);
        add(saveToDatabase);
        basicConfig();
    }

    private void basicConfig() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(600, 600);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        File file = new File("./src/pl/pjwstk/app/files/data.txt");
        try (
                FileWriter fileWriter = new FileWriter(file, true);
                BufferedWriter writer = new BufferedWriter(fileWriter)
        ) {
            Player player = new Player(0, playerNameInput.getText(), GameFrame.time);
            writer.write(player.getPosition() + "," + player.getName() + "," + player.getId() + "," + player.getTime());
        } catch (IOException ex) {
            System.out.println("Error with saving player");
        }
    }
}
