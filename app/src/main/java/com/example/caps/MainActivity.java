package com.example.caps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Game game;
    private String question;
    private String answer;
    private int score;
    private int qNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        score=0;
        qNum=1;
        ask();
    }

    private void ask(){
    String qa= new Game().qa();

    String[] result= (qa).split("\\n");

    question=result[0];
    answer=result[1];
    ((TextView) findViewById(R.id.question)).setText(question);


    }
    public void onDone(View v){

        EditText input = (EditText) findViewById(R.id.answer);
        String myInput = input.getText().toString();
        myInput = myInput.toUpperCase();



        if (myInput.equalsIgnoreCase(answer)){
            score+=1;
            String scoreView = String.format("SCORE = %d", score);
            ((TextView) findViewById(R.id.score)).setText(scoreView);
        }
        ((EditText) findViewById(R.id.answer)).setText("");

        TextView scrollView= findViewById(R.id.log);
        String log=scrollView.getText().toString();
        String newLog = String.format("Q#: %d: %s \nYour answer: %s \nCorrect Answer: %s\n\n", qNum, question, myInput, answer);
        log =newLog+log;

        ((TextView) findViewById(R.id.log)).setText(log);

        qNum++;

        if (qNum>10){
            ((TextView) findViewById(R.id.qNum)).setText("Game Over!");
            Button btn = (Button) findViewById(R.id.button);
            btn.setEnabled(false);

        }
        else{
            String qNumView = String.format("Q# %d", qNum);
            ((TextView) findViewById(R.id.qNum)).setText(qNumView);
            ask();
        }
    }
}
