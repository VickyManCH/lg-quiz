package item.level;

import item.base.BaseQuestion;
import item.usage.ChoiceType;
import item.usage.hasPicture;

public class MediumQuestion extends BaseQuestion implements hasPicture {

    private String question;

    private String answer;

    private Boolean hasPicture;

    private final int SCORE = 2;

    public MediumQuestion(ChoiceType type, String question, String answer) {
        super(type,question,answer);
    }

    public String getQuestion() {
        return question;
    }

    @Override
    public String getAnswer(){
        return answer;
    }

    @Override
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getScore(){
        return SCORE;
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
