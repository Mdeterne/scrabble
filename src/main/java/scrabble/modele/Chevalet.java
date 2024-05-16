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
	
	public boolean estVide() {
		return jetons.isEmpty();
	}
	
	public int nbJeton() {
		return jetons.size();
	}
	
	public void ajouterUneListeJeton(List<Jeton> jetonEchanger) {
		jetons.addAll(jetonEchanger);
	}
	
}
