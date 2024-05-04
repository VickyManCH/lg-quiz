package item.base;

import item.usage.ChoiceType;
import item.usage.Hint;

public abstract class BaseQuestion extends BaseQuiz{

    private String question;


    public BaseQuestion(ChoiceType choiceType, String question) {
        super(choiceType);
        setQuestion(question);
    }

    public abstract String getQuestion() ;


    public abstract void setQuestion(String question) ;


}
