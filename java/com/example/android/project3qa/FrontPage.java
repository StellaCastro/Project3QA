package com.example.android.project3qa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FrontPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);

        //this method will take the user to the quiz layou and save the user name
        Button startButton = (Button) findViewById(R.id.start_button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText quizTaker = (EditText) findViewById(R.id.user_name);
                String userName = quizTaker.getText().toString();
                Intent passName_Intent = new Intent(FrontPage.this, QuizPandora.class);
                passName_Intent.putExtra("testTaker", userName);
                startActivity(passName_Intent);
            }
        });
    }
}