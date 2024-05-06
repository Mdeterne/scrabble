package scrabble.modele;

public enum Points {
	UN(1),
    DEUX(2),
    TROIS(3),
    QUATRE(4),
    HUIT(8),
    DIX(10),
    ZERO(0);
    
    private final int valeur;

    Points(int valeur) {
        this.valeur = valeur;
    }

    public int getValeur() {
        return valeur;
    }
}
