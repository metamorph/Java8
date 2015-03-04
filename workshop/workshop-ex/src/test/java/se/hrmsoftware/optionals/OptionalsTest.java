package se.hrmsoftware.optionals;

import junit.framework.TestCase;
import org.junit.Test;

import static se.hrmsoftware.model.OptionalModel.*;

public class OptionalsTest extends TestCase {

	@Test
	public void testSystemPropWithFallback() {
		System.setProperty(Optionals.SYS_PROP, "23");
		assertEquals(23, Optionals.readSystemProperty(12));
		System.clearProperty(Optionals.SYS_PROP);
		assertEquals(12, Optionals.readSystemProperty(12));
	}

	@Test
	public void testAddressReader() {
		assertEquals("secondaryAddress", Optionals.addressOfStandinProjectLeader(new Project(
				new ProjectLeader(new Address("primaryAddress")),
				new ProjectLeader(new Address("secondaryAddress")))));
		assertEquals("primaryAddress", Optionals.addressOfStandinProjectLeader(new Project(
				new ProjectLeader(new Address("primaryAddress")),
				new ProjectLeader(new Address(null)))));
		assertEquals("primaryAddress", Optionals.addressOfStandinProjectLeader(new Project(
				new ProjectLeader(new Address("primaryAddress")),
				new ProjectLeader(null))));
		assertEquals("primaryAddress", Optionals.addressOfStandinProjectLeader(new Project(
				new ProjectLeader(new Address("primaryAddress")),
				null)));
		assertEquals("N/A", Optionals.addressOfStandinProjectLeader(new Project(
				new ProjectLeader(new Address(null)),
				null)));
		assertEquals("N/A", Optionals.addressOfStandinProjectLeader(new Project(
				new ProjectLeader(null),
				null)));
		assertEquals("N/A", Optionals.addressOfStandinProjectLeader(new Project(
				new ProjectLeader(null),
				new ProjectLeader(new Address(null)))));
	}

	@Test
	public void testOptionalStringLength() {
		assertEquals("default", Optionals.checkLengthString(null));
		assertEquals("default", Optionals.checkLengthString("abc"));
		assertEquals("default", Optionals.checkLengthString("abcde"));
		assertEquals("default", Optionals.checkLengthString(" abcde "));
		assertEquals("ABCDEF", Optionals.checkLengthString("abcdef"));
	}

}