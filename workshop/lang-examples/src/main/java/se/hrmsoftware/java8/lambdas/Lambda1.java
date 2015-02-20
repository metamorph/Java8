package se.hrmsoftware.java8.lambdas;

/**
 * An first example of what a lambda is and how you can reason about it.
 */
public class Lambda1 {

	@FunctionalInterface
	interface IntegerMath {
		int operation(int a, int b);
	}

	public static int operateBinary(int a, int b, IntegerMath op) {
		return op.operation(a, b);
	}

	public static void main(String... args) {

		IntegerMath addition = (a, b) -> a + b;

		IntegerMath subtraction = (a, b) -> a - b;

		System.out.println("40 + 2 = " + operateBinary(40, 2, addition));
		System.out.println("20 - 10 = " + operateBinary(20, 10, subtraction));
	}
}
