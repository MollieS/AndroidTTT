package mollie.tictactoe.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import mollie.tictactoe.GameHelper;
import mollie.tictactoe.R;
import mollie.tictactoe.StateManager;
import mollie.tictactoe.ui.BoardView;
import mollie.tictactoe.ui.CellButton;
import mollie.tictactoe.ui.UIBoardManager;

public class BoardActivity extends AppCompatActivity {

    private GameHelper mGameHelper = new GameHelper();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        mGameHelper = new GameHelper(StateManager.restoreStateToGame(savedInstanceState));
    }

    @Override
    public void onResume() {
        super.onResume();
        UIBoardManager.updateUIBoard(mGameHelper.getBoard(), getView());
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        StateManager.getOutStateBundle(outState, mGameHelper.getGame());
    }

    public void placeMark(View view) {
        CellButton button = (CellButton) view;
        int position = button.getButtonPosition();
        String mark = mGameHelper.playMove(position);
        UIBoardManager.updateUI(mark, button);
        if (mGameHelper.gameIsOver()) {
            UIBoardManager.endGame(mGameHelper.getWinner(), getView(), getApplicationContext());
            promptForPlayAgain().show();
        }
    }

    private BoardView getView() {
        View view = findViewById(R.id.board);
        return ((BoardView) view);
    }

    private Dialog promptForPlayAgain() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.play_again)
                .setPositiveButton(R.string.yes, new PlayAgainClickListener())
                .setNegativeButton(R.string.no, new CancelDialogListener());
        return builder.create();
    }


    private class PlayAgainClickListener implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            onBackPressed();
        }
    }

    private class CancelDialogListener implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }
}
