package se.hrmsoftware.exercises1.no4;


import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static se.hrmsoftware.exercises1.no4.StreamingVladde.*;

/**
 *
 */
public class StreamingTest {

    @Test
    public void testGetPeopleBornBetween() {
        int minYear = 1940;
        int maxYear = 1970;
        List<Person> persons = getPeopleBornBetween(PersonRepository.getDefaultPeople(), minYear, maxYear);

        for (Person p : persons) {
            int yearOfBirth = Integer.parseInt(p.getBirthDate().substring(0, 4));
            assertEquals((yearOfBirth >= minYear && yearOfBirth <= maxYear), true);
            System.out.println(p.getName() + ":" + p.getBirthDate());
        }
    }

    @Test
    public void testGetBirthYearOfPeople() {
        List<Integer> birthYears = getBirthYearOfPeople(PersonRepository.getDefaultPeople());
        List<Integer> years = asList(1970, 1987, 1995, 2003, 1945, 1984);
        for (int i = 0; i < birthYears.size(); i++) {
            assertEquals(birthYears.get(i), years.get(i));
        }
    }

    @Test
    public void testGetAverageAgeFromPeople() {
        // 45 + 28 + 20 + 12 + 70 + 31 = 34.333332
        float average = 34.333332f;
        float calcAverage = getAverageAgeFromPeople(PersonRepository.getDefaultPeople());
        assertEquals(average, calcAverage, 0.0001f);
    }
}
