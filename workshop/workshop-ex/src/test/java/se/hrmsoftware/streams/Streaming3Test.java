package se.hrmsoftware.streams;

import org.junit.Test;
import se.hrmsoftware.model.Person;

import java.util.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static se.hrmsoftware.model.PersonRepository.getDefaultPeople;

import static se.hrmsoftware.streams.Streaming3.*;

@SuppressWarnings("ALL") public class Streaming3Test {


	//Some stats
	@Test
	public void testAgeStats() {
		IntSummaryStatistics intStats = calculateAgeStats(getDefaultPeople().stream());

		assertEquals("Unexpected max age", 35, intStats.getMax());
		assertEquals("Unexpected min age", 21, intStats.getMax());
		assertEquals("Unexpected average age", 25, (int) Math.floor(intStats.getAverage()));
		assertEquals("Unexpected count", 6, intStats.getCount());
	}


	//Some stats
	@Test
	public void testNameLengthStats() {
		IntSummaryStatistics intStats = calculateNameLengthStats(getDefaultPeople().stream());

		getDefaultPeople().stream().forEach(p -> System.out.println(p.getName().length()));

		assertEquals("Unexpected max length", 20, intStats.getMax());
		assertEquals("Unexpected min length", 9, intStats.getMin());
		assertEquals("Unexpected average length", 13, (int) Math.floor(intStats.getAverage()));
		assertEquals("Unexpected count", 6, intStats.getCount());
	}


	//Partitioning.
	@Test
	public void testPartitioningPeopleBetween() {

		Map<Boolean, List<Person>> p_20_25 = partitionByAgeBetween(getDefaultPeople().stream(), 20, 25);

		List<Person> personsBetween20_25 = p_20_25.get(true);
		List<Person> personsNot20_25 = p_20_25.get(false);

		assertEquals(personsBetween20_25.size(), 3);

		assertTrue(personsBetween20_25.contains(new Person("Urban Hult", 23, "urban@hult.se")));
		assertTrue(personsBetween20_25.contains(new Person("Anna Jult", 21, "anna@jult.se")));
		assertTrue(personsBetween20_25.contains(new Person("Jussi Karjalajnen jr", 21, "jussijr@eisapeita.fi")));

		assertEquals(personsNot20_25.size(), 3);

		assertTrue(personsNot20_25.contains(new Person("Jussi Karjalajnen", 89, "jussi@eisapeita.fi")));
		assertTrue(personsNot20_25.contains(new Person("Jörgen Hult", 29, "jorgen@hult.se")));
		assertTrue(personsNot20_25.contains(new Person("Åsa Råmson", 35, "slangpengarnaisjon@regeringen.se")));

	}

// Grouping
 	@Test
	public void tesetGroupPeopleByAge() {

		Map<Integer, List<Person>> people = groupPeopleByAge(getDefaultPeople().stream());

		assertEquals(1, people.get(89).size());
		assertEquals(2, people.get(21).size());
		assertEquals(1, people.get(23).size());
		assertEquals(1, people.get(35).size());
		assertEquals(1, people.get(29).size());

	}


	@Test
	public void testSortByAge() {

		List<Person> sorted = Arrays.asList(
				new Person("Anna Jult", 21, "anna@jult.se"),
				new Person("Jussi Karjalajnen jr", 21, "jussijr@eisapeita.fi"),
				new Person("Urban Hult", 23, "urban@hult.se"),
				new Person("Jörgen Hult", 29, "jorgen@hult.se"),
				new Person("Åsa Råmson", 35, "slangpengarnaisjon@regeringen.se"),
				new Person("Jussi Karjalajnen", 89, "jussi@eisapeita.fi"));

		assertEquals(sorted, sortByAge(getDefaultPeople().stream()));

	}
}