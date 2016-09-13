package mollie.tictactoe;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import mollie.tictactoe.activities.BoardActivity;

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
    public ActivityTestRule<BoardActivity> mActivityTestRule = new ActivityTestRule<>(BoardActivity.class);

    @Test
    public void canPlaceAMarkOnTheBoard() {
        onClick(R.id.centre_button);

        onView(allOf(withId(R.id.centre_right), withText("X")));
    }

    @Test
    public void onceAButtonIsPressedItIsDisabled() {
        onClick(R.id.centre_button);

        onView(withId(R.id.centre_button)).check(matches(not(isEnabled())));
    }

    @Test
    public void canPlayAGame() {
        onClick(R.id.centre_button);
        onClick(R.id.top_left);
        onClick(R.id.centre_left);
        onClick(R.id.top_centre);
        onClick(R.id.centre_right);

        onView(withText("X wins!")).check(matches(isDisplayed()));
    }

    private void onClick(int button_id) {
        onView(withId(button_id)).perform(click());
    }


}
