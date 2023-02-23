package au.edu.jcu.quiz_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class QuizActivity extends AppCompatActivity {

    private Accelerometer accelerometer;
    private Gyroscope gyroscope;

    private TextView question;
    private AppCompatButton next_button, option1, option2, option3, option4;

    private Timer timer;

    private int minutes = 1, seconds = 60, currentQuestionNumber = 0;

    private List<Questions> questionsList = new ArrayList<>();

    private String userChoice = "";

    private LinearLayout myLayout;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        accelerometer = new Accelerometer(this);
        gyroscope = new Gyroscope(this);
        myLayout = findViewById(R.id.quiz_layout);

        /** Control the functionality of the app when the device is shaken.**/
        accelerometer.setListener(new Accelerometer.Listener() {
            @Override
            public void onTranslation(float x, float y, float z) {

               /** Skip the current question by shaking the device horizontally.
                * The more it is shaken the greater number of questions can be skipped.
                * If the device is shaken a lot then all questions will be skipped and the quiz will end. **/
                if(x > 1.0f || x < -1.0f)
                   updateNextQuestion();

            }
        });

        /** Control the functionality of the app when the device is rotated.**/
        gyroscope.setListener(new Gyroscope.Listener() {
            @Override
            public void onRotation(float x, float y, float z) {

                /** Skip the current question by rotating the device.
                 * The more it is rotated the greater number of questions can be skipped.
                 * If the device is rotated many times then all questions will be skipped and the quiz will end. **/
                if(z > 1.0f || z < -1.0f)
                     updateNextQuestion();

            }
        });


        ImageView back_button = findViewById(R.id.back_button);
        TextView stopwatch = findViewById(R.id.stopwatch);
        TextView selected_topic = findViewById(R.id.selected_topic);
        question = findViewById(R.id.question);
        TextView question_number = findViewById(R.id.question_number);

        option1 = findViewById(R.id.option_1);
        option2 = findViewById(R.id.option_2);
        option3 = findViewById(R.id.option_3);
        option4 = findViewById(R.id.option_4);

        next_button = findViewById(R.id.next_button);

        String getTopicName = getIntent().getStringExtra("topicName"); // Fetch the topic selected by the user.

        selected_topic.setText(getTopicName);

        questionsList = AllQuestions.getQuestions(getTopicName);

        startStopWatch(stopwatch);

        String question_num = Integer.toString(currentQuestionNumber + 1) + "/" + Integer.toString(questionsList.size());

        question_number.setText(question_num);
        question.setText(questionsList.get(0).getQuestion());

        option1.setText(questionsList.get(0).getOption1());
        option2.setText(questionsList.get(0).getOption2());
        option3.setText(questionsList.get(0).getOption3());
        option4.setText(questionsList.get(0).getOption4());

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(userChoice.isEmpty()) {

                    userChoice = option1.getText().toString(); // Fetch the option selected by the user.
                    option1.setBackgroundResource(R.drawable.rectangle_stroke); // Highlight the option selected by the user.

                    /** Play the sound of "Hiya" when the user selects the correct option and play the sound of "laughter" when the user selects the wrong option.**/
                    if(userChoice.equals(questionsList.get(currentQuestionNumber).getAnswer())){
                        mediaPlayer = MediaPlayer.create(QuizActivity.this, R.raw.human_boy_saying_hiya);
                        mediaPlayer.start();
                    }
                    else{
                        mediaPlayer = MediaPlayer.create(QuizActivity.this, R.raw.human_children_laughing);
                        mediaPlayer.start();
                    }


                    showAnswer();

                    questionsList.get(currentQuestionNumber).setUserChoice(userChoice);

                }
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(userChoice.isEmpty()) {

                    userChoice = option2.getText().toString();
                    option2.setBackgroundResource(R.drawable.rectangle_stroke);

                    if(userChoice.equals(questionsList.get(currentQuestionNumber).getAnswer())){
                        mediaPlayer = MediaPlayer.create(QuizActivity.this, R.raw.human_boy_saying_hiya);
                        mediaPlayer.start();
                    }
                    else{
                        mediaPlayer = MediaPlayer.create(QuizActivity.this, R.raw.human_children_laughing);
                        mediaPlayer.start();
                    }

                    showAnswer();

                    questionsList.get(currentQuestionNumber).setUserChoice(userChoice);

                }

            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(userChoice.isEmpty()) {

                    userChoice = option3.getText().toString();
                    option3.setBackgroundResource(R.drawable.rectangle_stroke);

                    if(userChoice.equals(questionsList.get(currentQuestionNumber).getAnswer())){
                        mediaPlayer = MediaPlayer.create(QuizActivity.this, R.raw.human_boy_saying_hiya);
                        mediaPlayer.start();
                    }
                    else{
                        mediaPlayer = MediaPlayer.create(QuizActivity.this, R.raw.human_children_laughing);
                        mediaPlayer.start();
                    }

                    showAnswer();

                    questionsList.get(currentQuestionNumber).setUserChoice(userChoice);

                }

            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(userChoice.isEmpty()) {

                    userChoice = option4.getText().toString();
                    option4.setBackgroundResource(R.drawable.rectangle_stroke);

                    if(userChoice.equals(questionsList.get(currentQuestionNumber).getAnswer())){
                        mediaPlayer = MediaPlayer.create(QuizActivity.this, R.raw.human_boy_saying_hiya);
                        mediaPlayer.start();
                    }
                    else{
                        mediaPlayer = MediaPlayer.create(QuizActivity.this, R.raw.human_children_laughing);
                        mediaPlayer.start();
                    }

                    showAnswer();

                    questionsList.get(currentQuestionNumber).setUserChoice(userChoice);

                }

            }
        });

        // Go to the next question when the next button is clicked.
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(userChoice.isEmpty())
                    Toast.makeText(QuizActivity.this, "Please select one option", Toast.LENGTH_SHORT).show();

                else
                {
                    updateNextQuestion();
                }

            }
        });

        // Go to the home page when the back button is pressed.
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.purge();
                timer.cancel();

                startActivity(new Intent(QuizActivity.this, MainActivity.class));
                finish();
            }
        });

    }

    private void updateNextQuestion(){

        currentQuestionNumber += 1;

        if((currentQuestionNumber) == questionsList.size())
            next_button.setText("Submit"); // Change the text on the next button if the quiz is over.

        else if(currentQuestionNumber < questionsList.size()){

            userChoice = "";

            /** Reset the backgrounds of the options buttons.**/
            option1.setBackgroundResource(R.drawable.rectangle_white_stroke_2);
            option2.setBackgroundResource(R.drawable.rectangle_white_stroke_2);
            option3.setBackgroundResource(R.drawable.rectangle_white_stroke_2);
            option4.setBackgroundResource(R.drawable.rectangle_white_stroke_2);

//            String question_num = Integer.toString(currentQuestionNumber + 1) + "/" + Integer.toString(questionsList.size());

//            question_number.setText(question_num);
            question.setText(questionsList.get(currentQuestionNumber).getQuestion()); // Set the next question.

            option1.setText(questionsList.get(currentQuestionNumber).getOption1()); // Set the new questions.
            option2.setText(questionsList.get(currentQuestionNumber).getOption2());
            option3.setText(questionsList.get(currentQuestionNumber).getOption3());
            option4.setText(questionsList.get(currentQuestionNumber).getOption4());

        }

        else{

            Intent intent = new Intent(QuizActivity.this, QuizOutcomeActivity.class);
            intent.putExtra("Correct Answers", getAnswer());
            intent.putExtra("Incorrect Answers", getWrongAnswer());
            startActivity(intent);

            finish();

        }

    }

    private void startStopWatch(TextView stopwatchText){

        timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                /**
                 * Check if the timer has been ticking for 1 minute already and change the minutes value accordingly.**/
                if(seconds == 0 && minutes > 0){
                    minutes -= 1;
                    seconds = 59;
                }

                /** Check if the time has run out.**/
                else if(seconds <= 0 && minutes <= 0){

                    timer.purge();
                    timer.cancel();

                    // Toast.makeText(QuizActivity.this, "Time Up", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(QuizActivity.this, QuizOutcomeActivity.class);
                    intent.putExtra("correct", getAnswer()); // Get the number of correct and incorrect answers.
                    intent.putExtra("incorrect", getWrongAnswer());
                    startActivity(intent);
                    finish();

                }
                else
                    seconds -= 1;

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        String finalMinutes = String.valueOf(minutes); // Convert the timer values to string.
                        String finalSeconds = String.valueOf(seconds);

                        if(finalMinutes.length() == 1)
                            finalMinutes = "0" + finalMinutes;

                        if(finalSeconds.length() == 1)
                            finalSeconds = "0" + finalSeconds;

                        String final_time = finalMinutes + ":" + finalSeconds; // Create the text to display as the time.

                        stopwatchText.setText(final_time);
                    }
                });

            }
        }, 1000, 1000);

    }

    private int getAnswer(){

        int correctAnswers = 0;
        for(int i = 0; i < questionsList.size(); i++){

            String getUserAnswer = questionsList.get(i).getUserChoice(); // Fetch the correct answer and the user's choice.
            String getAnswer = questionsList.get(i).getAnswer();

            if(getAnswer.equals(getUserAnswer)) // Check if the user has chosen the correct answer.
                correctAnswers += 1;

        }
        return correctAnswers;
    }

    private int getWrongAnswer(){

        int incorrectAnswers = 0;
        for(int i = 0; i < questionsList.size(); i++){

            String getUserAnswer = questionsList.get(i).getUserChoice(); // Fetch the correct answer and the user's choice.
            String getAnswer = questionsList.get(i).getAnswer();

            if(!getAnswer.equals(getUserAnswer)) // Check if the user has chosen an incorrect answer.
                incorrectAnswers += 1;

        }
        return incorrectAnswers;
    }

    @Override
    public void onBackPressed() {

        timer.purge(); // Stop the timer.
        timer.cancel();

        startActivity(new Intent(QuizActivity.this, MainActivity.class));
        finish();

    }

    private void showAnswer(){

        String correctAnswer = questionsList.get(currentQuestionNumber).getAnswer(); // Fetch the correct answer from the list of questions.

        /**
         * Check which option holds the correct answer.**/
        if(option1.getText().toString().equals(correctAnswer))
            option1.setBackgroundResource(R.drawable.rectangle_green);

        else if(option2.getText().toString().equals(correctAnswer))
            option2.setBackgroundResource(R.drawable.rectangle_green);

        else if(option3.getText().toString().equals(correctAnswer))
            option3.setBackgroundResource(R.drawable.rectangle_green);

        else
            option4.setBackgroundResource(R.drawable.rectangle_green);

    }

    @Override
    protected void onResume() {

        super.onResume();

        accelerometer.sensorRegister(); // Start the functionality of the sensors.
        gyroscope.sensorRegister();

    }

    @Override
    protected void onPause() {

        super.onPause();

        accelerometer.sensorUnregister(); // Stop the functionality of the sensors.
        gyroscope.sensorUnregister();

    }
}


