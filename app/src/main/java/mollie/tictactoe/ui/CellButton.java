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

    public int getButtonPosition() {
        String tag = (String) super.getTag();
        return Integer.valueOf(tag);
    }

    public void disable() {
        super.setEnabled(false);
    }
}
