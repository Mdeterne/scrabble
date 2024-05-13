package scrabble.modele;

import java.util.ArrayList;
import java.util.List;

import scrabble.gui.Console;
import scrabble.utils.SacVideException;

public class Chevalet {
	ArrayList<Jeton> chevalet; 
	
	public Chevalet(){
		this.chevalet = new ArrayList<Jeton>();
	}
	
	public void ajouter(Jeton jeton) {
		
		if (chevalet.size() < 7) {
			this.chevalet.add(jeton);
		}
		else {
			Console.message("impposible votre chevalet est plein");
		}
	}
	
	void jouer(Jeton jeton, Position position){
		// TODO Ajouter l'envoi d'un jeton vers une case du plateau
	}
	
	public void afficher() {
	    if (chevalet.isEmpty()) {
	        Console.message("Le chevalet est vide."); // Affiche un message si le chevalet est vide
	    } else {
	        Console.message("Jetons sur le chevalet :");
	        for (Jeton jeton : chevalet) {
	            Console.message("Lettre : " + jeton.getLettre() + ", Points : " + jeton.getPoints());
	        }
	    }
	}
	
	public void remplirMonChevalet(SacJeton sacJeton) {
		Jeton jeton = null;
		for(int i = 0; i < Constantes.NBPLACECHEVALET; i++) {
			try {
				jeton = sacJeton.piocherJeton();
			} catch (SacVideException e) {
				Console.message("erreur sac de jeton vide");
			}
			chevalet.add(jeton);
		}
		
		
	}

	
}
