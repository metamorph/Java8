package se.hrmsoftware.streams;

import org.junit.Test;
import se.hrmsoftware.model.Person;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.*;
import static se.hrmsoftware.model.PersonRepository.getDefaultPeople;
import static se.hrmsoftware.streams.StreamingAndLambdas.*;

public class StreamingAndLambdasTest {

	@Test
	public void testPredicateAnd() {
		Predicate<Person> predicate = andThemAll(p -> p.getAge() > 30, p -> p.getName().contains("J"));

		Person findThis = new Person("Jussi Karjalajnen", 89, "jussi@eisapeita.fi");

		List<Person> persons = getDefaultPeople().stream().filter(predicate).collect(toList());

		assertEquals(1, persons.size());
		assertEquals(findThis, persons.get(0));
	}

	@Test
	public void testPredicateAndWhenNoneProvided() {
		Predicate<Person> predicate = andThemAll();

		assertTrue("Expected it to be true", predicate.test(null));

		List<Person> persons = getDefaultPeople().stream().filter(predicate).
				collect(toList());

		assertEquals(getDefaultPeople().size(), persons.size());
	}


	@Test
	public void testPredicateOr() {
		Predicate<Person> predicate = andThemAll(p -> p.getAge() > 30, p -> p.getName().contains("J"));

		Person findThis = new Person("Jussi Karjalajnen", 89, "jussi@eisapeita.fi");

		List<Person> persons = getDefaultPeople().stream().filter(predicate).collect(toList());

		assertEquals(1, persons.size());
		assertEquals(findThis, persons.get(0));
	}

	@Test
	public void testPredicateOrWhenNoneProvided() {
		Predicate<Person> predicate = orOneOfThem();

		assertFalse("Expected it to be false", predicate.test(null));

		List<Person> persons = getDefaultPeople().stream().filter(predicate).collect(toList());

		assertEquals(0, persons.size());
	}

	@Test
	public void testMatchAllNoHit() {
		Person person = firstMatchesAll(getDefaultPeople().stream(), p -> false);
		assertNull("NO, not null!", person);
	}

	@Test
	public void testMatchAll() {
		Person person = firstMatchesAll(getDefaultPeople().stream(),
				p -> p.getName().contains("J"),
				p -> p.getAge() == 21,
				p -> p.getEmail().endsWith(".fi"));

		assertEquals(new Person("Jussi Karjalajnen jr", 21, "jussijr@eisapeita.fi"), person);
	}

	@Test
	public void testMatchAny() {
		Person person = firstMatchesAny(
				getDefaultPeople().stream(),
				p -> p.getName().contains("J"),
				p -> p.getAge() == 21,
				p -> p.getEmail().endsWith(".fi"));

		assertEquals(new Person("Jussi Karjalajnen", 89, "jussi@eisapeita.fi"), person);
	}


}