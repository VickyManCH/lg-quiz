package pane;

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

import static utils.Goto.quizPage;

public class HintPane extends VBox {
    public HintPane(){
        setSpacing(16);
        setPadding(new Insets(32,0,32,0));
        setAlignment(Pos.CENTER);
        try {
            ImageView hintImg = new ImageView(new Image(new FileInputStream("res/lghint.jpg")));
            hintImg.setFitWidth(900);
            hintImg.setFitHeight(600);
            getChildren().add(hintImg);
        } catch (FileNotFoundException err) {

        }
        Button back = new Button("Back");
        try {
            back.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("res/choiceback.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, false))));
        } catch (FileNotFoundException err) {

        }
        back.setOnMouseExited(mouseEvent -> {
            try {
                back.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("res/choiceback.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, false))));
                back.setTextFill(Color.BLACK);
            } catch (FileNotFoundException err) {

            }
        });
        back.setOnMouseEntered(mouseEvent -> {
            try {
                back.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("res/choiceback2.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, false))));
                back.setTextFill(Color.WHITE);
            } catch (FileNotFoundException err) {

            }
        });
        back.setFont(Font.font("Noto Sans Thai", FontWeight.BOLD, 20));
        back.setPrefWidth(400);
        back.setPrefHeight(100);
        back.setOnMouseClicked(mouseEvent -> quizPage());
        VBox.setMargin(back, new Insets(50, 0, 0, 0));
        getChildren().add(back);
    }
}
