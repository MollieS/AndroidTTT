package mollie.tictactoe;

import org.junit.Test;

import mollie.tictactoe.players.MobilePlayer;
import ttt.game.Marks;

import static org.junit.Assert.assertEquals;

public class MobilePlayerTest {

    @Test
    public void hasAMark() {
        MobilePlayer mobilePlayer = new MobilePlayer(Marks.X);

        assertEquals(Marks.X, mobilePlayer.getMark());
    }
}
