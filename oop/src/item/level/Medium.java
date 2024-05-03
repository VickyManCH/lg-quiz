package item.level;

import item.base.BaseQuiz;
import item.usage.ChoiceType;

public class Medium extends BaseQuiz {

    private String receivedAnswer;

    public Medium(ChoiceType type) {
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


}
