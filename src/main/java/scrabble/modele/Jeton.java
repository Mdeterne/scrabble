package scrabble.modele;

import java.util.Scanner;

public class Jeton {
    private String lettre;
    private int points;

    public Jeton(Lettre lettre, Points points){
    	this.lettre=lettre.getLettre();
    	this.points= points.getValeur();
    }
    
    public String getLettre() {
        return lettre;
    }

    public void setLettre(Lettre lettre) {
        this.lettre = lettre.getLettre();
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
     
	public void attribuerJoker() {
    	Scanner input = new Scanner(System.in);
        System.out.println("Entrer la lettre que vous souhaitez utiliser: ");
        String maLettre = input.nextLine();
        input.close();
        try {
        	Lettre lettreRemplacement=Lettre.valueOf(maLettre.toUpperCase());
        	this.lettre= lettreRemplacement.getLettre();
        }catch (IllegalArgumentException e) {
        	System.out.println("La lettre saisie n'est pas valide");
        }
    	
    }
   
}
