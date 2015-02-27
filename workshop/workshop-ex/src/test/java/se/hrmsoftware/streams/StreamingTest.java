package se.hrmsoftware.streams;

import org.junit.Test;
import se.hrmsoftware.model.Person;
import se.hrmsoftware.model.PersonRepository;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static se.hrmsoftware.streams.Streaming.*;

public class StreamingTest {

	@Test public void testCountLargerThan23() {
		List<Integer> data = asList(155, 2, 3, 4, 5, 23, 23, 23, 22, 25, 88, 19323, 121, 3, 5);
		assertEquals(5, countLargerThan23(data));
	}

	private void testTransform(Function<List<Person>, List<String>> function) {
		List<Person> persons = PersonRepository.getDefaultPeople();
		List<String> emails = function.apply(persons);

		assertEquals(persons.size(), emails.size());
		persons.forEach((p) -> assertTrue(emails.contains(p.getEmail())));
	}

	@Test public void testTransformFunctional() {
		testTransform(Streaming::transformTest);
	}

	@Test public void testImperativeTransform() {
		testTransform(Streaming2::transformImperatively);
	}

	@Test public void testOddNumbers() {
		List<Integer> oneToTwenty = asList(1, 3, 5, 7, 9, 11, 13, 15, 17, 19);

		List<Integer> result = oddNumbersBetween(1, 20).collect(Collectors.toList());
		result.sort(Integer::compare);
		oneToTwenty.sort(Integer::compare);

		assertEquals(oneToTwenty, result);
	}

	public void testSumOfOddNumbers(BiFunction<Integer, Integer, Integer> function) {
		assertEquals(new Integer(4), function.apply(1, 4));
		assertEquals(new Integer(2500), function.apply(1, 100));
	}

	@Test public void testSumOddNumbersFunctional() {
		testSumOfOddNumbers(Streaming::sumOfOddNumbersBetween);
	}

	@Test public void testSumOddNumbersImperatively() {
		testSumOfOddNumbers(Streaming2::sumOfOddNumbersBetweenImperatively);
	}

	public void testReduce(Function<List<Person>, String> function) {
		String result = function.apply(PersonRepository.getDefaultPeople());
		assertEquals("Jussi Karjalajnen;Jörgen Hult;Jussi Karjalajnen jr;", result);
	}

	@Test public void testReduceFunctional() {
		testReduce(Streaming::reduceToString);
	}

	@Test public void testReduceImperatively() {
		testReduce(Streaming2::reduceToStringImperatively);
	}

	@Test public void testInifinity() {
		List<Long> result = infinitePow2().limit(6).collect(Collectors.toList());
		assertEquals(asList(2L, 4L, 8L, 16L, 32L, 64L), result);
	}

	@Test
	public void testMapFunction() {
		List<String> source = asList("foo", "baaz", "qwerty", ".");
		List<Integer> expected = asList(3, 4, 6, 1);
		Streaming2.Mapper<String, Integer> stringLen = String::length;
		assertEquals(expected, Streaming2.doMap(source, stringLen));
	}

	@Test
	public void testFilterFunction() {
		List<String> source = asList("foo", "baaz", "qwerty", ".");
		List<String> expected = asList("foo", ".");
		Streaming2.Specification<String> isShorterThan4 = (s) -> s.length() < 4;
		assertEquals(expected, Streaming2.doFilter(source, isShorterThan4));
	}

	@Test
	public void testReducerFunction() {
		List<String> source = asList("aaa", "bb", "c", "dddd");
		Integer expected = 11;
		Streaming2.Reducer<String, Integer> sumOfStringLengths = (result, value) -> result + value.length();
		assertEquals(expected, Streaming2.doReduce(source, sumOfStringLengths, 1));

	}

}