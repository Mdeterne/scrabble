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
		int nbJetonsApresPioche = sacJeton.taille()-1;
		
		try {
			jeton = sacJeton.piocherJeton();
		} catch (SacVideException e) {
			Console.message("le sac de jeton est vide");
		}
		assertEquals(nbJetonsApresPioche,sacJeton.taille());
	}
	
	@Test
	void piocherAlorsQueLeSacEstVide() throws SacVideException  {
		
		SacJeton sacJeton = new SacJeton();
		if (sacJeton.estVide())
			throw new SacVideException("Le sac est vide, impossible de piocher.");
		Jeton jeton = null;
		boolean exception = false;
		jeton = sacJeton.piocherJeton();
		
		assertTrue(exception);
	}
}