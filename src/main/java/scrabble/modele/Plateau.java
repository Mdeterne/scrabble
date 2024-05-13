package scrabble.modele;

import scrabble.gui.*;

public class Plateau {

	Case[][] cases;

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
		for (int i = 0 ; i < Constantes.LIGNE ; i++ ) {
			for (int j = 0 ; j < Constantes.COLONNE ; j++) {
				System.out.println("("+i+","+j+")");
				Console.message(this.cases[i][j].toString());
			}
		}
	}
}

