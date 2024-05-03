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
