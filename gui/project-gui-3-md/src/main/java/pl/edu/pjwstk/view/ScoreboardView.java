package pl.edu.pjwstk.view;

import javafx.animation.FadeTransition;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;
import pl.edu.pjwstk.exceptions.DataException;
import pl.edu.pjwstk.model.MenuButton;
import pl.edu.pjwstk.model.ScoreRecord;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class ScoreboardView {
    private Stage rootStage;
    private AnchorPane scoreboardPane;
    private Scene scoreboardScene;
    private Stage scoreboardStage;
    private ListView<ScoreRecord> listView;
    private ArrayList<ScoreRecord> standings;
    private VBox vBox;
    private MenuButton backButton;

    public ScoreboardView() {
        standingsInit();
        getStandings();
        viewInit();
    }

    private void standingsInit() {
        standings = new ArrayList<>();

        try {
            loadScoresFromFile();
        } catch (DataException e) {
            popupErrorMessage(e);
        }
    }

    private void popupErrorMessage(DataException e) {
        String message = e.getMessage();
        Popup popup = new Popup();
        popup.getContent().setAll(new Label(message));
        popup.show(scoreboardStage);
    }

    private void loadScoresFromFile() throws DataException {
        File scoresFile = new File("./src/main/resources/scoreboard/scores.txt");
            try (
                    FileReader fileReader = new FileReader(scoresFile);
                    BufferedReader reader = new BufferedReader(fileReader)
            ) {
                fileCreationCheck(scoresFile);

                String nextLine;
                ArrayList<ScoreRecord> scoreRecords = new ArrayList<>();
                while ((nextLine = reader.readLine()) != null) {
                    String[] splitValues = nextLine.split(",");
                    scoreRecords.add(new ScoreRecord(splitValues[0], Integer.parseInt(splitValues[1])));
                }
                standings = scoreRecords;
            } catch (IOException e) {
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

    private void getStandings() {
        listView = new ListView<>();
        listView.getItems().addAll(standings);
        listView.getItems().sort(ScoreRecord::compareTo);
        listView.setMinHeight(750);
        listView.setMinWidth(600);

    }

    private void viewInit() {
        scoreboardPane = new AnchorPane();
        scoreboardPane.setId("stats-pane");
        scoreboardScene = new Scene(scoreboardPane, 600, 800);
        scoreboardScene.getStylesheets().addAll(Objects.requireNonNull(this.getClass().getResource("/style/primary.css")).toExternalForm());
        scoreboardStage = new Stage();
        scoreboardStage.setScene(scoreboardScene);
        vBox = new VBox();
        backButton = new MenuButton("Back to menu");
        backButton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseClicked -> {
            scoreboardStage.close();
            rootStage.show();
        });
        backButton.setLayoutX(205);
        backButton.setLayoutY(750);
        vBox.getChildren().addAll(listView);
        scoreboardPane.getChildren().addAll(vBox, backButton);
    }

    public void showScoreboard(Stage rootStage) {
        this.rootStage = rootStage;
        this.rootStage.hide();
        this.scoreboardStage.show();
    }
}
