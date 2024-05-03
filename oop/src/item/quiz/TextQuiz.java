package item.quiz;
import item.base.BaseQuiz;
import item.base.BaseReceived;
import item.usage.Hint;
import item.usage.hasPicture;
import item.usage.ChoiceType;
public class TextQuiz extends BaseReceived implements Hint {


    private String receivedAnswer;
    private String hint;

    private  boolean useHint ;
    public TextQuiz(String receivedAnswer){
        super(ChoiceType.TEXT,receivedAnswer);
    }

    public String getReceivedAnswer() {
        return receivedAnswer;
    }

    public void setReceivedAnswer(String receivedAnswer) {
        this.receivedAnswer = receivedAnswer;
    }

    @Override
    public String getHint() {
        return hint;
    }

    @Override
    public void setHint(String hint) {
        this.hint = hint;
    }

    public boolean isUseHint() {
        return useHint;
    }

    public void setUseHint(boolean useHint) {
        this.useHint = useHint;
    }


}
