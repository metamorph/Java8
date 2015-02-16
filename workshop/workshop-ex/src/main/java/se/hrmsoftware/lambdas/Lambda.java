package se.hrmsoftware.lambdas;

import se.hrmsoftware.model.Person;
import se.hrmsoftware.model.PersonRepository;
import se.hrmsoftware.model.Worker;

import java.util.function.Function;

/**
 * Lambda examples and stuff to test.
 * <p/>
 *
 * @author $Author: $
 */
public class Lambda {

    /**
     * Person repository that can be used to get hold of some data to work on.
     */
    private final PersonRepository repository = new PersonRepository();

    public Function<Person, String> createEmailGetterFunc() {
        //Todo
        //return a function which given a person returns it's email.

        return null;
    }

    public void test1() {
        //Todo
        //You should implement a lambda expression that will print all ages of persons in the
        // repository with age > 30 the ages should be issued as prints to System.out on the
        // format age; so for instance if there are three ages in the list i.e. 34,22 and 83 the
        // resulting prints would end up in a string like "34;83;"

    }


    public Worker workOnPersons() {
        Worker w = new Worker();

        //Todo
        //Register at least two different Handle<Person> implementations on the worker one that
        //prints the email and one that prints a concatenation of the name and the age on the form,
        //Name(age).

        return w;
    }
}
