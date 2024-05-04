package pane;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import utils.Goto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class RootPane extends VBox {
    private static RootPane instance;

    private RootPane() {
        // TODO: FILL CODE HERE
        Background bg;
        try {
            BackgroundImage bgImg = new BackgroundImage(new Image(new FileInputStream("res/quizback2.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, true));
            bg = new Background(bgImg);
        } catch (FileNotFoundException err) {
            bg = new Background(new BackgroundFill(Color.WHITE, null, null));
        }
        setBackground(bg);
        setAlignment(Pos.TOP_CENTER);
        setSpacing(16);
        setPadding(new Insets(32,0,32,0));
        Text text = new Text("");
        text.setFill(Color.DARKCYAN);
        text.setFont(Font.font("Verdana",FontWeight.BOLD,10));
        getChildren().add(text);
        ///////////////////////
        Goto.setRootPane(this);
        Goto.titleScreenPage();
    }

    public static RootPane getRootPane() {
        if (instance == null)
            instance = new RootPane();
        return instance;
    }
}
