package pane;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import utils.Goto;

public class TextPane  extends VBox {
    public TextPane(){
        setSpacing(16);
        setAlignment(Pos.CENTER);
        Button button=new Button("Submit");
        button.setPrefHeight(50);
        button.setPrefWidth(200);
        button.setOnMouseClicked(mouseEvent -> Goto.answerPage(true, "ยัมมี่", 999));
        TextField textField=new TextField();
        textField.setPromptText("ตอบเป็นตัวเลข");
        textField.setPrefWidth(800);
        textField.setPrefHeight(50);
        textField.setBackground(new Background(new BackgroundFill(Color.WHITE,new CornerRadii(16),null)));
        VBox.setMargin(textField, new Insets(-16, 200, 16, 200));
        getChildren().add(textField);
        getChildren().add(button);

    }
}
