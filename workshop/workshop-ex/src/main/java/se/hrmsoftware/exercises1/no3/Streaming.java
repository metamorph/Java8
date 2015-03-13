package se.hrmsoftware.exercises1.no3;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

public class Streaming {

    /**
     * Sätt ihop en kommaseparerad sträng med värdena i list. Om strings=true sätt ' runt värdena.
     * @param list
     * @param strings
     * @return
     */
    public static String createSqlWhereInString(List<Object> list, boolean strings){
        return "";
    }

    /**
     * Hämta aktuell lön på dagen date
     * @param date
     * @param salaryList
     * @return
     */
    public static double getSalary(LocalDate date, List<Salary> salaryList)
    {
        return 0;
    }

    /**
     * Verifiera att värdet på value stämmer med villkoren i predicates
     *
     * @param value
     * @param predicates
     * @return
     */
    public static <T> boolean verifyValue(T value, Predicate<T>... predicates)
    {
        return false;
    }
}
