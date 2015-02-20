package se.hrmsoftware.java8.lambdas;

import se.hrmsoftware.java8.lambdas.model.Book;

import java.util.*;

import static se.hrmsoftware.java8.lambdas.model.BookShelf.getBooks;

/**
 * More on lambdas and method references.
 */
public class Lambda2 {


	public static Collection<Book> sortedBookListByReleaseDate(Collection<Book> booksToSort) {
		List<Book> mutateIt = new ArrayList<>(booksToSort);

		Collections.sort(mutateIt, new Comparator<Book>(){
			@Override public int compare(Book o1, Book o2) {
				return o1.getReleased().compareTo(o2.getReleased());
			}
		});

		return mutateIt;
	}


	//The method signature of this invocation of sort is the following:
	//static <T> void sort(T[] a, Comparator<? super T> c)

	// THUS we can do the following:


	public static Collection<Book> sortedBookListByReleaseDate2(Collection<Book> booksToSort) {
		List<Book> mutateIt = new ArrayList<>(booksToSort);

		Collections.sort(mutateIt, (Book o1, Book o2) -> o1.getReleased().compareTo(o2.getReleased()));

		return mutateIt;
	}

	//BUT! there is a method on the Book class that actually does the same comparision, the compareByReleaseDate
	// method. Let's use that!

	public static Collection<Book> sortedBookListByReleaseDate3(Collection<Book> booksToSort) {
		List<Book> mutateIt = new ArrayList<>(booksToSort);

		Collections.sort(mutateIt, Book::combareByReleaseDate);

		return mutateIt;
	}

	public static void main(String[] args) {
		System.out.println(sortedBookListByReleaseDate(getBooks()));

		System.out.println(sortedBookListByReleaseDate2(getBooks()));

		System.out.println(sortedBookListByReleaseDate3(getBooks()));

		//Now this output is quite unreadable so as an exercise you could always map the results from these methods
		//to only contain the title. I.e. it will be a list of titles that is sorted in the order of their release date.

	}
}
