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
			inputIncludeMenu(coach.getName(), coach);
			System.out.println();
		}
	}

	private void inputIncludeMenu(String name, Coach coach) {
		try {
			String input = inputView.inputNotEatMenus(name);
			coach.setUnlikeMenu(input, menuBoard);
		} catch (IllegalArgumentException e) {
			outputView.printErrorMessage(e);
			inputIncludeMenu(name, coach);
		}
	}

	private void recommendMenu() {
		for(Coach coach : coachManager.getCoaches()) {
			selectMenus(coach);
		}
	}

	private void selectMenus(Coach coach) {
		for(Category category : menuResult.getSelectedCategory()) {
			coach.setEatingMenu(category, menuBoard);
		}
	}

	private void printResult() {
		outputView.printResultMessage();
		outputView.printCategory(menuResult);
		outputView.printCoaches(coachManager);
	}
}
