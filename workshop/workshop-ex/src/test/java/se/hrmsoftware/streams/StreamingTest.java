package se.hrmsoftware.streams;

import org.junit.Test;
import se.hrmsoftware.model.Person;
import se.hrmsoftware.model.PersonRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static se.hrmsoftware.streams.Streaming.*;

public class StreamingTest {


    @Test
    public void testCountLargerThan23() {
        List<Integer> data = Arrays.asList(155, 2, 3, 4, 5, 23, 23, 23, 22, 25, 88, 19323, 121, 3, 5);
		assertEquals(5, countLargerThan23(data));
	}

    @Test
    public void testTransform() {
        List<Person> persons = PersonRepository.getDefaultPeople();
		List<String> emails = transformTest(persons);

        assertEquals(persons.size(), emails.size());
        persons.forEach((p) -> assertTrue(emails.contains(p.getEmail())));
    }


    @Test
    public void testOddNumbers() {
        List<Integer> oneToTwenty = Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15, 17, 19);

		List<Integer> result = oddNumbersBetween(1, 20).collect(Collectors.toList());
		result.sort(Integer::compare);
        oneToTwenty.sort(Integer::compare);

        assertEquals(oneToTwenty, result);
    }

    @Test
    public void testSumOfOddNumbers() {
		assertEquals(4, sumOfOddNumbersBetween(1, 4));
		assertEquals(2500, sumOfOddNumbersBetween(1, 100));
	}

    @Test
    public void testReduce() {
		String result = reduceToString(PersonRepository.getDefaultPeople());
		assertEquals("Jussi Karjalajnen;Jörgen Hult", result);
    }

    @Test
    public void testInifinity() {
		List<Long> result = infinitePow2().limit(6).collect(Collectors.toList());
		assertEquals(Arrays.asList(2L, 4L, 8L, 16L, 32L, 64L), result);
    }


}