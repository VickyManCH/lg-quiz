package item.base;

import item.usage.ChoiceType;
import item.usage.Hint;

public class BaseQuestion extends BaseQuiz implements Hint {

    private String question;


    public BaseQuestion(ChoiceType type, String question) {
        super(type);
        setQuestion(question);
    }

    public String getQuestion() {
        return question;
    }


    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String getReceivedAnswer() {
        return null;
    }

    @Override
    public void setReceivedAnswer(String s) {

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
    public boolean isUseHint() {
        return false;
    }

    @Override
    public void setUseHint(boolean useHint) {

    }


}
