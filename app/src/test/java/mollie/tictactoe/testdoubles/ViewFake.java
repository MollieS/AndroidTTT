package mollie.tictactoe.testdoubles;

import android.content.Context;
import android.view.View;

import mollie.tictactoe.board.BoardView;
import mollie.tictactoe.board.CellButton;

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

}
