package scrabble;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import scrabble.modele.Chevalet;
import scrabble.modele.Plateau;
import scrabble.modele.SacJeton;

class TestScrable {
	
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
	
	@Test
	void nouveauChevaletDoitEtreVide() {
		Chevalet chevalet = new Chevalet();
		assertTrue(chevalet.estVide());
	}
	
	@Test
	void nouveauSacJetonDoitEtreVide() {
		SacJeton sacJeton = new SacJeton();
		assertTrue(sacJeton.estVide());
	}
	
	
}
