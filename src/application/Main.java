package application;
	
import java.io.InputStream;
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
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/descriptionScene.fxml"));

			InputStream iconStream = getClass().getResourceAsStream("/images/sort-icon.png");
			Image image = new Image(iconStream);
			primaryStage.getIcons().add(image);
			
			primaryStage.setTitle("Курсовая работа");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {launch(args);}
}
