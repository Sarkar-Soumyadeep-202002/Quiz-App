package au.edu.jcu.quiz_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Accelerometer accelerometer;
    private Gyroscope gyroscope;

    private String topicName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accelerometer = new Accelerometer(this); // Instantiate the sensors.
        gyroscope = new Gyroscope(this);

        accelerometer.setListener(new Accelerometer.Listener() {
            @Override
            public void onTranslation(float x, float y, float z) {

                /** Change the background of the main page from light to dark mode by shaking the device horizontally.**/
                if(x > 1.0f || x < -1.0f) // Check the extent of the translation.
                    getWindow().getDecorView().setBackgroundColor(Color.BLACK); // Change the background colour of the current page when the device is shaken.

            }
        });

        gyroscope.setListener(new Gyroscope.Listener() {
            @Override
            public void onRotation(float x, float y, float z) {

                /** Change the background of the main page from light to dark mode by rotating the device.**/
                if(z > 1.0f || z < -1.0f) // Check the extent of the rotation.
                    getWindow().getDecorView().setBackgroundColor(Color.BLACK); // Change the background color of the current page when the device is rotated.

            }
        });

        // Locate the option layouts.
        LinearLayout java_option = findViewById(R.id.java_setup);
        LinearLayout python_option = findViewById(R.id.python_setup);
        LinearLayout android_option = findViewById(R.id.android_setup);
        LinearLayout html_option = findViewById(R.id.html_setup);
        Button startbutton = findViewById(R.id.Start_button);

        /** Change the colour of the option which is selected.**/
        java_option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                topicName = "java";
                java_option.setBackgroundResource(R.drawable.rectangle_stroke);
                python_option.setBackgroundResource(R.drawable.rectangle_purple);
                android_option.setBackgroundResource(R.drawable.rectangle_purple);
                html_option.setBackgroundResource(R.drawable.rectangle_purple);

            }
        });

        python_option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                topicName = "python";
                python_option.setBackgroundResource(R.drawable.rectangle_stroke);
                java_option.setBackgroundResource(R.drawable.rectangle_purple);
                android_option.setBackgroundResource(R.drawable.rectangle_purple);
                html_option.setBackgroundResource(R.drawable.rectangle_purple);

            }
        });

        android_option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                topicName = "android";
                android_option.setBackgroundResource(R.drawable.rectangle_stroke);
                python_option.setBackgroundResource(R.drawable.rectangle_purple);
                java_option.setBackgroundResource(R.drawable.rectangle_purple);
                html_option.setBackgroundResource(R.drawable.rectangle_purple);

            }
        });

        html_option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                topicName = "html";
                html_option.setBackgroundResource(R.drawable.rectangle_stroke);
                python_option.setBackgroundResource(R.drawable.rectangle_purple);
                android_option.setBackgroundResource(R.drawable.rectangle_purple);
                java_option.setBackgroundResource(R.drawable.rectangle_purple);

            }
        });

        startbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(topicName.isEmpty())
                    Toast.makeText(MainActivity.this, "Please select one option", Toast.LENGTH_SHORT).show(); // Display an appropriate message.

                else {
                    Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                    intent.putExtra("topicName",topicName); // Start the quiz activity.
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    protected void onResume() {

        super.onResume();

        accelerometer.sensorRegister(); // Begin the functionality of the sensors.
        gyroscope.sensorRegister();

    }

    @Override
    protected void onPause() {

        super.onPause();

        accelerometer.sensorUnregister(); // Stop the functioning of the sensors.
        gyroscope.sensorUnregister();

    }
}
