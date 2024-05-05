package pane;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import utils.Goto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static utils.Goto.checkQuiz;

public class AnswerPane extends VBox {
    public AnswerPane(Boolean answer, String correctChoice, int score){
        setAlignment(Pos.CENTER);
        setSpacing(16);
        setPadding(new Insets(32,0,32,0));
        Color color = Color.RED;
        Button answerFrame = new Button();
        answerFrame.setWrapText(true);
        String points;
        if (score == 1) {
            points = score + " point.";
        } else {
            points = score + " points.";
        }
        if(answer) {
            MediaPlayer mediaPlayer = new MediaPlayer(new Media(new File("res/sound/correct.mp3").toURI().toString()));
            mediaPlayer.play();
            color = Color.GREEN;
                answerFrame.setText("Correct! You got " + points);
        } else {
            MediaPlayer mediaPlayer = new MediaPlayer(new Media(new File("res/sound/wrong.mp3").toURI().toString()));
            mediaPlayer.play();
            answerFrame.setText("Wrong! You lost " + points + " The correct answer is " + correctChoice);
        }
        answerFrame.setBackground(new Background(new BackgroundFill(color,new CornerRadii(20),null)));
        answerFrame.setPrefWidth(1080);
        answerFrame.setPrefHeight(540);
        answerFrame.setOpacity(0.8);
        answerFrame.setTextFill(Color.WHITE);
        answerFrame.setFont(Font.font("Noto Sans Thai", FontWeight.BOLD, 36));
        getChildren().add(answerFrame);
        Button next = new Button("Next");
        try {
            next.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("res/choiceback.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, false))));
        } catch (FileNotFoundException err) {

        }
        next.setOnMouseExited(mouseEvent -> {
            try {
                next.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("res/choiceback.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, false))));
                next.setTextFill(Color.BLACK);
            } catch (FileNotFoundException err) {

            }
        });
        next.setOnMouseEntered(mouseEvent -> {
            try {
                next.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("res/choiceback2.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, false))));
                next.setTextFill(Color.WHITE);
            } catch (FileNotFoundException err) {

            }
        });
        next.setFont(Font.font("Noto Sans Thai", FontWeight.SEMI_BOLD, 20));
        next.setPrefWidth(400);
        next.setPrefHeight(100);
        next.setOnMouseClicked(mouseEvent -> checkQuiz());
        VBox.setMargin(next, new Insets(50, 0, 50, 0));
        getChildren().add(next);
    }
}
