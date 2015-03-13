package se.hrmsoftware.exercises1.no3;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;
import static se.hrmsoftware.exercises1.no3.Streaming.*;

public class StreamingTest {

    @Test
    public void testCreateSqlWhereInString() {
        String joinedValues = createSqlWhereInString(Arrays.asList(1, 10, 50, 80, 100, 120, 133, 333), true);
        assertEquals("Unexpected string", "'1', '10', '50', '80', '100', '120', '133', '333'", joinedValues);

        joinedValues = createSqlWhereInString(Arrays.asList(1, 10, 50, 80, 100, 120, 133, 333), false);
        assertEquals("Unexpected string", "1, 10, 50, 80, 100, 120, 133, 333", joinedValues);

        joinedValues = createSqlWhereInString(Arrays.asList("Kalle", "Stina", "Lisa"), true);
        assertEquals("Unexpected string", "'Kalle', 'Stina', 'Lisa'", joinedValues);
    }

    @Test
    public void testGetSalary()
    {
        List<Salary> salaryList = Arrays.asList(
                new Salary(LocalDate.of(2010, 6, 30), LocalDate.of(2012, 7, 1), 30000),
                new Salary(LocalDate.of(2012, 7, 2), LocalDate.of(2013, 7, 25), 35000),
                new Salary(LocalDate.of(2013, 7, 26), LocalDate.of(2014, 6, 29), 40000),
                new Salary(LocalDate.of(2014, 6, 30), null, 50000));

        double salary = getSalary(LocalDate.of(2011, 6, 30), salaryList);
        assertEquals("Unexpected salary", 30000d, salary, 0d);

        salary = getSalary(LocalDate.of(2013, 1, 1), salaryList);
        assertEquals("Unexpected salary", 35000d, salary, 0d);

        salary = getSalary(LocalDate.of(2014, 12, 24), salaryList);
        assertEquals("Unexpected salary", 50000d, salary, 0d);
    }

    @Test
    public void testVerifyValue()
    {
        Predicate<Integer> procentOk = (n) -> n > 0 && n < 100;
        boolean valueOk = verifyValue(95, procentOk);
        assertEquals("Unexpected value", true, valueOk);

        Predicate<String> startsWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourLetterLong = (n) -> n.length() == 4;
        valueOk = verifyValue("Hello world", startsWithJ, fourLetterLong);
        assertEquals("Unexpected value", false, valueOk);

    }
}
