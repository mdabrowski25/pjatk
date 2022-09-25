package pl.pjwstk.app.models;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PlayerTableModel extends AbstractTableModel {
    private List<Player> players;
    private List<String> columnNames;

    public PlayerTableModel(List<Player> playersArrayList, List<String> columnNames) {
        this.players = playersArrayList;
        this.columnNames = columnNames;
    }

    @Override
    public int getRowCount() {
        return players.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Player player = players.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return player.getPosition();
            case 1:
                return player.getName();
            case 2:
                return player.getId();
            case 3:
                return player.getTime();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }
}
