package application;

import controllers.SortSceneController;

public class State {

	private int currentStateNumber;

	public State() {
		currentStateNumber = -1;
	}

	public void setState(int newStateNumber) {
		currentStateNumber = newStateNumber;
	}

	public int getState() {
		return currentStateNumber;
	}

	public String setCurrentStateDescription() {

		String currentStateDescription = "";

		switch (currentStateNumber) {
		case 0:
			// Размер массива > 1, поэтому предлагаем его отсортировать
			currentStateDescription = "Чтобы отсортировать массив выбором, нажми на кнопку \u00ABОтсортировать текущий массив\u00BB.";
			break;
		case 1:
			// Пользователь начал сортировку, но ещё не нажимал на кнопку "Следующий шаг"
			currentStateDescription = "Сейчас мы рассмотрим пошагово, как работает сортировка выбором.\n\nЧтобы перейти к следующей итераци, нажми на кнопку \u00ABСледующий шаг\u00BB.";
			break;
		case 2:
			// Пользователь сортирует массив, нажимая на "Следующий шаг"
			currentStateDescription = "Находим минимальный элемент среди неотсортированной части массива.";
			break;
		case 3:
			// Пользователь прошёлся по неотсортированной части массива и нашёл в ней
			// минимальный элемент
			currentStateDescription = "Минимальный элемент в неотсортированной части массива найден, и он равен: "
					+ SortSceneController.theArray.getByIndex(SortSceneController.theArray.getLocalMinIndex()) + ".";
			break;
		case 4:
			// Пользователь МЕНЯЕТ местами минимум с первым элементом в неотсортированной
			// части массива
			currentStateDescription = "Производим обмен минимального элемента ("
					+ SortSceneController.theArray.getByIndex(SortSceneController.theArray.getLocalMinIndex())
					+ ") со значением первой неотсортированной позиции ("
					+ SortSceneController.theArray.getByIndex(SortSceneController.theArray.getI()) + ").";
			break;
		case 5:
			// Пользователь ПОМЕНЯЛ местами минимум с первым элементом в неотсортированной
			// части массива
			currentStateDescription = "Далее продолжаем работать с неотсортированной частью, исключив из неё минимальный элемент ("
					+ SortSceneController.theArray.getByIndex(SortSceneController.theArray.getI()) + ").";
			break;
		case 6:
			// Пользователь отсортировал массивы
			currentStateDescription = "Текущий массив отсортирован. Воспользуйся кнопками, чтобы заполнить массив, который будет сортироваться выбором.";
			break;
		default:
			// Пользователь только открыл программу, массив пуст
			currentStateDescription = "Воспользуйся кнопками ниже, чтобы создать массив, который будет сортироваться выбором.";
			break;
		}
		return currentStateDescription;
	}

	public void doDependingOnCurrentStateNumber() {

		switch (currentStateNumber) {
		case 2:
			if (SortSceneController.theArray.getByIndex(SortSceneController.theArray
					.getJ()) < SortSceneController.theArray.getByIndex(SortSceneController.theArray.getLocalMinIndex()))
				SortSceneController.theArray.setLocalMinIndex(SortSceneController.theArray.getJ());
			SortSceneController.theArray.inkJ();
			break;
		case 4:
			SortSceneController.theArray.swapItemsByIndices(SortSceneController.theArray.getLocalMinIndex(),
					SortSceneController.theArray.getI());
			break;
		case 5:
			SortSceneController.theArray.setLocalMinIndex(SortSceneController.theArray.getI() + 1);
			;
			SortSceneController.theArray.inkI();
			SortSceneController.theArray.setJ(SortSceneController.theArray.getI());
			break;
		default:
			break;
		}
	}
}
