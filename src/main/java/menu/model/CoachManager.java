package menu.model;

import java.util.ArrayList;
import java.util.List;

public class CoachManager {
	private final String NOT_NAME_FORMAT_ERROR_MESSAGE = "이름의 길이가 안맞습니다.";
	private final String DUPLICATE_NAME_ERROR_MESSAGE = "같은 이름의 코치가 존재합니다.";
	private final String NOT_SIZE_ERROR_MESSAGE = "가능한 코치의 인원이 아닙니다.";

	List<Coach> coaches;

	public CoachManager(String input) {
		validateNames(input);
		validateSize(input);

		coaches = new ArrayList<>();
		createCoaches(input);
	}

	public List<Coach> getCoaches() {
		return coaches;
	}

	private void createCoaches(String input) {
		String[] names = input.split(",");

		for(String name : names) {
			coaches.add(new Coach(name));
		}
	}

	private void validateNames(String input) {
		List<String> correctNames = new ArrayList<>();
		String[] names = input.split(",");

		for(String name : names) {
			if(name.length() < 2 || name.length() > 4) {
				throw new IllegalArgumentException(NOT_NAME_FORMAT_ERROR_MESSAGE);
			}
			if(correctNames.contains(name)) {
				throw new IllegalArgumentException(DUPLICATE_NAME_ERROR_MESSAGE);
			}
			correctNames.add(name);
		}
	}

	private void validateSize(String input) {
		String[] names = input.split(",");
		if(names.length < 2 || names.length > 5) {
			throw new IllegalArgumentException(NOT_SIZE_ERROR_MESSAGE);
		}
	}
}
