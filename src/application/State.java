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
			currentStateDescription = "Находим минимальный элемент среди неотсортированной части массива.\n\nОбозначения цветов:\n\nНеотсортированная часть – чёрный, отсортированная – зелёный. Текущий рассматриваемый элемент – синий, а минимальный – красный.";
			break;
		case 3:
			// Пользователь прошёлся по неотсортированной части массива и нашёл в ней минимальный элемент
			currentStateDescription = "Минимальный элемент в неотсортированной части массива: " + Controller.theArray.getByIndex(Controller.theArray.getLocalMinIndex()) +".\n\nПроизводим обмен этого значения со значением первой неотсортированной позиции.\n\nДалее продолжаем работать с неотсортированной частью, исключив из неё " + Controller.theArray.getByIndex(Controller.theArray.getLocalMinIndex()) + ".";
			break;
		case 4:
			// Пользователь отсортировал массивы
			currentStateDescription = "Текущий массив отсортирован.\n\nВоспользуйся кнопками, чтобы заполнить массив, который будет сортироваться выбором.";
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
		case 3:
			Controller.theArray.swapItemsByIndices(Controller.theArray.getLocalMinIndex(), Controller.theArray.getI());
			Controller.theArray.setLocalMinIndex(Controller.theArray.getI() + 1);;
			Controller.theArray.inkI();
			Controller.theArray.setJ(Controller.theArray.getI());
			break;
		default:
			break;
		}
	}
}
