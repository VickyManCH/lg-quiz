package item.base;

import item.usage.ChoiceType;

public abstract class BaseReceived extends BaseQuiz {

    private ChoiceType choiceType;

    public BaseReceived(ChoiceType type, String received) {
        super(type);
        setReceivedAnswer(received);
    }

    public ChoiceType getChoiceType() {
        return choiceType;
    }
    public void setChoiceType(ChoiceType choiceType) {
        this.choiceType = choiceType;
    }


    public abstract String getReceivedAnswer();


    public abstract void setReceivedAnswer(String received);

    //หมายเหตุ received คือ คำตอบที่ผู้เล่นตอบมา
}
