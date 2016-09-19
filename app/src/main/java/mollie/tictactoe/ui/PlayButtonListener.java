package mollie.tictactoe.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import mollie.tictactoe.activities.BoardActivity;

public class PlayButtonListener implements View.OnClickListener {

    private static final String GAME = "game";
    private final Context mContext;

    public PlayButtonListener(Context context) {
        mContext = context;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(mContext, BoardActivity.class);
        mContext.startActivity(intent);
    }
}
