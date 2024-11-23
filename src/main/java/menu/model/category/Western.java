package menu.model.category;

public class Western extends Category {
	private final String MENUS = "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니";

	public Western() {
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
		return "양식";
	}
}
