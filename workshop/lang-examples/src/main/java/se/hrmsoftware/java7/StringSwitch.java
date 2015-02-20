package se.hrmsoftware.java7;

/**
 * Demonstration of the string in switch.
 */
public class StringSwitch {

	private static String switchIt(String input) {
		switch (input) {
			case "one":
				return "1";
			case "two":
				return "2";
			case "three":
				return "3";

			default:
				return "Ah, that I know nothing about!";

		}
	}

	public static void main(String[] args) {
		System.out.println(switchIt("one"));
		System.out.println(switchIt("three"));
		System.out.println(switchIt("two"));
		System.out.println(switchIt("ten"));
	}

}
