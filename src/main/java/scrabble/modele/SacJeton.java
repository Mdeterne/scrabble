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
		for (int i = 0; i < 15; i++) {
				jetons.add(new Jeton(Lettre.E, Points.UN, new ImageView("/scrabble/medias/jetonE.png")));
		}
		for (int i = 0; i < 9; i++) {
			jetons.add(new Jeton(Lettre.A, Points.UN, new ImageView("/scrabble/medias/jetonA.png")));
		}
		for (int i = 0; i < 8; i++) {
			jetons.add(new Jeton(Lettre.I, Points.UN, new ImageView("/scrabble/medias/jetonI.png")));
		}
		for (int i = 0; i < 6; i++) {
			jetons.add(new Jeton(Lettre.N, Points.UN, new ImageView("/scrabble/medias/jetonN.png")));
			jetons.add(new Jeton(Lettre.O, Points.UN, new ImageView("/scrabble/medias/jetonO.png")));
			jetons.add(new Jeton(Lettre.R, Points.UN, new ImageView("/scrabble/medias/jetonR.png")));
			jetons.add(new Jeton(Lettre.S, Points.UN, new ImageView("/scrabble/medias/jetonS.png")));
			jetons.add(new Jeton(Lettre.T, Points.UN, new ImageView("/scrabble/medias/jetonT.png")));
			jetons.add(new Jeton(Lettre.U, Points.UN, new ImageView("/scrabble/medias/jetonU.png")));
		}
		for (int i = 0; i < 5; i++) {
			jetons.add(new Jeton(Lettre.L, Points.UN, new ImageView("/scrabble/medias/jetonL.png")));
		}
		for (int i = 0; i < 3; i++) {
			jetons.add(new Jeton(Lettre.D, Points.DEUX, new ImageView("/scrabble/medias/jetonD.png")));
			jetons.add(new Jeton(Lettre.M, Points.DEUX, new ImageView("/scrabble/medias/jetonM.png")));
		}
		for (int i = 0; i < 2; i++) {
			jetons.add(new Jeton(Lettre.G, Points.DEUX, new ImageView("/scrabble/medias/jetonG.png")));
			jetons.add(new Jeton(Lettre.C, Points.TROIS, new ImageView("/scrabble/medias/jetonC.png")));
			jetons.add(new Jeton(Lettre.B, Points.TROIS, new ImageView("/scrabble/medias/jetonB.png")));
			jetons.add(new Jeton(Lettre.P, Points.TROIS, new ImageView("/scrabble/medias/jetonP.png")));
			jetons.add(new Jeton(Lettre.F, Points.QUATRE, new ImageView("/scrabble/medias/jetonF.png")));
			jetons.add(new Jeton(Lettre.H, Points.QUATRE, new ImageView("/scrabble/medias/jetonH.png")));
			jetons.add(new Jeton(Lettre.V, Points.QUATRE, new ImageView("/scrabble/medias/jetonV.png")));
			jetons.add(new Jeton(Lettre.JOKER, Points.ZERO, new ImageView("/scrabble/medias/jeton.png")));
		}
		for (int i = 0; i < 1; i++) {
			jetons.add(new Jeton(Lettre.J, Points.HUIT, new ImageView("/scrabble/medias/jetonJ.png")));
			jetons.add(new Jeton(Lettre.Q, Points.HUIT, new ImageView("/scrabble/medias/jetonQ.png")));
			jetons.add(new Jeton(Lettre.K, Points.DIX, new ImageView("/scrabble/medias/jetonK.png")));
			jetons.add(new Jeton(Lettre.W, Points.DIX, new ImageView("/scrabble/medias/jetonW.png")));
			jetons.add(new Jeton(Lettre.X, Points.DIX, new ImageView("/scrabble/medias/jetonX.png")));
			jetons.add(new Jeton(Lettre.Y, Points.DIX, new ImageView("/scrabble/medias/jetonY.png")));
			jetons.add(new Jeton(Lettre.Z, Points.DIX, new ImageView("/scrabble/medias/jetonZ.png")));
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