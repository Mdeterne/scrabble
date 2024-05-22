package scrabble.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PlateauTest {
	
	@Test
	void doitAjouterUnJeton() {
		Plateau plateau = new Plateau();
		Jeton jeton = new Jeton(Lettre.J, Points.QUATRE);
		Position position = new Position(1, 1);
		plateau.ajouterJeton(jeton, position);
		assertEquals(Lettre.J, plateau.cases[0][0].getJeton().getLettre());
	}
}