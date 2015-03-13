package se.hrmsoftware.exercises1.no5;

import java.util.List;
import java.util.Optional;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Streaming {
	public static List<Integer> flatIt(Stream<List<Integer>> stream) {
		return null;
	}

	public static int sumIt(Stream<List<Integer>> stream) {
		// TODO: Sum the stream of lists
		return -1;
	}

	public static IntSupplier supplyMeWithRandomInts() {
		// TODO: Return a lambda expression that creates some random ints
		return null;
	}

	public static Optional<Integer> getFirst(Stream<Integer> stream, Predicate<Integer> predicate) {
		// TODO: Get the first record in stream matching the predicate
		return null;
	}

	public static boolean contains(Stream<Integer> stream, Integer... any) {
		// TODO: Return true if the stream contains any of the integers
		return false;
	}
}
