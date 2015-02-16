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

	public static Function<Person, String> createEmailGetterFunc() {
		//Todo
        //return a function which given a person returns it's email.
        return null;
    }

	public static Function<Person, String> createEmailGetterWithNullFunc() {
		// TODO:
		// Return a function that will return the email of a person. If the email
		// is 'null', return 'unknown@domain.com'.
		return null;
	}

	public static String test1(PersonRepository repository) {
		// Todo
		// Implement a lambda expression that will return a String with all ages of persons in the
		// repository with age > 30. The format of the String must be '[age];[age];'
		// So for instance if there are three ages in the list i.e. 34,22 and 83 the
		// result would be "34;22;83;"
		return null;
	}


	public static Worker workOnPersons() {
		Worker w = new Worker();

		// Todo
		// Register at least two different Handle<Person> implementations on the worker. One that
		// outputs the email and one that prints a concatenation of the name and the age on the form:
		// Name(age).

        return w;
    }


}
