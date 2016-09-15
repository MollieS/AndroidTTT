package mollie.tictactoe.ui;

import android.content.Context;
import android.widget.Toast;

import ttt.game.Board;
import ttt.game.Marks;

public class UIBoardManager {

    public static void updateUIBoard(Board board, BoardView view) {
        for (int i = 0; i < board.size(); i++) {
            CellButton button = (CellButton) view.findViewWithTag(String.valueOf(i));
            Marks mark = board.getMarkAt(i);
            if (mark != Marks.NULL) {
                updateUI(mark.toString(), button);
            }
        }
    }

    public static void updateUI(String mark, CellButton button) {
        button.setText(mark);
        button.setEnabled(false);
    }

    public static void endGame(String winningMark, BoardView view, Context applicationContext) {
        disableAllButtons(view);
        showGameStatus(applicationContext, winningMark);
    }

    public static void showGameStatus(Context context, String winningMark) {
        String gameStatus;
        gameStatus = getGameStatus(winningMark);
        Toast.makeText(context, gameStatus, Toast.LENGTH_SHORT).show();
    }

    private static String getGameStatus(String winningMark) {
        if (winningMark == null) {
            return "It's a draw!";
        }
        return winningMark + " wins!";
    }

    private static void disableAllButtons(BoardView view) {
        for (int i = 0; i < 9; i++) {
            CellButton button = (CellButton) view.findViewWithTag(String.valueOf(i));
            button.setEnabled(false);
        }
    }
}
