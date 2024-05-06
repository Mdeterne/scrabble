package scrabble.modele;

public class Jeton {
    private Lettre lettre;
    private Points points;

    public Jeton(Lettre lettre, Points points){
    	this.lettre=lettre;
    	this.points=points;
    }
    
    public Lettre getLettre() {
        return lettre;
    }

    public void setLettre(Lettre lettre) {
        this.lettre = lettre;
    }

    public Points getPoints() {
        return points;
    }

    public void setPoints(Points points) {
        this.points = points;
    }
}
