package se.hrmsoftware.lambdas;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

import static se.hrmsoftware.lambdas.Functional.*;

public class FunctionalTest extends TestCase {

	@Test
	public void testNegatePredicate() {
		Predicate<Integer> isLargerThan5 = i -> i > 5;
		Predicate<Integer> isSmallerOrEqualTo5 = negate(isLargerThan5);

		assertTrue(isSmallerOrEqualTo5.test(2));
		assertTrue(isSmallerOrEqualTo5.test(5));
		assertFalse(isSmallerOrEqualTo5.test(7));
	}

	@Test
	public void testFlipped() {
		BiFunction<Integer, Integer, Integer> subtract = (a, b) -> a - b;
		assertEquals(6, subtract.apply(10, 4).intValue());
		assertEquals(-6, flip(subtract).apply(10, 4).intValue());
	}

	@Test
	public void testCompose() {
		Function<Integer, Boolean> isGreaterThan5 = i -> i > 5;
		Function<String, Integer> stringLength = String::length;

		Function<String, Boolean> isStringLongerThan5 = compose(stringLength, isGreaterThan5);

		assertTrue(isStringLongerThan5.apply("123456"));
		assertFalse(isStringLongerThan5.apply("abc"));
	}
}