package pl.edu.pjwstk.app;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.edu.pjwstk.view.ViewBuilder;


public class
App extends Application {

    @Override
    public void start(Stage stage) {
        ViewBuilder viewBuilder = new ViewBuilder(600, 800);
        stage = viewBuilder.getPrimaryStage();
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
