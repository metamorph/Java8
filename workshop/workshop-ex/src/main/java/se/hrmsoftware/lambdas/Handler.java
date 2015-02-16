package se.hrmsoftware.lambdas;

/**
 * A 'functional interface' this can transform a Person reference to a String.
 * <p>
 *
 * @author $Author: $
 */
public interface Handler<Person> {
	String handle(Person p);
}
