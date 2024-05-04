package pane;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HintPane extends VBox {
    public HintPane(){
        setAlignment(Pos.CENTER);
        try {
            Image hintImg = new Image(new FileInputStream("res/lghint.jpg"));
        } catch (FileNotFoundException err) {

        }
    }
}
