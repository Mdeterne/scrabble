package scrabble.application;

import scrabble.modele.Plateau;
import scrabble.modele.Jeton;
import scrabble.modele.SacJeton;
import scrabble.utils.SacVideException;
import scrabble.gui.Console;
import scrabble.modele.Chevalet;

public class ScrabbleJeuxEssais {

	public static void main(String[] args) {
		Console.titre("Bienvenue dans notre magnifique scrabble");
		
		Plateau plateau = new Plateau();
		
		plateau.mettreDesCaseDansMonPlateau();
		
		plateau.faireAfficherMesCases();
		
		SacJeton sacJeton = new SacJeton();
		
		sacJeton.mettreDesJetonDansMonSac();
		
		sacJeton.afficherMonSacDeJeton();
		
		
		
		Console.message("");
		
		Jeton jetonPioche = null;
		try {
			jetonPioche = SacJeton.piocherJeton();
		} catch (SacVideException e) {
			Console.message("Impossible de piocher le sac est vide");
		}
		
        
		Chevalet chevalet;
		chevalet = new Chevalet();
		
		
		chevalet.afficher();
		chevalet.ajouter(jetonPioche);
		chevalet.afficher();
		
		sacJeton.afficherMonSacDeJeton();
	}
}
