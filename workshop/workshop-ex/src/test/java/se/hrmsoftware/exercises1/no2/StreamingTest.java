package se.hrmsoftware.exercises1.no2;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static se.hrmsoftware.exercises1.no2.PersonRepository.getDefaultPeople;
import static se.hrmsoftware.exercises1.no2.Streaming.addTelephoneNumbers;
import static se.hrmsoftware.exercises1.no2.Streaming.occurrenciesOfDigit;
import static se.hrmsoftware.exercises1.no2.Streaming.sortTelephoneNumbers;

/**
 */
public class StreamingTest {

    @Test
    public void testSortTelephoneNumbers() {
        List<String> sorted = sortTelephoneNumbers(getDefaultPeople().stream());

        assertEquals(sorted.get(0), "0651234567");
        assertEquals(sorted.get(1), "0701234567");
        assertEquals(sorted.get(2), "0701243246");
        assertEquals(sorted.get(3), "0742342332");
        assertEquals(sorted.get(4), "0784567894");
        assertEquals(sorted.get(5), "0983123123");
    }

    @Test
    public void testAddTelephoneNumbers() {
        System.out.println(addTelephoneNumbers(getDefaultPeople().stream()));
        assertEquals(addTelephoneNumbers(getDefaultPeople().stream()), 4563745729L);
    }

    @Test
    public void testOccurrenciesOfDigit() {
        assertEquals(occurrenciesOfDigit(getDefaultPeople().stream(), 3), 9);
    }
}
