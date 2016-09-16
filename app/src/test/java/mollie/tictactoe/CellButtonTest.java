package mollie.tictactoe;

import org.junit.Ignore;
import org.junit.Test;

import mollie.tictactoe.testdoubles.ContextDummy;
import mollie.tictactoe.ui.CellButton;

import static org.junit.Assert.assertEquals;

public class CellButtonTest {

    @Ignore
    @Test
    public void returnsItsPosition() {
        CellButton cellButton = new CellButton(new ContextDummy());
        cellButton.setTag("1");

        int position = cellButton.getButtonPosition();

        assertEquals(1, position);
    }
}
