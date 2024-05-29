package scrabble.modele;

public enum Direction {

	DROITE("DROITE"),
	BAS("BAS");
	
	private String direction;

	Direction(String direction) {
		this.direction = direction ;
	}
	
	public String getLettre() {
        return direction;
    }
	
}
