package item.quiz;

import item.base.BaseReceived;
import item.usage.ChoiceType;

public class TextQuiz extends BaseReceived{

    private String receivedAnswer;

    public TextQuiz(String receivedAnswer){
        super(ChoiceType.TEXT,receivedAnswer);
    }

    public String getReceivedAnswer() {
        return receivedAnswer;
    }

    public void setReceivedAnswer(String receivedAnswer) {
        this.receivedAnswer = receivedAnswer;
    }

}
