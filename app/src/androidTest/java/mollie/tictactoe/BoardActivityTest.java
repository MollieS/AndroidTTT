package mollie.tictactoe;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import mollie.tictactoe.board.BoardActivity;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static mollie.tictactoe.DisplayMatchers.clickButton;
import static mollie.tictactoe.DisplayMatchers.getElement;
import static mollie.tictactoe.DisplayMatchers.isDisabled;
import static mollie.tictactoe.DisplayMatchers.isDisplayedOnScreen;
import static mollie.tictactoe.DisplayMatchers.matchesText;

@RunWith(AndroidJUnit4.class)
public class BoardActivityTest {

    @Rule
    public ActivityTestRule<BoardActivity> mActivityTestRule = new ActivityTestRule<>(BoardActivity.class, true, false);

    @Test
    public void canPlaceAMarkOnTheBoard() {
        clickButton(R.id.centre_button);

        getElement(matchesText(R.id.centre_right, "X"));
    }

    @Test
    public void onceAButtonIsPressedItIsDisabled() {
        clickButton(R.id.centre_button);

        getElement(withId(R.id.centre_button)).check(isDisabled());
    }

    @Test
    public void canPlayAGame() {
        startActivity(true);
        clickButton(R.id.centre_button);
        clickButton(R.id.top_left);
        clickButton(R.id.centre_left);
        clickButton(R.id.top_centre);
        clickButton(R.id.centre_right);

        getElement(withText("X wins!")).check(isDisplayedOnScreen());
    }

    @Test
    public void computerPlayerCanMakeAMove() {
        startActivity(false);
        clickButton(R.id.centre_button);
        getElement(withText("O")).check(isDisplayedOnScreen());
    }

    @Test
    public void promptsToReplayGame() {
        clickButton(R.id.centre_button);
        clickButton(R.id.top_left);
        clickButton(R.id.centre_left);
        clickButton(R.id.top_centre);
        clickButton(R.id.centre_right);

        getElement(withText("Would you like to play again?")).check(isDisplayedOnScreen());
    }

    private void startActivity(boolean isAComputerGame) {
        Context targetContext = InstrumentationRegistry.getInstrumentation()
                .getTargetContext();
        Intent intent = new Intent(targetContext, BoardActivity.class);
        intent.putExtra(BoardActivity.EXTRA_HUMAN_GAME, isAComputerGame);
        mActivityTestRule.launchActivity(intent);
        getElement(withText("X wins!")).check(isDisplayedOnScreen());
    }
}
