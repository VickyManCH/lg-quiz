package pane;

import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
//
public class ChoicePane extends GridPane {
    public  ChoicePane(ArrayList<String> choices){
        //ArrayList<Button> buttons = new ArrayList<>();
        int count=choices.size();
        int w;
        int h;
        setMaxSize(600,150);

        switch (count){
            case(2):{
                w=300;
                h=150;


            } case (4):{
                w=300;
                h=75;

            }
        }
        for (String choice:choices){
            Button button=new Button(choice);

            getChildren().add(button);
        }
    }
}
