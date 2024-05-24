package scrabble.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import scrabble.gui.Console;
import scrabble.utils.SacVideException;

class SacJetonsTest {

	@Test
	void nouveauSacJetonDoitEtreVide() {
		SacJeton sacJeton = new SacJeton();
		assertTrue(sacJeton.estVide());
	}
	
	@Test
	void piocherUnJeton() {
		SacJeton sacJeton = new SacJeton();
		sacJeton.mettreDesJetonDansMonSac();
		int nbJetonsApresPioche = sacJeton.nbJeton()-1;
		
		try {
			sacJeton.piocherJeton();
		} catch (SacVideException e) {
			Console.message("le sac de jeton est vide");
		}
		assertEquals(nbJetonsApresPioche,sacJeton.nbJeton());
	}
	
	@Test
	void piocherAlorsQueLeSacEstVide() {
		SacJeton sacJeton = new SacJeton();
		boolean exception = false;
		
		try {
			sacJeton.piocherJeton();
		} catch (SacVideException e) {
			Console.message("le sac de jeton est vide");
			exception = true;
		}
		
		assertTrue(exception);
	}
	
	@Test
	void doitAjouterUnJeton() {
		SacJeton sacJeton = new SacJeton();
		Jeton jeton = new Jeton(Lettre.N, Points.UN);
		sacJeton.ajouterUnJeton(jeton);
		assertEquals(1, sacJeton.jetons.size());
	}
	
	@Test
	void doitAjouterUneListeDeJetons() {
		SacJeton sacJeton = new SacJeton();
		Jeton jeton1 = new Jeton(Lettre.N, Points.UN);
		Jeton jeton2 = new Jeton(Lettre.O, Points.UN);
		List<Jeton> jetons = new ArrayList<Jeton>();
		jetons.add(jeton1);
		jetons.add(jeton2);
		sacJeton.ajouterUneListeJeton(jetons);
		assertEquals(2, sacJeton.jetons.size());
	}
}