package se.hrmsoftware.java8.lambdas.model;

import java.time.LocalDate;

/**
 * A small book class.
 */
public class Book {

	private final String title;
	private final String author;
	private final LocalDate released;
	private int numPages;


	public Book(String title, String author, LocalDate released, int numPages) {

		this.title = title;
		this.author = author;
		this.released = released;
		this.numPages = numPages;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public LocalDate getReleased() {
		return released;
	}

	public int getNumPages() {
		return numPages;
	}

	public static int combareByReleaseDate(Book a, Book b) {
		return a.getReleased().compareTo(b.getReleased());
	}

	@Override public String toString() {
		return "Book{" +
				"title='" + title + '\'' +
				", author='" + author + '\'' +
				", released=" + released +
				'}';
	}

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Book book = (Book) o;

		if (author != null ? !author.equals(book.author) : book.author != null)
			return false;
		if (released != null ? !released.equals(book.released) : book.released != null)
			return false;
		if (title != null ? !title.equals(book.title) : book.title != null)
			return false;

		return true;
	}

	@Override public int hashCode() {
		int result = title != null ? title.hashCode() : 0;
		result = 31 * result + (author != null ? author.hashCode() : 0);
		result = 31 * result + (released != null ? released.hashCode() : 0);
		return result;
	}
}
