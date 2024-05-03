package item.base;

import item.usage.ChoiceType;
import item.usage.Hint;

public class BaseHint extends BaseQuiz implements Hint {

    private String hint;
    private  boolean useHint ;

    public BaseHint(String hint, ChoiceType type, boolean useHint) {
        super(type);
        setHint(hint);
        setUseHint(useHint);

    }




//
//    public abstract String getAnswer() ;
//
//    public abstract void setAnswer(String answer) ;




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

    @Override
    public String getReceivedAnswer() {
        return null;
    }

    @Override
    public void setReceivedAnswer(String s) {

    }

    @Override
    public String getAnswer() {
        return null;
    }

    @Override
    public void setAnswer(String answer) {

    }
}
