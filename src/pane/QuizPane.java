package pane;

import item.base.BaseQuestion;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class QuizPane extends GridPane {
    public QuizPane(BaseQuestion question){
        setPadding(new Insets(32,0,32,0));
        Button quizFrame = new Button(question.getQuestion());
        quizFrame.setBackground(new Background(new BackgroundFill(Color.WHITE,new CornerRadii(20),null)));
        quizFrame.setPrefWidth(1080);
        quizFrame.setPrefHeight(540);
        quizFrame.setOpacity(0.8);
        quizFrame.setFont(Font.font("Noto Sans Thai", FontWeight.BOLD, 36));
        quizFrame.setWrapText(true);
        setAlignment(Pos.CENTER);

        if(question.getHasPicture()){
            try {
                ImageView hintImg = new ImageView(new Image(new FileInputStream(question.getPictureName())));
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
        } else {
            getChildren().add(quizFrame);
        }
    }
}
