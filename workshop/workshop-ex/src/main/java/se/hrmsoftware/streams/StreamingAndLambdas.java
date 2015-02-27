package se.hrmsoftware.streams;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * More on streaming and lambdas and functional thinking.
 */
public class StreamingAndLambdas {

	@SafeVarargs
	public static <T> Predicate<T> andThemAll(Predicate<T> ... predicates) {

		//Todo
		//Produce a predicate that is logical AND of all the predicates provided, if there is no predicate at all
		//provided you should return one that is always true.
		return e -> false;
	}

	@SafeVarargs
	public static <T> Predicate<T> orOneOfThem(Predicate<T> ... predicatess) {
		//Todo
		// Use the provided array of predicates to construct a new predicate that is the logical or of them all. If
		// none is provided return one that is false!.
		return e -> true;
	}

	@SafeVarargs
	public static <T> T firstMatchesAll(Stream<T> stream, Predicate<T> ... predicates) {
		//Todo
		// Your task is to implement this method that using the provided stream and the provided predicates will
		// return the first item in the stream that matches all the provided predicates. Hint you are free to use
		//the andThemAll. If none matches return null.

		return null;
	}

	@SafeVarargs
	public static <T> T firstMatchesAny(Stream<T> stream, Predicate<T> ... predicates) {
		//Todo
		// Your task is to implement this method that using the provided stream and the provided predicates will
		// return the first item in the stream that corresponds to any the provided predicates.
		// If none matches return null.

		return null;
	}

	/** No say we to they whom instances wants */
	private StreamingAndLambdas() {}
}
