package menu.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import menu.model.category.Asian;
import menu.model.category.Category;
import menu.model.category.Chinese;
import menu.model.category.Japanese;
import menu.model.category.Korean;
import menu.model.category.Western;

public class MenuBoard {
	private List<Category> board;
	private HashMap<Category, Integer> categoryCounter;

	public MenuBoard() {
		board = new ArrayList<>();
		board.add(new Japanese());
		board.add(new Korean());
		board.add(new Chinese());
		board.add(new Asian());
		board.add(new Western());

		categoryCounter = new HashMap<>();
		setCategoryCounter();
	}

	public List<Category> getBoard() {
		return board;
	}

	public Category pickCategory() {
		Category pick = board.get(Randoms.pickNumberInRange(1,5) - 1);
		while (categoryCounter.get(pick) >= 2) {
			pick = board.get(Randoms.pickNumberInRange(1,5) - 1);
		}

		return pick;
	}

	public String pickMenu(Category category) {
		List<String> menus = new ArrayList<>(category.getMenus());
		return Randoms.shuffle(menus).get(0);
	}

	private void setCategoryCounter() {
		for(Category category : board) {
			categoryCounter.put(category, 0);
		}
	}
}
