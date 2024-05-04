package item.base;

import item.usage.ChoiceType;
import item.usage.Hint;

public abstract class BaseQuiz {
    private ChoiceType choiceType;

    public BaseQuiz(ChoiceType choiceType) {
        setChoiceType(choiceType);
    }

    public ChoiceType getChoiceType() {
        return choiceType;
    }

    public void setChoiceType(ChoiceType choiceType) {
        this.choiceType = choiceType;
    }


}
