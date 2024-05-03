package item.base;

import item.usage.ChoiceType;
import item.usage.Hint;

public class BaseReceived extends BaseQuiz implements Hint {

    private String received;
    private ChoiceType choiceType;

    public BaseReceived(ChoiceType type, String received) {
        super(type);
        setChoiceType(type);
        setReceivedAnswer(received);
    }



    public ChoiceType getChoiceType() {
        return choiceType;
    }
    public void setChoiceType(ChoiceType choiceType) {
        this.choiceType = choiceType;
    }

    @Override
    public String getReceivedAnswer() {
        return received;
    }

    @Override
    public void setReceivedAnswer(String received) {
        this.received = received;
    }

    @Override
    public String getAnswer() {
        return null;
    }

    @Override
    public void setAnswer(String answer) {

    }


    @Override
    public String getHint() {
        return null;
    }

    @Override
    public void setHint(String hint) {

    }

    @Override
    public boolean useHint() {
        return false;
    }


    //คำตอบที่ผู้เล่นตอบมา

}
