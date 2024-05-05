package item.quiz;

import item.base.BaseQuiz;
import item.usage.ChoiceType;
import item.usage.Hint;
import item.usage.hasPicture;

import java.util.ArrayList;

public class ChoiceQuiz extends BaseReceived implements ChoiceNumber, Hint {

    private String receivedAnswer;
    private String[] TwoChoiceList;
    private String[] ThreeChoiceList;
    private String[] FourChoiceList;

    private int choiceNumber ;

    private  boolean useHint ;

    private String hint;
    public ChoiceQuiz(String receivedAnswer) {
        super(ChoiceType.CHOICE,receivedAnswer);
    }

    @Override
    public int getChoiceNumber() {
        return choiceNumber;
    }

    @Override
    public void setChoiceNumber(int choiceNumber) {
        this.choiceNumber = choiceNumber;
    }


    public String getReceivedAnswer() {
        return receivedAnswer;
    }

    public void setReceivedAnswer(String receivedAnswer) {
        this.receivedAnswer = receivedAnswer;
    }

    public String[] getTwoChoiceList() {
        return TwoChoiceList;
    }
    public String[] getThreeChoiceList() {
        return ThreeChoiceList;
    }
    public String[] getFourChoiceList() {
        return FourChoiceList;
    }



    public void setTwoChoiceList(String choice1,String choice2) {
        this.TwoChoiceList = new String[] {choice1, choice2};
        setChoiceNumber(2);
    }

    public void setThreeChoiceList(String choice1,String choice2,String choice3) {
        this.ThreeChoiceList = new String[] {choice1, choice2, choice3};
        setChoiceNumber(3);
    }

    public void setFourChoiceList(String choice1,String choice2,String choice3,String choice4) {
        this.FourChoiceList = new String[] {choice1, choice2, choice3, choice4};
        setChoiceNumber(4);
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
