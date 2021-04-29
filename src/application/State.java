package application;

public class State {
	
	private int currentStateNumber;
	
	public State() {currentStateNumber = -1;}
	
	public void setState(int newStateNumber) {currentStateNumber = newStateNumber;}
	
	public int getState() {return currentStateNumber;}
	
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
			currentStateDescription = "Находим минимальный элемент среди неотсортированной части массива.\n\nОбозначения цветов ячеек: отсортированная часть массива – бежевый, текущий рассматриваемый элемент – синий, а минимальный элемент – красный.";
			break;
		case 3:
			// Пользователь прошёлся по неотсортированной части массива и нашёл в ней минимальный элемент
			currentStateDescription = "Минимальный элемент в неотсортированной части массива найден, и он равен: " + Controller.theArray.getByIndex(Controller.theArray.getLocalMinIndex()) + ".";
			break;
		case 4:
			// Пользователь меняет 2 элемента местами
			currentStateDescription = "Производим обмен минимального элемента (" + Controller.theArray.getByIndex(Controller.theArray.getLocalMinIndex()) + ") со значением первой неотсортированной позиции (" + Controller.theArray.getByIndex(Controller.theArray.getI()) +").";
			break;
		case 5:
			// Пользователь меняет 2 элемента местами
			currentStateDescription = "Далее продолжаем работать с неотсортированной частью, исключив из неё минимальный элемент (" + Controller.theArray.getByIndex(Controller.theArray.getI()) + ").";
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
			if (Controller.theArray.getByIndex(Controller.theArray.getJ()) < Controller.theArray.getByIndex(Controller.theArray.getLocalMinIndex()))
				Controller.theArray.setLocalMinIndex(Controller.theArray.getJ());	
			Controller.theArray.inkJ();
			break;
		case 4:
			Controller.theArray.swapItemsByIndices(Controller.theArray.getLocalMinIndex(), Controller.theArray.getI());
			break;
		case 5:
			Controller.theArray.setLocalMinIndex(Controller.theArray.getI() + 1);;
			Controller.theArray.inkI();
			Controller.theArray.setJ(Controller.theArray.getI());
			break;
		default:
			break;
		}
	}
}
