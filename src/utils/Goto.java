package utils;

import item.Book;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import pane.BookListPane;
import pane.NewBookPane;
import pane.RootPane;
import pane.SearchPane;

public class Goto {
    private static RootPane rootPane;

    public static void setRootPane(RootPane rootPane) {
        Goto.rootPane = rootPane;
    }

    public static void clear(){
        if(rootPane.getChildren().size() > 1){
                rootPane.getChildren().remove(1,rootPane.getChildren().size());
        }
    }

    public static void mainPage(){
        clear();
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
}