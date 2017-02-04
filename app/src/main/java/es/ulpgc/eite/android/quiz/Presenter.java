package es.ulpgc.eite.android.quiz;

/**
 * Created by ivang_000 on 02/02/2017.
 */

public class Presenter {
    private Model model;
    private QuizView view;

    public Presenter(QuizView view){
        this.model = new Model();
        this.view = view;
    }

    /*public void onCheatBtnClicked() {
        goToCheatScreen();
    }
*/
    public void onFalseBtnClicked() {
        this.model.onFalseBtnClicked();
        this.view.setAnswer(model.getCurrentAnswer());
        this.view.setAnswerVisibility(true);
        this.view.isAnswerVisible();
        this.view.checkAnswerVisibility();
    }

    public void onNextBtnClicked(){
        this.view.setQuestion(this.model.getNextQuestion());
        this.view.checkAnswerVisibility();
    }

    public void onTrueBtnClicked() {
        this.model.onTrueBtnClicked();
        this.view.setAnswer(model.getCurrentAnswer());
        this.view.setAnswerVisibility(true);
        this.view.isAnswerVisible();
        this.view.checkAnswerVisibility();
    }

    public String getCurrentAnswer() {
        return this.model.getCurrentAnswer();
    }

    public String getCurrentQuestion() {
        return this.model.getCurrentQuestion();
    }


   /* public String getNextQuestion() {
        quizIndex++;
        return getCurrentQuestion();
    }
*/
}
