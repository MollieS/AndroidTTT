package mollie.tictactoe.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import mollie.tictactoe.ui.PlayButtonListener;
import mollie.tictactoe.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setPlayButton();
    }

    private void setPlayButton() {
        Button playButton = (Button) findViewById(R.id.human_v_human_button);
        playButton.setOnClickListener(new PlayButtonListener(this));
    }
}
