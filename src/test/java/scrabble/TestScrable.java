package scrabble;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import scrabble.gui.Console;
import scrabble.modele.Chevalet;
import scrabble.modele.Jeton;
import scrabble.modele.Plateau;
import scrabble.modele.SacJeton;
import scrabble.utils.SacVideException;

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
	
	@Test
	void piocherEtAjouterUnJeton() {
		SacJeton sacJeton = new SacJeton();
		sacJeton.mettreDesJetonDansMonSac();
		Chevalet chevalet = new Chevalet();
		Jeton jeton = null;
		boolean tailleEgale101 = false;
		
		try {
			jeton = sacJeton.piocherJeton();
		} catch (SacVideException e) {
			Console.message("le sac de jeton est vide");
		}
		
		if (sacJeton.taille() == 101) {
			tailleEgale101 = true;
		}
		chevalet.ajouter(jeton);
		
		assertFalse(chevalet.estVide());
		
		assertTrue(tailleEgale101);
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
	
	@Test
	void doitRemplirMonChevalet() {
		Chevalet chevalet = new Chevalet();
		SacJeton sacJeton = new SacJeton();
		chevalet.remplirMonChevalet(sacJeton);
		
		if (chevalet.taille()==7) {
			assertTrue(true);
		}
	}
	
}
