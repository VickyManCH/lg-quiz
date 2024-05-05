package utils;

import item.base.BaseQuestion;
import item.level.EasyQuestion;
import item.level.HardQuestion;
import item.level.MediumQuestion;
import item.quiz.ChoiceQuiz;
import item.usage.ChoiceType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import pane.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Goto {
    private static RootPane rootPane;

    private static MediaPlayer mediaPlayer;

    private static ArrayList<BaseQuestion> questions = new ArrayList<>();

    private static ArrayList<ChoiceQuiz> choiceAnswers = new ArrayList<>();

    private static int yourScore = 0;

    private static int totalScore = 0;

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

    public static void titleScreenPage(){
        clear();
        music("res/music/titlemusic.mp3");
        rootPane.getChildren().add(new TitleScreenPane());
    }

    public static void initQuiz(){
        music("res/music/quizmusic.mp3");

        questions.clear();
        choiceAnswers.clear();
        yourScore = 0;
        totalScore = 0;

        questions.add(new EasyQuestion(ChoiceType.CHOICE, "บางพลัดกับบางรักเคยเดินหากันภายใน 10 นาทีใช่ไหม", "เคย"));
        questions.add(new EasyQuestion(ChoiceType.CHOICE,"จากข้อ 1 ตลอดเวลาหรือเป็นช่วงเวลา", "ช่วงเวลา"));
        questions.add(new MediumQuestion(ChoiceType.CHOICE,"บางซื่อกับบางโพเคยเดินหากันภายใน 10 นาที กี่วิธี", "2"));
        questions.add(new HardQuestion(ChoiceType.CHOICE,"จากข้อ 3 ได้ช่วงเวลาไหนบ้าง", "ตลอดเวลา 1 วิธี ช่วงเวลา 1 วิธี"));
        ArrayList<BaseQuestion> shuffleQuestion = new ArrayList<>();
        shuffleQuestion.add(new EasyQuestion(ChoiceType.CHOICE,"ช่วงเวลานี้ปีไหน", "2024"));
        shuffleQuestion.add(new EasyQuestion(ChoiceType.CHOICE,"บ้านบางโพ บ้านบางคลาส บ้านบางเอิน บ้านบางรัก บ้านบางระจัน บ้านบางพลัด บ้านบางที บ้านบางซื่อ เคยเดินหากันได้ไหม", "ได้"));
        shuffleQuestion.add(new EasyQuestion(ChoiceType.TEXT,"บ้านบางคลาส คือ บ้านที่", "2"));
        shuffleQuestion.add(new EasyQuestion(ChoiceType.TEXT,"บ้านบางระจัน คือ บ้านที่", "5", "res/bangrajan.jpg"));
        shuffleQuestion.add(new EasyQuestion(ChoiceType.TEXT,"บ้านบางซื่อ คือ บ้านที่", "8", "res/bangsue.jpg"));
        shuffleQuestion.add(new EasyQuestion(ChoiceType.TEXT,"บ้านบางโพ คือ บ้านที่", "1", "res/bangpho.jpg"));
        shuffleQuestion.add(new EasyQuestion(ChoiceType.TEXT,"บ้านบางพลัด คือ บ้านที่", "6", "res/bangplad.jpg"));
        shuffleQuestion.add(new EasyQuestion(ChoiceType.TEXT,"บ้านบางรัก คือ บ้านที่", "4", "res/bangrak.jpg"));
        shuffleQuestion.add(new EasyQuestion(ChoiceType.TEXT,"บ้านบางเอิน คือ บ้านที่", "3"));
        shuffleQuestion.add(new EasyQuestion(ChoiceType.TEXT,"บ้านบางที คือ บ้านที่", "7"));
        shuffleQuestion.add(new MediumQuestion(ChoiceType.TEXT,"วันที่ตื่นเต้นมากที่สุด ของค่ายลานเกียร์คือวันที่เท่าไหร่", "4", "res/lghint.jpg"));
        shuffleQuestion.add(new HardQuestion(ChoiceType.TEXT,"ค่ายลานเกียร์มีกี่ฝ่าย", "11"));
        Collections.shuffle(shuffleQuestion);

        questions.addAll(shuffleQuestion);

        ChoiceQuiz cq1 = new ChoiceQuiz();
        ChoiceQuiz cq2 = new ChoiceQuiz();
        ChoiceQuiz cq3 = new ChoiceQuiz();
        ChoiceQuiz cq4 = new ChoiceQuiz();
        ChoiceQuiz cq5 = new ChoiceQuiz();
        ChoiceQuiz cq6 = new ChoiceQuiz();
        cq1.addChoices("บางพลัดกับบางรักเคยเดินหากันภายใน 10 นาทีใช่ไหม", "เคย", "ไม่เคย");
        cq2.addChoices("จากข้อ 1 ตลอดเวลาหรือเป็นช่วงเวลา", "ตลอดเวลา", "ช่วงเวลา");
        cq3.addChoices("บางซื่อกับบางโพเคยเดินหากันภายใน 10 นาที กี่วิธี", "0", "1", "2", "3");
        cq4.addChoices("จากข้อ 3 ได้ช่วงเวลาไหนบ้าง", "ตลอดเวลา 1 วิธี ช่วงเวลา 1 วิธี", "ตลอดเวลา 2 วิธี", "ช่วงเวลา 2 วิธี", "ไม่มีข้อถูก");
        cq5.addChoices("ช่วงเวลานี้ปีไหน", "2021", "2022", "2023", "2024");
        cq6.addChoices("บ้านบางโพ บ้านบางคลาส บ้านบางเอิน บ้านบางรัก บ้านบางระจัน บ้านบางพลัด บ้านบางที บ้านบางซื่อ เคยเดินหากันได้ไหม", "ไม่ได้", "ได้");
        choiceAnswers.add(cq1);
        choiceAnswers.add(cq2);
        choiceAnswers.add(cq3);
        choiceAnswers.add(cq4);
        choiceAnswers.add(cq5);
        choiceAnswers.add(cq6);

        quizPage();
    }


    public static void quizPage(){
        clear();
        ArrayList<String> choices = new ArrayList<>();
        if(questions.get(0).getChoiceType() == ChoiceType.CHOICE){
            for(ChoiceQuiz c:choiceAnswers){
                if(Objects.equals(c.getQuestion(), questions.get(0).getQuestion())){
                    choices.addAll(c.getChoices());
                }
            }
        }
        rootPane.getChildren().add(new HintButtonPane());
        rootPane.getChildren().add(new QuizPane(questions.get(0)));
        if(questions.get(0).getChoiceType() == ChoiceType.CHOICE){
            rootPane.getChildren().add(new ChoicePane(choices));
        } else {
            rootPane.getChildren().add(new TextPane());
        }
    }

    public static void hintPage(){
        clear();
        rootPane.getChildren().add(new HintPane());
    }

    public static void checkAnswer(String choice){
        clear();
        totalScore += questions.get(0).getScore();
        Boolean answer = false;
        if(choice.equals(questions.get(0).getAnswer())){
            answer = true;
            yourScore += questions.get(0).getScore();
        }
        answerPage(answer, questions.get(0).getAnswer(), questions.get(0).getScore());
    }

    public static void answerPage(Boolean answer, String correctChoice, int score){
        clear();
        rootPane.getChildren().add(new AnswerPane(answer, correctChoice, score));
    }

    public static void checkQuiz(){
        clear();
        questions.remove(0);
        if(questions.isEmpty()) scorePage();
        else quizPage();
    }

    public static void scorePage(){
        clear();
        music("res/music/scoremusic.mp3");
        rootPane.getChildren().add(new ScorePane(yourScore, totalScore));
    }
}