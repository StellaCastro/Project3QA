package com.example.android.project3qa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LastPage extends AppCompatActivity {
    String finalScore;
    String testTaker;
    String wrongMarks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_page);
        //receives the users wrong score from the quiz
        wrongMarks= getIntent().getExtras().getString("wrong");
        //receives the the user right score from the quiz and puts ir in the xml layout
        finalScore= getIntent().getExtras().getString("gradeMessage");
        //receives the the user name from the quiz and puts ir in the xml layout
        testTaker= getIntent().getExtras().getString("testTaker");
        TextView nameTextView = (TextView) findViewById(R.id.name_view);
        nameTextView.setText("" + testTaker);
    }
    //displays the test result in the the screen and release the toast
    public void checkScore (View view){
        TextView gradeTextView = (TextView) findViewById(R.id.correct_score);
        gradeTextView.setText("" + finalScore);
        TextView incorrectTextView = (TextView) findViewById(R.id.incorrect_score);
        incorrectTextView.setText(""+ wrongMarks);
        Toast.makeText(getApplicationContext(),"Congratulations!\nCorrect: "+finalScore+ "\nIncorrect: "+wrongMarks, Toast.LENGTH_LONG).show();
    }
    //reset the app and takes the user to the beginning of the app
    public void startOver (View view){
        Intent resetIntent = new Intent(LastPage.this, FrontPage.class);
        LastPage.this.startActivity(resetIntent);
    }

}


