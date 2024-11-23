package menu.view;

import menu.model.Coach;
import menu.model.CoachManager;
import menu.model.MenuResult;

public class OutputView {
	private final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
	private final String RESULT_MESSAGE = "메뉴 추천 결과입니다.";
	private final String END_MESSAGE = "추천을 완료했습니다.";
	private final String ERROR_FORMAT = "[ERROR] %s\n";
	private final String DAY_OUTPUT_FORMAT = "[ 구분 | %s ]\n";
	private final String CATEGORY_OUTPUT_FORMAT = "[ 카테고리 | %s ]\n";
	private final String COACH_OUTPUT_FORMAT = "[ %s | %s ]\n";

	public void printStartMessage() {
		System.out.println(START_MESSAGE);
		System.out.println();
	}

	public void printEndMessage() {
		System.out.println();
		System.out.println(END_MESSAGE);
	}

	public void printErrorMessage(IllegalArgumentException e) {
		System.out.printf(ERROR_FORMAT, e.getMessage());
	}

	public void printResultMessage() {
		System.out.println(RESULT_MESSAGE);
	}

	public void printCategory(MenuResult menuResult) {
		System.out.printf(DAY_OUTPUT_FORMAT, String.join("|", menuResult.getFiveDays()));
		System.out.printf(CATEGORY_OUTPUT_FORMAT, String.join("|", menuResult.getSelectedCategoryNames()));
	}

	public void printCoaches(CoachManager coachManager) {
		for(Coach coach : coachManager.getCoaches()) {
			System.out.printf(COACH_OUTPUT_FORMAT, coach.getName(), String.join("|", coach.getEatingMenu()));
		}
	}
}
