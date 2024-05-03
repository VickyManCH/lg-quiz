package player;


import item.base.BaseAnswer;
import item.base.BaseQuestion;
import item.base.BaseQuiz;
import item.base.BaseReceived;
import item.level.Easy;
import item.level.Hard;
import item.level.Medium;
import item.quiz.ChoiceQuiz;
import item.quiz.TextQuiz;
import item.usage.ChoiceType;
import item.usage.Hint;

import java.util.*;

public class QuizGame {

    private final ArrayList<BaseQuiz> QUESTION;
    private final ArrayList<BaseQuiz> HINT;
    private final ArrayList<BaseQuiz> RECEIVED;
    // คำตอบที่ผู้เล่นตอบมา
    private final ArrayList<BaseAnswer> ANSWER;
    // เฉลย
    private int score ;

    private final int QUIZ_SIZE;

    public QuizGame() {
        RECEIVED = new ArrayList<>();
        ANSWER = new ArrayList<>();
        QUESTION = new ArrayList<>();
        HINT = new ArrayList<>();
        QUIZ_SIZE = 20;


    }


    public ArrayList<BaseQuiz> getQuestion() {
        return QUESTION;
    }

    public ArrayList<BaseQuiz> getReceived() {
        return RECEIVED;
    }

    public ArrayList<BaseAnswer> getAnswer() {
        return ANSWER;
    }

    public ArrayList<BaseQuiz> getHint() {
        return HINT;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = Math.max(score,0);
    }

    public void addQuestion(BaseQuiz question) {
        if (QUESTION.size() <= QUIZ_SIZE) {
            QUESTION.add(question);
        }
        else {

            System.out.println("=====================================");
            System.out.println("Your quiz cannot more than 10 question");

        }
    }

    public void addReceived(BaseReceived Received) {
        if (RECEIVED.size() <= QUIZ_SIZE) {
            RECEIVED.add(Received);
        }
        else {

            System.out.println("=====================================");
            System.out.println("Your quiz cannot more than 10 received answer");
        }
    }



    public void addAnswer(BaseAnswer Answer) {
        if (ANSWER.size() <= QUIZ_SIZE) {
            ANSWER.add(Answer);
        }
        else {

            System.out.println("=====================================");
            System.out.println("Your quiz cannot more than 10 answer");

        }
    }

    public void addHint(BaseQuiz hint) {
        if (HINT.size() <= QUIZ_SIZE) {
            HINT.add(hint);
        }
        else {

            System.out.println("=====================================");
            System.out.println("Your quiz cannot more than 10 hint");

        }
    }

//    public void setUpQuestion(){
//        QUESTION.add(new BaseQuestion(ChoiceType.CHOICE,"บางพลัดกับบางรักเคยเดินหากันภายใน 10 นาทีใช่ไหม") );
//        QUESTION.add(new BaseQuestion(ChoiceType.CHOICE,"จากข้อ 2 ตลอดเวลาหรือเป็นช่วงเวลา") );
//        QUESTION.add(new BaseQuestion(ChoiceType.CHOICE,"บางซื่อกับบางโพเคยเดินหากันภายใน 10 นาที กี่วิธี") );
//        QUESTION.add(new BaseQuestion(ChoiceType.CHOICE,"จากข้อ 3 ได้ช่วงเวลาไหนบ้าง") );
//        QUESTION.add(new BaseQuestion(ChoiceType.CHOICE,"ช่วงเวลานี้ปีไหน") );
//        QUESTION.add(new BaseQuestion(ChoiceType.CHOICE,"บ้านบางโพ บ้านบางคลาส บ้านบางเอิน บ้านบางรัก บ้านบางระจัน บ้านบางพลัด บ้านบางที่ บ้านบางซื่อ เคยเดินหากันได้ไหม") );
//        QUESTION.add(new BaseQuestion(ChoiceType.CHOICE,"บ้านบางคลาส คือ บ้านที่") );
//        QUESTION.add(new BaseQuestion(ChoiceType.CHOICE,"บ้านบางระจัน คือ บ้านที่") );
//        QUESTION.add(new BaseQuestion(ChoiceType.CHOICE,"บ้านบางซื่อ คือ บ้านที่") );
//        QUESTION.add(new BaseQuestion(ChoiceType.CHOICE,"บ้านบางโพ คือ บ้านที่") );
//        QUESTION.add(new BaseQuestion(ChoiceType.CHOICE,"บ้านบางพลัด คือ บ้านที่") );
//        QUESTION.add(new BaseQuestion(ChoiceType.CHOICE,"บ้านบางรัก คือ บ้านที่") );
//        QUESTION.add(new BaseQuestion(ChoiceType.CHOICE,"บ้านบางเอิน คือ บ้านที่") );
//        QUESTION.add(new BaseQuestion(ChoiceType.CHOICE,"บ้านบางที่ คือ บ้านที่") );
//    }

    public void setUpAnswer(){
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

    public int QuizScore(BaseQuiz quiz) {
        this.setScore(0);
        for (int i = 0; i < 10; i++) {
            if (Objects.equals(RECEIVED.get(i).getReceivedAnswer(), ANSWER.get(i).getAnswer())) {
                if(quiz instanceof Easy){
                    this.setScore(this.getScore() + 5);
                }
                else if(quiz instanceof Medium){
                    this.setScore(this.getScore() + 10);
                }
                else if(quiz instanceof Hard){
                    this.setScore(this.getScore() + 20);
                }

            }
            else if(!Objects.equals(RECEIVED.get(i).getReceivedAnswer(), ANSWER.get(i).getAnswer())){
                if(quiz instanceof ChoiceQuiz){
                    this.setScore(this.getScore() - 5);
                }
                else if(quiz instanceof TextQuiz){
                    this.setScore(this.getScore() - 2);
                }

            }

//            if (quiz.useHint()){
//                this.setScore(this.getScore() - 6);
//            }

        }
        return this.getScore();
    }

    public String Rank() {
        if (this.getScore() >= 105){
            return "Legendary" ;
        }
        else if (this.getScore() >= 70 && this.getScore() < 105){
            return "Diamond" ;
        }
        else if (this.getScore() >= 45 && this.getScore() < 70){
            return "Gold" ;
        }
        else if (this.getScore() >= 25 && this.getScore() < 45){
            return "Silver" ;
        }
        else if (this.getScore() >= 10 && this.getScore() < 25){
            return "Bronze" ;
        }
        else {
            return "None" ;
        }

    }











}
