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
		plateau.Afficher();
		plateau.Afficher();
		
		SacJeton sacJeton = new SacJeton();
		sacJeton.mettreDesJetonDansMonSac();
		sacJeton.afficherNombreJetons();
		sacJeton.afficherMonSacDeJeton();
		
		Chevalet chevalet;
		chevalet = new Chevalet();
		Console.message("test");
		chevalet.afficher();
		chevalet.remplirMonChevalet(sacJeton);		
		Console.message("");
		
		Jeton jetonPioche = null;
		try {
			jetonPioche = sacJeton.piocherJeton();
		} catch (SacVideException e) {
			Console.message("Impossible de piocher le sac est vide");
		}
		
		chevalet.afficher();
		chevalet.ajouter(jetonPioche);
		sacJeton.afficherNombreJetons();
		sacJeton.afficherMonSacDeJeton();
	}
}