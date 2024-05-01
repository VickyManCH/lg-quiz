package item.base;

import item.usage.ChoiceType;

public abstract class BaseAnswer {

    private String question;
    private String answer;

    public BaseAnswer(String answer) {
        super();

    }


    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }


    public abstract String getAnswer() ;

    public abstract void setAnswer(String answer) ;



}
