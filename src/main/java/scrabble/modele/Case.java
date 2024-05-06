package scrabble.modele;

public class Case {
	
	private Specialite specialite;
	private Boolean presenceJeton = false;

	public Specialite getSpecialite() {
		return specialite;
	}
	
	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}

	public Boolean getPrésenceJeton() {
		return presenceJeton;
	}

	public void setPresenceJeton(Boolean présenceJeton) {
		this.presenceJeton = présenceJeton;
	}

	public Case(Specialite specialite) {
		this.specialite = specialite;
	}

	@Override
	public String toString() {
		return "Case [presenceJeton=" + presenceJeton + "]\n     [specialite=" + specialite + "]";
	}
	
}
