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
		
		cases[0][0].setSpecialite(Specialite.MOTTRIPLE);
		cases[0][3].setSpecialite(Specialite.LETTREDOUBLE);
		cases[0][7].setSpecialite(Specialite.MOTTRIPLE);
		cases[0][11].setSpecialite(Specialite.LETTREDOUBLE);
		cases[0][14].setSpecialite(Specialite.MOTTRIPLE);
		cases[1][1].setSpecialite(Specialite.MOTDOUBLE);
		cases[1][5].setSpecialite(Specialite.LETTRETRIPLE);
		cases[1][9].setSpecialite(Specialite.LETTRETRIPLE);
		cases[1][13].setSpecialite(Specialite.MOTDOUBLE);
		cases[2][2].setSpecialite(Specialite.MOTDOUBLE);
		cases[2][6].setSpecialite(Specialite.LETTREDOUBLE);
		cases[2][8].setSpecialite(Specialite.LETTREDOUBLE);
		cases[2][12].setSpecialite(Specialite.MOTDOUBLE);
		cases[3][0].setSpecialite(Specialite.LETTREDOUBLE);
		cases[3][3].setSpecialite(Specialite.MOTDOUBLE);
		cases[3][7].setSpecialite(Specialite.LETTREDOUBLE);
		cases[3][11].setSpecialite(Specialite.MOTDOUBLE);
		cases[3][14].setSpecialite(Specialite.LETTREDOUBLE);
		cases[4][4].setSpecialite(Specialite.MOTDOUBLE);
		cases[4][10].setSpecialite(Specialite.MOTDOUBLE);
		cases[5][1].setSpecialite(Specialite.LETTRETRIPLE);
		cases[5][5].setSpecialite(Specialite.LETTRETRIPLE);
		cases[5][9].setSpecialite(Specialite.LETTRETRIPLE);
		cases[5][13].setSpecialite(Specialite.LETTRETRIPLE);
		cases[6][2].setSpecialite(Specialite.LETTREDOUBLE);
		cases[6][6].setSpecialite(Specialite.LETTREDOUBLE);
		cases[6][8].setSpecialite(Specialite.LETTREDOUBLE);
		cases[6][12].setSpecialite(Specialite.LETTREDOUBLE);
		cases[7][0].setSpecialite(Specialite.MOTTRIPLE);
		cases[7][3].setSpecialite(Specialite.LETTREDOUBLE);
		cases[7][7].setSpecialite(Specialite.ETOILE);
		cases[7][11].setSpecialite(Specialite.LETTREDOUBLE);
		cases[7][14].setSpecialite(Specialite.MOTTRIPLE);
		cases[14][0].setSpecialite(Specialite.MOTTRIPLE);
		cases[14][3].setSpecialite(Specialite.LETTREDOUBLE);
		cases[14][7].setSpecialite(Specialite.MOTTRIPLE);
		cases[14][11].setSpecialite(Specialite.LETTREDOUBLE);
		cases[14][14].setSpecialite(Specialite.MOTTRIPLE);
		cases[13][1].setSpecialite(Specialite.MOTDOUBLE);
		cases[13][5].setSpecialite(Specialite.LETTRETRIPLE);
		cases[13][9].setSpecialite(Specialite.LETTRETRIPLE);
		cases[13][13].setSpecialite(Specialite.MOTDOUBLE);
		cases[12][2].setSpecialite(Specialite.MOTDOUBLE);
		cases[12][6].setSpecialite(Specialite.LETTREDOUBLE);
		cases[12][8].setSpecialite(Specialite.LETTREDOUBLE);
		cases[12][12].setSpecialite(Specialite.MOTDOUBLE);
		cases[11][0].setSpecialite(Specialite.LETTREDOUBLE);
		cases[11][3].setSpecialite(Specialite.MOTDOUBLE);
		cases[11][7].setSpecialite(Specialite.LETTREDOUBLE);
		cases[11][11].setSpecialite(Specialite.MOTDOUBLE);
		cases[11][14].setSpecialite(Specialite.LETTREDOUBLE);
		cases[10][4].setSpecialite(Specialite.MOTDOUBLE);
		cases[10][10].setSpecialite(Specialite.MOTDOUBLE);
		cases[9][1].setSpecialite(Specialite.LETTRETRIPLE);
		cases[9][5].setSpecialite(Specialite.LETTRETRIPLE);
		cases[9][9].setSpecialite(Specialite.LETTRETRIPLE);
		cases[9][13].setSpecialite(Specialite.LETTRETRIPLE);
		cases[8][2].setSpecialite(Specialite.LETTREDOUBLE);
		cases[8][6].setSpecialite(Specialite.LETTREDOUBLE);
		cases[8][8].setSpecialite(Specialite.LETTREDOUBLE);
		cases[8][12].setSpecialite(Specialite.LETTREDOUBLE);
		
		return cases;
	}
	
	public void afficher() {
		if (cases[0][0]==null) {
			Console.message("Le plateau est vide.");
		}
		else {
			for (int i = 0 ; i < Constantes.LIGNE ; i++ ) {
				System.out.println(" ——  ——  ——  ——  ——  ——  ——  ——  ——  ——  ——  ——  ——  ——  —— ");
				for (int j = 0 ; j < Constantes.COLONNE ; j++) {
					if (cases[i][j].getPresenceJeton()== true) {
						System.out.print("|" + cases[i][j].getAffichageLettre() + " " + "|");
					}
					else {
						System.out.print("|" + cases[i][j].getSpecialite().getSpecialite() + "|");
					}
				}
				System.out.print("\n");
			}
			System.out.println(" ——  ——  ——  ——  ——  ——  ——  ——  ——  ——  ——  ——  ——  ——  —— ");
		}
	}
	
	public boolean estVide() {
		boolean estVide = true;
		for (int i = 0 ; i < Constantes.LIGNE ; i++ ) {
			for (int j = 0 ; j < Constantes.COLONNE ; j++) {
				if (Boolean.TRUE.equals(cases[i][j].getPresenceJeton())) {
					estVide = false;
				}
			}
		}
		
		return estVide;
	}
	
	public void ajouterJeton(Jeton jeton, Position position){
		cases[position.getLigne()-1][position.getColonne()-1].setJeton(jeton);
		cases[position.getLigne()-1][position.getColonne()-1].setPresenceJeton(true);
	}
	
	public Boolean caseEstVide(Position position) {
		Boolean estVide = true;
		if(cases[position.getLigne()-1][position.getColonne()-1] instanceof Case) {
			estVide = false;
		}
		return estVide;
	}
}

