package scrabble.application;

import scrabble.modele.Plateau;
import scrabble.modele.Points;
import scrabble.modele.Jeton;
import scrabble.modele.Lettre;
import scrabble.modele.SacJeton;
import scrabble.utils.SacVideException;

import java.util.ArrayList;
import java.util.List;

import scrabble.gui.Console;
import scrabble.modele.Chevalet;
import scrabble.modele.Constantes;
import scrabble.modele.Position;
import scrabble.modele.Direction;

public class ScrabbleJeuxEssais {

	public static void main(String[] args) throws SacVideException {
		Console.titre("Bienvenue dans notre magnifique scrabble");
		
		Plateau plateau = new Plateau();
		plateau.afficher();
		Jeton jeton = new Jeton(Lettre.T, Points.TROIS);
		Position positionT = new Position(7,7);
		Chevalet chevaletMot = new Chevalet();
		SacJeton sacJetonMot = new SacJeton();
		sacJetonMot.mettreDesJetonDansMonSac();
		sacJetonMot.melangerSac();
		Jouer.remplirChevalet(sacJetonMot, chevaletMot);
		List<Integer> indicesJetonsAJouer = new ArrayList<>();
		indicesJetonsAJouer.add(1);
		indicesJetonsAJouer.add(5);
		//jouer.placerUnJeton(jeton, positionT, plateau);
		Jouer.placerUnMot(indicesJetonsAJouer, plateau, Direction.BAS, chevaletMot, positionT);
		Console.message("");
		plateau.afficher();
		
		
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
		
		try {
			echanger(sacJeton,chevalet);
		} catch (SacVideException e) {
			Console.message("Impossible de piocher le sac est vide");
		}
		Position position = new Position(7,7);
		chevalet.afficher();
		chevalet.enlever(2);
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
	private static void echanger(SacJeton sacJeton, Chevalet chevalet) throws SacVideException {
		if (sacJeton.estVide()) {
			throw new SacVideException("Le sac est vide impossible de piocher");
		}
		List<Jeton>transition = new ArrayList<>();
		List<Jeton>transition2 = new ArrayList<>();
		int nbJetonEchange = chevalet.nbJeton();
		for (int i=0; i<nbJetonEchange; i++) {
			
			transition.add(sacJeton.piocherJeton());
			
		}
		for (int i=0; i<nbJetonEchange; i++) {
			
			transition2.add(chevalet.selectionner(0));
			
		}
		chevalet.nettoyer();
		chevalet.ajouterUneListeJeton(transition);
		sacJeton.ajouterUneListeJeton(transition2);
		
		
		
	}
}