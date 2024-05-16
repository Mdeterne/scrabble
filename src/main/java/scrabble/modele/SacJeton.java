package scrabble.modele;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import scrabble.gui.Console;
import scrabble.utils.SacVideException;

public class SacJeton {
	
	public List<Jeton> jetons;

	public SacJeton(){
        jetons = new ArrayList<>();
    }
	
	public void mettreDesJetonDansMonSac() {
		for (int i = 0; i < 15; i++) {
				jetons.add(new Jeton(Lettre.E, Points.UN));
		}
		for (int i = 0; i < 9; i++) {
			jetons.add(new Jeton(Lettre.A, Points.UN));
		}
		for (int i = 0; i < 8; i++) {
			jetons.add(new Jeton(Lettre.I, Points.UN));
		}
		for (int i = 0; i < 6; i++) {
			jetons.add(new Jeton(Lettre.N, Points.UN));
			jetons.add(new Jeton(Lettre.O, Points.UN));
			jetons.add(new Jeton(Lettre.R, Points.UN));
			jetons.add(new Jeton(Lettre.S, Points.UN));
			jetons.add(new Jeton(Lettre.T, Points.UN));
			jetons.add(new Jeton(Lettre.U, Points.UN));
		}
		for (int i = 0; i < 5; i++) {
			jetons.add(new Jeton(Lettre.L, Points.UN));
		}
		for (int i = 0; i < 3; i++) {
			jetons.add(new Jeton(Lettre.D, Points.DEUX));
			jetons.add(new Jeton(Lettre.M, Points.DEUX));
		}
		for (int i = 0; i < 2; i++) {
			jetons.add(new Jeton(Lettre.G, Points.DEUX));
			jetons.add(new Jeton(Lettre.C, Points.TROIS));
			jetons.add(new Jeton(Lettre.B, Points.TROIS));
			jetons.add(new Jeton(Lettre.P, Points.TROIS));
			jetons.add(new Jeton(Lettre.F, Points.QUATRE));
			jetons.add(new Jeton(Lettre.H, Points.QUATRE));
			jetons.add(new Jeton(Lettre.V, Points.QUATRE));
			jetons.add(new Jeton(Lettre.JOKER, Points.ZERO));
		}
		for (int i = 0; i < 1; i++) {
			jetons.add(new Jeton(Lettre.J, Points.HUIT));
			jetons.add(new Jeton(Lettre.Q, Points.HUIT));
			jetons.add(new Jeton(Lettre.K, Points.DIX));
			jetons.add(new Jeton(Lettre.W, Points.DIX));
			jetons.add(new Jeton(Lettre.X, Points.DIX));
			jetons.add(new Jeton(Lettre.Y, Points.DIX));
			jetons.add(new Jeton(Lettre.Z, Points.DIX));
		}
	}
	
	public void melangerSac() {
		Collections.shuffle(jetons);
	}
	
	public Jeton piocherJeton() throws SacVideException{
        if (jetons.isEmpty()) {
        	throw new SacVideException("Le sac est vide impossible de piocher");
        }
        return jetons.remove(0);
    }
	
	public void afficher() {
		for (int i = 0 ; i < jetons.size() ; i++) {
			Console.message(jetons.get(i).toSting()+", ");
		}
	}
	
	public boolean estVide() {
		return jetons.isEmpty();	
	}
	
	public int nbJeton() {
		return jetons.size();
	}
	
	public void ajouterUnJeton(Jeton jeton) {
		jetons.add(jeton);
	}
	
	public void ajouterUneListeJeton(List<Jeton> jetonEchanger) {
		jetons.addAll(jetonEchanger);
	}
	
}