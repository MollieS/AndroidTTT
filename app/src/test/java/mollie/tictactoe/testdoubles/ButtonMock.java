package mollie.tictactoe.testdoubles;

import android.content.Context;

import mollie.tictactoe.board.CellButton;

public class ButtonMock extends CellButton {

    private int mTimesCalledGetButtonPosition;
    private int mTimesCalledSetText;
    private int mTimesCalledSetEnabled;
    private String mTag;
    private String mArgument;

    public ButtonMock(Context context) {
        super(context);
        mTimesCalledSetText = 0;
        mTimesCalledSetEnabled = 0;
        mTimesCalledGetButtonPosition = 0;
        mArgument = "X";
    }

    @Override
    public void disable() {
        mTimesCalledSetEnabled++;
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

    public boolean disableWasCalled(int times) {
        return (times == mTimesCalledSetEnabled);
    }

    public int getButtonPosition() {
        mTimesCalledGetButtonPosition++;
        return Integer.valueOf(mTag);
    }

    public boolean getButtonPositionWasCalled(int times) {
        return (times == mTimesCalledGetButtonPosition);
    }
}
