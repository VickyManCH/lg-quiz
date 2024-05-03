package item.base;

import item.usage.ChoiceType;

public class BaseAnswer extends BaseQuiz {

    private String answer;

    public BaseAnswer(String answer, ChoiceType type) {
        super(type);
        setAnswer(answer);

    }


    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
