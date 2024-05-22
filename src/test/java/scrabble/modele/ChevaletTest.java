package scrabble.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ChevaletTest {
	
	@Test
	void nouveauChevaletDoitEtreVide() {
		Chevalet chevalet = new Chevalet();
		assertTrue(chevalet.estVide());
	}
	
	@Test
	void doitAjouterUnJeton() {
		SacJeton sacJeton = new SacJeton();
		sacJeton.mettreDesJetonDansMonSac();
		Chevalet chevalet = new Chevalet();
		Jeton jeton = new Jeton(Lettre.J,Points.TROIS);
		chevalet.ajouter(jeton);
		assertFalse(chevalet.estVide());
	}
	
	@Test
	void doitAjouterUneListeDeJetons() {
		SacJeton sacJeton = new SacJeton();
		sacJeton.mettreDesJetonDansMonSac();
		Chevalet chevalet = new Chevalet();
		List<Jeton> jetons = new ArrayList<>();
		Jeton jeton1 = new Jeton(Lettre.N,Points.TROIS);
		jetons.add(jeton1);
		Jeton jeton2 = new Jeton(Lettre.J,Points.TROIS);
		jetons.add(jeton2);
		Jeton jeton3 = new Jeton(Lettre.C,Points.TROIS);
		jetons.add(jeton3);
		chevalet.ajouterUneListeJeton(jetons);
		assertEquals(3,chevalet.nbJeton());
	}
}