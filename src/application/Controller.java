package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import myanimations.HighlightCell;
import myexceptions.GoingOutOfNumericRangeException;
import myanimations.AppearanceOf;

public class Controller {
	
	public static MyArray theArray = new MyArray();
	public static State currentState = new State();
    
    @FXML
    private VBox addVBox;
    
    @FXML
    private VBox delVBox;
    
    @FXML
    private VBox changeVBox;
    
    @FXML
    private VBox fillArrayVBox;
    
    @FXML
    private void addButtonClicked(ActionEvent event) {
    	
    	isNodeVisible(addVBox, true);
    	isNodeVisible(delVBox, false);
    	isNodeVisible(changeVBox, false);
    	isNodeVisible(fillArrayVBox, false);
    }
    
    @FXML
    private void delButtonClicked(ActionEvent event) {
    	
    	isNodeVisible(delVBox, true);
    	isNodeVisible(addVBox, false);
    	isNodeVisible(changeVBox, false);
    	isNodeVisible(fillArrayVBox, false);
    }
    
    @FXML
    private void changeButtonClicked(ActionEvent event) {
    	
    	isNodeVisible(changeVBox, true);
    	isNodeVisible(addVBox, false);
    	isNodeVisible(delVBox, false);
    	isNodeVisible(fillArrayVBox, false);
    }
    
    @FXML
    private TextField inputFillArrayField;
    
    @FXML
    private Button confirmFillArrayButton;
    
    @FXML
    private void confirmFillArrayButtonClicked(ActionEvent event) {
    	
    	try {
			int numberRandomElementsToAdd = Integer.parseInt(inputFillArrayField.getText());
			
			if (theArray.size() + numberRandomElementsToAdd > 10)
				numberRandomElementsToAdd = 10 - theArray.size();
			
			for (int i = 0; i < numberRandomElementsToAdd; i++) {
				theArray.add(-1000 + (int) (Math.random() * 2000));
				highlightCell(theArray.size() - 1, 0, 255, 127);
			}
		} 
		catch (NumberFormatException ex) {
			inputFillArrayField.setText("Ошибка ввода!");
			return;
		}
    	
		canUseSomeButtons();
    	printArrayElements();
    }

    @FXML
    private Button fillArrayButton;
    
    @FXML
    private void fillArrayButtonClicked(ActionEvent event) {
    	
    	isNodeVisible(fillArrayVBox, true);
    	isNodeVisible(delVBox, false);
    	isNodeVisible(changeVBox, false);
    	isNodeVisible(addVBox, false);
    }

    @FXML
    private Button clearArrayButton;
    
    @FXML
    private void clearArrayButtonClicked(ActionEvent event) {
    	
    	for (int i = theArray.size() - 1; i >= 0; i--) {
			theArray.deleteByIndex(i);
			highlightCell(i, 255, 45, 0);
		}
    	
		canUseSomeButtons();
		isNodeVisible(delVBox, false);
    	isNodeVisible(changeVBox, false);
    	printArrayElements();
    }

    @FXML
    private Button sortArrayButton;
    
    @FXML
    private GridPane mainMenuButtons;
    
    @FXML
    private HBox sortingControlButtonsHBox;

    @FXML
    private Button nextSortingActionButton;
    
    @FXML
    void nextSortingActionButtonClicked(ActionEvent event) {
    	
    	currentState.doDependingOnCurrentStateNumber();
    	
		if (theArray.getI() < theArray.size()) {
			
			if (theArray.getJ() < theArray.size())
				currentState.setState(2);
			else
				currentState.setState(3);
		}
		else {
			currentState.setState(4);
			isNodeVisible(mainMenuButtons, true);
			sortArrayButton.setDisable(true);
			isNodeVisible(sortingControlButtonsHBox, false);
		}
		
		printArrayElements();
		lblStateDescription.setText(currentState.setCurrentStateDescription());
    }

    @FXML
    private Button exitSortingButton;
    
    @FXML
    void exitSortingButtonClicked(ActionEvent event) {
    	
    	theArray.selectionSort();
		currentState.setState(4);
		
		isNodeVisible(mainMenuButtons, true);
		isNodeVisible(sortingControlButtonsHBox, false);
		sortArrayButton.setDisable(true);
		
		lblStateDescription.setText(currentState.setCurrentStateDescription());
		
		printArrayElements();
    }
    
    @FXML
    private void sortArrayButtonClicked(ActionEvent event) {
    	
    	currentState.setState(1);
		
		lblStateDescription.setText(currentState.setCurrentStateDescription());
		
		isNodeVisible(sortingControlButtonsHBox, true);
		isNodeVisible(mainMenuButtons, false);
		sortArrayButton.setDisable(true);
    	
    	printArrayElements();
    }
    
    @FXML
    private TextField inputAddingField;

    @FXML
    private Button confirmAddButton;
    
    @FXML
    private void confirmAddButtonClicked(ActionEvent event) {
    	
    	try {
			int value = Integer.parseInt(inputAddingField.getText());
			if (Math.abs(value) >= 10000)
				throw new GoingOutOfNumericRangeException("Число выходит за рамки допустимого диапазона:" + value);
			else {
				theArray.add(value);
				highlightCell(theArray.size() - 1, 0, 255, 127);
			}
		} 
		catch (NumberFormatException ex) {
			inputAddingField.setText("Ошибка ввода!");
			return;
		}
    	catch (GoingOutOfNumericRangeException ex) {
    		inputAddingField.setText("Выход за границы числового диапазона!");
			return;
    	}
    	
    	canUseSomeButtons();
    	printArrayElements();
    }
    
    private void highlightCell(int index, int rectColorR, int rectColorG, int rectColorB) {
    	
    	switch (index) {
    	case 0:
    		highlightСellAnimation(rectFirst, rectColorR, rectColorG, rectColorB);
    		break;
    	case 1:
    		highlightСellAnimation(rectSecond, rectColorR, rectColorG, rectColorB);
    		break;
    	case 2:
    		highlightСellAnimation(rectThird, rectColorR, rectColorG, rectColorB);
    		break;
    	case 3:
    		highlightСellAnimation(rectFourth, rectColorR, rectColorG, rectColorB);
    		break;
    	case 4:
    		highlightСellAnimation(rectFifth, rectColorR, rectColorG, rectColorB);
    		break;
    	case 5:
    		highlightСellAnimation(rectSixth, rectColorR, rectColorG, rectColorB);
    		break;
    	case 6:
    		highlightСellAnimation(rectSeventh, rectColorR, rectColorG, rectColorB);
    		break;
    	case 7:
    		highlightСellAnimation(rectEighth, rectColorR, rectColorG, rectColorB);
    		break;
    	case 8:
    		highlightСellAnimation(rectNineth, rectColorR, rectColorG, rectColorB);
    		break;
    	case 9:
    		highlightСellAnimation(rectTenth, rectColorR, rectColorG, rectColorB);
    		break;
		}
    }
    
    private void highlightСellAnimation(Rectangle rect, int rectColorR, int rectColorG, int rectColorB) {
    	
    	HighlightCell theAnimation = new HighlightCell(rect, rectColorR, rectColorG, rectColorB);
        theAnimation.start();
    }

    @FXML
    private TextField inputDeletingField;

    @FXML
    private Button confirmDelButton;
    
    @FXML
    private void confirmDelButtonClicked(ActionEvent event) {
    	
    	try {
			String strIndex = inputDeletingField.getText();
			int deletedElementIndex = Integer.parseInt(strIndex);
			theArray.deleteByIndex(deletedElementIndex);
			highlightCell(deletedElementIndex, 255, 45, 0);
		} 
		catch (NumberFormatException ex) {
			inputDeletingField.setText("Ошибка ввода!");
			return;
		}
		catch (IndexOutOfBoundsException ex) {
			inputDeletingField.setText("Недопустимый индекс!");
			return;
		}
    	
    	canUseSomeButtons();
    	printArrayElements();
    }

    @FXML
    private TextField inputChangingIndexField;

    @FXML
    private TextField inputChangingNewElField;

    @FXML
    private Button confirmChangeButton;
    
    @FXML
    private void confirmChangeButtonClicked(ActionEvent event) {
    	
    	try {
			String strIndex = inputChangingIndexField.getText();
			String strValue = inputChangingNewElField.getText();
			theArray.changeByIndex(Integer.parseInt(strIndex), Integer.parseInt(strValue));
			highlightCell(Integer.parseInt(strIndex), 254, 254, 34);
		} 
		catch (IndexOutOfBoundsException ex) {
			inputChangingIndexField.setText("Недопустимый индекс!");
			return;
		}
		catch (NumberFormatException ex) {
			inputChangingNewElField.setText("Ошибка ввода!");
			return;
		}
    	
		canUseSomeButtons();
    	printArrayElements();
    }

    @FXML
    private Rectangle rectFirst;

    @FXML
    private Label lblFirst;

    @FXML
    private Rectangle rectSecond;

    @FXML
    private Label lblSecond;

    @FXML
    private Rectangle rectThird;

    @FXML
    private Label lblThird;

    @FXML
    private Rectangle rectFourth;

    @FXML
    private Label lblFourth;

    @FXML
    private Rectangle rectFifth;

    @FXML
    private Label lblFifth;

    @FXML
    private Rectangle rectSixth;

    @FXML
    private Label lblSixth;

    @FXML
    private Rectangle rectSeventh;

    @FXML
    private Label lblSeventh;

    @FXML
    private Rectangle rectEighth;

    @FXML
    private Label lblEighth;

    @FXML
    private Rectangle rectNineth;

    @FXML
    private Label lblNineth;

    @FXML
    private Rectangle rectTenth;

    @FXML
    private Label lblTenth;
    
    @FXML
    private Label lblStateDescription;
    
    @FXML
    private Button addButton;
    
    @FXML
    private Button delButton;
    
    @FXML
    private Button changeButton;
    
    private void canUseSomeButtons() {
    	
		if (theArray.size() > 0) {
			delButton.setDisable(false);
			changeButton.setDisable(false);
			clearArrayButton.setDisable(false);
		}
		else {
			delButton.setDisable(true);
			changeButton.setDisable(true);
	    	isNodeVisible(delVBox, false);
			clearArrayButton.setDisable(true);
		}
		
		if (theArray.size() == 10) {
			addButton.setDisable(true);
			fillArrayButton.setDisable(true);
			isNodeVisible(addVBox, false);
			isNodeVisible(fillArrayVBox, false);
		}
		else {
			addButton.setDisable(false);
			fillArrayButton.setDisable(false);
		}
		
		if (theArray.size() > 1) {
			sortArrayButton.setDisable(false);
			currentState.setState(0);
		} 
		else {
			sortArrayButton.setDisable(true);
			currentState.setState(-1);
		}
		
		lblStateDescription.setText(currentState.setCurrentStateDescription());
	}
    
    private void printArrayElements() {
    	
    	for (int i = 0; i < 10; i++) {
    		if (i < theArray.size())
    			fillCell(i, theArray.getByIndex(i));
    		else
    			clearCell(i);
    	}
    }
    
    private void fillCell(int index, int arrayElement) {
    	
    	switch (index) {
    	case 0:
    		lblFirst.setText(Integer.toString(arrayElement));
    		break;
    	case 1:
    		lblSecond.setText(Integer.toString(arrayElement));
    		break;
    	case 2:
    		lblThird.setText(Integer.toString(arrayElement));
    		break;
    	case 3:
    		lblFourth.setText(Integer.toString(arrayElement));
    		break;
    	case 4:
    		lblFifth.setText(Integer.toString(arrayElement));
    		break;
    	case 5:
    		lblSixth.setText(Integer.toString(arrayElement));
    		break;
    	case 6:
    		lblSeventh.setText(Integer.toString(arrayElement));
    		break;
    	case 7:
    		lblEighth.setText(Integer.toString(arrayElement));
    		break;
    	case 8:
    		lblNineth.setText(Integer.toString(arrayElement));
    		break;
    	case 9:
    		lblTenth.setText(Integer.toString(arrayElement));
    		break;
		}
    }
    
    private void clearCell(int index) {
    	
    	switch (index) {
    	case 0:
    		lblFirst.setText("");
    		break;
    	case 1:
    		lblSecond.setText("");
    		break;
    	case 2:
    		lblThird.setText("");
    		break;
    	case 3:
    		lblFourth.setText("");
    		break;
    	case 4:
    		lblFifth.setText("");
    		break;
    	case 5:
    		lblSixth.setText("");
    		break;
    	case 6:
    		lblSeventh.setText("");
    		break;
    	case 7:
    		lblEighth.setText("");
    		break;
    	case 8:
    		lblNineth.setText("");
    		break;
    	case 9:
    		lblTenth.setText("");
    		break;
		}
    }
    
    private void isNodeVisible(Node theNode, boolean choice) {
    	
    	AppearanceOf theAppearanceOfNodeAnimation = new AppearanceOf(theNode, choice);
    	theAppearanceOfNodeAnimation.start();
    }
}
