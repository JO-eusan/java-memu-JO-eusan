package menu.model.category;

public class Chinese extends Category {
	private final String MENUS = "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채";

	public Chinese() {
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
