package se.hrmsoftware.streams;

import se.hrmsoftware.model.Person;

import java.util.Collections;
import java.util.List;

/**
 * As an exercise to see the actual difference in writing code functionally compared to the imperative approach you
 * might be used to, this class contains the same tasks as in the {@link se.hrmsoftware.streams.Streaming} class, but
 * here you should solve them <b>without</b> using any features from Java 8.
 */
public class Streaming2 {

	/**
	 * Mimicing the map behavior.
	 *
	 * @param people list of people to transform.
	 * @return a list of strings containing the email of each person in the provided list.
	 */
	public static List<String> transformImperatively(List<Person> people) {
		//Todo
		//Transform the given list of people into a list of strings containing the email of each person in the list.

		return Collections.emptyList();
	}

	public static String sumOfOddNumbersBetweenImperatively(List<Person> persons) {
		//Todo
		//Using the oddNumbersBetween method above, create the sum of all odd numbers between the given
		//min and max.

		//Do this imperatively, not using java8 features at all.

		return null;
	}

	public static String reduceToStringImperatively(List<Person> persons) {
		//Todo
		//given the list of persons, reduce them into a single string of the names provided
		//that the name starts with a J, separate the names with ;.

		//Do this imperatively, not using java8 features at all.

		return null;
	}


}
