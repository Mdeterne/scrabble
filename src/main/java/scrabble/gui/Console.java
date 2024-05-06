package scrabble.gui;

public class Console {

	public static void message(String text) {
	System.out.println(text);
	}

	public static final String SEPARATOR_LINE = "--------------------------------------------";

	public static void titre(String text) {
		message(SEPARATOR_LINE);
		message(text);
		message(SEPARATOR_LINE);
	}

}
