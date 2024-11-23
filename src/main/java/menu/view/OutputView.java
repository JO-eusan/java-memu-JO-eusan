package menu.view;

public class OutputView {
	private final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
	private final String END_MESSAGE = "추천을 완료했습니다.";
	private final String ERROR_FORMAT = "[ERROR] %s\n";

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
}
