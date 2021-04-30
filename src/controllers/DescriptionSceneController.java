package controllers;

import java.awt.Desktop;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.stage.Stage;

public class DescriptionSceneController {

    @FXML
    private Button goToSortSceneButton;

    @FXML
    void goToSortSceneButtonClicked(ActionEvent event) {
    	
    	goToSortSceneButton.getScene().getWindow().hide();
    	
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/fxml/sortScene.fxml"));
    	
    	try {
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	Parent root = loader.getRoot();
    	Stage sortStage = new Stage();
    	
    	InputStream iconStream = getClass().getResourceAsStream("/images/sort-icon.png");
		Image image = new Image(iconStream);
		sortStage.getIcons().add(image);
    	
    	sortStage.setTitle("Курсовая работа");
    	sortStage.setScene(new Scene(root));
    	sortStage.show();
    }
    
    @FXML
    private Hyperlink myGithubHyperlink;

    @FXML
    void myGithubHyperlinkClicked(ActionEvent event) {
    	
    	try {
            Desktop d = Desktop.getDesktop();
            d.browse(new URI(myGithubHyperlink.getText()));
        } 
    	catch (IOException ioe) {
    		ioe.printStackTrace();
    	}
    	catch (URISyntaxException use) {
    		use.printStackTrace();
    	}
    }
    
    @FXML
    void initialize() {
    	
		Image image = new Image("/images/github-icon.png", 25, 25, false, false);
		ImageView imageView = new ImageView(image);
		myGithubHyperlink.setGraphic(imageView);
		myGithubHyperlink.setBorder(Border.EMPTY);
    }
}
