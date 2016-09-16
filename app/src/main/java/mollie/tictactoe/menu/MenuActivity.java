package mollie.tictactoe.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import mollie.tictactoe.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setPlayButtons();
    }

    private void setPlayButtons() {
        setButton(R.id.human_v_human_button, true);
        setButton(R.id.human_v_computer, false);
    }

    private void setButton(int human_v_human_button, boolean isAHumanGame) {
        Button humanVHuman = (Button) findViewById(human_v_human_button);
        humanVHuman.setOnClickListener(new PlayButtonListener(this, isAHumanGame));
    }
}
