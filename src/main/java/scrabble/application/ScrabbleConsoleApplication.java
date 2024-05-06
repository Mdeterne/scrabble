package scrabble.application;

import scrabble.gui.Console;
import scrabble.modele.Chevalet;
import scrabble.modele.Plateau;

public class ScrabbleConsoleApplication {

	public static void main(String[] args) {
		Plateau plateau = new Plateau();
		plateau.mettreDesCaseDansMonPlateau();
		plateau.faireAfficherMesCases();
		Console.message("");
		
		Chevalet chevalet = new Chevalet();
		chevalet.afficher();
	}

}
