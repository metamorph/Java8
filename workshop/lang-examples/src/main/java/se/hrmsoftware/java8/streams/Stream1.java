package se.hrmsoftware.java8.streams;

import se.hrmsoftware.java8.lambdas.model.Book;

import java.util.Collection;

import static se.hrmsoftware.java8.lambdas.model.BookShelf.getBooks;

/**
 * Let's use some streams and higher order functions!
 * A stream is what it sounds like, a stream of values, we can apply functions on each element in that stream.
 */
public class Stream1 {

	/**
	 * We use the map function in order to transform each element in the stream from a book to a string (the books
	 * title). Instead of returning stuff here we just print the result.
	 * Notice that we need print the result using a forEach function on the stream. We use method references here!
	 *
	 * @param books the book collection we work on.
	 */

	public static void mappingExample(Collection<Book> books) {
		books.stream().map(Book::getTitle).forEach(System.out::println);
	}

	/**
	 * Filtering on a stream is quite fun ! This particular filtering will find all the books that have the character
	 * 'c' in the title.
	 *
	 * @param books the books to filter on.
	 */
	public static void filterExample(Collection<Book> books) {
		books.stream().filter(b -> b.getTitle().contains("c")).forEach(System.out::println);
	}

	/**
	 * But why not step it up a small notch and do some reducing of a stream, i.e. we produce a single value given all
	 * the elements in the stream. This one here will sum up all the number of pages we have in total on all books
	 * given.
	 *
	 * @param books the books on which we want to sum the number of pages.
	 */
	public static Integer reduceExample(Collection<Book> books) {
		return books.stream().map(Book::getNumPages).reduce(0, (acc, i) -> acc + i);
	}

	public static void main(String[] args) {
		System.out.println("-------------------- Mapping ----------------");
		mappingExample(getBooks());

		System.out.println("\n------------------- Filtering ---------------");
		filterExample(getBooks());

		System.out.println("\n-------------------- Reducing ---------------");
		System.out.println("Number of pages: " + reduceExample(getBooks()));
	}

}
