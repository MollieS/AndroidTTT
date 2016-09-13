package mollie.tictactoe.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

public class CellButton extends Button {

    public CellButton(Context context) {
        super(context);
    }

    public CellButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CellButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CellButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setText(String text) {
        super.setText(text);
    }
}
