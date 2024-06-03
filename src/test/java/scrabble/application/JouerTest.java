package scrabble.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import scrabble.gui.Console;
import scrabble.modele.Chevalet;
import scrabble.modele.Constantes;
import scrabble.modele.Direction;
import scrabble.modele.Jeton;
import scrabble.modele.Lettre;
import scrabble.modele.Plateau;
import scrabble.modele.Points;
import scrabble.modele.Position;
import scrabble.modele.SacJeton;
import scrabble.utils.SacVideException;

import java.util.ArrayList;
import java.util.List;

class JouerTest {

    private Chevalet chevalet;
    private SacJeton sacJeton;
    private Plateau plateau;

    @BeforeEach
    void setUp() {
        chevalet = new Chevalet();
        sacJeton = new SacJeton();
        sacJeton.mettreDesJetonDansMonSac();
        plateau = new Plateau();
    }

    @Test
    void doitRemplirMonChevalet() {
        try {
            Jouer.remplirChevalet(sacJeton, chevalet);
        } catch (SacVideException e) {
            Console.message("Erreur: Le sac est vide!");
            e.printStackTrace();
        }

        assertEquals(Constantes.NBPLACECHEVALET, chevalet.nbJeton());
    }

    @Test
    void doitLancerUneExceptionSiLeSacEstVide() {
        sacJeton = new SacJeton(); // sac vide

        SacVideException exception = assertThrows(SacVideException.class, () -> {
            Jouer.remplirChevalet(sacJeton, chevalet);
        });

        assertEquals("Le sac est vide impossible de piocher", exception.getMessage());
    }

    @Test
    void doitAjouterUnJetonAuPlateau() {
        Jeton jeton = new Jeton(Lettre.A, Points.UN);
        Position position = new Position(7, 7);

        Jouer.placerUnJeton(jeton, position, plateau);

        assertEquals(Lettre.A.getLettre(), plateau.cases[7][7].getJeton().getLettre());
    }

    @Test
    void doitPlacerUnMotVerticalement() {
    	System.out.println("Verticalement");
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            indices.add(i);
        }

        try {
            Jouer.remplirChevalet(sacJeton, chevalet);
        } catch (SacVideException e) {
            Console.message("Erreur: le sac est vide");
        }

        chevalet.nettoyer();
        chevalet.ajouter(new Jeton(Lettre.A, Points.UN));
        chevalet.ajouter(new Jeton(Lettre.B, Points.TROIS));
        chevalet.ajouter(new Jeton(Lettre.C, Points.TROIS));

        Position position = new Position(7, 7);
        Jouer.placerUnMot(indices, plateau, Direction.BAS, chevalet, position);
        System.out.println("7,7 8,7 9,7");
        assertEquals(Lettre.A.getLettre(), plateau.cases[7][7].getJeton().getLettre());
        assertEquals(Lettre.B.getLettre(), plateau.cases[8][7].getJeton().getLettre());
        assertEquals(Lettre.C.getLettre(), plateau.cases[9][7].getJeton().getLettre());
    }

    @Test
    void doitPlacerUnMotHorizontalement() {
    	System.out.println("Horizontalement");
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            indices.add(i);
        }

        try {
            Jouer.remplirChevalet(sacJeton, chevalet);
        } catch (SacVideException e) {
            e.printStackTrace();
        }

        chevalet.nettoyer();
        chevalet.ajouter(new Jeton(Lettre.A, Points.UN));
        chevalet.ajouter(new Jeton(Lettre.B, Points.TROIS));
        chevalet.ajouter(new Jeton(Lettre.C, Points.TROIS));

        Position position = new Position(7, 7);
        Jouer.placerUnMot(indices, plateau, Direction.DROITE, chevalet, position);
        System.out.println("7,7 7,8 7,9");
        assertEquals(Lettre.A.getLettre(), plateau.cases[7][7].getJeton().getLettre());
        assertEquals(Lettre.B.getLettre(), plateau.cases[7][8].getJeton().getLettre());
        assertEquals(Lettre.C.getLettre(), plateau.cases[7][9].getJeton().getLettre());
    }
}
