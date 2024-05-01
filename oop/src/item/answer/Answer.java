package item.answer;

import item.base.BaseAnswer;

public class Answer extends BaseAnswer {


    private String answer;


    public Answer(String answer){
        super(answer);
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
