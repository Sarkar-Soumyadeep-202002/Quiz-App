package au.edu.jcu.quiz_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizOutcomeActivity extends AppCompatActivity {

    SQLiteHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_outcome);

        TextView score = findViewById(R.id.score); // Get the text field and the buttons and instantiate them.
        Button home_button = findViewById(R.id.home_button);
        Button save_button = findViewById(R.id.save_button);
        Button high_score_button = findViewById(R.id.high_score_button);

        DB = new SQLiteHelper(this);

        int numberOfCorrectAnswers = getIntent().getIntExtra("Correct Answers", 0); // Get the number of correct answers selected by the user.

        String score_text = "Your Score is: " + String.valueOf(numberOfCorrectAnswers);

        score.setText(score_text); // Display the correct with a prompt.

        /** Save your score to the database.
         * All users who play the game can save their score to the database.
         * This allows the user to see how much they scored each time they play the game.**/
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String scoreText = String.valueOf(numberOfCorrectAnswers);

                Boolean checkInsertData = DB.insertData(scoreText); // Check if the data is inserted into the database and display an appropriate message.
                if(checkInsertData)
                    Toast.makeText(QuizOutcomeActivity.this, "Score Saved Successfully", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(QuizOutcomeActivity.this, "Your Score was not Saved", Toast.LENGTH_SHORT).show();

            }
        });

        /** Go to the high score screen when the user selects the high score button.**/
        high_score_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuizOutcomeActivity.this, HighScoreActivity.class));
            }
        });

        /** Go to the home page when the user selects the home button.**/
        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuizOutcomeActivity.this, MainActivity.class));
            }
        });

    }
}

