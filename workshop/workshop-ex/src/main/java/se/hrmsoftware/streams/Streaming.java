package se.hrmsoftware.streams;

import se.hrmsoftware.model.Person;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Explore the world of java 8 streams! And be on your way to functional programming in just a sec.
 *
 * @author $Author: $
 */
public class Streaming {

	public static long countLargerThan23(List<Integer> integers) {
		//Todo
		//Using the stream api, count all elements larger than 23 in the list

		return integers.stream().filter(i -> i > 23).count();
	}

	public static List<String> transformTest(List<Person> people) {
		//Todo
		//Using the result of the method Lambda#createEmailGetterFunc() above transform the given list of persons
		// into a list of strings containing the email of each person in the list.
		return people.stream().map(Person::getEmail).collect(Collectors.toList());
	}

	public static java.util.stream.Stream<Integer> oddNumbersBetween(int min, int max) {
		//Todo
		//Using streams and functional style programming with lambdas create a stream
		//of all the odd numbers between low and high.

		return IntStream.range(min, max).filter(i -> i % 2 != 0).boxed();

	}

	public static int sumOfOddNumbersBetween(int min, int max) {
		//Todo
		//Using the oddNumbersBetween method above, create the sum of all odd numbers between the given
		//min and max.

		return oddNumbersBetween(min, max).mapToInt(Integer::intValue).sum();

	}

	public static String reduceToString(List<Person> persons) {
		//Todo
		//given the list of persons, reduce them into a single string of the names provided
		//that the name starts with a J, separate the names with ;.

		return persons.stream().map(Person::getName).filter(s -> s.startsWith("J")).reduce("", (r, s) -> r + s + ";");
	}

	public static java.util.stream.Stream<Long> infinitePow2() {
		//Todo
		//implement an infinite stream which will produce the 2^n starting from 1.
		return Stream.iterate(2L, v -> v * 2);
	}


}
