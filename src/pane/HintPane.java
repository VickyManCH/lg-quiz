package pane;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static utils.Goto.quizPage;

public class HintPane extends VBox {
    public HintPane(){
        setSpacing(16);
        setPadding(new Insets(32,0,32,0));
        setAlignment(Pos.CENTER);
        try {
            ImageView hintImg = new ImageView(new Image(new FileInputStream("res/lghint.jpg")));
            getChildren().add(hintImg);
            hintImg.setFitWidth(900);
            hintImg.setFitHeight(600);
        } catch (FileNotFoundException err) {

        }
        Button back = new Button("Back");
        back.setBorder(new Border(new BorderStroke(Color.DARKCYAN, BorderStrokeStyle.SOLID,null,new BorderWidths(2))));
        back.setBackground(new Background(new BackgroundFill(Color.WHITE,null,null)));
        back.setTextFill(Color.DARKCYAN);
        back.setPrefWidth(400);
        back.setPrefHeight(100);
        back.setOnMouseClicked(mouseEvent -> quizPage());
        VBox.setMargin(back, new Insets(50, 0, 0, 0));
        getChildren().add(back);
    }
}
