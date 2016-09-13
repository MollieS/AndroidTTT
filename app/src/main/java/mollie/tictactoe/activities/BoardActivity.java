package mollie.tictactoe.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import mollie.tictactoe.ui.BoardView;
import mollie.tictactoe.ui.CellButton;
import mollie.tictactoe.GameHelper;
import mollie.tictactoe.R;
import mollie.tictactoe.StateManager;
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
        int position = getButtonPosition(button);
        String mark = mGameHelper.playMove(position);
        UIBoardManager.updateUI(mark, button);
        if (mGameHelper.gameIsOver()) {
            UIBoardManager.endGame(mGameHelper.getWinner(), getView(), getApplicationContext());
        }
    }

    private BoardView getView() {
        View view = findViewById(R.id.board);
        return ((BoardView) view);
    }

    private int getButtonPosition(CellButton button) {
        return Integer.valueOf((String) button.getTag());
    }
}
