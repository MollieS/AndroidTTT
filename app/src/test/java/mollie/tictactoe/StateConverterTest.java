package mollie.tictactoe;

import org.junit.Before;
import org.junit.Test;

import mollie.tictactoe.board.StateConverter;
import mollie.tictactoe.players.MobilePlayer;
import ttt.Player;
import ttt.game.Board;
import ttt.game.GameEngine;
import ttt.game.Marks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class StateConverterTest {

    private Board mBoard = new Board(3);
    private GameEngine mGame;

    @Before
    public void setUp() {
        Player playerOne = new MobilePlayer(Marks.X);
        Player playerTwo = new MobilePlayer(Marks.O);
        mGame = new GameEngine(playerOne, playerTwo, mBoard);
    }

    @Test
    public void convertsEmptyBoardToEmptyBoardString() {
        String[] stringBoard = StateConverter.convertBoardToString(mBoard);

        assertTrue(isEmpty(stringBoard));
    }

    @Test
    public void convertsABoardWithAnXToAString() {
        mBoard = mBoard.placeMark(Marks.X, 0);

        String[] stringBoard = StateConverter.convertBoardToString(mBoard);

        assertEquals("X", stringBoard[0]);
    }

    @Test
    public void convertsABoardWithAnOToAString() {
        mBoard = mBoard.placeMark(Marks.O, 0);

        String[] stringBoard = StateConverter.convertBoardToString(mBoard);

        assertEquals("O", stringBoard[0]);
    }

    @Test
    public void returnsTheCurrentMarkAsString() {
        String currentMark = StateConverter.getCurrentMark(mGame);

        assertEquals("X", currentMark);
    }

    @Test
    public void createsAnEmptyBoardFromAnEmptyStringBoard() {
        String[] emptyStringBoard = {"-", "-", "-", "-", "-", "-", "-", "-", "-"};

        Board board = StateConverter.convertStringToBoard(emptyStringBoard);

        assertTrue(board.isEmpty());
    }

    @Test
    public void createsABoardFromAStringBoardWithAnX() {
        String[] stringBoardWithX = {"X", "-", "-", "-", "-", "-", "-", "-", "-"};

        Board board = StateConverter.convertStringToBoard(stringBoardWithX);

        assertEquals(Marks.X, board.getMarkAt(0));
    }

    @Test
    public void returnsTheCorrectCurrentPlayer() {
        Player player = StateConverter.getCurrentPlayer("X");

        assertEquals(Marks.X, player.getMark());
    }

    @Test
    public void returnsTheCorrectOpponentPlayer() {
        Player player = StateConverter.getOpponentPlayer("X");

        assertEquals(Marks.O, player.getMark());
    }

    @Test
    public void createsABoardFromAStringBoardWithAnO() {
        String[] stringBoardWithO = {"O", "-", "-", "-", "-", "-", "-", "-", "-"};

        Board board = StateConverter.convertStringToBoard(stringBoardWithO);

        assertEquals(Marks.O, board.getMarkAt(0));
    }

    private boolean isEmpty(String[] stringBoard) {
        for (String string : stringBoard) {
            if (!string.equals("-")) {
                return false;
            }
        }
        return true;
    }
}
