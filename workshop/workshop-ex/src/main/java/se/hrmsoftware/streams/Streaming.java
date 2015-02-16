package se.hrmsoftware.streams;

import se.hrmsoftware.lambdas.Lambda;
import se.hrmsoftware.model.Person;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * Explore the world of java 8 streams! And be on your way to functional programming in just a sec.
 *
 * @author $Author: $
 */
public class Streaming {

	public long countLargerThan23(List<Integer> integers) {
		//Todo
		//Using the stream api, count all elements larger than 23 in the list

		return -1;
	}

	public List<String> transformTest(List<Person> persons) {
		//Todo
		//Using the result of the method Lambda#createEmailGetterFunc() above transform the given list of persons
		// into a list of strings containing the email of each person in the list.
		Lambda l = new Lambda();

		return Collections.emptyList();
	}

	public java.util.stream.Stream<Integer> oddNumbersBetween(int min, int max) {
		//Todo
		//Using streams and functional style programming with lambdas get hold of a list
		//of all the odd numbers between low and high.
		return null;
	}

	public int sumOfOddNumbersBetween(int min, int max) {
		//Todo
		//Using the oddNumbersBetween method above, create the sum of all odd numbers between the given
		//min and max.

		return -1;
	}

	public String reduceToString(List<Person> persons) {
		//Todo
		//given the list of persons, reduce them into a single string of the names provided
		//that the name starts with a J, separate the names with ;.

		return null;
	}

	public java.util.stream.Stream<Long> infinitePow2() {
		//Todo
		//implement an infinite stream which will produce the 2^n starting from 1.
		return Stream.iterate(2L, n -> n * 2);
	}
}
