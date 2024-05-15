package scrabble.modele;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import scrabble.gui.Console;
import scrabble.utils.SacVideException;

public class Chevalet {
	public List<Jeton> jetons; 
	
	public Chevalet(){
		this.jetons = new ArrayList<>();
	}
	
	public void ajouter(Jeton jeton) {
		
		if (jetons.size() < Constantes.NBPLACECHEVALET) {
			this.jetons.add(jeton);
		}
		else {
			Console.message("impposible votre chevalet est plein");
		}
	}
	
	void jouer(Jeton jeton, Position position){
		// TODO Ajouter l'envoi d'un jeton vers une case du plateau
	}
	
	public void afficher() {
	    if (jetons.isEmpty()) {
	        Console.message("Le chevalet est vide.");
	    } else {
	        Console.message("Jetons sur le chevalet :");
	        for (Jeton jeton : jetons) {
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
			jetons.add(jeton);
		}
	}

	
	public void echangeLettre(int i, SacJeton sacJeton) throws SacVideException {
		if(jetons.size()<i || i>7) {
			Console.message("Vous ne pouvez pas procéder à l'échange.");
		}
		else {
			for(int j=0;j<i;j++) {
				Scanner input = new Scanner(System.in);
				Console.message("Quelle est la position du jeton que vous souhaitez enlever: ");
		        String jetonEchanger = input.next();
		        int foo = Integer.parseInt(jetonEchanger);
		        Jeton indice = jetons.get(foo);
				jetons.remove(indice);
				((Collection<Jeton>) sacJeton).add(indice);
			}
			sacJeton.melangerSac();
			for(int k=0;k<i;k++) {
				jetons.add(sacJeton.piocherJeton());
			}
		}
	}
	
	public boolean estVide() {
		return jetons.isEmpty();
	}
	
	public int nbJeton() {
		return jetons.size();
	}
	
}
