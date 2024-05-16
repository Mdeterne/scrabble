package scrabble.application;

import scrabble.modele.Plateau;
import scrabble.modele.Jeton;
import scrabble.modele.SacJeton;
import scrabble.utils.SacVideException;

import java.util.ArrayList;
import java.util.List;

import scrabble.gui.Console;
import scrabble.modele.Chevalet;
import scrabble.modele.Constantes;

public class ScrabbleJeuxEssais {

	public static void main(String[] args) {
		Console.titre("Bienvenue dans notre magnifique scrabble");
		
		Plateau plateau = new Plateau();
		plateau.Afficher();
		plateau.Afficher();
		
		SacJeton sacJeton = new SacJeton();
		sacJeton.mettreDesJetonDansMonSac();
		sacJeton.melangerSac();
		sacJeton.nbJeton();
		sacJeton.afficher();
		
		Chevalet chevalet;
		chevalet = new Chevalet();
		Console.message("test");
		chevalet.afficher();
		try {
			remplirChevalet(Constantes.NBPLACECHEVALET,sacJeton,chevalet);
		} catch (SacVideException e) {
			Console.message("le sac est vide");
		}	
		Console.message("");
		
		Jeton jetonPioche = null;
		try {
			jetonPioche = sacJeton.piocherJeton();
		} catch (SacVideException e) {
			Console.message("Impossible de piocher le sac est vide");
		}
		
		chevalet.afficher();
		chevalet.ajouter(jetonPioche);
		sacJeton.nbJeton();
		sacJeton.afficher();
		
		chevalet.afficher();
		
		chevalet.afficher();
		
	}
	
	private static void remplirChevalet(int nbJetonAEchanger, SacJeton sacJeton, Chevalet chevalet) throws SacVideException {
		if (sacJeton.estVide()) {
			throw new SacVideException("Le sac est vide impossible de piocher");
		}
		
		List<Jeton>transition = new ArrayList<>();
		for (int i=0; i<Constantes.NBPLACECHEVALET; i++) {
			
			transition.add(sacJeton.piocherJeton());
			
		}
		chevalet.ajouterUneListeJeton(transition);
	}
	
}