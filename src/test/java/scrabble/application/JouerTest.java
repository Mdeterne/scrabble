package scrabble.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import scrabble.gui.Console;
import scrabble.modele.Chevalet;
import scrabble.modele.Constantes;
import scrabble.modele.SacJeton;
import scrabble.utils.SacVideException;

public class JouerTest {
	@Test
	void doitRemplirMonChevalet() {
		Chevalet chevalet = new Chevalet();
		SacJeton sacJeton = new SacJeton();
		sacJeton.mettreDesJetonDansMonSac();
		try {
			Jouer.remplirChevalet(sacJeton, chevalet);
		} catch (SacVideException e) {
			Console.message("Erreur: Le sac est vide!");
			e.printStackTrace();
		}
		
		assertEquals(Constantes.NBPLACECHEVALET,chevalet.nbJeton());
	}
}
