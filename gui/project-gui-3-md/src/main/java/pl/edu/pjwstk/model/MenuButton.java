package pl.edu.pjwstk.model;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;


public class MenuButton extends Button{
    public MenuButton(String s) {
        setText(s);
        addFont();
        getStylesheets().add(Objects.requireNonNull(getClass().getResource("/style/button-styles.css")).toExternalForm());
        setPrefHeight(49);
        setPrefWidth(190);
        buttonStyle();
        addFilters();
    }

    private void addFont() {
        try {
            setFont(Font.loadFont(new FileInputStream("src/main/resources/fonts/IndieFlower-Regular.ttf"), 19));
        } catch (FileNotFoundException e) {
            setFont(Font.font("Arial", 19));
        }
    }

    private void buttonStyle() {
        getStyleClass().setAll("button", "button-with-ui");
        setPrefHeight(49);
        setLayoutY(getLayoutY() - 4);
    }

    private void buttonPressedStyle() {
        getStyleClass().setAll("button", "pressed-button-with-ui");
        setPrefHeight(45);
        setLayoutY(getLayoutY() + 4);
    }

    private void addFilters() {
        addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> buttonPressedStyle());
        addEventFilter(MouseEvent.MOUSE_RELEASED, mouseEvent -> buttonStyle());
    }
}
