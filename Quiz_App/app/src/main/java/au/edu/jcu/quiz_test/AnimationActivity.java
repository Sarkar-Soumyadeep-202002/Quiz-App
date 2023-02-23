package au.edu.jcu.quiz_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class AnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        new Handler().postDelayed(new Runnable() { // Create a handler for controlling the delay of the animation.
            @Override
            public void run() {

                startActivity(new Intent(AnimationActivity.this, HomePageActivity.class)); // Launch the home page.
                finish(); // End the AnimationActivity.

            }
        }, 3000);

    }
}
