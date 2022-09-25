package pl.pjwstk.app.components.main;

import pl.pjwstk.app.components.ScoreboardPanel;
import pl.pjwstk.app.exceptions.DataException;
import pl.pjwstk.app.models.Player;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreboardFrame extends JFrame {
    ScoreboardPanel scoreboardPanel;
    List<Player> playersArrayList;
    List<String> columnNames;

    public ScoreboardFrame() throws HeadlessException {
        super();

        loadScoreboardFromFile();

        scoreboardPanel = new ScoreboardPanel(playersArrayList, columnNames);

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();


        gc.fill = GridBagConstraints.BOTH;
        gc.anchor = GridBagConstraints.CENTER;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.gridx = 0;
        gc.gridy = 0;

        add(scoreboardPanel, gc);

        basicConfig();
    }

    private void loadScoreboardFromFile() {
        File columnNamesFile = new File("./src/pl/pjwstk/app/files/columnNames.txt");
        File dataFile = new File("./src/pl/pjwstk/app/files/data.txt");

        getDataFromTxt(columnNamesFile, dataFile);
    }

    private void getDataFromTxt(File columnNamesFile, File dataFile) {
        try {
            getColumns(columnNamesFile);
            getPlayers(dataFile);
        } catch (DataException e) {
            System.out.println(e.getMessage());
        }
    }

    private void getPlayers(File dataFile) throws DataException {
        try (
                FileReader fileReader = new FileReader(dataFile);
                BufferedReader reader = new BufferedReader(fileReader)
        ) {
            fileCreationCheck(dataFile);

            String nextLine;
            ArrayList<Player> players = new ArrayList<>();
            while ((nextLine = reader.readLine()) != null) {
                String[] splitValues = nextLine.split(",");
                players.add(new Player(Integer.parseInt(splitValues[2]), Integer.parseInt(splitValues[0]), splitValues[1],
                        new Integer(splitValues[3])));
            }
            List<Player> sortedList = players.stream()
                    .sorted(Player::compareTo)
                    .collect(Collectors.toList());
            int counter = 1;
            for (Player player : sortedList) {
                player.setPosition(counter++);
            }
            this.playersArrayList = sortedList;
        } catch (IOException e) {
            throw new DataException("Data loading error");
        }
    }

    private void getColumns(File columnNamesFile) throws DataException {
        try (
                FileReader fileReader = new FileReader(columnNamesFile);
                BufferedReader reader = new BufferedReader(fileReader)
        ) {
            fileCreationCheck(columnNamesFile);

            String line = reader.readLine();

            String[] strings = line.split(",");
            this.columnNames = Arrays.asList(strings);

        } catch (Exception e) {
            throw new DataException("Data loading error");
        }
    }

    private void fileCreationCheck(File file) throws IOException {
        if (file.createNewFile()) {
            System.out.println("File" + file.getName() + "created");
        } else {
            System.out.println("File " + file.getName() + " exists");
        }
    }

    private void basicConfig() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(600, 600);
        setLocationRelativeTo(null);
    }
}
