package mollie.tictactoe;

import android.os.Bundle;

import ttt.game.GameEngine;

import static mollie.tictactoe.StateConverter.convertBoardToString;
import static mollie.tictactoe.StateConverter.getStringMark;
import static mollie.tictactoe.StateConverter.recreateGame;

public class StateManager {

    private static final String BOARD = "board";
    private static final String CURRENT_MARK = "currentMark";

    public static Bundle getOutStateBundle(Bundle bundle, GameEngine gameEngine) {
        bundle.putStringArray(BOARD, convertBoardToString(gameEngine.showBoard()));
        bundle.putString(CURRENT_MARK, getStringMark(gameEngine.currentMark()));
        return bundle;
    }

    public static GameEngine restoreStateToGame(Bundle bundle) {
        if (bundle != null) {
            String currentMark = bundle.getString(CURRENT_MARK);
            String[] stringBoard = bundle.getStringArray(BOARD);
            return recreateGame(currentMark, stringBoard);
        }
        return null;
    }
}
