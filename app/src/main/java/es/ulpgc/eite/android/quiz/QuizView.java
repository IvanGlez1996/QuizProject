package es.ulpgc.eite.android.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizView extends AppCompatActivity {


    private boolean toolbarVisible;
    private boolean answerVisible;
    private boolean answerBtnClicked;

    private Toolbar toolbarScreen;
    private Button buttonTrue, buttonFalse, buttonCheat, buttonNext;
    private TextView labelQuestion, labelAnswer;

    private Presenter presenter;

    private String falseLabel, trueLabel, cheatLabel, nextLabel;
    private String correctLabel, incorrectLabel;
    //private QuizApp quizApp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);


        labelQuestion = (TextView) findViewById(R.id.labelQuestion);
        labelAnswer = (TextView) findViewById(R.id.labelAnswer);

        toolbarScreen = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbarScreen);

        this.presenter = new Presenter(this);

        buttonTrue = (Button) findViewById(R.id.buttonTrue);
        buttonTrue.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                presenter.onTrueBtnClicked();
            }
        });
        buttonFalse = (Button) findViewById(R.id.buttonFalse);
        buttonFalse.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                presenter.onFalseBtnClicked();
            }
        });
        buttonCheat = (Button) findViewById(R.id.buttonCheat);
   /* buttonCheat.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.onCheatBtnClicked();
      }
    });
    */
        buttonNext = (Button) findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                presenter.onNextBtnClicked();
            }
        });

        falseLabel = "False";
        trueLabel = "True";
        correctLabel = "Correct!";
        incorrectLabel = "Incorrect!";
        cheatLabel = "Cheat";
        nextLabel = "Next";

        onScreenStarted();

    }

    private void onScreenStarted() {
        //quizApp = (QuizApp) getApplication();

        setButtonLabels();
        checkVisibility();

        setQuestion(presenter.getCurrentQuestion());
        if(isAnswerBtnClicked()){
            setAnswer(presenter.getCurrentAnswer());
        }
    }


    private void setButtonLabels(){
        setTrueButton(getTrueLabel());
        setFalseButton(getFalseLabel());
        setCheatButton(getCheatLabel());
        setNextButton(getNextLabel());
    }

    public String getTrueLabel() {
        return trueLabel;
    }
    public String getFalseLabel() {
        return falseLabel;
    }
    public String getNextLabel() {
        return nextLabel;
    }
    public String getCheatLabel() {
        return cheatLabel;
    }


    public boolean isAnswerVisible() {
        return answerVisible;
    }

    private boolean isToolbarVisible() {
        return toolbarVisible;
    }

    public void setAnswerVisibility(boolean visible) {
        answerVisible = visible;
    }

    private boolean isAnswerBtnClicked() {
        return answerBtnClicked;
    }

    private void setAnswerBtnClicked(boolean clicked) {
        answerBtnClicked = clicked;
    }

  /*
  private boolean isAnswerBtnClicked() {
    return quizApp.isAnswerBtnClicked();
  }

  private void setAnswerBtnClicked(boolean clicked) {
    quizApp.setAnswerBtnClicked(clicked);
  }

  private QuestionStore getQuestionStore() {
    return quizApp.getQuestionStore();
  }

  private boolean isToolbarVisible() {
    return quizApp.isToolbarVisible();
  }

  private void setAnswerVisibility(boolean visible) {
    quizApp.setAnswerVisibility(visible);
  }

  private boolean isAnswerVisible() {
    return quizApp.isAnswerVisible();
  }
  */

    /* private void goToCheatScreen(){
       startActivity(new Intent(this, CheatActivity.class));
       //quizApp.goToCheatScreen(this);
     }
   */
    public void checkAnswerVisibility(){
        if(!isAnswerVisible()) {
            hideAnswer();
        } else {
            showAnswer();
        }
    }

    private void checkToolbarVisibility(){
        if (!isToolbarVisible()) {
            hideToolbar();
        }
    }


    private void checkVisibility(){
        checkToolbarVisibility();
        checkAnswerVisibility();
    }


    private void hideAnswer() {
        labelAnswer.setVisibility(android.view.View.INVISIBLE);
    }

    private void hideToolbar() {
        toolbarScreen.setVisibility(android.view.View.GONE);
    }

    public void setAnswer(String text) {
        labelAnswer.setText(text);
    }

    private void setCheatButton(String label) {
        buttonCheat.setText(label);
    }

    private void setFalseButton(String label) {
        buttonFalse.setText(label);
    }

    private void setNextButton(String label) {
        buttonNext.setText(label);
    }

    public void setQuestion(String text) {
        labelQuestion.setText(text);
    }

    private void setTrueButton(String label) {
        buttonTrue.setText(label);
    }

    private void showAnswer() {
        labelAnswer.setVisibility(android.view.View.VISIBLE);
    }


}

