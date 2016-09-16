package mollie.tictactoe;

import org.junit.Test;

import mollie.tictactoe.board.GameHelper;
import mollie.tictactoe.testdoubles.ButtonMock;
import mollie.tictactoe.testdoubles.ContextDummy;
import mollie.tictactoe.testdoubles.ViewFake;
import mollie.tictactoe.board.UIBoardManager;
import ttt.game.Board;
import ttt.game.Marks;

import static junit.framework.Assert.assertTrue;

public class UIBoardManagerTest {

    ViewFake mView = new ViewFake(new ContextDummy());
    private ButtonMock mButton = new ButtonMock(new ContextDummy());
    private GameHelper mGameHelper = new GameHelper();
    private Board board = new Board(3);

    @Test
    public void updatesButtonText() {
        UIBoardManager.updateUI("X", mButton);

        assertTrue(mButton.setTextWasCalled(1, "X"));
    }

    @Test
    public void disablesButton() {
        UIBoardManager.updateUI("X", mButton);

        assertTrue(mButton.setEnabledWasCalled(1, false));
    }

    @Test
    public void doesNotUpdateUIBoardIfGameBoardIsEmpty() {
        UIBoardManager.updateUIBoard(board, mView);

        assertTrue(mButton.setTextWasCalled(0, "X"));
    }

    @Test
    public void updatesBoardToShowAnX() {
        board = board.placeMark(Marks.X, 4);
        mView.setButton(mButton);

        UIBoardManager.updateUIBoard(board, mView);

        assertTrue(mButton.setTextWasCalled(1, "X"));
    }

    @Test
    public void updatesBoardToShowAnO() {
        board = board.placeMark(Marks.O, 4);
        mView.setButton(mButton);

        UIBoardManager.updateUIBoard(board, mView);

        assertTrue(mButton.setTextWasCalled(1, "O"));
    }

    @Test
    public void disablesButtonIfMarked() {
        board = board.placeMark(Marks.O, 4);
        mView.setButton(mButton);

        UIBoardManager.updateUIBoard(board, mView);

        assertTrue(mButton.setEnabledWasCalled(1, false));
    }
}
