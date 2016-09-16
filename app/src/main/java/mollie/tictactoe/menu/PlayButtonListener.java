package mollie.tictactoe.menu;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import mollie.tictactoe.board.BoardActivity;

import static mollie.tictactoe.board.BoardActivity.EXTRA_HUMAN_GAME;

public class PlayButtonListener implements View.OnClickListener {

    private final Context mContext;
    private final boolean misAHumanGame;

    public PlayButtonListener(Context context, boolean isAHumanGame) {
        mContext = context;
        misAHumanGame = isAHumanGame;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(mContext, BoardActivity.class);
        intent.putExtra(EXTRA_HUMAN_GAME, misAHumanGame);
        mContext.startActivity(intent);
    }
}
