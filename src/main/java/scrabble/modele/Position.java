package scrabble.modele;

public class Position {
	
	private Integer colonne;
	private Integer ligne;

	public Position(Integer ligne, Integer colonne) {
		this.colonne = colonne;
		this.ligne = ligne;
	}

	public Integer getColonne() {
		return colonne;
	}

	public void setColonne(Integer colonne)  {
		this.colonne = colonne;
	}

	public Integer getLigne() {
		return ligne;
	}

	public void setLigne(Integer ligne) {
		this.ligne = ligne;
	}
}
