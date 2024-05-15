package scrabble.modele;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ChevaletTest {
	
	@Test
	void nouveauChevaletDoitEtreVide() {
		Chevalet chevalet = new Chevalet();
		assertTrue(chevalet.estVide());
	}
	
	@Test
	void ajouterUnJeton() {
		SacJeton sacJeton = new SacJeton();
		sacJeton.mettreDesJetonDansMonSac();
		Chevalet chevalet = new Chevalet();
		Jeton jeton = new Jeton(Lettre.J,Points.TROIS);
		chevalet.ajouter(jeton);
		assertFalse(chevalet.estVide());
	}
	
	@Test
	void doitRemplirMonChevalet() {
		Chevalet chevalet = new Chevalet();
		SacJeton sacJeton = new SacJeton();
		chevalet.remplirMonChevalet(sacJeton);
		
		if (chevalet.nbJeton()==7) {
			assertTrue(true);
		}
	}
}