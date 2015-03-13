package se.hrmsoftware.exercises1.no5;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StreamingTest {
	@Test
	public void testFlatIt() {
		Stream<List<Integer>> stream = Stream.of(Arrays.asList(12), Arrays.asList(2), Arrays.asList(66),
				Arrays.asList(4), Arrays.asList(9), Arrays.asList(1));
		assertEquals(Arrays.asList(12, 2, 66, 4, 9, 1), Streaming4.flatIt(stream));
	}

	@Test
	public void testSumIt() {
		Stream<List<Integer>> stream = Stream.of(Arrays.asList(12), Arrays.asList(2), Arrays.asList(66),
				Arrays.asList(4), Arrays.asList(9), Arrays.asList(1));
		assertEquals(12 + 2 + 66 + 4 + 9 + 1, Streaming4.sumIt(stream));
	}

	@Test
	public void testSupplyMe() {
		assertEquals(10,
				IntStream.generate(Streaming4.supplyMeWithRandomInts()).skip(1000).limit(10).summaryStatistics()
						.getCount());
	}

	@Test
	public void testGetFirst() {
		Supplier<Stream<Integer>> streamSupplier = () -> Stream.of(12, 2, 66, 4, 9, 1);
		assertEquals(Integer.valueOf(66), Streaming4.getFirst(streamSupplier.get(), i -> i == 66).get());
		assertFalse(Streaming4.getFirst(streamSupplier.get(), i -> i == 33).isPresent());
	}

	@Test
	public void testContains() {
		Supplier<Stream<Integer>> streamSupplier = () -> Stream.of(12, 2, 66, 4, 9, 1);
		assertTrue(Streaming4.contains(streamSupplier.get(), 0, 3, 4));
		assertFalse(Streaming4.contains(streamSupplier.get(), 0, 3, 67));
	}
}
