package scrabble.modele;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import scrabble.utils.SacVideException;

public class SacJeton {
	
	public ArrayList<Jeton> sacJeton;

	public SacJeton(){
        sacJeton = new ArrayList<>();
    }
	
	public void mettreDesJetonDansMonSac() {
		for (int i = 0; i < 15; i++) {
				sacJeton.add(new Jeton(Lettre.E, Points.UN));
		}
		for (int i = 0; i < 9; i++) {
			sacJeton.add(new Jeton(Lettre.A, Points.UN));
		}
		for (int i = 0; i < 8; i++) {
			sacJeton.add(new Jeton(Lettre.I, Points.UN));
		}
		for (int i = 0; i < 6; i++) {
			sacJeton.add(new Jeton(Lettre.N, Points.UN));
			sacJeton.add(new Jeton(Lettre.O, Points.UN));
			sacJeton.add(new Jeton(Lettre.R, Points.UN));
			sacJeton.add(new Jeton(Lettre.S, Points.UN));
			sacJeton.add(new Jeton(Lettre.T, Points.UN));
			sacJeton.add(new Jeton(Lettre.U, Points.UN));
		}
		for (int i = 0; i < 5; i++) {
			sacJeton.add(new Jeton(Lettre.L, Points.UN));
		}
		for (int i = 0; i < 3; i++) {
			sacJeton.add(new Jeton(Lettre.D, Points.DEUX));
			sacJeton.add(new Jeton(Lettre.M, Points.DEUX));
		}
		for (int i = 0; i < 2; i++) {
			sacJeton.add(new Jeton(Lettre.G, Points.DEUX));
			sacJeton.add(new Jeton(Lettre.C, Points.TROIS));
			sacJeton.add(new Jeton(Lettre.B, Points.TROIS));
			sacJeton.add(new Jeton(Lettre.P, Points.TROIS));
			sacJeton.add(new Jeton(Lettre.F, Points.QUATRE));
			sacJeton.add(new Jeton(Lettre.H, Points.QUATRE));
			sacJeton.add(new Jeton(Lettre.V, Points.QUATRE));
			sacJeton.add(new Jeton(Lettre.JOKER, Points.ZERO));
		}
		for (int i = 0; i < 1; i++) {
			sacJeton.add(new Jeton(Lettre.J, Points.HUIT));
			sacJeton.add(new Jeton(Lettre.Q, Points.HUIT));
			sacJeton.add(new Jeton(Lettre.K, Points.DIX));
			sacJeton.add(new Jeton(Lettre.W, Points.DIX));
			sacJeton.add(new Jeton(Lettre.X, Points.DIX));
			sacJeton.add(new Jeton(Lettre.Y, Points.DIX));
			sacJeton.add(new Jeton(Lettre.Z, Points.DIX));
		}
	}
	
	public void melangerSac() {
		Collections.shuffle(sacJeton);
	}
	
	public Jeton piocherJeton() throws SacVideException{
        if (sacJeton.isEmpty()) {
        	throw new SacVideException("Le sac est vide impossible de piocher");
        }
		Random rand = new Random();
        return sacJeton.remove(rand.nextInt(sacJeton.size()));
    }
	
	public void afficherMonSacDeJeton() {
		for (int i = 0 ; i < sacJeton.size() ; i++) {
			System.out.print(sacJeton.get(i).toSting()+", ");
		}
	}
	
	public boolean estVide() {
		return sacJeton.isEmpty();	}
	
}
