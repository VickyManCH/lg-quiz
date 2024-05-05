package item.level;

import item.base.BaseQuestion;
import item.usage.ChoiceType;
import item.usage.hasPicture;

public class HardQuestion extends BaseQuestion implements hasPicture {

    private String question;

    private String answer;

    private Boolean hasPicture = false;

    private String pictureName;

    private final int SCORE = 3;

    public HardQuestion(ChoiceType type, String question, String answer) {
        super(type, question,answer);
    }

    public HardQuestion(ChoiceType type, String question, String answer, String pictureName) {
        super(type,question,answer);
        hasPicture = true;
        setPictureName(pictureName);
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

    @Override
    public int getScore(){
        return SCORE;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


    @Override
    public boolean getHasPicture() {
        return hasPicture;
    }

    @Override
    public String getPictureName() {
        return pictureName;
    }

    @Override
    public void setPictureName(String pictureName){
        this.pictureName = pictureName;
    }
}
