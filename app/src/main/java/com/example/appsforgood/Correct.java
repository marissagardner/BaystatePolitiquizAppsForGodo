package com.example.appsforgood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Correct extends AppCompatActivity {

    static int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String answer = bundle.getString("Correct");
        int computerScore = bundle.getInt("ComputerScore");

        TextView answerView = (TextView)findViewById(R.id.correctID);
        answerView.setText(answer);

        if(answerView.getText().equals("Correct")){
            score++;
        }
        else{
            TextView correctAnswerView = (TextView) findViewById(R.id.correctAnswerID);
            correctAnswerView.setText("Correct Answer: " + bundle.getString("CorrectAnswer"));
        }

        TextView scoreView = (TextView)findViewById(R.id.scoreID);
        scoreView.setText(String.valueOf(score));
        TextView computerScoreView = (TextView) findViewById(R.id.computerScoreID);
        computerScoreView.setText(String.valueOf(computerScore));

    }

    public void nextButton(View v){
        Intent intent = new Intent(this,QuizViewActivity.class);
        intent.putExtra("Score",score);
        intent.putExtra("New Game","Same Game");
        startActivity(intent);
    }

    public void reset(){
        score = 0;
    }
}
