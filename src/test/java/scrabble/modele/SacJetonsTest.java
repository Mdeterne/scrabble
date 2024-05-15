package scrabble.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
		Jeton jeton = null;
		int nbJetonsApresPioche = sacJeton.nbJeton()-1;
		
		try {
			jeton = sacJeton.piocherJeton();
		} catch (SacVideException e) {
			Console.message("le sac de jeton est vide");
		}
		assertEquals(nbJetonsApresPioche,sacJeton.nbJeton());
	}
	
	@Test
	void piocherAlorsQueLeSacEstVide() {
		SacJeton sacJeton = new SacJeton();
		Jeton jeton = null;
		boolean exception = false;
		
		try {
			jeton = sacJeton.piocherJeton();
		} catch (SacVideException e) {
			Console.message("le sac de jeton est vide");
			exception = true;
		}
		
		assertTrue(exception);
	}
}