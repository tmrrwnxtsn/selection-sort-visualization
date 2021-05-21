## Визуализация работы алгоритма сортировки выбором

В данном репозитории представлен исходный код Java-приложения для наглядного представления работы алгоритма сортировки
выбором.

### Скриншоты

<img src="https://user-images.githubusercontent.com/49313203/119182647-3d30f480-ba84-11eb-93bd-105f01d2187d.png" width="500" alt="Вид приложения после запуска">
<img src="https://user-images.githubusercontent.com/49313203/119185210-8f274980-ba87-11eb-8a9e-87c1798edf11.png" width="500" alt="Вид приложения во время создания массива">
<img src="https://user-images.githubusercontent.com/49313203/119183022-90a34280-ba84-11eb-813b-9ac5ff8945dc.png" width="500" alt="Вид приложения в процессе работы алгоритма сортировки выбором">
<img src="https://user-images.githubusercontent.com/49313203/119185027-3bb4fb80-ba87-11eb-8d9f-ee932343046e.png" width="500" alt="Вид приложения в процессе работы алгоритма сортировки выбором">


### Установка и запуск

Об установке и запуске приложения подробно написано
в [описании к релизу его первой версии](https://github.com/tmrrwnxtsn/term-paper-in-algorithms/releases/tag/v1.0).

### Описание исходного кода

| Файл | Описание |
|----|----|
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
