package es.ulpgc.eite.android.quiz;

/**
 * Created by ivang_000 on 13/02/2017.
 */

public class CheatPresenter {

    private QuizApp mediator;

    public CheatPresenter(QuizApp mediator){
        this.mediator = mediator;
    }

    public void onFalseBtnClicked() {
        mediator.setCheatAnswerVisibility(false);
        mediator.backToQuestionScreen(mediator.getCheatView());
    }

    public void onTrueBtnClicked() {
        mediator.getCheatView().setAnswer(mediator.getQuizModel().getCheatAnswer());
        mediator.getCheatView().setAnswer(mediator.getCheatView().getAnswer());
        mediator.setCheatAnswerVisibility(true);
        mediator.setConfirmBtnClicked(true);
        mediator.checkCheatVisibility();
    }
}
