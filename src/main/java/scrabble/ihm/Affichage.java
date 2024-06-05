package scrabble.ihm;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Affichage extends Application{
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		HBox chevalet1 = new HBox();
		GridPane plateau = new GridPane();
		
		Pane root = FXMLLoader.load(getClass().getResource("/FXML/AffichageView.fxml"));
		
		Scene scene = new Scene(root,1060,800);
		
		primaryStage.setTitle("Scrabble");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
