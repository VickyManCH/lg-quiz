package utils;

import item.Book;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class GetDisplay {
    public static Text Description(Book book,int fontSize,int wrappingWidth){
        Text newText = new Text(book.getDescription());
        newText.setFont(new Font(fontSize));
        newText.setWrappingWidth(wrappingWidth);
        return newText;
    }

    public static ImageView image(Book book,int fitHeight){
        ImageView newImg = new ImageView(book.getImage());
        newImg.setPreserveRatio(true);
        newImg.setFitHeight(fitHeight);
        return newImg;
    }

    public static Text name(Book book, int fontSize, int wrappingWidth,TextAlignment textAlignment){
        Text newText = new Text(book.getName());
        newText.setFont(new Font(newText.getFont().getName(),fontSize));
        newText.setWrappingWidth(wrappingWidth);
        newText.setTextAlignment(textAlignment);
        return newText;
    }

    public static Text author(Book book,int fontSize,int wrappingWidth,TextAlignment textAlignment){
        Text newText = new Text(book.getAuthor());
        newText.setFill(Color.GRAY);
        newText.setFont(new Font(fontSize));
        newText.setWrappingWidth(wrappingWidth);
        newText.setTextAlignment(textAlignment);
        return newText;
    }

    public static Text stars(Book book,int fontSize){
        String star = "★".repeat(book.getStars())+"☆".repeat(5- book.getStars());
        Text newText = new Text(star);
        newText.setFill(Color.DARKRED);
        newText.setFont(new Font(fontSize));
        return newText;
    }
}
