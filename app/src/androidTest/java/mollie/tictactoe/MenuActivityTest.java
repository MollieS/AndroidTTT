package mollie.tictactoe;


import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import mollie.tictactoe.activities.MenuActivity;

import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static mollie.tictactoe.DisplayMatchers.assertIntentWasSent;
import static mollie.tictactoe.DisplayMatchers.clickButton;
import static mollie.tictactoe.DisplayMatchers.getElement;
import static mollie.tictactoe.DisplayMatchers.isDisplayedOnScreen;

@RunWith(AndroidJUnit4.class)
public class MenuActivityTest {

    @Rule
    public IntentsTestRule<MenuActivity> mIntentsTestRule = new IntentsTestRule<>(MenuActivity.class);

    @Test
    public void pressingPlayButtonShowsTheBoard() {
        clickButton(R.id.human_v_human_button);
        getElement(withId(R.id.board)).check(isDisplayedOnScreen());
    }

    @Test
    public void pressingPlaySendsAnIntent() {
        clickButton(R.id.human_v_human_button);
        assertIntentWasSent(toPackage("mollie.tictactoe"));
    }
}