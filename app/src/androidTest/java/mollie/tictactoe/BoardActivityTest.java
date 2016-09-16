package mollie.tictactoe;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import mollie.tictactoe.board.BoardActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.core.IsNot.not;

@RunWith(AndroidJUnit4.class)
public class BoardActivityTest {

    @Rule
    public ActivityTestRule<BoardActivity> mActivityTestRule = new ActivityTestRule<>(BoardActivity.class, true, false);

    @Test
    public void canPlaceAMarkOnTheBoard() {
        clickButton(R.id.centre_button);

        findElement(allOf(withId(R.id.centre_right), withText("X")));
    }

    @Test
    public void onceAButtonIsPressedItIsDisabled() {
        clickButton(R.id.centre_button);

        findElement(withId(R.id.centre_button)).check(matches(not(isEnabled())));
    }

    @Test
    public void canPlayAGame() {
        startActivity(true);
        clickButton(R.id.centre_button);
        clickButton(R.id.top_left);
        clickButton(R.id.centre_left);
        clickButton(R.id.top_centre);
        clickButton(R.id.centre_right);

        findElement(withText("X wins!")).check(isDisplayedOnScreen());
    }

    @Test
    public void computerPlayerCanMakeAMove() {
        startActivity(false);
        clickButton(R.id.centre_button);
        findElement(withText("O")).check(isDisplayedOnScreen());
    }

    private ViewInteraction findElement(Matcher<View> o) {
        return onView(o);
    }

    @NonNull
    private ViewAssertion isDisplayedOnScreen() {
        return matches(isDisplayed());
    }


    private void clickButton(int button_id) {
        findElement(withId(button_id)).perform(click());
    }

    private void startActivity(boolean isAComputerGame) {
        Context targetContext = InstrumentationRegistry.getInstrumentation()
                .getTargetContext();
        Intent intent = new Intent(targetContext, BoardActivity.class);
        intent.putExtra(BoardActivity.EXTRA_HUMAN_GAME, isAComputerGame);
        mActivityTestRule.launchActivity(intent);
    }


}
