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

	public Boolean getPresenceJeton() {
		return presenceJeton;
	}

	public void setPresenceJeton(Boolean presenceJeton) {
		this.presenceJeton = presenceJeton;
	}

	public Case(Specialite specialite) {
		this.specialite = specialite;
	}

	@Override
	public String toString() {
		return "Case [presenceJeton=" + presenceJeton + "]\n     [specialite=" + specialite + "]";
	}
	
}
