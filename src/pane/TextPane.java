package pane;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import utils.Goto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TextPane  extends VBox {
    public TextPane(){
        setSpacing(16);
        setAlignment(Pos.CENTER);
        Button button=new Button("Submit");
        button.setPrefHeight(50);
        button.setPrefWidth(200);
        try {
            button.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("res/choiceback.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, false))));
        } catch (FileNotFoundException err) {

        }
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
        button.setFont(Font.font("Noto Sans Thai", FontWeight.SEMI_BOLD, 20));
        TextField textField=new TextField();
        textField.setPromptText("ตอบเป็นตัวเลข");
        textField.setPrefWidth(1000);
        textField.setPrefHeight(50);
        textField.setFont(Font.font("Noto Sans Thai", FontWeight.SEMI_BOLD, 16));
        try {
            textField.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("res/textback.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, true))));
        } catch (FileNotFoundException err) {

        }
        VBox.setMargin(textField, new Insets(-16, 400, 16, 400));
        button.setOnMouseClicked(mouseEvent -> Goto.checkAnswer(textField.getText()));
        getChildren().add(textField);
        getChildren().add(button);
    }
}
