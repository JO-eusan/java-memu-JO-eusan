package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private final String ASK_NAMES_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
	private final String ASK_DO_NOT_EAT_MENU_MESSAGE = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";

	public String inputNames() {
		System.out.println(ASK_NAMES_MESSAGE);
		return Console.readLine();
	}

	public String inputNotEatMenus(String name) {
		System.out.printf(ASK_DO_NOT_EAT_MENU_MESSAGE + "\n", name);
		return Console.readLine();
	}
}
