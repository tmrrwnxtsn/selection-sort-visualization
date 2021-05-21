## Визуализация работы алгоритма сортировки выбором

Java-приложение для наглядного представления работы алгоритма сортировки выбором.

### Скриншоты приложения

Как выглядит приложение после того, как оно было запущено:

![descriptionScene](https://user-images.githubusercontent.com/49313203/119182647-3d30f480-ba84-11eb-93bd-105f01d2187d.png)

Вид приложения во время создания массива, который будет сортироваться выбором:

![sortSceneBeforeSorting](https://user-images.githubusercontent.com/49313203/119183014-8e40e880-ba84-11eb-81eb-65fdd27ce044.png)

Вид приложения в течение сортировки выбором:

![sortSceneDuringSorting](https://user-images.githubusercontent.com/49313203/119183022-90a34280-ba84-11eb-813b-9ac5ff8945dc.png)

### Установка и запуск

Об установке и запуске приложения подробно написано
в [описании к релизу его первой версии](https://github.com/tmrrwnxtsn/term-paper-in-algorithms/releases/tag/v1.0).

### Описание исходного кода

| Файл | Описание |
|:----:|:----:|
| animations/AppearanceOf.java | Класс, анимирующий появление (или исчезновение) элементов GUI |
| animations/HighlightCell.java | Класс, подсвечивающий ячейки с элементами массива |
| application/Main.java | Основной класс, через который запускается приложение |
| application/MyArray.java | Класс массива, сортируемого выбором |
| application/State.java | Класс, отслеживающий, на каком этапе сортировки (или работы с приложением) находится пользователь |
| fxml/descriptionScene.fxml | Файл, в котором определены все элементы и их свойства начальной сцены |
| fxml/sortScene.fxml | Файл, в котором определены все элементы и их свойства сцены с сортировкой |
| images | Папка с изображениями, используемыми в приложении |
| controllers/DescriptionSceneController.java | Класс-обработчик событий элементов GUI, располагающихся в файле descriptionScene.fxml |
| controllers/SortSceneController.java | Класс-обработчик событий элементов GUI, располагающихся в файле sortScene.fxml |
| myexceptions/GoingOutOfNumericRangeException.java | Класс исключения, возникающего, когда пользователь вводит данные, выходящие за рамки допустимого диапазона |
