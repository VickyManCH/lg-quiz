package pane;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class TextPane  extends VBox {
    public TextPane(){
        Button button=new Button("Submit");
        TextField textField=new TextField();
        getChildren().add(textField);
        getChildren().add(button);
        
    }
}
