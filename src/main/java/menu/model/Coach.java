package menu.model;

import java.util.ArrayList;
import java.util.List;

import menu.model.category.Category;

public class Coach {
	private final String SIZE_ERROR_MESSAGE = "못 먹는 메뉴는 0-2개 이어야 합니다.";
	private final String NOT_INCLUDE_BOARD_ERROR_MESSAGE = "없는 메뉴입니다.";

	private String name;
	private List<String> eatingMenu;
	private List<String> unlikeMenu;

	public Coach(String name) {
		this.name = name;
		eatingMenu = new ArrayList<>();
		unlikeMenu = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public List<String> getEatingMenu() {
		return eatingMenu;
	}

	public void setEatingMenu(Category category, MenuBoard menuBoard) {
		String pick = menuBoard.pickMenu(category);
		while(!eatingMenu.contains(pick)) {
			pick = menuBoard.pickMenu(category);
		}
		eatingMenu.add(pick);
	}

	public void setUnlikeMenu(String input, MenuBoard menuBoard) {
		String[] menus = input.split(",");
		validateNotLikeMenuSize(menus);

		for(String menu : menus) {
			if(!validateIncludeMenu(menuBoard.getBoard(), menu)) {
				throw new IllegalArgumentException(NOT_INCLUDE_BOARD_ERROR_MESSAGE);
			}
		}

		for(String menu : menus) {
			unlikeMenu.add(menu);
		}
	}

	private void validateNotLikeMenuSize(String[] menus) {
		if(menus.length < 0 || menus.length > 2) {
			throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
		}
	}

	private boolean validateIncludeMenu(List<Category> board, String menu) {
		if(menu.length() == 0) {
			return true;
		}

		for(Category category : board) {
			List<String> real_menu = category.getMenus();
			if(real_menu.contains(menu)) {
				return true;
			}
		}
		return false;
	}
}
