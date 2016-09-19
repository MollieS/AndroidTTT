package mollie.tictactoe.board;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import mollie.tictactoe.R;

public class BoardActivity extends AppCompatActivity {

    public static final String EXTRA_HUMAN_GAME = "mollie.tictactoe.human_game";
    private GameHelper mGameHelper;
    private boolean mIsAHumanGame;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        Intent intent = getIntent();
        mIsAHumanGame = intent.getBooleanExtra(EXTRA_HUMAN_GAME, true);
        mGameHelper = new GameHelper(StateManager.restoreStateToGame(savedInstanceState), mIsAHumanGame);
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
        playMove((CellButton) view);
        checkIfGameIsOver();
        if (!mIsAHumanGame && !mGameHelper.gameIsOver()) {
            playComputerMove();
            checkIfGameIsOver();
        }
    }

    private void playMove(CellButton view) {
        int position = view.getButtonPosition();
        String mark = mGameHelper.playMove(position);
        UIBoardManager.updateUI(mark, view);
    }

    private void checkIfGameIsOver() {
        if (mGameHelper.gameIsOver()) {
            UIBoardManager.endGame(mGameHelper.getWinner(), getView(), getApplicationContext());
            promptForPlayAgain().show();
        }
    }

    private void playComputerMove() {
        new ComputerMove().execute();
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

    private class ComputerMove extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            final int move = mGameHelper.getComputerMove();
            final String computerMark = mGameHelper.playMove(move);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    CellButton computerButton = getView().findButtonByPosition(move);
                    UIBoardManager.updateUI(computerMark, computerButton);
                }
            });
            return null;
        }
    }
}
