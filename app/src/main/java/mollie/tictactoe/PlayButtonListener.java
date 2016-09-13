package mollie.tictactoe;

import android.content.Context;
import android.content.Intent;
import android.view.View;

public class PlayButtonListener implements View.OnClickListener {

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
