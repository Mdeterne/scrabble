package scrabble.modele;

public enum Lettre {
	A("A"),
	B("B"),
	C("C"),
	D("D"),
	E("E"),
	F("F"),
	G("G"),
	H("H"),
	I("I"),
	J("J"),
	K("K"),
	L("L"),
	M("M"),
	N("N"),
	O("O"),
	P("P"),
	Q("Q"),
	R("R"),
	S("S"),
	T("T"),
	U("U"),
	V("V"),
	W("W"),
	X("X"),
	Y("Y"),
	Z("Z"),
	JOKER("JOKER");

	private String lettre;

	Lettre(String lettre) {
		this.lettre = lettre ;
	}
	
	public String getLettre() {
        return lettre;
    }
	
	public static Lettre forValue(String valeur) {
        for (Lettre val: values()) {
            if (val.equals(valeur)) {
                return val;
            }
        }
		return null;
    }
}
