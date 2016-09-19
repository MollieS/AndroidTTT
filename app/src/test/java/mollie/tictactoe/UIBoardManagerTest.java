package mollie.tictactoe;

import org.junit.Test;

import mollie.tictactoe.testdoubles.ButtonMock;
import mollie.tictactoe.testdoubles.ContextDummy;
import mollie.tictactoe.testdoubles.ViewFake;
import mollie.tictactoe.ui.UIBoardManager;
import ttt.game.Board;
import ttt.game.Marks;

import static org.junit.Assert.assertTrue;


public class UIBoardManagerTest {

    private ViewFake mView = new ViewFake(new ContextDummy());
    private ButtonMock mButton = new ButtonMock(new ContextDummy());
    private Board board = new Board(3);

    @Test
    public void updatesButtonText() {
        UIBoardManager.updateUI("X", mButton);

        assertTrue(mButton.setTextWasCalled(1, "X"));
    }

    @Test
    public void disablesButton() {
        UIBoardManager.updateUI("X", mButton);

        assertTrue(mButton.disableWasCalled(1));
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

        assertTrue(mButton.disableWasCalled(1));
    }
}
