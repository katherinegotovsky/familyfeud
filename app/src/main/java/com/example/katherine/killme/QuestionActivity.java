package com.example.katherine.killme;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Collections;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * The QuestionActivity class contains all the methods that are required for gameplay.
 * It contains all user input and output necessary for the game to be played.
 * @author: Katherine Gotovsky
 * @version: 1.0
 * @date: June 7 2017
 */

public class QuestionActivity extends Activity {
    ArrayList<Question> quesList = new ArrayList<>() ;
    int score = 0;
    int qid = 0;
    Question currentQ;
    TextView txtQuestion, times, scored, message, answer1, answer2, answer3, answer4, score1, score2, score3, score4;
    EditText editText1;
    Button button1;
    int strikes = 0;
    int attempts = 0;

    /**
     * This method dictates what will happen once this Activity is opened,
     * which includes setting a timer, setting up the layout, and retrieving a question.
     * @param savedInstanceState any data that is supplied to the method
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addAllQuestions(quesList);
        Collections.shuffle(quesList);

        currentQ = quesList.get(qid); // the current question
        txtQuestion = (TextView) findViewById(R.id.txtQuestion); // the textview in which the question will be displayed
        scored = (TextView) findViewById(R.id.score); //the textview in which the score will be displayed
        times = (TextView) findViewById(R.id.timers); //the textview in which the timer will be displayed
        editText1 = (EditText) findViewById(R.id.editText1);
        button1 = (Button) findViewById(R.id.button1);
        message = (TextView) findViewById(R.id.message); //the textview in which error messages are displayed.
        answer1 = (TextView) findViewById(R.id.answer1);
        answer2 = (TextView) findViewById(R.id.answer2);
        answer3 = (TextView)  findViewById(R.id.answer3);
        answer4 = (TextView) findViewById(R.id.answer4);
        score1 = (TextView) findViewById(R.id.score1);
        score2 = (TextView) findViewById(R.id.score2);
        score3 = (TextView) findViewById(R.id.score3);
        score4 = (TextView) findViewById(R.id.score4);
        Bundle b = getIntent().getExtras();
        if (b != null) {
            qid = b.getInt("qid");// Your score
        }


        setQuestionView(); // method which will set the things up for our game
        times.setText("00:02:00"); // A timer of 60 seconds to play for, with an interval of 1 second (1000 milliseconds)

        final CounterClass timer = new CounterClass(60000, 1000);
        timer.start();

        button1.setOnClickListener(new View.OnClickListener() { //editText onclick listener
            @Override
            public void onClick(View v) {
                getAnswer(editText1.getText().toString().toLowerCase().trim()); //see if the answer is right or not
                editText1.setText("");
                timer.cancel();
                timer.start();
            }
        });

    }

    /**
     * Compares the text that the user has entered to the 4 possible answers to the questions.
     * If the input is correct, the answer is revealed and the appropriate value is added to the score.
     * If not, the user gets a strike.
     * If the user gets three strikes, they are directed to the Result Activity.
     * If the user gets all four answers right, they are given a new question.
     *
     * @param AnswerString The text that the user has inputted
     */
    public void getAnswer(String AnswerString) {
        if (currentQ.getANSWER1().equals(AnswerString)) {
            score+= currentQ.getScore1();
            scored.setText("Score : " + score);
            message.setText("That is correct!");
            answer1.setText(currentQ.getANSWER1().toUpperCase());
            score1.setText(Integer.toString(currentQ.getScore1()));
            attempts++;
            if (attempts == 4) {
                strikes = 0;
                attempts = 0;
                message.setText("Next question!");
                setQuestionView();
            }

        } else if (currentQ.getANSWER2().equals(AnswerString)) {
            score+= currentQ.getScore2();
            scored.setText("Score : " + score);
            message.setText("That is correct!");
            answer2.setText(currentQ.getANSWER2().toUpperCase());
            score2.setText(Integer.toString(currentQ.getScore2()));
            attempts++;
            if (attempts == 4) {
                strikes = 0;
                attempts = 0;
                message.setText("Next question!");
                setQuestionView();
            }

        } else if (currentQ.getANSWER3().equals(AnswerString)) {
            score+= currentQ.getScore3();
            scored.setText("Score : " + score);
            message.setText("That is correct!");
            answer3.setText(currentQ.getANSWER3().toUpperCase());
            score3.setText(Integer.toString(currentQ.getScore3()));
            attempts++;
            if (attempts == 4) {
                strikes = 0;
                attempts = 0;
                message.setText("Next question!");
                setQuestionView();
            }

        } else if (currentQ.getANSWER4().equals(AnswerString)) {
            score+= currentQ.getScore4();
            scored.setText("Score : " + score);
            message.setText("That is correct!");
            answer4.setText(currentQ.getANSWER4().toUpperCase());
            score4.setText(Integer.toString(currentQ.getScore4()));
            attempts++;
            if (attempts == 4) {
                strikes = 0;
                attempts = 0;
                message.setText("Next question!");
                setQuestionView();
            }

        } else if (strikes == 1) {
            strikes++;
            message.setText("That is incorrect. You have " + strikes + " strikes.");

        } else if (strikes == 0) {
            strikes++;
            message.setText("That is incorrect. You have " + strikes + " strike.");

        } else {
            message.setText("You have three strikes. Game over.");
            Intent intent = new Intent(QuestionActivity.this,
                    ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score);
            b.putInt("qid", qid); // Your score
            intent.putExtras(b); // Put your score to your next
            startActivity(intent);
            finish();
        }

    }

    /**
     * The timer counter class.
     */
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")
    public class CounterClass extends CountDownTimer {
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);

        }

        /**
         * When the timer runs out, the user is directed to the Result Activity.
         */
        @Override
        public void onFinish() {
           message.setText("Time is up.");
            Intent intent = new Intent(QuestionActivity.this,
                    ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score); // Your score
            intent.putExtras(b); // Put your score to your next
            startActivity(intent);
            finish();

        }

        /**
         * This method ouputs the time into readable form by converting it to a string and defining
         * it in terms of second, hours, and minutes instead of milliseconds.
         * @param millisUntilFinished The number of milliseconds left before the timer reaches 0.
         */
        @Override
        public void onTick(long millisUntilFinished) {
            long millis = millisUntilFinished;
            String hms = String.format(
                    "%02d:%02d:%02d",
                    TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis)
                            - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
                            .toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                            .toMinutes(millis)));
            System.out.println(hms);
            times.setText(hms);
        }
    }

    /**
     * This method displays a new question and resets the 'tiles' on the board.
     */
    private void setQuestionView() {
        currentQ = quesList.get(qid++);
        txtQuestion.setText(currentQ.getQUESTION());
        answer1.setText("Answer 1");
        answer2.setText("Answer 2");
        answer3.setText("Answer 3");
        answer4.setText("Answer 4");
        score1.setText("Score 1");
        score2.setText("Score 2");
        score3.setText("Score 3");
        score4.setText("Score 4");
    }

    /**
     * Contains the list of questions that will be used in the game. Adds them to an
     * Array List.
     * @param arrayList an empty list that will contain all the questions so that they can be displayed
     * to the user.
     */
    public void addAllQuestions(ArrayList<Question> arrayList) {
        arrayList.add(new Question(1, "Name a bad job for someone who’s accident-prone.", "driver", "construction", "food service", "police", 33, 20, 11, 10));
        arrayList.add(new Question(2, "Name something that is uncomfortable to sit on.", "rock", "saddle", "pew", "steps", 52, 29, 13, 6));
        arrayList.add(new Question(3, "Name a country that begins with the letter “E”", "england", "egypt", "ethiopia", "ecuador", 46, 25, 19, 10));
        arrayList.add(new Question(4, "Give me a woman's name that is 4 letters long.", "mary", "jane", "lisa", "beth", 36, 24, 16, 10));
        arrayList.add(new Question(5, "Tell me a word you’d use to describe someone that is mean.", "bully", "horrible", "bossy", "wicked", 35, 27, 21, 11));
    }
}