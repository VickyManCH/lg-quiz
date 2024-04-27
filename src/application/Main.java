package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import pane.RootPane;

import java.io.File;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        // TODO: FILL CODE HERE
        Scene scene = new Scene(RootPane.getRootPane());
        stage.setFullScreen(true);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.setScene(scene);
        stage.setTitle("LG-QUIZ");
        stage.setResizable(false);
        stage.show();
    }
}