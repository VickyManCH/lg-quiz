package item.base;

import item.usage.ChoiceType;
import item.usage.Hint;

public abstract class BaseQuiz implements Hint {

    private String question;
    private ChoiceType choiceType;

    public BaseQuiz(ChoiceType type) {
        setChoiceType(type);
    }

    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }

    public ChoiceType getChoiceType() {
        return choiceType;
    }
    public void setChoiceType(ChoiceType choiceType) {
        this.choiceType = choiceType;
    }


    public abstract String getReceivedAnswer();
    public abstract void setReceivedAnswer(String s);

    //คำตอบที่ผู้เล่นตอบมา

}
