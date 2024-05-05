package pane;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import utils.Goto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TitleScreenPane extends VBox{
    public TitleScreenPane(){
        setAlignment(Pos.CENTER);
        try {
            Button exitButton = new Button("Exit");
            exitButton.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("res/choiceback.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, false))));
            exitButton.setFont(Font.font("Noto Sans Thai", FontWeight.BOLD, 36));
            exitButton.setPrefWidth(400);
            exitButton.setPrefHeight(100);
            exitButton.setOnMouseExited(mouseEvent -> {
                try {
                    exitButton.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("res/choiceback.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, false))));
                    exitButton.setTextFill(Color.BLACK);
                } catch (FileNotFoundException err) {

                }
            });
            exitButton.setOnMouseEntered(mouseEvent -> {
                try {
                    exitButton.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("res/choiceback2.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, false))));
                    exitButton.setTextFill(Color.WHITE);
                } catch (FileNotFoundException err) {

                }
            });
            exitButton.setOnMouseClicked(mouseEvent -> Platform.exit());
            Button playButton = new Button("Play");
            playButton.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("res/choiceback.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, false))));
            playButton.setTextFill(Color.BLACK);
            playButton.setFont(Font.font("Noto Sans Thai", FontWeight.BOLD, 36));
            playButton.setPrefWidth(400);
            playButton.setPrefHeight(100);
            playButton.setOnMouseExited(mouseEvent -> {
                try {
                    playButton.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("res/choiceback.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, false))));
                    playButton.setTextFill(Color.BLACK);
                } catch (FileNotFoundException err) {

                }
            });
            playButton.setOnMouseEntered(mouseEvent -> {
                try {
                    playButton.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("res/choiceback2.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, false))));
                    playButton.setTextFill(Color.WHITE);
                } catch (FileNotFoundException err) {

                }
            });
            playButton.setOnMouseClicked(mouseEvent -> Goto.initQuiz());
            VBox.setMargin(playButton, new Insets(300,0,50,0));
            getChildren().add(playButton);
            getChildren().add(exitButton);
        } catch (FileNotFoundException err){

        }
    }
}
