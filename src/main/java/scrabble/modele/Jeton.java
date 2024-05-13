package scrabble.modele;

public class Jeton {
    private Lettre lettre;
    private int points;

    public Jeton(Lettre lettre, Points points){
    	this.lettre=lettre;
    	this.points= points.getValeur();
    }
    
    public Lettre getLettre() {
        return lettre;
    }

    public void setLettre(Lettre lettre) {
        this.lettre = lettre;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(Points points) {
        this.points = points.getValeur();
    }
    
    public String toSting() {
    	return this.lettre + " " + this.points;
    }
    
}
