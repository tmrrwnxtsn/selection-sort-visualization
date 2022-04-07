## Selection sort visualization app

This repository contains the source code of a Java application that step-by-step demonstrates the operation
of the selection sorting algorithm. The application is written using the JavaFX.

### Screenshots

<div>
<img src="https://user-images.githubusercontent.com/49313203/119182647-3d30f480-ba84-11eb-93bd-105f01d2187d.png" width="400" alt="Вид приложения после запуска">
<img src="https://user-images.githubusercontent.com/49313203/119185210-8f274980-ba87-11eb-8a9e-87c1798edf11.png" width="400" alt="Вид приложения во время создания массива">
</div>

### Installation and launch

To launch the application, you need:

1) Install JRE 8
2) Go to the release page of the [first version of the application](https://github.com/tmrrwnxtsn/term-paper-in-algorithms/releases/tag/v1.0)
3) Download the archive `Visualization_of_the_selection_sorting_algorithm.zip` from the release page and unpack it
4) Find the file `run.bat` in the directory where the archive was unpacked and open the file

### Description of the source code

| File | Description |
|----|----|
| animations/AppearanceOf.java | A class that animates the appearance (or disappearance) of GUI elements |
| animations/HighlightCell.java | A class that highlights cells with array elements |
| application/Main.java | The main class through which the application is launched |
| application/MyArray.java | The class of the array that is being sorted |
| application/State.java | A class that tracks at what stage the user is working with the application |
| fxml/descriptionScene.fxml | The file in which all elements of the initial scene are defined |
| fxml/sortScene.fxml | A file that defines all the elements of the scene with sorting |
| images | Folder with images used in the application |
| controllers/DescriptionSceneController.java | Event handler class for GUI elements located in the descriptionScene.fxml file |
| controllers/SortSceneController.java | Event handler class for GUI elements located in the sortScene.fxml file |
| myexceptions/GoingOutOfNumericRangeException.java | A class of exception that occurs when a user enters data that is out of the acceptable range |
