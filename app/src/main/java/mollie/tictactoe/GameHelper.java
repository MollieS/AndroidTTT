package mollie.tictactoe;

import mollie.tictactoe.players.MobilePlayer;
import ttt.game.Board;
import ttt.game.GameEngine;
import ttt.game.Marks;

public class GameHelper {

    private GameEngine mGameEngine;

    public GameHelper(GameEngine game) {
        mGameEngine = game;
    }

    public GameHelper() {
    }

    public GameEngine createGame() {
        mGameEngine = new GameEngine(new MobilePlayer(Marks.X), new MobilePlayer(Marks.O), new Board(3));
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
}
