package menu.model;

import java.util.ArrayList;
import java.util.List;

import menu.model.category.Asian;
import menu.model.category.Category;
import menu.model.category.Chinese;
import menu.model.category.Japanese;
import menu.model.category.Korean;
import menu.model.category.Western;

public class MenuBoard {
	private List<Category> board;

	public MenuBoard() {
		board = new ArrayList<>();
		board.add(new Japanese());
		board.add(new Korean());
		board.add(new Chinese());
		board.add(new Asian());
		board.add(new Western());
	}

	public List<Category> getBoard() {
		return board;
	}

}
