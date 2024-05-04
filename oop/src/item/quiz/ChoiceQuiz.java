package item.quiz;

import item.base.BaseQuiz;
import item.base.BaseReceived;
import item.usage.ChoiceNumber;
import item.usage.ChoiceType;
import item.usage.Hint;
import item.usage.hasPicture;

import java.util.ArrayList;

public class ChoiceQuiz extends BaseReceived implements ChoiceNumber, Hint {

    private String receivedAnswer;
    private ArrayList<String> ChoiceList;

    private  boolean useHint ;

    private String hint;
    public ChoiceQuiz(String receivedAnswer) {
        super(ChoiceType.CHOICE,receivedAnswer);
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
    public String getHint() {
        return hint;
    }

    @Override
    public void setHint(String hint) {
        this.hint = hint;
    }

    public boolean isUseHint() {
        return useHint;
    }

    public void setUseHint(boolean useHint) {
        this.useHint = useHint;
    }


}
