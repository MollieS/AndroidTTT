package mollie.tictactoe;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.ViewInteraction;
import android.view.View;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.core.IsNot.not;

public class DisplayMatchers {

    @NonNull
    public static ViewAssertion isDisabled() {
        return matches(not(isEnabled()));
    }

    @NonNull
    public static ViewAssertion isDisplayedOnScreen() {
        return matches(isDisplayed());
    }

    @NonNull
    public static Matcher<View> matchesText(int element_id, String text) {
        return allOf(withId(element_id), withText(text));
    }

    public static void assertIntentWasSent(Matcher<Intent> intentMatcher) {
        intended(intentMatcher);
    }

    public static void clickButton(int element_id) {
        getElement(withId(element_id)).perform(click());
    }

    public static ViewInteraction getElement(Matcher<View> viewMatcher) {
        return onView(viewMatcher);
    }
}
