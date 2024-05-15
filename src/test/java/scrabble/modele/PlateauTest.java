package scrabble.modele;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PlateauTest {
	
	@Test
	void nouveauPlateauDoitEtreVide() {
		Plateau plateau = new Plateau();
		assertTrue(plateau.estVide());
	}
	
	@Test
	void remplirMonPlateauDoitMettreDesCases() {
		Plateau plateau = new Plateau();
		plateau.mettreDesCaseDansMonPlateau();
		assertFalse(plateau.estVide());
	}
}
