package scrabble.application;

import java.util.ArrayList;
import java.util.List;

import scrabble.modele.Chevalet;
import scrabble.modele.Constantes;
import scrabble.modele.Jeton;
import scrabble.modele.Plateau;
import scrabble.modele.SacJeton;
import scrabble.utils.SacVideException;

public class Jouer {

	Chevalet chevaletJoueur1;
	Plateau plateau;
	SacJeton sacJeton;
	
	public void tourDeJeu() {
		//TODO
	}
	
	public void placerUnJeton(Jeton jetonJouer) {
		if(plateau.estVide()) {
			//TODO
		}
	}
	
	private static void remplirChevalet(int nbJetonAEchanger, SacJeton sacJeton, Chevalet chevaletJoueur1) throws SacVideException {
		if (sacJeton.estVide()) {
			throw new SacVideException("Le sac est vide impossible de piocher");
		}
		
		List<Jeton>transition = new ArrayList<>();
		for (int i=0; i<Constantes.NBPLACECHEVALET; i++) {
			
			transition.add(sacJeton.piocherJeton());
			
		}
		chevaletJoueur1.ajouterUneListeJeton(transition);
	}
	private static void echanger(SacJeton sacJeton, Chevalet chevaletJoueur1) throws SacVideException {
		if (sacJeton.estVide()) {
			throw new SacVideException("Le sac est vide impossible de piocher");
		}
		List<Jeton>transition = new ArrayList<>();
		List<Jeton>transition2 = new ArrayList<>();
		int nbJetonEchange = chevaletJoueur1.nbJeton();
		for (int i=0; i<nbJetonEchange; i++) {
			
			transition.add(sacJeton.piocherJeton());
			
		}
		for (int i=0; i<nbJetonEchange; i++) {
			
			transition2.add(chevaletJoueur1.selectionner(0));
			
		}
		chevaletJoueur1.nettoyer();
		chevaletJoueur1.ajouterUneListeJeton(transition);
		sacJeton.ajouterUneListeJeton(transition2);
		
	}
	
}
