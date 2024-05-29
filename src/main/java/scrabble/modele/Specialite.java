package scrabble.modele;

public enum Specialite {
	
	NEUTRE("  "),
	ETOILE("**"),
	MOTTRIPLE("MT"),
	MOTDOUBLE("MD"),
	LETTRETRIPLE("LT"),
	LETTREDOUBLE("LD");
	
	private String specialite;

	Specialite(String specialite) {
		this.specialite = specialite ;
	}
	
	public String getSpecialite() {
        return specialite;
    }
	
}
