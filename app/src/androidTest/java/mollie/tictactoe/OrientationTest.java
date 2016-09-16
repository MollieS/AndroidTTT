package mollie.tictactoe;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import mollie.tictactoe.board.BoardActivity;

import static mollie.tictactoe.DisplayMatchers.clickButton;
import static mollie.tictactoe.DisplayMatchers.getElement;
import static mollie.tictactoe.DisplayMatchers.matchesText;

@RunWith(AndroidJUnit4.class)
public class OrientationTest {

    @Rule
    public ActivityTestRule<BoardActivity> mActivityTestRule = new ActivityTestRule<>(BoardActivity.class);

    @Test
    public void keepsMarksOnBoardWhenRotated() {
        clickButton(R.id.centre_button);
        rotateScreen();
        getElement(matchesText(R.id.centre_button, "X"));
    }

    private void rotateScreen() {
        Context context = InstrumentationRegistry.getTargetContext();
        int orientation
                = context.getResources().getConfiguration().orientation;

        Activity activity = mActivityTestRule.getActivity();
        activity.setRequestedOrientation(
                (orientation == Configuration.ORIENTATION_PORTRAIT) ?
                        ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE :
                        ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
}
