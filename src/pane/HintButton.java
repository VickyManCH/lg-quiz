package pane;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import utils.Goto;

public class HintButton extends HBox {
    public HintButton(){
        setAlignment(Pos.TOP_RIGHT);
        Button hint = new Button("Hint");
        hint.setPrefWidth(100);
        hint.setPrefHeight(50);
        HBox.setMargin(hint, new Insets(0, 75, 0, 0));
        hint.setOnMouseClicked(mouseEvent -> Goto.hintPage());
        getChildren().add(hint);
    }
}
