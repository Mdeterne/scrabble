package scrabble.modele;

import java.util.ArrayList;
//import java.util.Collection;
import java.util.List;
import scrabble.gui.Console;
//import scrabble.utils.SacVideException;

public class Chevalet {
	private List<Jeton> jetons; 
	
	public Chevalet(){
		this.jetons = new ArrayList<>();
	}
	
	public void ajouter(Jeton jeton) {
		
		if (jetons.size() < Constantes.NBPLACECHEVALET) {
			this.jetons.add(jeton);
		}
		else {
			Console.message("Erreur: votre chevalet est plein");
		}
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
	
	public void ajouterUneListeJeton(List<Jeton> jetonsAAjouter) {
		if (Constantes.NBPLACECHEVALET-jetons.size()>=jetonsAAjouter.size()) {
			jetons.addAll(jetonsAAjouter);
		}
		else {
			Console.message("Erreur: votre chevalet n'as pas assez de place");
		}
		
	}
	
	public Jeton selectionner(int indice) {
		return jetons.get(indice);
	}
	
	public void nettoyer() {
		jetons.removeAll(jetons);
	}
	
	public void enlever(int indice) {
		jetons.remove(indice);
	}
}
