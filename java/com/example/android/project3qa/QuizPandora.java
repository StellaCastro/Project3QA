package com.example.android.project3qa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuizPandora extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_pandora);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("userScore", score);

    }
    @Override
    protected void onRestoreInstanceState(Bundle savedIntanceState){
        super.onRestoreInstanceState(savedIntanceState);
        score = savedIntanceState.getInt("userScore");
    }
    int score= 0;
    int userAnswer;
    int correctAnswer;
    String scoreMessage;
    String userName;
    int incorrect=0;
    String wrongAnswers;
    //this method will check the answers of the quiz
    public void checkAnswers (){
        EditText pandoraText = (EditText) findViewById(R.id.Q1AA);
        String typedAnswer = pandoraText.getText().toString();
        String correctAnswerType = "Pandora";
        if (correctAnswerType.equals(typedAnswer)&&score<8 ){
            score+=1;
        }else{
            if (incorrect<8) {
                incorrect += 1;
            }
        }
        RadioGroup question2RG = (RadioGroup) findViewById(R.id.Q2RG);
        userAnswer= question2RG.getCheckedRadioButtonId();
        RadioButton question2RB = (RadioButton)findViewById(R.id.Q2AA);
        correctAnswer = question2RB.getId();
        if (userAnswer == correctAnswer&&score<8){
            score += 1;
        }else{
            if (incorrect<8) {
                incorrect += 1;
            }
        }
        CheckBox question3CB1 = (CheckBox) findViewById(R.id.Q3AA);
        CheckBox question3CB2 = (CheckBox) findViewById(R.id.Q3AB);
        CheckBox question3CB3 = (CheckBox) findViewById(R.id.Q3AC);
        boolean question3A1 = question3CB1.isChecked();
        boolean question3A2 = question3CB2.isChecked();
        boolean question3A3 = question3CB3.isChecked();
        if (question3A1 && question3A2 && question3A3 && score < 8){
            score +=1;
        }else{
            if (incorrect<8) {
                incorrect += 1;
            }
        }
        RadioGroup question4RG = (RadioGroup) findViewById(R.id.Q4RG);
        userAnswer= question4RG.getCheckedRadioButtonId();
        RadioButton question4RB = (RadioButton)findViewById(R.id.Q4AB);
        correctAnswer = question4RB.getId();
        if (userAnswer == correctAnswer && score < 8){
            score += 1;
        }else{
            if (incorrect<8) {
                incorrect += 1;
            }
        }
        RadioGroup question5RG = (RadioGroup) findViewById(R.id.Q5RG);
        userAnswer= question5RG.getCheckedRadioButtonId();
        RadioButton question5RB = (RadioButton)findViewById(R.id.Q5AB);
        correctAnswer = question5RB.getId();
        if (userAnswer == correctAnswer && score < 8){
            score += 1;
        }else{
            if (incorrect<8) {
                incorrect += 1;
            }
        }
        RadioGroup question6RG = (RadioGroup) findViewById(R.id.Q6RG);
        userAnswer= question6RG.getCheckedRadioButtonId();
        RadioButton question6RB = (RadioButton)findViewById(R.id.Q6AB);
        correctAnswer = question6RB.getId();
        if (userAnswer == correctAnswer&& score < 8){
            score += 1;
        }else{
            if (incorrect<8) {
                incorrect += 1;
            }
        }
        RadioGroup question7RG = (RadioGroup) findViewById(R.id.Q7RG);
        userAnswer= question7RG.getCheckedRadioButtonId();
        RadioButton question7RB = (RadioButton)findViewById(R.id.Q7AB);
        correctAnswer = question7RB.getId();
        if (userAnswer == correctAnswer && score < 8){
            score += 1;
        }else{
            if (incorrect<8) {
                incorrect += 1;
            }
        }
        CheckBox question8CB1 = (CheckBox) findViewById(R.id.Q8AA);
        CheckBox question8CB2 = (CheckBox) findViewById(R.id.Q8AB);
        CheckBox question8CB3 = (CheckBox) findViewById(R.id.Q8AC);
        boolean question8A1 = question8CB1.isChecked();
        boolean question8A2 = question8CB2.isChecked();
        boolean question8A3 = question8CB3.isChecked();
        if (question8A1 && question8A2 && !question8A3 && score < 8){
            score +=1;
        }else{
            if (incorrect<8) {
                incorrect += 1;
            }
        }
    }
    //this method will pass the user score to the last activity of the app
    public void submitAnswers (View view) {
        checkAnswers();
        wrongAnswers= " "+incorrect;
        scoreMessage = " " + score;
        userName = getIntent().getExtras().getString("testTaker");
        Intent intentScore = new Intent(QuizPandora.this, LastPage.class);
        intentScore.putExtra("wrong", wrongAnswers);
        intentScore.putExtra("gradeMessage", scoreMessage);
        intentScore.putExtra("testTaker", userName);
        startActivity(intentScore);
        toastGreat();
    }
    //the custom toast method
    public void toastGreat (){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.great_toast, (ViewGroup)findViewById(R.id.great_job));
        Toast toast = new Toast (getApplicationContext());
        toast.setGravity(Gravity.FILL,0,0);
        toast.setDuration(toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
}
