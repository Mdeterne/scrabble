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

	
	public void echangerTousLesJetons(ArrayList<Jeton> sacJeton){
		try {
			int nombreJeton=jetons.size()-1;
			for(int j=0;j<nombreJeton;j++) {
				Jeton jetonCible=jetons.get(0);
				sacJeton.add(jetonCible);
				jetons.remove(jetonCible);
			}
			sacJeton.melangerSac();
			for(int k=0;k<nombreJeton;k++) {
				jetons.add(sacJeton.piocherJeton());
			}
		}catch (SacVideException e){
			Console.message("Impossible de piocher le sac est vide");
		}
	}
	
	public boolean estVide() {
		return jetons.isEmpty();
	}
	
	public int nbJeton() {
		return jetons.size();
	}
	
	public void ajouterUneListeJeton(ArrayList<Jeton> jetonEchanger) {
		jetons.addAll(jetonEchanger);
	}
	
}
