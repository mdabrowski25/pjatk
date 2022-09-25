package pl.edu.pjwstk.view;

import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;
import pl.edu.pjwstk.model.MenuButton;
import pl.edu.pjwstk.model.ScoreRecord;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class GameView {
    private AnchorPane gamePane;
    private Scene gameScene;
    private Stage gameStage;
    private AnchorPane savePane;
    private Scene saveScene;
    private Stage saveStage;
    private Stage rootStage;
    private AnimationTimer timer;
    private ImageView character;
    private ImageView[] eggs;
    private final Integer[] rows = {50, 150, 250, 350, 450, 550};
    private int fails;
    private Label failsLabel;
    private int points;
    private Label pointsLabel;
    private final Random random = new Random();

    public GameView() {
        viewInit();
        fails = 0;
        points = 0;
        generateLabels();
        keyListenersInit();
        createGameCharacter();
        createEggs();
        startGameLoop();
    }

    private void generateLabels() {
        failsLabel = new Label("Fails: " + this.fails);
        failsLabel.setLayoutX(10);
        failsLabel.setLayoutY(10);
        pointsLabel = new Label("Points: " + this.points);
        pointsLabel.setLayoutX(10);
        pointsLabel.setLayoutY(30);
        Label exitLabel = new Label("Click CTRL + Q to exit");
        exitLabel.setLayoutX(205);
        exitLabel.setLayoutY(10);
        gamePane.getChildren().addAll(failsLabel, pointsLabel, exitLabel);
    }

    private void keyListenersInit() {
        gameScene.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.LEFT) {
                if (character.getLayoutX() > 0) {
                    character.setLayoutX(character.getLayoutX() - 100);
                }
            } else if (keyEvent.getCode() == KeyCode.RIGHT) {
                if (character.getLayoutX() < 500) {
                    character.setLayoutX(character.getLayoutX() + 100);
                }
            } else if (keyEvent.getCode() == KeyCode.Q && keyEvent.isControlDown()) {
                gameStage.close();
                rootStage.show();
            }
        });
    }

    private void viewInit() {
        gamePane = new AnchorPane();
        gamePane.setId("primary-pane");
        gameScene = new Scene(gamePane, 600, 800);
        gameScene.getStylesheets().addAll(Objects.requireNonNull(this.getClass().getResource("/style/primary.css")).toExternalForm());
        gameStage = new Stage();
        gameStage.setScene(gameScene);
    }

    public void createGame(Stage rootStage) {
        this.rootStage = rootStage;
        this.rootStage.hide();
        this.gameStage.show();
    }

    public void startGameLoop() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                moveEggs();
                catchAnEgg();
            }
        };
        timer.start();
    }

    public void createGameCharacter() {
        character = new ImageView("ui/character_maleAdventurer_walk5.png");
        character.setLayoutX(300);
        character.setLayoutY(650);
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2), character);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
        character.setEffect(new DropShadow(40, Color.BLACK));
        gamePane.getChildren().add(character);
    }

    private void createEggs() {
        this.eggs = new ImageView[4];
        for (int i = 0; i < eggs.length; i++) {
            eggs[i] = new ImageView("ui/egg.png");
            generateRandomizedEggPosition(eggs[i]);
            eggs[i].setFitWidth(20);
            eggs[i].setFitHeight(20);
            gamePane.getChildren().add(eggs[i]);
        }
    }

    private void moveEggs() {
        for (int i = 0; i < eggs.length; i++) {
            eggs[i].setLayoutY(eggs[i].getLayoutY() + 1);
            if (eggs[i].getLayoutY() > 820) {
                setNewEggPosition(eggs[i]);
                fails++;
                failsLabel.setText("Fails: " + fails);
                if (fails >= 3) {
                    gameStage.close();
                    timer.stop();
                    saveScore();
                }
            }
        }
    }

    private void saveScore() {
        savePane = new AnchorPane();
        saveScene = new Scene(savePane, 300, 200);
        saveStage = new Stage();
        saveStage.setScene(saveScene);
        TextField textField = new TextField();
        Label label = new Label("Name: ");
        MenuButton button = new MenuButton("Save score!");
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            ScoreRecord scoreRecord = new ScoreRecord(textField.getText(), points);
            saveScoreRecordToFile(scoreRecord);
            saveStage.close();
            rootStage.show();
        });
        VBox vBox = new VBox();
        vBox.getChildren().addAll(label, textField, button);
        savePane.getChildren().add(vBox);
        saveStage.show();
    }

    private void saveScoreRecordToFile(ScoreRecord scoreRecord) {
        File file = new File("./src/main/resources/scoreboard/scores.txt");
        try (
                FileWriter fileWriter = new FileWriter(file, true);
                BufferedWriter writer = new BufferedWriter(fileWriter)
        ) {
            writer.write(scoreRecord.getName() + "," + scoreRecord.getScore() + "\n");
        } catch (IOException ex) {
            showPopupError();
        }
    }

    private void showPopupError() {
        String message = "Error occured: Cannot save score to scoreboard file";
        Popup popup = new Popup();
        popup.getContent().setAll(new Label(message));
        popup.show(saveStage);
    }

    private void setNewEggPosition(ImageView egg) {
        egg.setLayoutY(30);
        egg.setLayoutX(rows[random.nextInt(6)]);
    }

    public void generateRandomizedEggPosition(ImageView egg) {
        egg.setLayoutX(rows[random.nextInt(6)]);
        egg.setLayoutY(-random.nextInt(2000));
    }


    private double checkDistanceBetween(double a1, double a2, double b1, double b2) {
        return Math.sqrt(Math.pow(a1 - a2, 2) + Math.pow(b1 - b2, 2));
    }

    private void catchAnEgg() {
        //promienie assetow (egg i character)
        for (int i = 0; i < eggs.length; i++) {
            if (10 + 64 > checkDistanceBetween(character.getLayoutX() + 48, eggs[i].getLayoutX() + 10, character.getLayoutY() + 64, eggs[i].getLayoutY() + 10)) {
                setNewEggPosition(eggs[i]);
                points++;
                pointsLabel.setText("Points: " + points);
            }
        }
    }
}
