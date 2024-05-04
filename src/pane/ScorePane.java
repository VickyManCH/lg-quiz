package pane;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import static utils.Goto.*;

public class ScorePane extends VBox {
    public ScorePane(){
        setAlignment(Pos.CENTER);
        setSpacing(20);
        setPadding(new Insets(32,0,32,0));
        Text gameOver = new Text("Game Over!");
        gameOver.setFont(Font.font("Lucida Fax", FontWeight.BOLD, 36));
        VBox.setMargin(gameOver, new Insets(50, 0, 50, 0));
        int score = 0;// = getScore();
        int scoreCap = 1;// = getScoreCap();
        Text scoreText = new Text("You got " + score + "/" + scoreCap + " points!");
        scoreText.setFont(Font.font("Lucida Fax", FontWeight.BOLD, 36));
        //TODO: ถ้าทำทัน มาทำ Text ชมผู้เล่นด้วย เช่น ได้ 5/5 ชมว่า Great job!
        Button tryAgain = new Button("Try Again");
        tryAgain.setBorder(new Border(new BorderStroke(Color.DARKCYAN, BorderStrokeStyle.SOLID,null,new BorderWidths(2))));
        tryAgain.setBackground(new Background(new BackgroundFill(Color.WHITE,null,null)));
        tryAgain.setTextFill(Color.DARKCYAN);
        tryAgain.setPrefWidth(400);
        tryAgain.setPrefHeight(100);
        tryAgain.setOnMouseClicked(mouseEvent -> quizPage());
        VBox.setMargin(tryAgain, new Insets(100, 0, 50, 0));
        Button exit = new Button("Return");
        exit.setBorder(new Border(new BorderStroke(Color.DARKCYAN, BorderStrokeStyle.SOLID,null,new BorderWidths(2))));
        exit.setBackground(new Background(new BackgroundFill(Color.WHITE,null,null)));
        exit.setTextFill(Color.DARKCYAN);
        exit.setPrefWidth(400);
        exit.setPrefHeight(100);
        exit.setOnMouseClicked(mouseEvent -> titleScreenPage());
        getChildren().addAll(gameOver, scoreText, tryAgain, exit);
    }
}
