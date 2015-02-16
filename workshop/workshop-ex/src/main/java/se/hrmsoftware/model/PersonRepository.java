package se.hrmsoftware.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A repository to hold on to persons.
 * <p/>
 *
 * @author $Author: $
 */
public class PersonRepository {

    public static List<Person> getDefaultPersons() {
        return new ArrayList<>(defaultPersons);
    }

    private static final List<Person> defaultPersons = Arrays.asList(
            new Person("Jussi Karjalajnen", 89, "jussi@eisapeita.fi"),
            new Person("Urban Hult", 23, "urban@hult.se"),
            new Person("Jörgen Hult", 29, "jorgen@hult.se"),
            new Person("Anna Hult", 21, "anna@hult.se"),
            new Person("Åsa Råmson", 35, "slangpengarnaisjon@regeringen.se"));


    //Mutatable list of persons in this repository.
    private final List<Person> persons = new ArrayList<>(defaultPersons);

    public PersonRepository() {

    }

    public List<Person> getPersons () {
        return new ArrayList<Person>(persons);
    }

    public void addPerson(Person p) {
        persons.add(p);
    }

    public void removePerson(Person p) {
        persons.remove(p);
    }

}
