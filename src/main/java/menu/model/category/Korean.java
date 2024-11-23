package menu.model.category;

public class Korean extends Category {
	private final String MENUS = "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음";

	public Korean() {
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
}
