package menu.controller;

import menu.model.Coach;
import menu.model.CoachManager;
import menu.model.MenuBoard;
import menu.model.MenuResult;
import menu.model.category.Category;
import menu.view.InputView;
import menu.view.OutputView;

public class SystemController {
	private InputView inputView;
	private OutputView outputView;
	private MenuBoard menuBoard;
	private MenuResult menuResult;
	private CoachManager coachManager;

	public SystemController() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
		this.menuBoard = new MenuBoard();
		this.menuResult = new MenuResult(menuBoard);
	}

	public void start() {
		outputView.printStartMessage();
		setCoachManager();
		setCoachNotLikeMenu();
		recommendMenu();
		printResult();
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
		System.out.println();
	}

	private void setCoachNotLikeMenu() {
		for(Coach coach : coachManager.getCoaches()) {
			inputIncludeMenu(coach);
			System.out.println();
		}
	}

	private void inputIncludeMenu(Coach coach) {
		try {
			String input = inputView.inputNotEatMenus(coach.getName());
			coach.setUnlikeMenu(input, menuBoard);
		} catch (IllegalArgumentException e) {
			outputView.printErrorMessage(e);
			inputIncludeMenu(coach);
		}
	}

	private void recommendMenu() {
		for(int i=0; i<5; i++) {
			Category category = menuResult.getSelectedCategory().get(i);
			selectMenus(category);
		}
	}

	private void selectMenus(Category category) {
		for(Coach coach : coachManager.getCoaches()) {
			coach.setEatingMenu(category, menuBoard);
		}
	}

	private void printResult() {
		outputView.printResultMessage();
		outputView.printCategory(menuResult);
		outputView.printCoaches(coachManager);
	}
}
