package item.level;

import item.base.BaseQuiz;
import item.usage.ChoiceType;

public class Hard extends BaseQuiz {
    private String receivedAnswer;

    public Hard(ChoiceType type) {
        super(type);
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
}
