package menu.model.category;

import java.util.ArrayList;
import java.util.List;

public abstract class Category {
	protected List<String> menus;

	public Category() {
		menus = new ArrayList<>();
	}

	protected abstract void setMenus();
}
