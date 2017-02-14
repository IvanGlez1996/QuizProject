package es.ulpgc.eite.android.quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatView extends AppCompatActivity {

  private QuizApp mediator;
  private CheatPresenter presenter;

  private String falseLabel, trueLabel;
  private String confirmLabel;
  private boolean trueAnswer;

  private Toolbar toolbarScreen;
  private Button buttonTrue, buttonFalse;
  private TextView labelConfirm, labelAnswer;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cheat);

    labelConfirm = (TextView) findViewById(R.id.labelConfirm);
    labelAnswer = (TextView) findViewById(R.id.labelAnswer);

    toolbarScreen = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbarScreen);

    buttonTrue = (Button) findViewById(R.id.buttonTrue);
    buttonTrue.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.onTrueBtnClicked();
      }
    });
    buttonFalse = (Button) findViewById(R.id.buttonFalse);
    buttonFalse.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.onFalseBtnClicked();
      }
    });
    
    onScreenStarted();
  }

  private void onScreenStarted() {
    mediator = (QuizApp) getApplication();
    mediator.setCheatView(this);
    presenter = mediator.getCheatPresenter();

    falseLabel = "False";
    trueLabel = "True";
    confirmLabel = "Are you sure?";

    setButtonLabels();
    mediator.checkCheatVisibility();

  }


  private void setButtonLabels(){
    setTrueButton(getTrueLabel());
    setFalseButton(getFalseLabel());
    setConfirm(getConfirmLabel());
  }
  
  
  public void hideToolbar() {
    toolbarScreen.setVisibility(View.GONE);
  }

  public void hideAnswer() {
    labelAnswer.setVisibility(View.INVISIBLE);
  }

  public void setAnswer(String txt) {
    labelAnswer.setText(txt);
  }

  private void setConfirm(String text) {
    labelConfirm.setText(text);
  }

  private void setFalseButton(String label) {
    buttonFalse.setText(label);
  }

  private void setTrueButton(String label) {
    buttonTrue.setText(label);
  }

  public void showAnswer() {
    labelAnswer.setVisibility(View.VISIBLE);
  }


  private String getConfirmLabel() {
    return confirmLabel;
  }


  private String getFalseLabel() {
    return falseLabel;
  }


  public String getAnswer() {
    if(trueAnswer) {
      return trueLabel;
    } else {
      return falseLabel;
    }
  }

  private String getTrueLabel() {
    return trueLabel;
  }

  public void setAnswer(boolean answer){
    trueAnswer = answer;
  }
}
