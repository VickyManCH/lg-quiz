package item.level;

import item.base.BaseQuestion;
import item.usage.ChoiceType;
import item.usage.hasPicture;

public class MediumQuestion extends BaseQuestion implements hasPicture {

    private String question;
    public MediumQuestion(ChoiceType type, String question) {
        super(type,question);
    }

    public String getQuestion() {
        return question;
    }


    public void setQuestion(String question) {
        this.question = question;
    }


    @Override
    public boolean getHasPicture() {
        return false;
    }

    @Override
    public String getPictureName() {
        return null;
    }
}