package scrabble.modele;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import scrabble.gui.Console;
import scrabble.utils.SacVideException;

public class SacJeton {
	
	public List<Jeton> jetons;

	public SacJeton(){
        jetons = new ArrayList<>();
    }
	
	public void mettreDesJetonDansMonSac() {
		Image image = new Image("/scrabble/modele/jeton.png");
		ImageView imageVue = new ImageView(image);
		for (int i = 0; i < 15; i++) {
				jetons.add(new Jeton(Lettre.E, Points.UN, imageVue));
		}
		for (int i = 0; i < 9; i++) {
			jetons.add(new Jeton(Lettre.A, Points.UN, imageVue));
		}
		for (int i = 0; i < 8; i++) {
			jetons.add(new Jeton(Lettre.I, Points.UN, imageVue));
		}
		for (int i = 0; i < 6; i++) {
			jetons.add(new Jeton(Lettre.N, Points.UN, imageVue));
			jetons.add(new Jeton(Lettre.O, Points.UN, imageVue));
			jetons.add(new Jeton(Lettre.R, Points.UN, imageVue));
			jetons.add(new Jeton(Lettre.S, Points.UN, imageVue));
			jetons.add(new Jeton(Lettre.T, Points.UN, imageVue));
			jetons.add(new Jeton(Lettre.U, Points.UN, imageVue));
		}
		for (int i = 0; i < 5; i++) {
			jetons.add(new Jeton(Lettre.L, Points.UN, imageVue));
		}
		for (int i = 0; i < 3; i++) {
			jetons.add(new Jeton(Lettre.D, Points.DEUX, imageVue));
			jetons.add(new Jeton(Lettre.M, Points.DEUX, imageVue));
		}
		for (int i = 0; i < 2; i++) {
			jetons.add(new Jeton(Lettre.G, Points.DEUX, imageVue));
			jetons.add(new Jeton(Lettre.C, Points.TROIS, imageVue));
			jetons.add(new Jeton(Lettre.B, Points.TROIS, imageVue));
			jetons.add(new Jeton(Lettre.P, Points.TROIS, imageVue));
			jetons.add(new Jeton(Lettre.F, Points.QUATRE, imageVue));
			jetons.add(new Jeton(Lettre.H, Points.QUATRE, imageVue));
			jetons.add(new Jeton(Lettre.V, Points.QUATRE, imageVue));
			jetons.add(new Jeton(Lettre.JOKER, Points.ZERO, imageVue));
		}
		for (int i = 0; i < 1; i++) {
			jetons.add(new Jeton(Lettre.J, Points.HUIT, imageVue));
			jetons.add(new Jeton(Lettre.Q, Points.HUIT, imageVue));
			jetons.add(new Jeton(Lettre.K, Points.DIX, imageVue));
			jetons.add(new Jeton(Lettre.W, Points.DIX, imageVue));
			jetons.add(new Jeton(Lettre.X, Points.DIX, imageVue));
			jetons.add(new Jeton(Lettre.Y, Points.DIX, imageVue));
			jetons.add(new Jeton(Lettre.Z, Points.DIX, imageVue));
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