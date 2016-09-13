package mollie.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    private Button mPlayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mPlayButton = (Button) findViewById(R.id.play_button);

        mPlayButton.setOnClickListener(new PlayButtonListener(this));
    }
}
