package scrabble.application;

import java.util.ArrayList;
import java.util.List;

import scrabble.gui.Console;
import scrabble.modele.Chevalet;
import scrabble.modele.Constantes;
import scrabble.modele.Direction;
import scrabble.modele.Jeton;
import scrabble.modele.Lettre;
import scrabble.modele.Plateau;
import scrabble.modele.Position;
import scrabble.modele.SacJeton;
import scrabble.utils.SacVideException;

public class Jouer {

	
	

	private List<Integer> indiceJetonsAJouer;
	
	
	public void selectionnerDesLettres(List<Integer> indiceJetonAJouer){
		//TODO
	}
	
	public void placerUnJeton(Jeton jetonJoue, Position position, Plateau plateau) {
		String lettreJeton= jetonJoue.getLettre();
		if(lettreJeton.equals(Lettre.JOKER.getLettre())) {
			jetonJoue.attribuerJoker();
		}
		if(plateau.estVide()) {
			plateau.ajouterJeton(jetonJoue, new Position(8,8));
		}
		else {
			plateau.ajouterJeton(jetonJoue, position);
		}
	}

	public void placerUnMot(List<Integer> indiceJetonAJouer,Plateau plateau,Direction direction,Chevalet chevalet,Position position) {
		
		Jeton jeton = chevalet.selectionner(indiceJetonAJouer.get(0));
		placerUnJeton(jeton,position,plateau);
		if (direction.equals(Direction.BAS)) {
			for (int i=0 ; i < indiceJetonAJouer.size()-1 ; i++) {
				position.setColonne(position.getColonne()+1);
				jeton = chevalet.selectionner(indiceJetonAJouer.get(i+1));
				placerUnJeton(jeton,position,plateau);
			}
		}
		if (direction.equals(Direction.DROITE)) {
			for (int i=0 ; i < indiceJetonAJouer.size()-1 ; i++) {
				position.setLigne(position.getLigne()+1);
				jeton = chevalet.selectionner(indiceJetonAJouer.get(i+1));
				placerUnJeton(jeton,position,plateau);
			}
		}
		for (int i= indiceJetonAJouer.size() ; i > 0 ; i--) {
			chevalet.enlever(indiceJetonAJouer.get(i));
		}
		
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
	public static void main(String[]arg) {
		
		SacJeton sacJeton = new SacJeton();
		Plateau plateau = new Plateau();
		Chevalet chevalet = new Chevalet();
		
		sacJeton.mettreDesJetonDansMonSac();
		sacJeton.melangerSac();
		
		try {
			remplirChevalet(Constantes.NBPLACECHEVALET,sacJeton,chevalet);
		} catch (SacVideException e) {
			Console.message("le sac est vide");
		}	
		
		
		
		
	}

}
