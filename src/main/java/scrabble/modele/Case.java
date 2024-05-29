package scrabble.modele;

public class Case {
	
	private Specialite specialite;
	private Boolean presenceJeton = false;
	private Jeton jeton;

	public Specialite getSpecialite() {
		return specialite;
	}
	
	public String afficherSpecialite() {
		
		String sspecialite = "00";
		if (specialite==Specialite.ETOILE) {
			sspecialite = "**";
		}
		if (specialite == Specialite.LETTREDOUBLE) {
			sspecialite = "LD";
		}
		if (specialite == Specialite.LETTRETRIPLE) {
			sspecialite = "LT";
		}
		if (specialite == Specialite.MOTDOUBLE) {
			sspecialite = "MD";
		}
		if (specialite == Specialite.MOTTRIPLE) {
			sspecialite = "MT";
		}
		return sspecialite;
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

	public Jeton getJeton() {
		return jeton;
	}

	public void setJeton(Jeton jeton) {
		this.jeton = jeton;
	}

	public Case(Specialite specialite) {
		this.specialite = specialite;
	}

	@Override
	public String toString() {
		return "Case [presenceJeton=" + presenceJeton + "]\n     [specialite=" + specialite + "]";
	}
	
}
