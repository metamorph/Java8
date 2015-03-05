package se.hrmsoftware.java8.streams;

/**
 * Well gottza have them utils classes!
 */
public class Utils {

	public static void sleepHeavily(long delay) {
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			//We were interrupted, so what?
		}
	}
}
