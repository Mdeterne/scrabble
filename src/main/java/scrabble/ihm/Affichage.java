package scrabble.ihm;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Affichage extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = FXMLLoader.load(getClass().getResource("/scrabble/ihm/vue/AffichageVue.fxml"));
			Scene scene = new Scene(root, 1060, 800);
			
			primaryStage.setTitle("Scrabble");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Failed to load FXML file: " + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}