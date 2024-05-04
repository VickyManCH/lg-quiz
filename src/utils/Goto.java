package utils;

import item.Book;
import item.base.BaseQuestion;
import item.level.EasyQuestion;
import item.level.HardQuestion;
import item.level.MediumQuestion;
import item.usage.ChoiceType;
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
import java.util.ArrayList;
import java.util.Collections;

public class Goto {
    private static RootPane rootPane;

    private static MediaPlayer mediaPlayer;

    private static ArrayList<BaseQuestion> questions = new ArrayList<>();

    private static void setMediaPlayer(String musicPath){
        mediaPlayer = new MediaPlayer(new Media(new File(musicPath).toURI().toString()));
    }

    public static void setRootPane(RootPane rootPane) {
        Goto.rootPane = rootPane;
    }

    private static void music(String musicPath){
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

    public static void initQuiz(){
        questions.add(new EasyQuestion(ChoiceType.CHOICE, "บางพลัดกับบางรักเคยเดินหากันภายใน 10 นาทีใช่ไหม", "เคย"));
        questions.add(new EasyQuestion(ChoiceType.CHOICE,"จากข้อ 1 ตลอดเวลาหรือเป็นช่วงเวลา", "ช่วงเวลา"));
        questions.add(new MediumQuestion(ChoiceType.CHOICE,"บางซื่อกับบางโพเคยเดินหากันภายใน 10 นาที กี่วิธี", "2"));
        questions.add(new HardQuestion(ChoiceType.CHOICE,"จากข้อ 3 ได้ช่วงเวลาไหนบ้าง", "ตลอดเวลา 1 วิธี ช่วงเวลา 1 วิธี"));
        ArrayList<BaseQuestion> shuffleQuestion = new ArrayList<>();
        shuffleQuestion.add(new EasyQuestion(ChoiceType.CHOICE,"ช่วงเวลานี้ปีไหน", "2024"));
        shuffleQuestion.add(new EasyQuestion(ChoiceType.CHOICE,"บ้านบางโพ บ้านบางคลาส บ้านบางเอิน บ้านบางรัก บ้านบางระจัน บ้านบางพลัด บ้านบางที บ้านบางซื่อ เคยเดินหากันได้ไหม", "ได้"));
        shuffleQuestion.add(new EasyQuestion(ChoiceType.TEXT,"บ้านบางคลาส คือ บ้านที่", "2"));
        shuffleQuestion.add(new EasyQuestion(ChoiceType.TEXT,"บ้านบางระจัน คือ บ้านที่", "5"));
        shuffleQuestion.add(new EasyQuestion(ChoiceType.TEXT,"บ้านบางซื่อ คือ บ้านที่", "8"));
        shuffleQuestion.add(new EasyQuestion(ChoiceType.TEXT,"บ้านบางโพ คือ บ้านที่", "1"));
        shuffleQuestion.add(new EasyQuestion(ChoiceType.TEXT,"บ้านบางพลัด คือ บ้านที่", "6"));
        shuffleQuestion.add(new EasyQuestion(ChoiceType.TEXT,"บ้านบางรัก คือ บ้านที่", "4"));
        shuffleQuestion.add(new EasyQuestion(ChoiceType.TEXT,"บ้านบางเอิน คือ บ้านที่", "3"));
        shuffleQuestion.add(new EasyQuestion(ChoiceType.TEXT,"บ้านบางที คือ บ้านที่", "2"));
        shuffleQuestion.add(new MediumQuestion(ChoiceType.TEXT,"วันที่ตื่นเต้นมากที่สุด ของค่ายลานเกียร์คือวันที่เท่าไหร่", "4"));
        shuffleQuestion.add(new HardQuestion(ChoiceType.TEXT,"ค่ายลานเกียร์มีกี่ฝ่าย", "17"));
        Collections.shuffle(shuffleQuestion);

        questions.addAll(shuffleQuestion);

        quizPage();
    }

    public static void hintPage(){
        clear();
        rootPane.getChildren().add(new HintPane());
    }

    public static void quizPage(){
        clear();
        ArrayList<String> choices = new ArrayList<>();
        choices.add("Good job!");
        choices.add("Very gud!");
        choices.add("Lightning McQueen");
        choices.add("I'm bad");
        rootPane.getChildren().add(new HintButton());
        rootPane.getChildren().add(new QuizPane(questions.get(0).getQuestion()));
        rootPane.getChildren().add(new ChoicePane(choices));
    }

    public static void checkQuiz(){
        clear();
        questions.remove(0);
        if(questions.isEmpty()) scorePage();
        else quizPage();
    }

    public static void answerPage(Boolean answer, String correctChoice, int score){
        clear();
        rootPane.getChildren().add(new AnswerPane(answer, correctChoice, score));
    }

    public static void titleScreenPage(){
        clear();
        rootPane.getChildren().add(new TitleScreenPane());
    }

    public static void scorePage(){
        clear();
        rootPane.getChildren().add(new ScorePane());
    }
}