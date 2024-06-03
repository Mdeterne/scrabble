package scrabble.gui;

import java.util.Scanner;

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
	
	public static int entrerNombre() {
		Scanner input = new Scanner(System.in);
		int retour = input.nextInt();
		input.close();
		return retour;
	}

}
