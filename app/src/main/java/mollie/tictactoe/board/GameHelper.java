package mollie.tictactoe.board;

import android.util.Log;

import mollie.tictactoe.players.MobilePlayer;
import ttt.game.Board;
import ttt.game.GameEngine;
import ttt.game.Marks;
import ttt.players.PerfectPlayer;

public class GameHelper {

    private final boolean mIsAHumanGame;
    private GameEngine mGameEngine;

    public GameHelper(GameEngine game, boolean isAHumanGame) {
        mGameEngine = game;
        mIsAHumanGame = isAHumanGame;
    }

    public GameHelper(boolean isAHumanGame) {
        mIsAHumanGame = isAHumanGame;
    }

    public GameEngine createGame() {
        if (mIsAHumanGame) {
            mGameEngine = new GameEngine(new MobilePlayer(Marks.X), new MobilePlayer(Marks.O), new Board(3));
        } else {
            mGameEngine = new GameEngine(new MobilePlayer(Marks.X), new PerfectPlayer(Marks.O), new Board(3));
        }
        return mGameEngine;
    }

    public String playMove(int moveLocation) {
        mGameEngine = getGame();
        mGameEngine.play(moveLocation);
        return mGameEngine.board(moveLocation).toString();
    }

    public GameEngine getGame() {
        if (isNotStarted()) {
            createGame();
        }
        return mGameEngine;
    }

    public Board getBoard() {
        if (isNotStarted()) {
            return new Board(3);
        }
        return mGameEngine.showBoard();
    }

    private boolean isNotStarted() {
        return mGameEngine == null;
    }

    public boolean gameIsOver() {
        return mGameEngine.isOver();
    }

    public String getWinner() {
        if (mGameEngine.isWon()) {
            return mGameEngine.winningMark().toString();
        }
        return null;
    }

    public int getComputerMove() {
        int computerMove = getComputerLocation();
        return computerMove;
    }

    private int getComputerLocation() {
        try {
            return mGameEngine.getPlayerMove(mGameEngine.showBoard());
        } catch (Exception e) {
            Log.e("ERROR", e.getMessage());
        }
        return 0;
    }
}
