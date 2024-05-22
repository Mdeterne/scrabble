package scrabble.modele;

import scrabble.gui.*;

public class Plateau {

	private Case[][] cases;

	public Plateau() {
		this.setCases(new Case[Constantes.LIGNE][Constantes.COLONNE]);
		remplirMonPlateau();
	}

	
	private Case[][] remplirMonPlateau() {
		for (int i = 0 ; i < Constantes.LIGNE ; i++ ) {
			for (int j = 0 ; j < Constantes.COLONNE ; j++) {
				getCases()[i][j] = new Case(Specialite.NEUTRE);
			}
		}
		
		getCases()[7][7].setSpecialite(Specialite.ETOILE);
		return getCases();
	}
	
	public void Afficher() {
		if (getCases()[0][0]==null) {
			Console.message("Le plateau est vide.");
		}
		else {
			for (int i = 0 ; i < Constantes.LIGNE ; i++ ) {
				for (int j = 0 ; j < Constantes.COLONNE ; j++) {
					System.out.println("("+i+","+j+")");
					Console.message(this.getCases()[i][j].toString());
				}
			}
		}
	}
	
	public boolean estVide() {
		boolean estVide = false;
		for (int i = 0 ; i < Constantes.LIGNE ; i++ ) {
			for (int j = 0 ; j < Constantes.COLONNE ; j++) {
				if (getCases()[i][j] instanceof Case) {
					estVide = false;
				}
				else {
					estVide = true;
				}
			}
		}
		return estVide;
	}
	
	public void ajouterUnJeton(Jeton jeton) {
		cases.add(jeton);
	}
}

