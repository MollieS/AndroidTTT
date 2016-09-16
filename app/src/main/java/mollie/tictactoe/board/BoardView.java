package mollie.tictactoe.board;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

public class BoardView extends RelativeLayout {

    public BoardView(Context context) {
        super(context);
    }

    public BoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BoardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BoardView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public View findViewWithTag(String tag) {
        return super.findViewWithTag(tag);
    }

    public CellButton findButtonByPosition(int position) {
        View view = super.findViewWithTag(String.valueOf(position));
        return (CellButton) view;
    }

    public void disableAllButtons() {
        for (int i = 0; i < 9; i++) {
            CellButton cellButton = findButtonByPosition(i);
            cellButton.disable();
        }
    }
}
