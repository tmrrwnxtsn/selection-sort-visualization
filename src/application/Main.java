package application;
	
import java.io.InputStream;
import java.net.URL;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			FXMLLoader loader = new FXMLLoader();
			URL xmlUrl = getClass().getResource("/fxml/mainScene.fxml");
			loader.setLocation(xmlUrl);
			Parent root = loader.load();
			
			primaryStage.setTitle("Курсовая работа");

			InputStream iconStream = getClass().getResourceAsStream("/images/sort-icon.png");
			Image image = new Image(iconStream);
			primaryStage.getIcons().add(image);
			
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {launch(args);}
}