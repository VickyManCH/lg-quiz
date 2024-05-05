package pane;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static utils.Goto.*;

public class ScorePane extends VBox {
    public ScorePane(int yourScore, int totalScore){
        setAlignment(Pos.CENTER);
        setSpacing(20);
        setPadding(new Insets(32,0,32,0));
        Text gameOver = new Text("Game Over!");
        gameOver.setFill(Color.WHITE);
        gameOver.setFont(Font.font("Noto Sans Thai", FontWeight.EXTRA_BOLD, 50));
        VBox.setMargin(gameOver, new Insets(50, 0, 50, 0));
        Text scoreText = new Text("You got " + yourScore + "/" + totalScore + " points!");
        scoreText.setFill(Color.WHITE);
        scoreText.setFont(Font.font("Noto Sans Thai", FontWeight.BOLD, 36));
        VBox.setMargin(scoreText, new Insets(10, 0, 10, 0));
        Text comment = new Text("You got some skills dodging all the correct answers!");
        float scoreRatio = (float) yourScore / Math.max(totalScore, 1);
        if (scoreRatio == 1) {
            comment.setText("You're legendary! Congrats on getting full score!");
        }
        else if (scoreRatio > 0.9) {
            comment.setText("You're the best!");
        }
        else if (scoreRatio > 0.7) {
            comment.setText("Amazing! Keep trying to get more!");
        }
        else if (scoreRatio > 0.49) {
            comment.setText("Great job!");
        }
        else if (scoreRatio > 0.3) {
            comment.setText("Not bad!");
        }
        else if (scoreRatio != 0) {
            comment.setText("It's okay. Keep trying!");
        }
        comment.setFill(Color.WHITE);
        comment.setFont(Font.font("Noto Sans Thai", FontWeight.BOLD, 36));
        Button tryAgain = new Button("Try Again");
        Button exit = new Button("Return");
        try {
            tryAgain.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("res/choiceback.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, false))));
            tryAgain.setPrefWidth(400);
            tryAgain.setPrefHeight(100);
            tryAgain.setFont(Font.font("Noto Sans Thai", FontWeight.BOLD, 36));
            tryAgain.setOnMouseClicked(mouseEvent -> initQuiz());
            VBox.setMargin(tryAgain, new Insets(100, 0, 50, 0));
            exit.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("res/choiceback.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, false))));
            exit.setPrefWidth(400);
            exit.setPrefHeight(100);
            exit.setFont(Font.font("Noto Sans Thai", FontWeight.BOLD, 36));
            exit.setOnMouseClicked(mouseEvent -> titleScreenPage());
        } catch (FileNotFoundException err) {

        }
        tryAgain.setOnMouseExited(mouseEvent -> {
            try {
                tryAgain.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("res/choiceback.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, false))));
                tryAgain.setTextFill(Color.BLACK);
            } catch (FileNotFoundException err) {

            }
        });
        tryAgain.setOnMouseEntered(mouseEvent -> {
            try {
                tryAgain.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("res/choiceback2.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, false))));
                tryAgain.setTextFill(Color.WHITE);
            } catch (FileNotFoundException err) {

            }
        });
        exit.setOnMouseExited(mouseEvent -> {
            try {
                exit.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("res/choiceback.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, false))));
                exit.setTextFill(Color.BLACK);
            } catch (FileNotFoundException err) {

            }
        });
        exit.setOnMouseEntered(mouseEvent -> {
            try {
                exit.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("res/choiceback2.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, false))));
                exit.setTextFill(Color.WHITE);
            } catch (FileNotFoundException err) {

            }
        });
        getChildren().addAll(gameOver, scoreText, comment, tryAgain, exit);
    }
}
