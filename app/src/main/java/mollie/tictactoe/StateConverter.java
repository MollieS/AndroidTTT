package mollie.tictactoe;

import mollie.tictactoe.players.MobilePlayer;
import ttt.Player;
import ttt.game.Board;
import ttt.game.GameEngine;
import ttt.game.Marks;

public class StateConverter {

    private static final String CURRENT_MARK = "currentMark";
    private static final String BOARD = "board";

    public static String[] convertBoardToString(Board board) {
        String[] stringBoard = new String[board.size()];
        fillBoard(board, stringBoard);
        return stringBoard;
    }

    public static Player getCurrentPlayer(String mark) {
        return new MobilePlayer(Marks.valueOf(mark));
    }

    public static Player getOpponentPlayer(String currentMark) {
        Marks mark = Marks.valueOf(currentMark);
        if (mark == Marks.X) {
            return new MobilePlayer(Marks.O);
        }
        return new MobilePlayer(Marks.X);
    }

    public static String getCurrentMark(GameEngine game) {
        return game.currentMark().toString();
    }

    public static Board convertStringToBoard(String[] stringBoard) {
        Board board = new Board(3);
        for (int i = 0; i < stringBoard.length; i++) {
            if (!stringBoard[i].equals("-")) {
                Marks mark = Marks.valueOf(stringBoard[i]);
                board = board.placeMark(mark, i);
            }
        }
        return board;
    }

    public static GameEngine recreateGame(String currentMark, String[] stringBoard) {
        Board board = convertStringToBoard(stringBoard);
        Player playerOne = getCurrentPlayer(currentMark);
        Player playerTwo = getOpponentPlayer(currentMark);
        return new GameEngine(playerOne, playerTwo, board);
    }

    private static void fillBoard(Board board, String[] stringBoard) {
        for (int i = 0; i < stringBoard.length; i++) {
            stringBoard[i] = getStringMark(board.getMarkAt(i));
        }
    }

    public static String getStringMark(Marks mark) {
        if (mark == Marks.NULL) {
            return "-";
        }
        return mark.toString();
    }
}
