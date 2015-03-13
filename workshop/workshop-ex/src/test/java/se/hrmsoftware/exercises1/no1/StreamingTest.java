package se.hrmsoftware.exercises1.no1;

import junit.framework.Assert;
import org.junit.Test;


import java.util.List;


import static se.hrmsoftware.exercises1.no1.PersonRepository.getDefaultPeople;
import static se.hrmsoftware.exercises1.no1.Streaming.getNamesSorted;
import static se.hrmsoftware.exercises1.no1.Streaming.getPersonWithGender;
import static se.hrmsoftware.exercises1.no1.Streaming.getTotalAge;

public class StreamingTest {

	@Test
	public void testGetGender() {
		List<Person> persons = getPersonWithGender(getDefaultPeople(), "female");

		for(Person person : persons) {
			Assert.assertEquals(person.getGender(), "female");
		}
	}

	@Test
	public void testTotalAge() {
		int totalAge = getTotalAge(getDefaultPeople());
		Assert.assertEquals(162 , totalAge);
	}

	@Test
	public void testNameSorted() {
		List<String> persons = getNamesSorted(getDefaultPeople());

		Assert.assertEquals(persons.get(0) , "Anna Jult");
		Assert.assertEquals(persons.get(1), "Asa Ramson");
	}
}
