package mollie.tictactoe;

import org.junit.Test;

import mollie.tictactoe.activities.BoardActivity;
import mollie.tictactoe.testdoubles.ButtonMock;
import mollie.tictactoe.testdoubles.ContextDummy;

import static org.junit.Assert.assertTrue;

public class BoardActivityUnitTest {

    private final ButtonMock mButton = new ButtonMock(new ContextDummy());
    private final BoardActivity mBoardActivity = new BoardActivity();

    @Test
    public void readsIndexOfButton() {
        mButton.setTag("4");

        mBoardActivity.placeMark(mButton);

        assertTrue(mButton.getButtonPositionWasCalled(1));
    }

    @Test
    public void placesCorrectMarkOnBoard() {
        mButton.setTag("4");

        mBoardActivity.placeMark(mButton);

        assertTrue(mButton.setTextWasCalled(1, "X"));
    }
}
