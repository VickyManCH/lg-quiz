package main;


import item.base.*;
import item.level.EasyQuestion;
import item.level.HardQuestion;
import item.level.MediumQuestion;
import item.quiz.ChoiceQuiz;
import item.quiz.TextQuiz;
import item.usage.ChoiceType;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static ArrayList<BaseQuestion> QUESTION = new ArrayList<>();

    private static final ArrayList<BaseReceived> RECEIVED = new ArrayList<>();

    private static final ArrayList<BaseAnswer> ANSWER = new ArrayList<>();

    private static ArrayList<BaseQuestion> questionRelease = new ArrayList<>();

    private static final ArrayList<ChoiceQuiz>  CHOICELIST = new ArrayList<>();

    private static final ArrayList<BaseHint> HINT = new ArrayList<>();

    private static int score ;





    public Main(ArrayList<BaseQuestion> question) {
        QUESTION = question;
    }

    public static void main(String[] args) {

        System.out.println("======================================================================");
        System.out.println(" ");
        System.out.println(" Welcome To Lg_Game");
        System.out.println(" ");
        System.out.println(" Click Enter To Start The Game");

        Scanner sc = new Scanner(System.in);

            setUpQuestion();
            setUpAnswer();
            setUpChoice();
            setUpHint();



        sc.nextLine();
        int i=0;

       while(!questionRelease.isEmpty()) {

            System.out.println(" ");
            System.out.println("---------------------------------------------");
            System.out.println(" ");
            System.out.println( i+1 + ". " + questionRelease.get(0).getQuestion());

            if(i<6){
                for(int j=0 ; j<CHOICELIST.get(i).getChoiceNumber(); j++){
                    switch (CHOICELIST.get(i).getChoiceNumber()) {
                        case 2 -> System.out.println(CHOICELIST.get(i).getTwoChoiceList()[j]);
                        case 3 -> System.out.println(CHOICELIST.get(i).getThreeChoiceList()[j]);
                        case 4 -> System.out.println(CHOICELIST.get(i).getFourChoiceList()[j]);
                    }

                }
            }

            System.out.println("if you want to see hint please type <0>");
            System.out.print("Your answer: ");

            String received = sc.nextLine();

            if(!Objects.equals(received, "0")){

                if(questionRelease.get(0).getChoiceType() == ChoiceType.CHOICE){
                    RECEIVED.add(new ChoiceQuiz(received));
                }
                else{
                    RECEIVED.add(new TextQuiz(received));
                }

            }
            else {
                System.out.println("HINT : " + HINT.get(i).getHint());
                System.out.print("Your answer: ");

                HINT.get(i).setUseHint(true);

                received = sc.nextLine();

                if(questionRelease.get(0).getChoiceType() == ChoiceType.CHOICE){
                    RECEIVED.add(new ChoiceQuiz(received));
                }
                else{
                    RECEIVED.add(new TextQuiz(received));
                }
            }

            if (Objects.equals(RECEIVED.get(i).getReceivedAnswer(), ANSWER.get(i).getAnswer())){
                System.out.print("Correct");
            }
            else {
                System.out.print("Wrong");
            }
            
            questionRelease.remove(0);
            i++;
            sc.nextLine();
        }

        int score = QuizScore();
        String rank = Ranking();
        sc.nextLine();
        System.out.println("Your score is: " + score);
        sc.nextLine();
        System.out.println("Rank : " + rank);
        }


    public static void setUpQuestion(){

        QUESTION.add(new EasyQuestion(ChoiceType.CHOICE,"บางพลัดกับบางรักเคยเดินหากันภายใน 10 นาทีใช่ไหม") );
        QUESTION.add(new MediumQuestion(ChoiceType.CHOICE,"จากข้อ 2 ตลอดเวลาหรือเป็นช่วงเวลา") );
        QUESTION.add(new MediumQuestion(ChoiceType.CHOICE,"บางซื่อกับบางโพเคยเดินหากันภายใน 10 นาที กี่วิธี") );
        QUESTION.add(new EasyQuestion(ChoiceType.CHOICE,"จากข้อ 3 ได้ช่วงเวลาไหนบ้าง") );
        QUESTION.add(new MediumQuestion(ChoiceType.CHOICE,"ช่วงเวลานี้ปีไหน") );
        QUESTION.add(new EasyQuestion(ChoiceType.CHOICE,"บ้านบางโพ บ้านบางคลาส บ้านบางเอิน บ้านบางรัก บ้านบางระจัน บ้านบางพลัด บ้านบางที่ บ้านบางซื่อ เคยเดินหากันได้ไหม") );
        QUESTION.add(new MediumQuestion(ChoiceType.TEXT,"บ้านบางคลาส คือ บ้านที่") );
        QUESTION.add(new HardQuestion(ChoiceType.TEXT,"บ้านบางระจัน คือ บ้านที่") );
        QUESTION.add(new EasyQuestion(ChoiceType.TEXT,"บ้านบางซื่อ คือ บ้านที่") );
        QUESTION.add(new EasyQuestion(ChoiceType.TEXT,"บ้านบางโพ คือ บ้านที่") );
        QUESTION.add(new MediumQuestion(ChoiceType.TEXT,"บ้านบางพลัด คือ บ้านที่") );
        QUESTION.add(new HardQuestion(ChoiceType.TEXT,"บ้านบางรัก คือ บ้านที่") );
        QUESTION.add(new MediumQuestion(ChoiceType.TEXT,"บ้านบางเอิน คือ บ้านที่") );
        QUESTION.add(new HardQuestion(ChoiceType.TEXT,"บ้านบางที่ คือ บ้านที่") );

        questionRelease.addAll(QUESTION);

    }

    public static void setUpAnswer(){

        ANSWER.add(new BaseAnswer("1",ChoiceType.CHOICE) );
        ANSWER.add(new BaseAnswer("1",ChoiceType.CHOICE) );
        ANSWER.add(new BaseAnswer("3",ChoiceType.CHOICE) );
        ANSWER.add(new BaseAnswer("1",ChoiceType.CHOICE) );
        ANSWER.add(new BaseAnswer("1",ChoiceType.CHOICE) );
        ANSWER.add(new BaseAnswer("1",ChoiceType.CHOICE) );
        ANSWER.add(new BaseAnswer("2",ChoiceType.CHOICE) );
        ANSWER.add(new BaseAnswer("5",ChoiceType.CHOICE) );
        ANSWER.add(new BaseAnswer("8",ChoiceType.CHOICE) );
        ANSWER.add(new BaseAnswer("1",ChoiceType.CHOICE) );
        ANSWER.add(new BaseAnswer("6",ChoiceType.CHOICE) );
        ANSWER.add(new BaseAnswer("4",ChoiceType.CHOICE) );
        ANSWER.add(new BaseAnswer("3",ChoiceType.CHOICE) );
        ANSWER.add(new BaseAnswer("7",ChoiceType.CHOICE) );
    }

    public static void setUpHint(){

        HINT.add(new BaseHint("dthdg",ChoiceType.CHOICE,false) );
        HINT.add(new BaseHint("hgh",ChoiceType.CHOICE,false) );
        HINT.add(new BaseHint("ghgdj",ChoiceType.CHOICE,false) );
        HINT.add(new BaseHint("gjdgj",ChoiceType.CHOICE,false) );
        HINT.add(new BaseHint("gjfgj",ChoiceType.CHOICE,false) );
        HINT.add(new BaseHint("jfgjf",ChoiceType.CHOICE,false) );
        HINT.add(new BaseHint("fgjfgj",ChoiceType.CHOICE,false) );
        HINT.add(new BaseHint("gjdgjd",ChoiceType.CHOICE,false) );
        HINT.add(new BaseHint("dgjdgf",ChoiceType.CHOICE,false) );
        HINT.add(new BaseHint("dgjdgjfdjf",ChoiceType.CHOICE,false) );
        HINT.add(new BaseHint("djgdgjjg",ChoiceType.CHOICE,false) );
        HINT.add(new BaseHint("dgjdgj",ChoiceType.CHOICE,false) );
        HINT.add(new BaseHint("dgjdj",ChoiceType.CHOICE,false) );
        HINT.add(new BaseHint("gjddg",ChoiceType.CHOICE,false) );

    }

    public static void setUpChoice(){

        ChoiceQuiz choiceQ1 = new ChoiceQuiz(" ");
        ChoiceQuiz choiceQ2 = new ChoiceQuiz(" ");
        ChoiceQuiz choiceQ3 = new ChoiceQuiz(" ");
        ChoiceQuiz choiceQ4 = new ChoiceQuiz(" ");
        ChoiceQuiz choiceQ5 = new ChoiceQuiz(" ");
        ChoiceQuiz choiceQ6 = new ChoiceQuiz(" ");

        choiceQ1.setTwoChoiceList("เคย","ไม่เคย");
        choiceQ2.setTwoChoiceList("ช่วงเวลา","ตลอดเวลา");
        choiceQ3.setThreeChoiceList("0","1","2");
        choiceQ4.setFourChoiceList("ช่วงเวลาทั้ง 2 วิธี","ตลอดเวลาทั้ง 2 วิธี","ตลอดเวลา 1 วิธี","ช่วงเวลา 1 วิธี");
        choiceQ5.setThreeChoiceList("2024","2023","2022");
        choiceQ6.setTwoChoiceList("ได้","ไม่ได้");

        CHOICELIST.add(choiceQ1);
        CHOICELIST.add(choiceQ2);
        CHOICELIST.add(choiceQ3);
        CHOICELIST.add(choiceQ4);
        CHOICELIST.add(choiceQ5);
        CHOICELIST.add(choiceQ6);

    }


    public static int QuizScore() {

        setScore(0);
        int numQuestions = Math.min(RECEIVED.size(), ANSWER.size());

        for (int i = 0; i < numQuestions; i++) {

            if (Objects.equals(RECEIVED.get(i).getReceivedAnswer(), ANSWER.get(i).getAnswer())) {

                if(QUESTION.get(i) instanceof EasyQuestion){
                    setScore(getScore() + 5);
                }
                else if(QUESTION.get(i) instanceof MediumQuestion){
                    setScore(getScore() + 10);
                }
                else if(QUESTION.get(i) instanceof HardQuestion){
                    setScore(getScore() + 20);
                }

            }

            else{
                if(RECEIVED.get(i) instanceof ChoiceQuiz){
                    setScore(getScore() - 5);
                }
                else if(RECEIVED.get(i) instanceof TextQuiz){
                    setScore(getScore() - 3);
                }
            }

            if(HINT.get(i).isUseHint()){
                setScore(getScore() - 6);
            }
            else {
                setScore(getScore() + 2);
            }

        }
        return getScore();
    }



    public static String Ranking() {
        if (getScore() >= 120){
            return "Legendary" ;
        }
        else if (getScore() >= 80){
            return "Diamond" ;
        }
        else if (getScore() >= 45){
            return "Gold" ;
        }
        else if (getScore() >= 25){
            return "Silver" ;
        }
        else if (getScore() >= 10){
            return "Bronze" ;
        }
        else {
            return "None" ;
        }

    }

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        Main.score = Math.max(score,0);
    }

    public static String getQuestion() {
        while (!questionRelease.isEmpty()) {
            String s = questionRelease.get(0).getQuestion();
            questionRelease.remove(0);

                return s;

            }
        return null;
    }




}
