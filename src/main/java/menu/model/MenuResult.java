package menu.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import menu.model.category.Category;

public class MenuResult {
	private List<String> fiveDays;
	private List<Category> selectedCategory;

	public MenuResult(MenuBoard menuBoard) {
		fiveDays = new ArrayList<>(Arrays.asList("월요일", "화요일", "수요일", "목요일", "금요일"));
		selectedCategory = new ArrayList<>();
		setSelectedCategory(menuBoard);
	}

	public List<Category> getSelectedCategory() {
		return selectedCategory;
	}

	private void setSelectedCategory(MenuBoard menuBoard) {
		for(int i=0; i< fiveDays.size(); i++) {
			Category pick = menuBoard.pickCategory();
			selectedCategory.add(pick);
		}
	}
}
