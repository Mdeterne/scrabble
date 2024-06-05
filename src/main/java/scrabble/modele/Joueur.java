package scrabble.modele;

public class Joueur {

	String nom;
	Chevalet monChevalet;
	int score;
	
	public Joueur(String nom, Chevalet chevalet) {
		this.nom = nom;
		this.monChevalet = chevalet;
		this.score = 0;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
}
