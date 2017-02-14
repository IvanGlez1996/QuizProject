package es.ulpgc.eite.android.quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

public class QuizView extends AppCompatActivity {

    private Toolbar toolbarScreen;
    private Button buttonTrue, buttonFalse, buttonCheat, buttonNext;
    private TextView labelQuestion, labelAnswer;

    private QuizApp mediator;
    private QuizPresenter quizPresenter;

    private String falseLabel, trueLabel, cheatLabel, nextLabel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        mediator = (QuizApp)getApplication();
        mediator.setQuizView(this);
        this.quizPresenter = mediator.getQuizPresenter();

        labelQuestion = (TextView) findViewById(R.id.labelQuestion);
        labelAnswer = (TextView) findViewById(R.id.labelAnswer);

        toolbarScreen = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbarScreen);

        buttonTrue = (Button) findViewById(R.id.buttonTrue);
        buttonTrue.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                quizPresenter.onTrueBtnClicked();
            }
        });
        buttonFalse = (Button) findViewById(R.id.buttonFalse);
        buttonFalse.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                quizPresenter.onFalseBtnClicked();
            }
        });
        buttonCheat = (Button) findViewById(R.id.buttonCheat);
        buttonCheat.setOnClickListener(new android.view.View.OnClickListener() {
             @Override
             public void onClick(android.view.View view) {
                quizPresenter.onCheatBtnClicked();
      }
    });
        buttonNext = (Button) findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                quizPresenter.onNextBtnClicked();
            }
        });

        falseLabel = "False";
        trueLabel = "True";
        cheatLabel = "Cheat";
        nextLabel = "Next";

        onScreenStarted();

    }

    private void onScreenStarted() {

        setButtonLabels();
        mediator.checkVisibility();

        setQuestion(quizPresenter.getCurrentQuestion());
        if(mediator.isAnswerBtnClicked()){
            setAnswer(quizPresenter.getCurrentAnswer());
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


    public void hideAnswer() {
        labelAnswer.setVisibility(android.view.View.INVISIBLE);
    }

    public void hideToolbar() {
        toolbarScreen.setVisibility(android.view.View.GONE);
    }

    public void setAnswer(String text) {
        labelAnswer.setText(text);
    }

    public void setCheatButton(String label) {
        buttonCheat.setText(label);
    }

    public void setFalseButton(String label) {
        buttonFalse.setText(label);
    }

    public void setNextButton(String label) {
        buttonNext.setText(label);
    }

    public void setQuestion(String text) {
        labelQuestion.setText(text);
    }

    public void setTrueButton(String label) {
        buttonTrue.setText(label);
    }

    public void showAnswer() {
        labelAnswer.setVisibility(android.view.View.VISIBLE);
    }


}

