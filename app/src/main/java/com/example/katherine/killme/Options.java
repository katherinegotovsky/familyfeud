package com.example.katherine.killme;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Shows instructions and allows the user to click a button to play the game.
 * @author: Katherine Gotovsky
 * @version: 1.0
 * @date: June 7 2017
 */

public class Options extends Activity {
    int qid;
    Button btngame;

    /**
     * When the page is opened, a menu of options is generated, a "Play" button appears, and
     * music plays.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.optionsmenu);


        btngame = (Button) findViewById(R.id.btngame);

        /**
         * When the "Play" button is clicked, the QuestionActivity is generated.
         */
        btngame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Options.this,
                        QuestionActivity.class);
                Bundle b = getIntent().getExtras();
                if (b != null) {
                    qid = b.getInt("qid");
                    b.putInt("qid", qid); // Your score
                    intent.putExtras(b);
                }
                startActivity(intent);
                finish();
            }
        });

    }
}
