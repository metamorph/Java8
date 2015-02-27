package se.hrmsoftware.lambdas;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Functional {

	public static <T> Predicate<T> negate(Predicate<T> predicate) {
		// TODO:
		// A predicate is a Function<T, Boolean> - return a predicate that negates the
		// provided predicate.
		return null;
	}

	public static <A, B, C> BiFunction<A, B, C> flip(BiFunction<B, A, C> fun) {
		// TODO:
		// Return a function that will evaluate 'fun' with its parameters exchanged/swapped.
		return null;
	}

	public static <A, B, C> Function<A, C> compose(Function<A, B> f, Function<B, C> g) {
		// TODO:
		// Return a function that is the result of 'composing' f and g.
		return null;
	}



}
