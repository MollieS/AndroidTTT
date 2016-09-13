package mollie.tictactoe;

import org.junit.Before;
import org.junit.Test;

import mollie.tictactoe.players.MobilePlayer;
import ttt.Player;
import ttt.game.Board;
import ttt.game.GameEngine;
import ttt.game.Marks;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class GameHelperTest {

    private GameHelper mGameHelper;

    @Before
    public void setUp() {
        mGameHelper = new GameHelper();
    }

    @Test
    public void createsAGameWithTwoHumanPlayers() {
        GameEngine game = mGameHelper.createGame();

        Player playerOne = game.getCurrentPlayer();
        game.play(1);
        Player playerTwo = game.getCurrentPlayer();

        assertEquals(MobilePlayer.class, playerOne.playerType());
        assertEquals(MobilePlayer.class, playerTwo.playerType());
    }

    @Test
    public void createsAGameWithA3x3Board() {
        GameEngine game = mGameHelper.createGame();

        Board board = game.showBoard();

        assertEquals(9, board.size());
    }

    @Test
    public void playsAMoveOnTheBoard() {
        GameEngine game = mGameHelper.createGame();

        mGameHelper.playMove(1);
        Marks mark = game.board(1);

        assertEquals(Marks.X, mark);
    }

    @Test
    public void returnsTheStringValueOfTheMarkPlacedWhenX() {
        mGameHelper.createGame();

        String mark = mGameHelper.playMove(1);

        assertEquals("X", mark);
    }

    @Test
    public void returnsTheStringValueOfTheMarkPlacedWhenO() {
        mGameHelper.createGame();

        mGameHelper.playMove(4);
        String mark = mGameHelper.playMove(1);

        assertEquals("O", mark);
    }

    @Test
    public void returnsANewGameIfAGameHasNotBeenStarted() {
        GameEngine game = mGameHelper.getGame();

        assertEquals(Marks.X, game.currentMark());
        assertTrue(game.showBoard().isEmpty());
    }

    @Test
    public void returnsCurrentGameStateIfGameIsStarted() {
        mGameHelper.playMove(1);

        GameEngine game = mGameHelper.getGame();

        assertEquals(Marks.O, game.currentMark());
        assertEquals(Marks.X, game.board(1));
    }

    @Test
    public void returnsANewBoardIfGameIsNotStarted() {
        Board board = mGameHelper.getBoard();

        assertTrue(board.isEmpty());
    }

    @Test
    public void returnsAMarkedBoardIfGameIsStarted() {
        mGameHelper.playMove(1);
        Board board = mGameHelper.getBoard();

        assertEquals(Marks.X, board.getMarkAt(1));
    }

    @Test
    public void knowsWhenGameIsNotOver() {
        mGameHelper.playMove(1);

        assertFalse(mGameHelper.gameIsOver());
    }

    @Test
    public void knowsWhenTheGameIsOver() {
        playAGameWhereXWins();

        assertTrue(mGameHelper.gameIsOver());
    }

    @Test
    public void knowsTheWinner() {
        playAGameWhereXWins();

        assertEquals("X", mGameHelper.getWinner());
    }

    @Test
    public void returnsNullIfNoWinner() {
        mGameHelper.playMove(1);

        assertEquals(null, mGameHelper.getWinner());
    }

    private void playAGameWhereXWins() {
        mGameHelper.playMove(0);
        mGameHelper.playMove(1);
        mGameHelper.playMove(3);
        mGameHelper.playMove(4);
        mGameHelper.playMove(6);
    }
}
