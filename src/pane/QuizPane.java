package pane;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class QuizPane extends GridPane {
    public QuizPane(String question){
        setPadding(new Insets(32,0,32,0));
        Button quizFrame = new Button(question);
        quizFrame.setBackground(new Background(new BackgroundFill(Color.BLUEVIOLET,new CornerRadii(20),null)));
        quizFrame.setPrefWidth(1080);
        quizFrame.setPrefHeight(540);
        quizFrame.setOpacity(0.8);
        quizFrame.setTextFill(Color.WHITE);
        quizFrame.setFont(Font.font("Lucida Fax", FontWeight.BOLD, 36));
        quizFrame.setWrapText(true);
        setAlignment(Pos.CENTER);

        try {
            ImageView hintImg = new ImageView(new Image(new FileInputStream("res/lghint.jpg")));
            quizFrame.setAlignment(Pos.TOP_CENTER);
            hintImg.setPreserveRatio(true);
            hintImg.setFitWidth(500);
            GridPane.setMargin(hintImg, new Insets(100, 0, 0, 0));
            GridPane.setHalignment(hintImg, HPos.CENTER);
            getChildren().add(quizFrame);
            getChildren().add(hintImg);
        } catch (FileNotFoundException err) {
            getChildren().add(quizFrame);
        }
    }
}
