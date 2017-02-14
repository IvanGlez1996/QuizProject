package es.ulpgc.eite.android.quiz;

import android.app.Application;
import android.content.Intent;

public class QuizApp extends Application {

  private QuestionState questionState;
  private CheatState cheatState;
  private QuizModel quizModel;
  private QuizView quizView;
  private QuizPresenter quizPresenter;
  private CheatModel cheatModel;
  private CheatView cheatView;
  private CheatPresenter cheatPresenter;

  @Override
  public void onCreate() {
    super.onCreate();

    questionState = new QuestionState();
    questionState.toolbarVisible = false;
    questionState.answerVisible = false;

  }

  public QuizModel getQuizModel(){

    if (quizModel==null){
      quizModel= new QuizModel(this);
    }
    return quizModel;

  }
  public CheatPresenter getCheatPresenter() {
    if (cheatPresenter == null){
      cheatPresenter = new CheatPresenter(this);
    }
    return cheatPresenter;
  }

  public void setCheatView(CheatView cheatView) {
    this.cheatView = cheatView;
  }

  public CheatView getCheatView(){
    return cheatView;
  }

  public CheatModel getCheatModel(){
    if (cheatModel==null){
      cheatModel= new CheatModel(this);
    }
    return cheatModel;

  }
  public QuizPresenter getQuizPresenter() {
    if (quizPresenter == null){
      quizPresenter = new QuizPresenter(this);
    }
    return quizPresenter;
  }


  public void setQuizView(QuizView quizView) {
    this.quizView = quizView;
  }

  public QuizView getQuizView(){
    return quizView;
  }


  public boolean isAnswerBtnClicked() {
    return questionState.answerBtnClicked;
  }

  public void setAnswerBtnClicked(boolean clicked) {
    questionState.answerBtnClicked = clicked;
  }

  public void setConfirmBtnClicked(boolean clicked) {
        cheatState.confirmBtnClicked = clicked;
    }

  public boolean isAnswerVisible() {
    return questionState.answerVisible;
  }

  public boolean isToolbarVisible() {
    return questionState.toolbarVisible;
  }

  public void setAnswerVisibility(boolean visible) {
    questionState.answerVisible = visible;
  }


  public void checkAnswerVisibility(){
    if(!isAnswerVisible()) {
      quizView.hideAnswer();
    } else {
      quizView.showAnswer();
    }
  }

  private void checkToolbarVisibility(){
    if (!isToolbarVisible()) {
      quizView.hideToolbar();
    }
  }


  public void checkVisibility(){
    checkToolbarVisibility();
    checkAnswerVisibility();
  }

  public boolean isCheatAnswerVisible() {
        return cheatState.answerVisible;
    }

  public boolean isCheatToolbarVisible() {
        return cheatState.toolbarVisible;
    }

  public void setCheatAnswerVisibility(boolean visible) {
        cheatState.answerVisible = visible;
    }

  public void checkCheatAnswerVisibility(){
        if(!isCheatAnswerVisible()) {
            cheatView.hideAnswer();
        } else {
            cheatView.showAnswer();
        }
    }

  private void checkCheatToolbarVisibility(){
        if (!isCheatToolbarVisible()) {
            cheatView.hideToolbar();
        }
    }


  public void checkCheatVisibility(){
        checkCheatToolbarVisibility();
        checkCheatAnswerVisibility();
    }


  private class QuestionState {
    boolean toolbarVisible;
    boolean answerVisible;
    boolean answerBtnClicked;


  }

  private class CheatState {
    boolean toolbarVisible;
    boolean answerVisible;
    boolean answerBtnClicked;
    boolean confirmBtnClicked;
  }

  public void goToCheatScreen(QuizView activity){
    cheatState = new CheatState();
    cheatState.toolbarVisible = false;
    cheatState.answerVisible = false;
    cheatState.answerBtnClicked = questionState.answerBtnClicked;

    activity.startActivity(new Intent(activity, CheatView.class));
  }

  public void backToQuestionScreen(CheatView activity){
      activity.finish();
  }

}
