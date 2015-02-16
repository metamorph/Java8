package se.hrmsoftware.model;

import se.hrmsoftware.lambdas.Handler;

import java.util.ArrayList;
import java.util.List;

/**
 * A worker that you can registers person handlers on. Then Person objects can be sent to each
 * handler in sequence, however if any fails the entire call fails.
 * <p>
 *
 * @author $Author: $
 */
public class Worker {

    private List<Handler<Person>> handlers = new ArrayList<>();

    public void registerHandler(Handler<Person> h) {
        handlers.add(h);
    }

    public void onEvent(Person person) {
        handlers.forEach(h -> h.handle(person));
    }
}

