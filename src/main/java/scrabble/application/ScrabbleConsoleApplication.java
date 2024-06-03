package scrabble.application;

import scrabble.gui.Console;
import scrabble.modele.Chevalet;
import scrabble.modele.Joueur;
import scrabble.modele.Plateau;
import scrabble.modele.SacJeton;

public class ScrabbleConsoleApplication {

	public static void main(String[] args) {
		Plateau plateau = new Plateau();
		SacJeton sacJeton = new SacJeton();
		Chevalet chevalet = new Chevalet();
		Joueur joueur1 = new Joueur();
		Jouer.tourDeJeu(sacJeton, chevalet, plateau, joueur1);
	}

}
