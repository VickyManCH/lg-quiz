package pane;

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
import java.util.ArrayList;

public class ChoicePane extends HBox {
    public  ChoicePane(ArrayList<String> choices){
        setAlignment(Pos.CENTER);
        setPadding(new Insets(10));
        int count=choices.size();
        int w = 100;
        int h = 50;
        int margin = 50;

        switch (count){
            case 2:{
                w=400;
                h=100;
                margin = 100;
                break;
            } case 4:{
                w=350;
                h=70;
                margin = 15;
                break;
            }
        }
        for (String choice:choices){
            Button button = new Button(choice);
            button.setPrefWidth(w);
            button.setPrefHeight(h);
            HBox.setMargin(button, new Insets( 0, margin, 0, margin));
            try {
                button.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("res/choiceback.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, false))));
            } catch (FileNotFoundException err) {

            }
            button.setFont(Font.font("Noto Sans Thai", FontWeight.SEMI_BOLD, 20));
            button.setOnMouseClicked(mouseEvent -> Goto.checkAnswer(choice));
            button.setOnMouseExited(mouseEvent -> {
                try {
                    button.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("res/choiceback.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, false))));
                    button.setTextFill(Color.BLACK);
                } catch (FileNotFoundException err) {

                }
            });
            button.setOnMouseEntered(mouseEvent -> {
                try {
                    button.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("res/choiceback2.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, false))));
                    button.setTextFill(Color.WHITE);
                } catch (FileNotFoundException err) {

                }
            });
            getChildren().add(button);
        }
    }
}
