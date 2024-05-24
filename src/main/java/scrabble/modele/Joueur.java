package scrabble.modele;

public class Joueur {

	String nom;
	Chevalet monChevalet;
	Integer score = 0;
	
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
