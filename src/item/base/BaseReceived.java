package item.base;

import item.usage.ChoiceType;

public abstract class BaseReceived extends BaseQuiz {

    private ChoiceType choiceType;

    public BaseReceived(ChoiceType type, String received) {
        super(type);
    }

    public ChoiceType getChoiceType() {
        return choiceType;
    }
    public void setChoiceType(ChoiceType choiceType) {
        this.choiceType = choiceType;
    }

    //หมายเหตุ received คือ คำตอบที่ผู้เล่นตอบมา
}
