package es.ulpgc.eite.android.quiz;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by ivang_000 on 02/02/2017.
 */

public class QuizModel {

    private String correctLabel, incorrectLabel;
    private int quizIndex;
    private boolean[] userAnswers = new boolean[20];
    private QuizApp mediator;

    private String[] quizQuestions = {
            "Christian Bale played Batman in 'The Dark Knight Rises'?", // 1
            "The Gremlins movie was released in 1986?",  // 2
            "Brad Pitt played Danny Ocean in Ocean's Eleven, Ocean's Twelve and Ocean's Thirteen?",  // 3
            "A spoon full of sugar' came from the 1964 movie Mary Poppins?",  // 4
            "The song “I don't want to miss a thing” featured in Armageddon?", // 5
            "Will Smith has a son called Jaden?", // 6
            "Mark Ruffalo played Teddy Daniels in Shutter Island?", // 7
            "Mike Myers starred in the 'Cat in the Hat' 2003 children's movie?", // 8
            "Ryan Reynolds is married to Scarlett Johansson?", // 9
            "The movie 'White House Down' was released in 2014?",  // 10
            "Michael Douglas starred in Basic Instinct, Falling Down and The Game?", // 11
            "Colin Firth won an Oscar for his performance in the historical movie 'The King's Speech'?",  // 12
            "Cameron Diaz and Ashton Kutcher starred in the movie 'What happens in Vegas'?", // 13
            "Arnold Schwarzenegger played lead roles in Rocky, Rambo and Judge Dredd?", // 14
            "The Titanic movie featured the song 'My Heart Will Go On'?", // 15
            "Eddie Murphy narrates the voice of Donkey in the Shrek movies?", // 16
            "Nicole Kidman played Poison Ivy in 'Batman and Robin'?", // 17
            "The Lara Croft: Tomb Raider movie was released in 2003?", // 18
            "Hallie Berry played the character Rogue in X Men?", // 19
            "The Teenage Mutant Ninja Turtles are named after famous artists?", // 20
    };

    private boolean[] quizAnswers = {
            true, // 1
            false, // 2
            false, // 3
            true, // 4
            true, // 5
            true, // 6
            false, // 7
            true, // 8
            false, // 9
            false, // 10
            true, // 11
            true, // 12
            true, // 13
            false, // 14
            true, // 15
            true, // 16
            false, // 17
            false, // 18
            false, // 19
            true // 20
    };

    public QuizModel(QuizApp mediator) {
        correctLabel = "Correct!";
        incorrectLabel = "Incorrect...";
        this.mediator = mediator;
    }

    public String getCurrentAnswer() {
        if(quizAnswers[quizIndex] == userAnswers[quizIndex]) {
            return correctLabel;
        } else {
            return incorrectLabel;
        }
    }

    public String getCurrentQuestion() {
        return quizQuestions[quizIndex];
    }

    public String getNextQuestion() {
        quizIndex++;
        return getCurrentQuestion();
    }

    public void setCurrentAnswer(boolean answer) {
        userAnswers[quizIndex] = answer;
    }

    public void onFalseBtnClicked() {
        onAnswerBtnClicked(false);
    }

    public void onTrueBtnClicked() {
        onAnswerBtnClicked(true);
    }

    public void onAnswerBtnClicked(boolean answer) {
        setCurrentAnswer(answer);
    }

    public boolean getCheatAnswer (){
        return quizAnswers[quizIndex];
    }

}
