package se.hrmsoftware.java8.lambdas.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.time.LocalDate.of;

/**
 * A shelf of books.
 */
public class BookShelf {

	private final static List<Book> BOOKS = Collections.unmodifiableList(
			Arrays.asList(
					new Book("Functional Thinking", "Neal Ford", of(2014, 6, 26), 170),
					new Book("Lilla Spöket Laban", "Inger & Lasse Sandberg", of(2015, 4, 1), 45),
					new Book("Minecraft: Bygghandboken", "Isabella Berthagen, Petter Sjölund", of(2014, 7, 16), 120),
					new Book("Elda med ved", "Vincent Thurkettle", of(2013, 9, 5), 79),
					new Book("Clean Code", "Robert C. Martin", of(2009, 4, 26), 201),
					new Book("The Pragmatic Programming", "Andrew Hunt, David Thomas", of(2013, 12, 12), 300)));

	public static List<Book> getBooks() {
		return BOOKS;
	}

}
