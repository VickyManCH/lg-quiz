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

public class HintButtonPane extends HBox {
    public HintButtonPane(){
        setAlignment(Pos.TOP_RIGHT);
        Button hint = new Button("Hint");
        hint.setPrefWidth(200);
        hint.setPrefHeight(50);
        try {
            hint.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("res/choiceback.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, false))));
        } catch (FileNotFoundException err) {

        }
        hint.setOnMouseExited(mouseEvent -> {
            try {
                hint.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("res/choiceback.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, false))));
                hint.setTextFill(Color.BLACK);
            } catch (FileNotFoundException err) {

            }
        });
        hint.setOnMouseEntered(mouseEvent -> {
            try {
                hint.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("res/choiceback2.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, false))));
                hint.setTextFill(Color.WHITE);
            } catch (FileNotFoundException err) {

            }
        });
        hint.setFont(Font.font("Noto Sans Thai", FontWeight.BOLD, 20));
        HBox.setMargin(hint, new Insets(0, 75, 0, 0));
        hint.setOnMouseClicked(mouseEvent -> Goto.hintPage());
        getChildren().add(hint);
    }
}
