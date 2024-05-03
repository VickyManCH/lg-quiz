package main;


import item.base.BaseAnswer;
import item.base.BaseQuiz;
import item.base.BaseReceived;
import item.level.Easy;
import item.level.Hard;
import item.level.Medium;
import item.quiz.ChoiceQuiz;
import item.quiz.TextQuiz;
import item.usage.ChoiceType;
import item.base.BaseQuestion;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import item.usage.ChoiceType;

public class Main {

    private static ArrayList<BaseQuiz> QUESTION = new ArrayList<>();
    private static final ArrayList<BaseQuiz> RECEIVED = new ArrayList<>();

    private static final ArrayList<BaseQuiz> ANSWER = new ArrayList<>();

    private static final ArrayList<ChoiceQuiz> choiceList = new ArrayList<>();

    private static final ArrayList<String[]>  CHOICELIST = new ArrayList<>();

    private static int score ;



    public Main(ArrayList<BaseQuiz> question) {
        QUESTION = question;
    }

    public static void main(String[] args) {

        System.out.println("======================================================================");
        System.out.println(" Welcome To Lg_Game");
        Scanner sc = new Scanner(System.in);


        //!gs.isGameEnd()


        setUpQuestion();
        setUpAnswer();
        setUpChoice();
        int i = 0;


        for (BaseQuiz quiz : QUESTION) {

            System.out.println( i+1 + ". " + quiz.getQuestion());
            if(i<6){
                for(int j=0 ; j<CHOICELIST.get(i).length ; j++){
                    System.out.println(CHOICELIST.get(i)[j]);
                }
            }


            System.out.print("Your answer: ");

            String received = sc.nextLine();
            RECEIVED.add(new BaseReceived(ChoiceType.CHOICE,received));
//            quiz.setReceivedAnswer(received);
//            System.out.println("Received answer: " + received);
            if (Objects.equals(RECEIVED.get(i).getReceivedAnswer(), ANSWER.get(i).getAnswer())){
                System.out.print("Correct");
            }
            else {
                System.out.print("Wrong");
            }
            i++;

            sc.nextLine();
        }
        int score = QuizScore();
        System.out.println("Your score is: " + score);







        }


    public static void setUpQuestion(){
        QUESTION.add(new BaseQuestion(ChoiceType.CHOICE,"บางพลัดกับบางรักเคยเดินหากันภายใน 10 นาทีใช่ไหม") );
        QUESTION.add(new BaseQuestion(ChoiceType.CHOICE,"จากข้อ 2 ตลอดเวลาหรือเป็นช่วงเวลา") );
        QUESTION.add(new BaseQuestion(ChoiceType.CHOICE,"บางซื่อกับบางโพเคยเดินหากันภายใน 10 นาที กี่วิธี") );
        QUESTION.add(new BaseQuestion(ChoiceType.CHOICE,"จากข้อ 3 ได้ช่วงเวลาไหนบ้าง") );
        QUESTION.add(new BaseQuestion(ChoiceType.CHOICE,"ช่วงเวลานี้ปีไหน") );
        QUESTION.add(new BaseQuestion(ChoiceType.CHOICE,"บ้านบางโพ บ้านบางคลาส บ้านบางเอิน บ้านบางรัก บ้านบางระจัน บ้านบางพลัด บ้านบางที่ บ้านบางซื่อ เคยเดินหากันได้ไหม") );
        QUESTION.add(new BaseQuestion(ChoiceType.CHOICE,"บ้านบางคลาส คือ บ้านที่") );
        QUESTION.add(new BaseQuestion(ChoiceType.CHOICE,"บ้านบางระจัน คือ บ้านที่") );
        QUESTION.add(new BaseQuestion(ChoiceType.CHOICE,"บ้านบางซื่อ คือ บ้านที่") );
        QUESTION.add(new BaseQuestion(ChoiceType.CHOICE,"บ้านบางโพ คือ บ้านที่") );
        QUESTION.add(new BaseQuestion(ChoiceType.CHOICE,"บ้านบางพลัด คือ บ้านที่") );
        QUESTION.add(new BaseQuestion(ChoiceType.CHOICE,"บ้านบางรัก คือ บ้านที่") );
        QUESTION.add(new BaseQuestion(ChoiceType.CHOICE,"บ้านบางเอิน คือ บ้านที่") );
        QUESTION.add(new BaseQuestion(ChoiceType.CHOICE,"บ้านบางที่ คือ บ้านที่") );

    }

    public static void setUpAnswer(){
        ANSWER.add(new BaseAnswer("1",ChoiceType.CHOICE) );
        ANSWER.add(new BaseAnswer("1",ChoiceType.CHOICE) );
        ANSWER.add(new BaseAnswer("3",ChoiceType.CHOICE) );
        ANSWER.add(new BaseAnswer("0",ChoiceType.CHOICE) );
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

    public static void setUpChoice(){
        CHOICELIST.add(new String[]{"<1> เคย","<2> ไม่เคย"});
        CHOICELIST.add(new String[]{"<1> ช่วงเวลา","<2> ตลอดเวลา"});
        CHOICELIST.add(new String[]{"<1> 0","<2> 1 ","<3> 2"});
        CHOICELIST.add(new String[]{"<1> ช่วงเวลาทั้ง 2 วิธี","<2> ตลอดเวลาทั้ง 2 วิธี","<3> ตลอดเวลา 1 วิธี","<4> ช่วงเวลา 1 วิธี"});
        CHOICELIST.add(new String[]{"<1> 2024","<2> 2023","<3> 2022"});
        CHOICELIST.add(new String[]{"<1> ได้","<2> ไม่ได้"});
    }


    public static int QuizScore() {
        setScore(0);
        int numQuestions = Math.min(RECEIVED.size(), ANSWER.size());
        for (int i = 0; i < numQuestions; i++) {
            if (Objects.equals(RECEIVED.get(i).getReceivedAnswer(), ANSWER.get(i).getAnswer())) {
               
                    setScore(getScore() + 5);
                

            }




        }
        return getScore();
    }


    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        Main.score = score;
    }
}
