package se.hrmsoftware.lambdas;

import org.junit.Test;
import se.hrmsoftware.model.Person;
import se.hrmsoftware.model.PersonRepository;
import se.hrmsoftware.model.Worker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LambdaTest {

	@Test
	public void testEmailGetter() {
		Person person = new Person("Nils", 33, "foo@bar.com");
		assertEquals("foo@bar.com", Lambda.createEmailGetterFunc().apply(person));
	}

	@Test
	public void testEmailGetterForNull() {
		assertEquals("unknown@domain.com", Lambda.createEmailGetterWithNullFunc()
				.apply(new Person("Nils", 33, null)));
		assertEquals("aaa@bbb.com", Lambda.createEmailGetterWithNullFunc()
				.apply(new Person("Nils", 33, "aaa@bbb.com")));
	}

    @Test
	public void testLambda1() {
		String data = Lambda.test1(new PersonRepository());
		String correct = "89;35;";
		assertEquals("Not equal", correct, data);
	}


	@Test
	public void testWorker() {
		Worker w = Lambda.workOnPersons();
		PersonRepository repo = new PersonRepository();

		repo.getPeople().forEach((p) -> {
			String result = w.apply(p);
			String cmp = p.getName() + "(" + p.getAge() + ")";
			assertTrue(">" + cmp + "< is not contained within >" + result + "<", result.contains(cmp));
			assertTrue(">" + p.getEmail() + "< is not contained within >" + result + "<",
					result.contains(p.getEmail()));
		});
	}

}