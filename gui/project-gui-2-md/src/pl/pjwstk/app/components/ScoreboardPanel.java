package pl.pjwstk.app.components;

import pl.pjwstk.app.models.Player;
import pl.pjwstk.app.models.PlayerTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ScoreboardPanel extends JPanel {

    private JTable scoreboard;
    private PlayerTableModel tableModel;

    public ScoreboardPanel(List<Player> playersArrayList, List<String> columnNames) {
        tableModel = new PlayerTableModel(playersArrayList, columnNames);

        scoreboard = new JTable(tableModel);

        setLayout(new BorderLayout());

        tableModel.fireTableStructureChanged();


        add(new JScrollPane(scoreboard), BorderLayout.CENTER);
    }
}
