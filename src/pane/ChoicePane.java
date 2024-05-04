package pane;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import utils.Goto;

import java.util.ArrayList;
//
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
                w=280;
                h=70;
                margin = 30;
                break;
            }
        }
        for (String choice:choices){
            Button button = new Button(choice);
            button.setPrefWidth(w);
            button.setPrefHeight(h);
            button.setOnMouseClicked(mouseEvent -> Goto.answerPage(true, "อารีฟ", 8));
            HBox.setMargin(button, new Insets( 0, margin, 0, margin));
            getChildren().add(button);
        }
    }
}
