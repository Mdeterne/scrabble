package scrabble.application;

import java.util.ArrayList;
import java.util.List;

import scrabble.gui.Console;
import scrabble.modele.Chevalet;
import scrabble.modele.Constantes;
import scrabble.modele.Direction;
import scrabble.modele.Jeton;
import scrabble.modele.Plateau;
import scrabble.modele.Position;
import scrabble.modele.SacJeton;
import scrabble.utils.SacVideException;

public class Jouer {

	Chevalet chevaletJoueur1;
	Plateau plateau;
	SacJeton sacJeton;

	private List<Integer> indiceJetonsAJouer;
	
	public void selectionnerDesLettres(List<Integer> indiceJetonAJouer){
		//TODO
	}
	public void tourDeJeu() {
		// TODO
	}

	public void placerUnJeton(Jeton jetonJouer) {
		if (plateau.estVide()) {

		}
	}

	public void placerUnMot(List<Integer> indiceJetonAJouer,Plateau plateau,Direction direction,Chevalet chevalet,Position position) {
		Jeton jeton = null;
		jeton = chevalet.selectionner(indiceJetonAJouer.get(0));
		placerUnJeton(jeton,position);
		chevalet.enlever(0);
	}

	private static void remplirChevalet(int nbJetonAEchanger, SacJeton sacJeton, Chevalet chevalet)
			throws SacVideException {

		if (sacJeton.estVide()) {
			throw new SacVideException("Le sac est vide impossible de piocher");
		}

		List<Jeton> transition = new ArrayList<>();
		for (int i = 0; i < Constantes.NBPLACECHEVALET; i++) {

			transition.add(sacJeton.piocherJeton());

		}
		chevalet.ajouterUneListeJeton(transition);
	}

	private static void echanger(SacJeton sacJeton, Chevalet chevalet) throws SacVideException {
		if (sacJeton.estVide()) {
			throw new SacVideException("Le sac est vide impossible de piocher");
		}
		List<Jeton> transition = new ArrayList<>();
		List<Jeton> transition2 = new ArrayList<>();
		int nbJetonEchange = chevalet.nbJeton();
		for (int i = 0; i < nbJetonEchange; i++) {

			transition.add(sacJeton.piocherJeton());

		}
		for (int i = 0; i < nbJetonEchange; i++) {

			transition2.add(chevalet.selectionner(0));

		}
		chevalet.nettoyer();
		chevalet.ajouterUneListeJeton(transition);
		sacJeton.ajouterUneListeJeton(transition2);

	}

}
