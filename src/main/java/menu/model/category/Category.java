package menu.model.category;

import java.util.ArrayList;
import java.util.List;

public abstract class Category {
	protected List<String> menus;

	public Category() {
		menus = new ArrayList<>();
	}

	public List<String> getMenus() {
		return menus;
	}

	protected abstract void setMenus();
}
