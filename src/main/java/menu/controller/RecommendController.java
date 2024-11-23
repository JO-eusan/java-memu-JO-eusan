package menu.controller;

import menu.model.Coach;
import menu.model.CoachManager;
import menu.model.MenuBoard;
import menu.view.InputView;
import menu.view.OutputView;

public class RecommendController {
	InputView inputView;
	OutputView outputView;
	MenuBoard menuBoard;
	CoachManager coachManager;

	public RecommendController() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
		this.menuBoard = new MenuBoard();
	}

	public void startRecommend() {
		outputView.printStartMessage();
		setCoachManager();
		setCoachNotLikeMenu();

		outputView.printEndMessage();
	}

	private void setCoachManager() {
		try {
			String names = inputView.inputNames();
			this.coachManager = new CoachManager(names);
		} catch (IllegalArgumentException e) {
			outputView.printErrorMessage(e);
			setCoachManager();
		}
	}

	private void setCoachNotLikeMenu() {
		for(Coach coach : coachManager.getCoaches()) {
			inputIncludeMenu(coach.getName(), coach);
		}
	}

	private void inputIncludeMenu(String name, Coach coach) {
		try {
			String input = inputView.inputNotEatMenus(name);
			coach.setNotMenu(input, menuBoard);
		} catch (IllegalArgumentException e) {
			outputView.printErrorMessage(e);
			inputIncludeMenu(name, coach);
		}
	}

}
