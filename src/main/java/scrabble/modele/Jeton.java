package scrabble.modele;

import java.util.Scanner;
import javafx.scene.image.ImageView;
import scrabble.gui.Console;

public class Jeton {
    private String lettre;
    private int points;
    private ImageView imageVue;

    public Jeton(Lettre lettre, Points points, ImageView imageVue){
    	this.lettre=lettre.getLettre();
    	this.points= points.getValeur();
    	this.imageVue = imageVue;
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
        Console.message("Entrer la lettre que vous souhaitez utiliser: ");
        String maLettre = input.nextLine();
        input.close();
        try {
        	Lettre lettreRemplacement=Lettre.valueOf(maLettre.toUpperCase());
        	this.lettre= lettreRemplacement.getLettre();
        }catch (IllegalArgumentException e) {
        	Console.message("La lettre saisie n'est pas valide");
        } 
    }
	
	public ImageView getImageView() {
	    return this.imageVue;
	}
   
}
