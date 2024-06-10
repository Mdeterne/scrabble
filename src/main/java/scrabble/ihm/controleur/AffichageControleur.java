package scrabble.ihm.controleur;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import scrabble.modele.Chevalet;
import scrabble.modele.Jeton;
import scrabble.modele.SacJeton;
import scrabble.utils.SacVideException;

public class AffichageControleur {
	
	@FXML
	private Label titreScrabble;
	
	@FXML
	private Button quitterbtn;
	
	@FXML
	private Button placerMotbtn;
	
	@FXML
	private Button remplacerChevaletbtn;
	
	@FXML
	private HBox chevaletHbox;
	
	@FXML
	private HBox emplacementBoutton;

	@FXML
	private HBox emplacementTitre;
	
	@FXML
	private GridPane plateau;
	
	@FXML
	private GridPane caseChevalet;
	
	private SacJeton sacDeJetons;
    private Chevalet chevalet;
	
	@FXML
    private void handleQuitButtonAction(ActionEvent event) {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
	
}
