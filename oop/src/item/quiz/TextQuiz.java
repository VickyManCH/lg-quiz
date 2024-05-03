package item.quiz;
import item.base.BaseQuiz;
import item.usage.Hint;
import item.usage.hasPicture;
import item.usage.ChoiceType;
public class TextQuiz extends BaseQuiz implements hasPicture, Hint {


    private String receivedAnswer;
    private String hint;
    public TextQuiz(){
        super(ChoiceType.TEXT);
    }

    @Override
    public boolean getHasPicture() {
        return false;
    }

    @Override
    public String getPictureName() {
        return null;
    }


    public String getReceivedAnswer() {
        return receivedAnswer;
    }

    public void setReceivedAnswer(String receivedAnswer) {
        this.receivedAnswer = receivedAnswer;
    }

    @Override
    public String getAnswer() {
        return null;
    }

    @Override
    public void setAnswer(String answer) {

    }


    @Override
    public String getHint() {
        return hint;
    }

    @Override
    public void setHint(String hint) {
        this.hint = hint ;
    }

    @Override
    public boolean useHint() {
        return false;
    }
}
