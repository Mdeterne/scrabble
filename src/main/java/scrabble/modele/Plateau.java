package scrabble.modele;

import scrabble.gui.*;

public class Plateau {

	private Case[][] cases;

	public Plateau() {
		this.cases = new Case[Constantes.LIGNE][Constantes.COLONNE];
	}

	
	public Case[][] mettreDesCaseDansMonPlateau() {
		for (int i = 0 ; i < Constantes.LIGNE ; i++ ) {
			for (int j = 0 ; j < Constantes.COLONNE ; j++) {
				cases[i][j] = new Case(Specialite.NEUTRE);
			}
		}
		
		cases[7][7].setSpecialite(Specialite.ETOILE);
		return cases;
	}
	
	public void faireAfficherMesCases() {
		if (cases[0][0]==null) {
			Console.message("Le plateau est vide.");
		}
		else {
			for (int i = 0 ; i < Constantes.LIGNE ; i++ ) {
				for (int j = 0 ; j < Constantes.COLONNE ; j++) {
					System.out.println("("+i+","+j+")");
					Console.message(this.cases[i][j].toString());
				}
			}
		}
	}
	
	public boolean estVide() {
		boolean estVide = false;
		for (int i = 0 ; i < Constantes.LIGNE ; i++ ) {
			for (int j = 0 ; j < Constantes.COLONNE ; j++) {
				if (cases[i][j] instanceof Case) {
					estVide = false;
				}
				else {
					estVide = true;
				}
			}
		}
		return estVide;
	}
}

