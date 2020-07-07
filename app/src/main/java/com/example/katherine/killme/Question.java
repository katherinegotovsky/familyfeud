package com.example.katherine.killme;
import android.app.Activity;

/**
 * The Question class contains a question, four possible answers, and four
 * scores that each correlate to one of those answers.
 * @author Katherine Gotovsky
 * @version 1.0
 * @date June 7 2017
 */

public class Question extends Activity {

    private String QUESTION;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private int score1;
    private int score2;
    private int score3;
    private int score4;

    /**
     * Constructor that instantiates Question objects.
     * @param qUESTION The question
     * @param Answer1 The first possible answer
     * @param Answer2 The second possible answer
     * @param Answer3 The third possible answer
     * @param Answer4 The fourth possible answer
     * @param Score1 The 'score' allotted to answer 1 (most popular answer)
     * @param Score2 The 'score' allotted to answer 2 (second most popular answer)
     * @param Score3 The 'score' allotted to answer 3 (third most popular answer)
     * @param Score4 The 'score' allotted to answer 4 (fourth most popular answer)
     */
    public Question(int ID, String qUESTION, String Answer1, String Answer2, String Answer3,
                    String Answer4, int Score1, int Score2, int Score3, int Score4) {

        QUESTION = qUESTION;
        answer1 = Answer1;
        answer2 = Answer2;
        answer3 = Answer3;
        answer4 = Answer4;
        score1 = Score1;
        score2 = Score2;
        score3 = Score3;
        score4 = Score4;

    }

    /**
     * Gets the question within a Question object.
     * @return the question within a Question object
     *
     */
    public String getQUESTION() {
        return QUESTION;
    }

    /**
     * Gets the first and most popular answer of a Question object.
     * @return answer 1
     *
     */
    public String getANSWER1() {
        return answer1;
    }

    /**
     * Gets the second answer of a Question object.
     * @return answer 2
     */
    public String getANSWER2() {
        return answer2;
    }

    /** Gets the third answer of a Question object.
     * @return answer 3
     */
    public String getANSWER3() {
        return answer3;
    }

    /**
     * Gets the fourth answer of a Question object.
     * @return answer 4
     */
    public String getANSWER4() {
        return answer4;
    }

    /**
     * Gets the score associated with answer 1 (the most popular answer).
     * @return score of answer 1
     */
    public int getScore1() {
        return score1;
    }

    /**
     * Gets the score associated with answer 2 (second most popular answer).
     * @return score of answer 2
     */
    public int getScore2() {
        return score2;
    }

    /**
     * Gets the score associated with answer 3 (the third most popular answer).
     * @return score of answer 3
     */
    public int getScore3() {
        return score3;
    }

    /**
     * Gets the score associated with answer 4 (the fourth most popular answer).
     * @return score of answer 4
     */
    public int getScore4() {
        return score4;
    }
    
}
