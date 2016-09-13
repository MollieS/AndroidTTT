package mollie.tictactoe.players;

import ttt.Player;
import ttt.game.Board;
import ttt.game.Marks;

public class MobilePlayer implements Player {

    private final Marks mMark;

    public MobilePlayer(Marks mark) {
        mMark = mark;
    }

    @Override
    public Marks getMark() {
        return mMark;
    }

    @Override
    public int getLocation(Board board) throws Exception {
        return 0;
    }

    @Override
    public Class playerType() {
        return getClass();
    }
}
