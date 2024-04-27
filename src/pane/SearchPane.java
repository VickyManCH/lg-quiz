package pane;

import item.Book;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class SearchPane extends HBox {
    public SearchPane(){
        setAlignment(Pos.CENTER);
        TextField textField = new TextField();
        textField.setPromptText("Find the book");
        textField.setPrefWidth(250);
        Button button = new Button("Search");
        button.setBackground(Background.fill(Color.DARKCYAN));
        button.setTextFill(Color.WHITE);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ArrayList<Book> books = new ArrayList<>(BookListPane.getInstance().getBooks());
                books.removeIf(book -> (!book.getName().contains(textField.getCharacters()) && !textField.getText().isBlank()));
                BookListPane.getInstance().setSearchedBooks(books);
            }
        });
        getChildren().add(textField);
        getChildren().add(button);
    }
}
