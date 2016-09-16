package mollie.tictactoe;


import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import mollie.tictactoe.menu.MenuActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class MenuActivityTest {

    @Rule
    public IntentsTestRule<MenuActivity> mIntentsTestRule = new IntentsTestRule<>(MenuActivity.class);

    @Test
    public void pressingHumanVHumanButtonStartsAHumanGame() {
        clickButton(R.id.human_v_human_button);
        onView(withId(R.id.board)).check(matches(isDisplayed()));
    }

    @Test
    public void pressingHumanVHumanSendsAnIntent() {
        clickButton(R.id.human_v_human_button);
        intended(toPackage("mollie.tictactoe"));
    }

    @Test
    public void pressingHumanVHumanAddsAnExtraToIntent() {
        clickButton(R.id.human_v_human_button);
        intended(allOf(
                hasExtra("mollie.tictactoe.human_game", true)
        ));
    }

    @Test
    public void pressingComputerVHumanAddsFalseExtraToIntent() {
        clickButton(R.id.human_v_computer);
        intended(allOf(
                hasExtra("mollie.tictactoe.human_game", false)
        ));
    }

    private void clickButton(int id) {
        onView(withId(id)).perform(click());
    }
}