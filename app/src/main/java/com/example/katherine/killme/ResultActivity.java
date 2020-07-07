package com.example.katherine.killme;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * The Result Activity lets the user know the game is over and shows them their score.
 * @author: Katherine Gotovsky
 * @version: 1.0
 * @date: June 7 2017
 */

public class ResultActivity extends Activity {
    int qid;


    /**
     * When this Activity is opened, the optionsmenu layout will be displayed, as will the user's
     * score.
     * @param savedInstanceState data that is supplied to the method
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView textResult = (TextView) findViewById(R.id.textResult);
        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");
        qid = b.getInt("qid");
        textResult.setText("Your score is " + score + ".");
        onPause();
    }

    /**
     * Opens the Options activity so that the user can play again.
     * @param o A button
     */
    public void playagain(View o) {
        Intent intent = new Intent(this, Options.class);
        Bundle b = new Bundle();
        b.putInt("qid", qid); // Your score
        intent.putExtras(b); // Put your score to your next
        startActivity(intent);

    }
}