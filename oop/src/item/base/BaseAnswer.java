package item.base;

import item.usage.ChoiceType;

public class BaseAnswer extends BaseQuiz {

    private String question;
    private String answer;

    public BaseAnswer(String answer, ChoiceType type) {
        super(type);
        setAnswer(answer);

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

//
//    public abstract String getAnswer() ;
//
//    public abstract void setAnswer(String answer) ;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }



}
