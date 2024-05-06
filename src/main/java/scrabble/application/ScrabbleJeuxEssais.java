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
		
		Console.message("");
		
		Jeton jetonPioche;
		try {
			jetonPioche = SacJeton.piocherJeton();
		} catch (SacVideException e) {
			Console.message("Impossible de piocher le sac est vide");
		}
        
		Jeton jetonPioche2;
		try {
			jetonPioche2 = SacJeton.piocherJeton();
		} catch (SacVideException e) {
			Console.message("Impossible de piocher le sac est vide");
		}
		
        
		Chevalet chevalet;
		chevalet = new Chevalet();
		
		Jeton jeton1 = new Jeton(Lettre.A, Points.DEUX);
		Jeton jeton2 = new Jeton(Lettre.B, Points.TROIS);
		chevalet.ajouter(jeton1);
		chevalet.ajouter(jeton2);
		chevalet.afficher();
		chevalet.piocher();
		chevalet.afficher();
		
	}
}
