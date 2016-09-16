package mollie.tictactoe.testdoubles;

import android.content.Context;
import android.view.View;

import mollie.tictactoe.ui.BoardView;
import mollie.tictactoe.ui.CellButton;

public class ViewFake extends BoardView {

    private CellButton mButton;

    public ViewFake(Context context) {
        super(context);
    }

    public void setButton(CellButton button) {
        mButton = button;
    }

    @Override
    public View findViewWithTag(String tag) {
        return mButton;
    }

    @Override
    public CellButton findButtonByPosition(int position) {
        return mButton;
    }
}
