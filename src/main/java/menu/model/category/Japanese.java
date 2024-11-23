package menu.model.category;

public class Japanese extends Category {
	private final String MENUS = "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼";

	public Japanese() {
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
