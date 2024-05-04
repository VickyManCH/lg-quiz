package pane;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import utils.Goto;

import static utils.Goto.checkQuiz;

public class AnswerPane extends VBox {
    public AnswerPane(Boolean answer, String correctChoice, int score){
        setSpacing(16);
        setPadding(new Insets(32,0,32,0));
        Color color = Color.RED;
        Button answerFrame = new Button();
        if(answer) {
            color = Color.GREEN;
            answerFrame.setText("Correct! You got " + score + " points.");
        } else {
            answerFrame.setText("Wrong! The correct answer is " + correctChoice);
        }
        Background bg = new Background(new BackgroundFill(Color.WHITE, null, null));
        answerFrame.setBackground(new Background(new BackgroundFill(color,new CornerRadii(20),null)));
        answerFrame.setPrefWidth(1080);
        answerFrame.setPrefHeight(540);
        answerFrame.setOpacity(0.8);
        answerFrame.setTextFill(Color.WHITE);
        answerFrame.setFont(Font.font("Lucida Fax", FontWeight.BOLD, 36));
        setAlignment(Pos.CENTER);
        getChildren().add(answerFrame);
        Button next = new Button("Next");
        next.setBorder(new Border(new BorderStroke(Color.DARKCYAN, BorderStrokeStyle.SOLID,null,new BorderWidths(2))));
        next.setBackground(new Background(new BackgroundFill(Color.WHITE,null,null)));
        next.setTextFill(Color.DARKCYAN);
        next.setPrefWidth(400);
        next.setPrefHeight(100);
        next.setOnMouseClicked(mouseEvent -> checkQuiz());
        VBox.setMargin(next, new Insets(100, 0, 100, 0));
        getChildren().add(next);
    }
}
