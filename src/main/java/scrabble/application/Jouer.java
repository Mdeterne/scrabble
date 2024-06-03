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
import scrabble.modele.Specialite;
import scrabble.utils.SacVideException;

public class Jouer{
	
	public void selectionnerDesLettres(ArrayList<Integer> positionJetonAJouer){
		
		try {
			Console.message("combien de lettres voulez vous utiliser :");
			Integer nbLettre = Console.entrerNombre();
			if (nbLettre>0 && nbLettre<8) {
				
				for (int i=0; i<nbLettre; i++) {
					
				    Console.message("Entrer l'indice de la lettre que vous souhaitez utiliser: ");
				    Integer indice = Console.entrerNombre();
				    
				    if(indice>0 && indice<8) {
			        	positionJetonAJouer.add(indice-1);
			        }
				    else {
				    	Console.message("veuillez indiquer l'indice pas la lettre");
				    }
				}
				
			}
			else {
				Console.message("vous avez selectionner un nombre incorect");
			}
			
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

	public void placerUnMot(List<Integer> indiceJetonAJouer, Plateau plateau, Direction direction, Chevalet chevalet, Position position) {
	    System.out.println("hello");
	    if (plateau.caseEstVide(position).equals(true)) {
	        System.out.println("caseestvide");
	        boolean condition1Rempli = false;
	        if (direction.equals(Direction.BAS)) {
	            Position position1 = new Position(position.getLigne(), position.getColonne() - 1);
	            Position position2 = new Position(position.getLigne() - 1, position.getColonne());
	            Position position3 = new Position(position.getLigne(), position.getColonne() + 1);
	            Position position4 = new Position(position.getLigne() + 1, position.getColonne());
	            if (plateau.caseEstVide(position1).equals(true) || plateau.caseEstVide(position2).equals(true) || plateau.caseEstVide(position3).equals(true)) {
	                condition1Rempli = true;
	                System.out.println("condition true dans bas " + position4.toString());
	                for (int i = 0; i < indiceJetonAJouer.size(); i++) {
	                    System.out.println(i);
	                    System.out.println(position4.toString());
	                    if (plateau.caseEstVide(position4).equals(false)) {
	                        condition1Rempli = false;
	                        position4 = new Position(position4.getLigne() + 1, position4.getColonne());
	                        System.out.println("condition false "+position4.toString());
	                    }
	                }
	            }
	        }
	        if (direction.equals(Direction.DROITE)) {
	            Position position1 = new Position(position.getLigne() - 1, position.getColonne());
	            Position position2 = new Position(position.getLigne(), position.getColonne() - 1);
	            Position position3 = new Position(position.getLigne() + 1, position.getColonne());
	            Position position4 = new Position(position.getLigne(), position.getColonne() + 1);
	            if (plateau.caseEstVide(position1).equals(true) || plateau.caseEstVide(position2).equals(true) || plateau.caseEstVide(position3).equals(true)) {
	                condition1Rempli = true;
	                System.out.println("condition true dans droite " + position4.toString());
	                for (int i = 0; i < indiceJetonAJouer.size(); i++) {
	                    System.out.println(i);
	                    System.out.println(position4.toString());

	                    if (plateau.caseEstVide(position4).equals(false)) {
	                        condition1Rempli = false;
	                        position4 = new Position(position4.getLigne(), position4.getColonne() + 1);
	                        System.out.println("condition false "+position4.toString());
	                    }
	                }
	            }
	        }
	        if (condition1Rempli) {
	            System.out.println("if condition true");
	            Jeton jeton = chevalet.selectionner(indiceJetonAJouer.get(0));
	            System.out.println("jeton selectionné");
	            placerUnJeton(jeton, position, plateau);
	            System.out.println("premier jeton placé");

	            Position positionActuelle = new Position(position.getLigne(), position.getColonne());

	            for (int i = 0; i < indiceJetonAJouer.size(); i++) {
	            	System.out.println(indiceJetonAJouer);
	            	System.out.println(positionActuelle);
	                System.out.println(i);
	                System.out.println("if bas/droite for");

	                if (direction.equals(Direction.BAS)) {
	                    positionActuelle.setLigne(positionActuelle.getLigne() + 1);
	                } else if (direction.equals(Direction.DROITE)) {
	                    positionActuelle.setColonne(positionActuelle.getColonne() + 1);
	                }

	                if (Boolean.TRUE.equals(plateau.caseEstVide(positionActuelle))) {
	                    jeton = chevalet.selectionner(indiceJetonAJouer.get(i));
	                    placerUnJeton(jeton, positionActuelle, plateau);
	                    System.out.println("jeton placé");
	                } else {
	                    break;
	                }
	            }

	            for (int i = indiceJetonAJouer.size() - 1; i >= 0; i--) {
	            	System.out.println(indiceJetonAJouer);
	            	System.out.println(i);
	                chevalet.enlever(indiceJetonAJouer.get(i));
	                System.out.println("jeton enlevé");
	            }
	        }
	    }
	}




	public void remplirChevalet(SacJeton sacJeton, Chevalet chevalet)
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

	private void echanger(SacJeton sacJeton, Chevalet chevalet) throws SacVideException {
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
	
	public Integer multiplicateurMot(Specialite caseSpecialite) {
		Integer multiplicateur = 1;
		if(caseSpecialite.getSpecialite().equals("MT")) {
			multiplicateur = 3;
		}
		if(caseSpecialite.getSpecialite().equals("MD")) {
			multiplicateur = 2;
		}
		return multiplicateur;
	}
	
	public Integer multiplicateurLettre(Specialite caseSpecialite) {
		Integer multiplicateur = 1;
		if(caseSpecialite.getSpecialite().equals("LT")) {
			multiplicateur = 3;
		}
		if(caseSpecialite.getSpecialite().equals("LD") || caseSpecialite.getSpecialite().equals("**")) {
			multiplicateur = 2;
		}
		return multiplicateur;
	}

	
	public void tourDeJeu(SacJeton sacJeton,Chevalet chevalet,Plateau plateau, Joueur joueur){
		try {
	        System.out.println("Choisissez ce que vous souhaité faire durant ce tour:"
	        		+ "1- Jouer  2- Echanger des Lettres  3- Quitter ");
	        Integer indice = Console.entrerNombre();
	        Boolean finDuTour = false;
	        
	        while (finDuTour == false) {
	        	
	        	if(indice == 1) {
		        	ArrayList<Integer> listeIndiceLettre = new ArrayList<>();
		        	selectionnerDesLettres(listeIndiceLettre);
		        	
		        	Integer score = 0;
		        	for(int i = 0 ; i < listeIndiceLettre.size() ; i++) {
		        		score = score + chevalet.selectionner(listeIndiceLettre.get(i)).getPoints();
		        	}
		        	joueur.setScore(joueur.getScore()+score);
		        	
		        	Direction direction = Direction.BAS;
		        	
			        System.out.println("Entrer la direction dans laquelle votre mot doit s'écrire: 1- BAS  2- DROITE ");
			        int ligneDirection = Console.entrerNombre();
			        Boolean sorti = false;
			        while(sorti==false) {
			        	if (ligneDirection == 1) {
			        		direction = Direction.BAS;
			        		sorti = true;
			        	}
			        	if (ligneDirection == 2){
			        		direction = Direction.DROITE;
			        		sorti = true;
			        	}
			        	if (ligneDirection<1 || ligneDirection>2) {
			        		Console.message("veuillez entrer un nombre entre 1 et 2");
			        	}
			        }
		        	
		        	
			        System.out.println("Entrer la ligne sur laquelle vous souhaitez poser votre jeton: ");
			        Integer ligne = Console.entrerNombre();
			        
			        
			        System.out.println("Entrer la colonne sur laquelle vous souhaitez poser votre jeton: ");
			        Integer colonne = Console.entrerNombre();
			        
			        
			        Position position = new Position(ligne, colonne);
			        
		        	placerUnMot(listeIndiceLettre,plateau,direction,chevalet,position);
		        	
		        	int nbLettreUtilise = listeIndiceLettre.size();
		        	
		        	for (int i = 0 ; i < nbLettreUtilise; i++) {
		        		Jeton jeton = null;
		        		try {
							jeton = sacJeton.piocherJeton();
						} catch (SacVideException e) {
							Console.message("le sac de jeton est vide");
						}
		        		chevalet.ajouter(jeton);
		        	}
		        	finDuTour = true;
		        }
		        if(indice == 2) {
		        	try {
		        		echanger(sacJeton, chevalet);
		        		finDuTour = true;
		        	}catch (SacVideException e) {
		        		Console.message("le sac de jeton est vide");
		        	}
		        	
		        }
		        else if(indice == 3) {
		        	finDuTour = true;
		        }
		        else {
		        	System.out.println("Le choix n'est pas disponible");
		        }
		        
	        }
	        
	        System.out.print("Votre score est : " + joueur.getScore().toString());
		}catch (IllegalArgumentException e) {
        	System.out.println("Le choix que vous avez choisie est invalide");
        }
	}
	
	public static void main(String[]arg) {
		
		Plateau plateau = new Plateau();
		SacJeton sacJeton = new SacJeton();
		Chevalet chevalet = new Chevalet();
		Joueur joueur1 = new Joueur();
		Jouer jouer = new Jouer();
		jouer.tourDeJeu(sacJeton, chevalet, plateau, joueur1);
	}
}
