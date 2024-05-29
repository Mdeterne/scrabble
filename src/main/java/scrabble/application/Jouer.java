package scrabble.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import scrabble.gui.Console;
import scrabble.modele.Chevalet;
import scrabble.modele.Constantes;
import scrabble.modele.Direction;
import scrabble.modele.Jeton;
import scrabble.modele.Joueur;
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
	
	public void tourDeJeu(SacJeton sacJeton,Chevalet chevalet,Plateau plateau, Joueur joueur){
		try {
			Scanner input = new Scanner(System.in);
	        System.out.println("Choisissez ce que vous souhaité faire durant ce tour: ");
	        Integer indice = input.nextInt();
	        input.close();
	        if(indice == 1) {
	        	ArrayList<Integer> listeIndiceLettre;
	        	selectionnerDesLettres(listeIndiceLettre);
	        	
	        	Integer score = 0;
	        	for(int i = 0 ; i < listeIndiceLettre.size() ; i++) {
	        		Integer pointJeton = 0;
	        		score = score + chevalet.selectionner(listeIndiceLettre.get(i)).getPoints();
	        	}
	        	joueur.setScore(joueur.getScore()+score);
	        	
	        	Direction direction;
	        	Scanner directionInput = new Scanner(System.in);
		        System.out.println("Entrer la direction dans laquelle votre mot doit s'écrire: ");
		        String ligneDirection = directionInput.nextLine();
		        try {
		        	direction = Direction.valueOf(ligneDirection.toUpperCase());
		        }catch (IllegalArgumentException e) {
		        	System.out.println("La direction saisie n'est pas valide");
		        }
		        input.close();
	        	
	        	
	        	Position position;
	        	Scanner ligneInput = new Scanner(System.in);
		        System.out.println("Entrer la ligne sur laquelle vous souhaitez poser votre jeton: ");
		        Integer ligne = ligneInput.nextInt();
		        position.setLigne(ligne);
		        input.close();
		        
		        Scanner colonneInput = new Scanner(System.in);
		        System.out.println("Entrer la colonne sur laquelle vous souhaitez poser votre jeton: ");
		        Integer colonne = colonneInput.nextInt();
		        position.setColonne(colonne);
		        input.close();
		        
	        	placerUnMot(listeIndiceLettre,plateau,direction,chevalet,position);
	        }
	        if(indice == 2) {
	        	try {
	        		echanger(sacJeton, chevalet);
	        	}catch (SacVideException e) {
	        		//TODO
	        	}
	        	
	        }
	        else if(indice == 3) {
	        	//quitter() TODO;
	        }
	        else {
	        	System.out.println("Le choix n'est pas disponible");
	        }
	        
	        if(!chevalet.estVide()) {
	        	try {
	        		remplirChevalet(sacJeton, chevalet);
	        	}catch (SacVideException e) {
	        		//TODO
	        	}
	        }
	        System.out.print("Votre score est : " + joueur.getScore().toString());
		}catch (IllegalArgumentException e) {
        	System.out.println("Le choix que vous avez choisie est invalide");
        }
	}
	
	public static void main(String[]arg) {
		
		SacJeton sacJeton = new SacJeton();
		Plateau plateau = new Plateau();
		Chevalet chevalet = new Chevalet();
		Direction direction;
		
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
		try {
			Scanner inputDirection = new Scanner(System.in);
			if (inputDirection.nextInt()==1) {
				
			}
		}
		catch(IllegalArgumentException e) {
			Console.message("entrez seulement 1 ou 2");
		}
		
		placerUnMot(indiceJetonAJouer,plateau,Direction.BAS,chevalet,postition);
		
	}

}
