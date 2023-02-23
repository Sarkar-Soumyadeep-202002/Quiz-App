package au.edu.jcu.quiz_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class HighScoreActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> scoreText;
    SQLiteHelper DB;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        DB = new SQLiteHelper(this); // Create the instance of the SQLiteHelper class.
        scoreText = new ArrayList<>(); // Create a list to store the scores.
        recyclerView = findViewById(R.id.high_score_screen);
        adapter = new MyAdapter(this, scoreText); // Create an adapter for the scores.
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData(); // Display the data.

    }

    private void displayData(){

        Cursor cursor = DB.getData(); // Instantiate the cursor to query through the database.
        if(cursor.getCount() == 0) {
            Toast.makeText(HighScoreActivity.this, "No Records Exist", Toast.LENGTH_SHORT).show(); // Display an appropriate message.
            return;
        }

        else{

            while(cursor.moveToNext()){

                scoreText.add(cursor.getString(0)); // Create a new query.

            }

        }

    }

}