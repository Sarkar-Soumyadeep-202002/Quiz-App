package au.edu.jcu.quiz_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        /** Get all the different layouts and inflate them.**/
        RelativeLayout home_page = (RelativeLayout) View.inflate(this, R.layout.activity_home_page, null);
        LinearLayout quiz_outcome_page = (LinearLayout) View.inflate(this, R.layout.activity_quiz_outcome, null);
        ConstraintLayout high_score_page = (ConstraintLayout) View.inflate(this, R.layout.activity_high_score, null);
        LinearLayout quiz_page = (LinearLayout) View.inflate(this, R.layout.activity_quiz, null);

        // Instantiate all the buttons.
        ImageView back_button = findViewById(R.id.back_button);
        Button displayMode = findViewById(R.id.change_mode);
        Button brightness = findViewById(R.id.change_brightness);

        LinearLayout settings_page = findViewById(R.id.settings_layout);

        /** Go back to the home page when the user clicks the back button.**/
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SettingsActivity.this, MainActivity.class));
                finish();

            }
        });

        /** Change the display mode of the app when the user selects the display mode button.**/
        displayMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                home_page.setBackgroundColor(Color.BLACK);
                quiz_page.setBackgroundColor(Color.BLACK);
                quiz_outcome_page.setBackgroundColor(Color.BLACK);
                high_score_page.setBackgroundColor(Color.BLACK);

            }
        });

        /** Reduce the brightness of the screen.**/
        brightness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                home_page.setBackgroundColor(808080);
                quiz_page.setBackgroundColor(808080);
                quiz_outcome_page.setBackgroundColor(808080);
                high_score_page.setBackgroundColor(808080);
                settings_page.setBackgroundColor(808080);

            }
        });

    }

}
