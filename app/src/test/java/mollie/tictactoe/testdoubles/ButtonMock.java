package mollie.tictactoe.testdoubles;

import android.content.Context;

import mollie.tictactoe.board.CellButton;

public class ButtonMock extends CellButton {

    private String mTag;
    private int mTimesCalledSetText;
    private int mTimesCalledSetEnabled;
    private String mArgument;
    private boolean mEnabledArgument;

    public ButtonMock(Context context) {
        super(context);
        mTimesCalledSetText = 0;
        mTimesCalledSetEnabled = 0;
        mArgument = "X";
        mEnabledArgument = false;
    }

    public void setTag(String tag) {
        mTag = tag;
    }

    public String getTag() {
        return mTag;
    }

    public void setText(String textToSet) {
        mArgument = textToSet;
        mTimesCalledSetText++;
    }

    public boolean setTextWasCalled(int times, String argument) {
        return (times == mTimesCalledSetText && argument.equals(mArgument));
    }

    public void setEnabled(boolean enabled) {
        mEnabledArgument = enabled;
        mTimesCalledSetEnabled++;
    }

    public boolean setEnabledWasCalled(int times, boolean enabledArgument) {

        return (times == mTimesCalledSetEnabled && enabledArgument == mEnabledArgument);
    }
}
