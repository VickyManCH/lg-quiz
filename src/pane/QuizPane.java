package pane;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class QuizPane extends VBox {
    public QuizPane(String question){
        setSpacing(16);
        setPadding(new Insets(32,0,32,0));
        Button quizFrame = new Button(question);
        quizFrame.setBackground(new Background(new BackgroundFill(Color.WHITE,new CornerRadii(20),null)));
        quizFrame.setPrefWidth(1080);
        quizFrame.setPrefHeight(540);
        setAlignment(Pos.CENTER);
        getChildren().add(quizFrame);
    }
}
