package scrabble.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
	
	public static void selectionnerDesLettres(ArrayList<Integer> positionJetonAJouer){
		
		try {
			Scanner inputNBLettre = new Scanner(System.in);
			Console.message("combien de lettres voulez vous utiliser :");
			Integer nbLettre = inputNBLettre.nextInt();
			if (nbLettre>0 && nbLettre<8) {
				Scanner inputLettre = new Scanner(System.in);
				for (int i=0; i<nbLettre; i++) {
					
				    Console.message("Entrer l'indice de la lettre que vous souhaitez utiliser: ");
				    Integer indice = inputLettre.nextInt();
				    
				    if(indice>0 && indice<8) {
			        	positionJetonAJouer.add(indice-1);
			        }
				    else {
				    	Console.message("veuillez indiquer l'indice pas la lettre");
				    }
				}
				inputLettre.close();
			}
			else {
				Console.message("vous avez selectionner un nombre incorect");
			}
			inputNBLettre.close();
		}
		catch (IllegalArgumentException e){
			Console.message("veuillez entrer un nombre");
		}
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
		
		if (plateau.caseEstVide(position).equals(true)) {
			Boolean condition1Rempli = false;
			if (direction.equals(Direction.BAS)) {
				Position position1 = new Position(position.getLigne(),position.getColonne()-1);
				Position position2 = new Position(position.getLigne()-1,position.getColonne());
				Position position3 = new Position(position.getLigne(),position.getColonne()+1);
				Position position4 = new Position(position.getLigne()+1,position.getColonne());
				if ( plateau.caseEstVide(position1).equals(true) || plateau.caseEstVide(position2).equals(true) || plateau.caseEstVide(position3).equals(true)) {
					condition1Rempli = true;
					for (int i = 0; i < indiceJetonAJouer.size()-1; i++) {
						if (plateau.caseEstVide(position4)) {
							condition1Rempli = false;
							position4 = new Position(position4.getLigne()+1,position4.getColonne());
						}
					}
				}
			}
			if (direction.equals(Direction.DROITE)) {
				Position position1 = new Position(position.getLigne()-1,position.getColonne());
				Position position2 = new Position(position.getLigne(),position.getColonne()-1);
				Position position3 = new Position(position.getLigne()+1,position.getColonne());
				Position position4 = new Position(position.getLigne(),position.getColonne()+1);
				if ( plateau.caseEstVide(position1).equals(true) || plateau.caseEstVide(position2).equals(true) || plateau.caseEstVide(position3).equals(true)) {
					condition1Rempli = true;
					for (int i = 0; i < indiceJetonAJouer.size()-1; i++) {
						if (plateau.caseEstVide(position4)) {
							condition1Rempli = false;
							position4 = new Position(position4.getLigne(),position4.getColonne()+1);
						}
					}
				}
			}
			if (condition1Rempli==true) {
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
		}
	}

	static void remplirChevalet(SacJeton sacJeton, Chevalet chevalet)
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
		
		ArrayList<Integer> indiceJetonAJouer;
		indiceJetonAJouer = new ArrayList<>();
		
		sacJeton.mettreDesJetonDansMonSac();
		sacJeton.melangerSac();
		
		try {
			remplirChevalet(sacJeton,chevalet);
		} catch (SacVideException e) {
			Console.message("le sac est vide");
		}	
		
		chevalet.afficher();
		Console.message("");
		selectionnerDesLettres(indiceJetonAJouer);
		System.out.println(indiceJetonAJouer);
		
		
	}

}
