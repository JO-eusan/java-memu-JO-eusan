package menu.model.category;

public class Asian extends Category {
	private final String MENUS = "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜";

	public Asian() {
		super();
		setMenus();
	}

	@Override
	protected void setMenus() {
		String[] tmp = MENUS.split(",");
		for(String menu : tmp) {
			menus.add(menu.trim());
		}
	}

	@Override
	public String toString() {
		return "아시안";
	}
}
