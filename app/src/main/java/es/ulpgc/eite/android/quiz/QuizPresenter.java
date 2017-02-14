package es.ulpgc.eite.android.quiz;

/**
 * Created by ivang_000 on 02/02/2017.
 */

public class QuizPresenter {
    private QuizModel quizModel;
    private QuizView quizView;
    private QuizApp mediator;

    public QuizPresenter(QuizApp mediator){
        this.mediator = mediator;
        this.quizModel = mediator.getQuizModel();
        this.quizView = mediator.getQuizView();
    }

    public void onFalseBtnClicked() {
        this.quizModel.onFalseBtnClicked();
        this.quizView.setAnswer(getCurrentAnswer());
        this.mediator.setAnswerVisibility(true);
        this.mediator.setAnswerBtnClicked(true);
        this.mediator.checkAnswerVisibility();
    }

    public void onNextBtnClicked(){
        this.quizView.hideAnswer();
        mediator.setAnswerVisibility(false);
        mediator.setAnswerBtnClicked(false);
        this.quizView.setQuestion(this.quizModel.getNextQuestion());
    }

    public void onTrueBtnClicked() {
        this.quizModel.onTrueBtnClicked();
        this.quizView.setAnswer(getCurrentAnswer());
        this.mediator.setAnswerVisibility(true);
        this.mediator.setAnswerBtnClicked(true);
        this.mediator.checkAnswerVisibility();

    }

    public void onCheatBtnClicked(){
        mediator.goToCheatScreen(quizView);
    }

    public String getCurrentAnswer() {
        return this.quizModel.getCurrentAnswer();
    }

    public String getCurrentQuestion() {
        return this.quizModel.getCurrentQuestion();
    }



}
