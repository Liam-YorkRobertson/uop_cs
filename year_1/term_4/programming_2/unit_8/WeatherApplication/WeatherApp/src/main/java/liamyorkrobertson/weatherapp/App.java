package liamyorkrobertson.weatherapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main application class for the Weather Application.
 * Launches the JavaFX application and sets up the primary stage.
 * 
 * @author Liam-York Robertson
 */
public class App extends Application {

    private static Scene scene;

    /**
     * Starts the JavaFX application.
     * Sets up the primary stage with the initial scene and displays it.
     * 
     * @param stage the primary stage for this application
     * @throws IOException if an error occurs while loading the FXML file
     */
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("/liamyorkrobertson/weatherapp/WeatherApp.fxml"), 640, 480);
        stage.setScene(scene);
        stage.setTitle("Weather Application");
        stage.setWidth(1315);
        stage.setHeight(855);
        stage.show();
    }

    /**
     * Changes the root of the current scene to the specified FXML file.
     * 
     * @param fxml the path to the FXML file
     * @throws IOException if an error occurs while loading the FXML file
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * Loads an FXML file and returns its root node.
     * 
     * @param fxml the path to the FXML file
     * @return the root node of the loaded FXML file
     * @throws IOException if an error occurs while loading the FXML file
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        return fxmlLoader.load();
    }

    /**
     * Main method that launches the application.
     * 
     * @param args command-line arguments (not used in this application)
     */
    public static void main(String[] args) {
        launch();
    }
}