package pane;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import utils.Goto;

public class TitleScreenPane extends VBox{
    public TitleScreenPane(){
        setAlignment(Pos.CENTER);
        Button exitButton = new Button("Exit");
        exitButton.setBorder(new Border(new BorderStroke(Color.DARKCYAN, BorderStrokeStyle.SOLID,null,new BorderWidths(2))));
        exitButton.setBackground(new Background(new BackgroundFill(Color.WHITE,null,null)));
        exitButton.setTextFill(Color.DARKCYAN);
        exitButton.setPrefWidth(300);
        exitButton.setPrefHeight(100);
        exitButton.setOpacity(0.5);
        exitButton.setOnMouseClicked(mouseEvent -> Platform.exit());
        Button playButton = new Button("Play");
        playButton.setBorder(new Border(new BorderStroke(Color.DARKCYAN,BorderStrokeStyle.SOLID,null,new BorderWidths(2))));
        playButton.setBackground(new Background(new BackgroundFill(Color.WHITE,new CornerRadii(16),null)));
        playButton.setTextFill(Color.DARKCYAN);
        playButton.setPrefWidth(300);
        playButton.setPrefHeight(100);
        playButton.setOnMouseExited(mouseEvent -> {
            playButton.setBorder(new Border(new BorderStroke(Color.DARKCYAN,BorderStrokeStyle.SOLID,null,new BorderWidths(2))));
            playButton.setBackground(new Background(new BackgroundFill(Color.WHITE,null,null)));
            playButton.setTextFill(Color.DARKCYAN);
            playButton.setPrefWidth(300);
            playButton.setPrefHeight(100);
        });
        playButton.setOnMouseEntered(mouseEvent -> {
            playButton.setBorder(new Border(new BorderStroke(Color.GREEN,BorderStrokeStyle.SOLID,null,new BorderWidths(2))));
            playButton.setBackground(new Background(new BackgroundFill(Color.BLACK,null,null)));
            playButton.setTextFill(Color.WHITE);
            playButton.setPrefWidth(300);
            playButton.setPrefHeight(100);
        });
        playButton.setOnMouseClicked(mouseEvent -> Goto.quizPage());
        VBox.setMargin(playButton, new Insets(300,0,50,0));
        getChildren().add(playButton);
        getChildren().add(exitButton);
    }
}
