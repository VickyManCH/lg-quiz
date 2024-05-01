package utils;

import item.Book;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import pane.*;

import java.io.File;

public class Goto {
    private static RootPane rootPane;

    private static MediaPlayer mediaPlayer;

    private static void setMediaPlayer(String musicPath){
        mediaPlayer = new MediaPlayer(new Media(new File(musicPath).toURI().toString()));
    }

    public static void setRootPane(RootPane rootPane) {
        Goto.rootPane = rootPane;
    }

    public static void music(String musicPath){
        if(mediaPlayer != null){
            mediaPlayer.stop();
        }
        setMediaPlayer(musicPath);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    public static void clear(){
        if(rootPane.getChildren().size() > 1){
                rootPane.getChildren().remove(1,rootPane.getChildren().size());
        }
    }

    public static void mainPage(){
        clear();
        music("res/music/oioioi.mp3");
        ScrollPane newScroll = new ScrollPane(BookListPane.getInstance());
        newScroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        newScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        rootPane.getChildren().addAll(new SearchPane(),newScroll);
    }

    public static Button backToMainPageButton(){
        Button newButton = new Button("Back");
        newButton.setBorder(new Border(new BorderStroke(Color.DARKCYAN,BorderStrokeStyle.SOLID,null,new BorderWidths(2))));
        newButton.setBackground(new Background(new BackgroundFill(Color.WHITE,null,null)));
        newButton.setTextFill(Color.DARKCYAN);
        newButton.setPrefWidth(300);
        newButton.setOnMouseClicked(mouseEvent -> mainPage());
        return newButton;
    }

    public static void bookPage(Book book){
        clear();
        music("res/music/gedagedifnaf.mp3");
        Text name = GetDisplay.name(book,28,336, TextAlignment.CENTER);
        Text author = GetDisplay.author(book,28,336, TextAlignment.CENTER);
        author.setText("By "+author.getText());
        ImageView image = GetDisplay.image(book,320);
        Text stars = GetDisplay.stars(book,24);
        Text description = GetDisplay.Description(book,16,336);
        rootPane.getChildren().add(backToMainPageButton());
        rootPane.getChildren().addAll(name,author,image,stars,description);
    }

    public static void addNewBookPage(){
        clear();
        rootPane.getChildren().add(backToMainPageButton());
        rootPane.getChildren().add(new NewBookPane());
    }

    public static void quizPage(){
        clear();
    }

    public static void titleScreenPage(){
        clear();
        Button exitButton = new Button("Exit");
        exitButton.setBorder(new Border(new BorderStroke(Color.DARKCYAN,BorderStrokeStyle.SOLID,null,new BorderWidths(2))));
        exitButton.setBackground(new Background(new BackgroundFill(Color.WHITE,null,null)));
        exitButton.setTextFill(Color.DARKCYAN);
        exitButton.setPrefWidth(300);
        exitButton.setPrefHeight(100);
        exitButton.setOnMouseClicked(mouseEvent -> Platform.exit());
        Button playButton = new Button("Play");
        playButton.setBorder(new Border(new BorderStroke(Color.DARKCYAN,BorderStrokeStyle.SOLID,null,new BorderWidths(2))));
        playButton.setBackground(new Background(new BackgroundFill(Color.WHITE,null,null)));
        playButton.setTextFill(Color.DARKCYAN);
        playButton.setPrefWidth(300);
        playButton.setPrefHeight(100);
        playButton.setOnMouseClicked(mouseEvent -> quizPage());
        VBox.setMargin(playButton, new Insets(300,0,50,0));
        rootPane.getChildren().add(playButton);
        rootPane.getChildren().add(exitButton);
    }
}