package item.base;

import item.usage.ChoiceType;
import item.usage.hasPicture;

public abstract class BaseQuestion extends BaseQuiz implements hasPicture {

    public BaseQuestion(ChoiceType choiceType, String question, String answer) {
        super(choiceType);
        setQuestion(question);
        setAnswer(answer);
    }

    public abstract String getAnswer();

    public abstract void setAnswer(String answer);

    public abstract String getQuestion() ;

    public abstract void setQuestion(String question);

    public abstract int getScore();

    @Override
    public abstract boolean getHasPicture();

    @Override
    public abstract String getPictureName();

    @Override
    public abstract void setPictureName(String pictureName);

}
