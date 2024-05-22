package scrabble.modele;

import scrabble.gui.*;

public class Plateau {

	Case[][] cases;

	public Plateau() {
		this.cases= new Case[Constantes.LIGNE][Constantes.COLONNE];
		remplirMonPlateau();
	}

	
	private Case[][] remplirMonPlateau() {
		for (int i = 0 ; i < Constantes.LIGNE ; i++ ) {
			for (int j = 0 ; j < Constantes.COLONNE ; j++) {
				cases[i][j] = new Case(Specialite.NEUTRE);
			}
		}
		
		cases[7][7].setSpecialite(Specialite.ETOILE);
		return cases;
	}
	
	public void Afficher() {
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
	
	public void ajouterJeton(Jeton jeton, Position position){
		cases[position.getLigne()-1][position.getColonne()-1].setJeton(jeton);
		cases[position.getLigne()-1][position.getColonne()-1].setPresenceJeton(true);
	}
}

