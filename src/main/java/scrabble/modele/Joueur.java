package scrabble.modele;

public class Joueur {

	String nom;
	Chevalet monChevalet;
	Integer score;
	
	public Joueur(String nom, Chevalet chevalet) {
		this.nom = nom;
		this.monChevalet = chevalet;
		this.score = 0;
	}
	
	public String getNom() {
		return nom;
	}
	
	public Integer getScore() {
		return score;
	}
	
	public void setScore(Integer score) {
		this.score = score;
	}
	
}
