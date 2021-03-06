package application;

import java.io.InputStream;
import java.util.Objects;

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
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/descriptionScene.fxml")));

            InputStream iconStream = getClass().getResourceAsStream("/images/sort-icon.png");
            assert iconStream != null;
            Image image = new Image(iconStream);
            primaryStage.getIcons().add(image);

            primaryStage.setTitle("Курсовая работа по дисциплине \u00ABАлгоритмы и структуры данных\u00BB");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
