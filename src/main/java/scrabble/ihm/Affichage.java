package scrabble.ihm;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Affichage extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		
		HBox chevalet1 = new HBox();
		Button placerMotBtn = new Button("Placer un mot");
		Button remplacerChevaletBtn = new Button("Remplacer le chevalet");
		Button quitterBtn = new Button("Quitter");
		GridPane plateau = new GridPane();
		
		BorderPane root = new BorderPane();
		root.setCenter(plateau);
		root.setBottom(chevalet1);
		root.setBottom(placerMotBtn);
		root.setBottom(remplacerChevaletBtn);
		root.setBottom(quitterBtn);
		//root.getChildren().addAll(chevalet1,plateau,placerMotBtn,remplacerChevaletBtn,quitterBtn);
		
		Scene scene = new Scene(root,1060,800);
		
		primaryStage.setTitle("Scrabble");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
