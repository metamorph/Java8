package se.hrmsoftware.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A repository to hold on to people.
 * <p/>
 *
 * @author $Author: $
 */
public class PersonRepository {

    public static List<Person> getDefaultPeople() {
        return new ArrayList<>(defaultPeople);
    }

    private static final List<Person> defaultPeople = Arrays.asList(
            new Person("Urban Hult", 23, "urban@hult.se"),
			new Person("Jussi Karjalajnen", 89, "jussi@eisapeita.fi"),
			new Person("Jörgen Hult", 29, "jorgen@hult.se"),
            new Person("Anna Jult", 21, "anna@jult.se"),
            new Person("Åsa Råmson", 35, "slangpengarnaisjon@regeringen.se"),
			new Person("Jussi Karjalajnen jr", 21, "jussijr@eisapeita.fi"));


    //Mutatable list of people in this repository.
    private final List<Person> people = new ArrayList<>(defaultPeople);

    public PersonRepository() {

    }

    public List<Person> getPeople() {
        return new ArrayList<Person>(people);
    }

    public void addPerson(Person p) {
        people.add(p);
    }

    public void removePerson(Person p) {
        people.remove(p);
    }

}
