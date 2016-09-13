package mollie.tictactoe;


import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import mollie.tictactoe.activities.MenuActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class MenuActivityTest {

    @Rule
    public IntentsTestRule<MenuActivity> mIntentsTestRule = new IntentsTestRule<>(MenuActivity.class);

    @Test
    public void pressingPlayButtonShowsTheBoard() {
        onView(withId(R.id.human_v_human_button)).perform(click());
        onView(withId(R.id.board)).check(matches(isDisplayed()));
    }

    @Test
    public void pressingPlaySendsAnIntent() {
        onView(withId(R.id.human_v_human_button)).perform(click());
        intended(toPackage("mollie.tictactoe"));
    }
}