package pl.edu.pjwstk.view;

import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pl.edu.pjwstk.model.MenuButton;

import java.util.Objects;


public class ViewBuilder {
    private AnchorPane primaryPane;
    private Scene primaryScene;
    private Stage primaryStage;
    private GameView gameView;
    private ScoreboardView scoreboardView;

    public ViewBuilder(int width, int height) {
        this.primaryPane = new AnchorPane();
        primaryPane.setId("primary-pane");
        this.primaryScene = new Scene(primaryPane, width, height);
        primaryScene.getStylesheets().addAll(Objects.requireNonNull(this.getClass().getResource("/style/primary.css")).toExternalForm());
        this.primaryStage = new Stage();
        primaryStage.setScene(primaryScene);
        createMenuButtons();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void createMenuButtons() {
        MenuButton button1 = new MenuButton("New Game");
        button1.setLayoutY(200);
        button1.setLayoutX(50);
        setButtonEventListener(button1, 1);
        MenuButton button2 = new MenuButton("Scoreboard");
        setButtonEventListener(button2, 2);
        button2.setLayoutY(400);
        button2.setLayoutX(50);
        MenuButton button3 = new MenuButton("Exit");
        setButtonEventListener(button3, 3);
        button3.setLayoutY(600);
        button3.setLayoutX(50);

        primaryPane.getChildren().add(button1);
        primaryPane.getChildren().add(button2);
        primaryPane.getChildren().add(button3);
    }

    private void setButtonEventListener(MenuButton button, int actionId) {
        if (actionId == 1) {
            button.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
                gameView = new GameView();
                gameView.createGame(primaryStage);
            });
        } else if (actionId == 2) {
            button.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
                scoreboardView = new ScoreboardView();
                scoreboardView.showScoreboard(primaryStage);
            });
        } else if (actionId == 3) {
            button.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> primaryStage.close());
        }
    }
}
