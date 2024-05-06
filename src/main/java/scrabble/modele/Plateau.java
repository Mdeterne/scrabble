package scrabble.modele;

import java.util.ArrayList;
import java.util.List;

import scrabble.gui.*;

public class Plateau {

	Case[][] cases;

	public Plateau() {
		this.cases = new Case[Constantes.LIGNE][Constantes.COLONNE];
	}

	
	public Case[][] mettreDesCaseDansMonPlateau() {
		int i =0;
		int j;
		while (i<15) {
			j=0;
			while (j<15) {
				cases[i][j] = new Case(Specialite.NEUTRE);
				j++;
			}
			i++;
		}
		cases[7][7].setSpecialite(Specialite.ETOILE);
		return cases;
	}
	
	public void faireAfficherMesCases() {
		int i =0;
		int j;
		while (i<15) {
			j=0;
			while (j<15) {
				System.out.println("("+i+","+j+")");
				Console.message(this.cases[i][j].toString());
				j++;
			}
			i++;
		}
	}
}
