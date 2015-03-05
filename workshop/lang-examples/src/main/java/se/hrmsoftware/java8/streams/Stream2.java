package se.hrmsoftware.java8.streams;

import java.util.List;
import java.util.concurrent.*;

import static java.lang.Math.sqrt;
import static java.util.stream.Collectors.toList;
import static java.util.stream.LongStream.range;
import static se.hrmsoftware.java8.streams.Utils.sleepHeavily;

/**
 * Streaming to illustrate parallel streams.
 */
public class Stream2 {

	public static void sequential1() {
		long start = System.currentTimeMillis();

		List<Long> primes = range(1, 1_000_000).filter(Stream2::isPrime).boxed().collect(toList());

		System.out.println(
				"There are " + primes.size() + " primes calculated in " + (System.currentTimeMillis() - start) + "ms");

	}

	public static void parallell1() {
		long start = System.currentTimeMillis();

		List<Long> primes = range(1, 1_000_000).parallel().filter(Stream2::isPrime).boxed().collect(toList());

		System.out.println(
				"There are " + primes.size() + " primes calculated in " + (System.currentTimeMillis() - start) + "ms");
	}

	public static void parallell2() throws ExecutionException, InterruptedException {
		ForkJoinPool forkJoinPool = new ForkJoinPool(2);
		long start = System.currentTimeMillis();

		List<Long> primes = forkJoinPool.submit(() ->
				range(1, 1_000_000).parallel().filter(Stream2::isPrime).boxed().collect(toList())).get();

		System.out.println(
				"There are " + primes.size() + " primes calculated in " + (System.currentTimeMillis() - start) + "ms");
	}

	public static void parallell3() throws ExecutionException, InterruptedException {
		ForkJoinPool forkJoinPool = new ForkJoinPool(4);
		long start = System.currentTimeMillis();
		List<Long> primes = CompletableFuture.supplyAsync(() ->
				range(1, 1_000_000).parallel().filter(Stream2::isPrime).boxed().collect(toList()), forkJoinPool).get();

		System.out.println(
				"There are " + primes.size() + " primes calculated in " + (System.currentTimeMillis() - start) + "ms");
	}


	private static void runForrestRun() throws InterruptedException {
		ExecutorService es = Executors.newCachedThreadPool();

		// Simulating multiple threads in the system
		// if one of them is executing a long-running task.
		// Some of the other threads/tasks are waiting
		// for it to finish

		int max = 1000;
		es.execute(() -> countPrimes(max, 1000)); //incorrect task will munch on all threads in the pool once started!
		es.execute(() -> countPrimes(max, 0));
		es.execute(() -> countPrimes(max, 0));
		es.execute(() -> countPrimes(max, 0));
		es.execute(() -> countPrimes(max, 0));
		es.execute(() -> countPrimes(max, 0));

		es.shutdown();
		es.awaitTermination(60, TimeUnit.SECONDS);
	}

	private static boolean isPrime(long n) {
		return n > 1 && range(2, (long) sqrt(n)).noneMatch(divisor -> n % divisor == 0);
	}

	/**
	 * Use some cool parallellism to count the number of primes up to a given max. BUT do it really sneaky and sleep
	 * for the specified amount of milliseconds each time a prime is found.
	 * @param max here but no further we'll look for primes.
	 * @param delay take a nap for this long each time we find a prime, its hard work ya know!
	 */
	private static void countPrimes(int max, int delay) {
		System.out.println(range(1, max).parallel().filter(Stream2::isPrime).peek(i -> sleepHeavily(delay)).count());
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		sequential1();

//		parallell1();

//		parallell2();

//		parallell3();

//		runForrestRun();

	}
}


