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

	public static Integer sumOfOddNumbersBetweenImperatively(int min, int max) {
		//Todo
		//Create the sum of all odd numbers from min to max.
		//Do this imperatively, not using java8 features at all.
		return -1;
	}

	public static String reduceToStringImperatively(List<Person> persons) {
		//Todo
		//given the list of persons, reduce them into a single string of the names provided
		//that the name starts with a J, separate the names with ;.

		//Do this imperatively, not using java8 features at all.
		return "";
	}

	// ------------------ Hack your own map, filter and reduce ------------------------------ //

	/**
	 * Transforms the 'source' list to a new list where each element in the original
	 * list is transformed using the map function.
	 *
	 * @param source the source list.
	 * @param mapper the mapping/transforming function.
	 * @param <T>    .
	 * @param <R>    .
	 * @return the transformed list.
	 */
	public static <T, R> List<R> doMap(List<T> source, Mapper<T, R> mapper) {
		// TODO: Implement the functional 'map' function on your own. Do not use the
		// stream API.

		return Collections.emptyList();
	}

	/**
	 * @param source the source list.
	 * @param filter a specification that defines which elements are included in the result.
	 * @param <T>
	 * @return a List that only contains the elements in 'source' that matches the 'filter'.
	 */
	public static <T> List<T> doFilter(List<T> source, Specification<T> filter) {
		// TODO: Implement a filtering function just as Stream#filter.
		return Collections.emptyList();
	}

	/**
	 * Reduce. a List to a value by applying the 'Reducer' function to each
	 * element in 'source'.
	 *
	 * @param source       .
	 * @param reducer      .
	 * @param initialValue .
	 * @param <T>
	 * @param <R>
	 * @return .
	 */
	public static <T, R> R doReduce(List<T> source, Reducer<T, R> reducer, R initialValue) {
		return null;
	}

	/**
	 * Defines a function (map) that transforms from T -> R.
	 *
	 * @param <T> .
	 * @param <R> .
	 */
	@FunctionalInterface
	public interface Mapper<T, R> {
		R map(T t);
	}

	/**
	 * Defines a predicate funtion that checks if a 'T' matches
	 * a predicate (or 'Specification' from the book 'Domain-driven Design').
	 *
	 * @param <T>
	 */
	@FunctionalInterface
	public interface Specification<T> {
		boolean isSatisfied(T t);
	}

	/**
	 * @param <T>
	 * @param <R>
	 */
	public interface Reducer<T, R> {
		R reduce(R result, T value);
	}

	// --------------------- When you're done - see if you can implement the 'imperative' functions
	// above by defining them in the terms of the map, filter & reduce functions above. --------------- //
}
