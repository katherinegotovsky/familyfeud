package com.example.katherine.killme;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.content.Intent;

/**
 * Opens the app and creates a splash page.
 * @author katherine.gotovsky
 * @version 1.0
 */

public class MainActivity extends Activity {
    MediaPlayer mediaPlayer;

    private static int SPLASH_TIME_OUT = 3000; // Splash screen timer

    /**
     * Sets the screen to the splash page and plays music. After the timer has elapsed, the
     * user is directed to the Options Activity.
     * @param savedInstanceState Any data that may have been saved from before
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash); //sets the screen to the splash page
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.familyfeud);
        mediaPlayer.start();

        new Handler().postDelayed(new Runnable() {

            /**
             * Starts the Options activity.
             */
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, Options.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    /**
     * Method that pauses and stops the media player.
     */
    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
    }

}