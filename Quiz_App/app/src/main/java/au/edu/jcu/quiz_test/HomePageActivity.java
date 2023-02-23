package au.edu.jcu.quiz_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomePageActivity extends AppCompatActivity {

    AppCompatEditText userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        userName = findViewById(R.id.Username); // Locate the username entered by the user.

    }

    public void start(View view){

        if(userName.getText().toString().length() == 0) // Check if the username entered is null.
            Toast.makeText(HomePageActivity.this, "PLEASE ENTER YOUR USERNAME", Toast.LENGTH_SHORT).show(); // Display a message.
        else {
            Toast.makeText(HomePageActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show(); // Display a message.
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent); // Start MainActivity.
        }
    }

    public void clickSettings(View view){

        Intent intent = new Intent(HomePageActivity.this, SettingsActivity.class);
        startActivity(intent); // Start SettingsActivity.

    }

}
