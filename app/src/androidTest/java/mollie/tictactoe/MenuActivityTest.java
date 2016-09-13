package mollie.tictactoe;


import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class MenuActivityTest {

    @Rule
    public IntentsTestRule<MenuActivity> mIntentsTestRule = new IntentsTestRule<>(MenuActivity.class);

    @Test
    public void clickingThePlayButtonShowsTheBoard() {
        onView(withId(R.id.play_button)).perform(click());
        onView(withId(R.id.board)).check(matches(isDisplayed()));
    }
}