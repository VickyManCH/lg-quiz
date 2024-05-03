package item.quiz;

import item.base.BaseQuiz;
import item.usage.ChoiceNumber;
import item.usage.ChoiceType;
import item.usage.Hint;
import item.usage.hasPicture;

import java.util.ArrayList;

public class ChoiceQuiz extends BaseQuiz implements ChoiceNumber, hasPicture, Hint {

    private String receivedAnswer;
    private ArrayList<String> ChoiceList;

    private String hint;
    public ChoiceQuiz(String choice) {
        super(ChoiceType.CHOICE);


    }





    @Override
    public int getChoiceNumber(int choiceNumber) {
        return choiceNumber;
    }


    public String getReceivedAnswer() {
        return receivedAnswer;
    }

    public void setReceivedAnswer(String receivedAnswer) {
        this.receivedAnswer = receivedAnswer;
    }

    @Override
    public String getAnswer() {
        return null;
    }

    @Override
    public void setAnswer(String answer) {

    }

    public ArrayList<String> getChoiceList() {
        return ChoiceList;
    }

    public void addChoiceList(String choice) {
        ChoiceList.add(choice);
    }

    public void setChoiceList(ArrayList<String> choiceList) {
        ChoiceList = choiceList;
    }

    @Override
    public boolean getHasPicture() {
        return false;
    }

    @Override
    public String getPictureName() {
        return null;
    }

    @Override
    public String getHint() {
        return hint;
    }

    @Override
    public void setHint(String hint) {
        this.hint = hint ;
    }

    @Override
    public boolean useHint() {
        return false;
    }
}
