package se.hrmsoftware.streams;

import se.hrmsoftware.model.Person;

import java.util.*;
import java.util.stream.Stream;

/**
 * More on streams.
 */
public class Streaming3 {


	public static IntSummaryStatistics calculateAgeStats(Stream<Person> people) {
		//Todo
		//Get hold of statistics of peoples age, i.e. min max avg. count of all people of age below 80
		return null;
	}


	public static IntSummaryStatistics calculateNameLengthStats(Stream<Person> people) {
		//Todo
		// Get hold of the statistics of the names of the given people. I.e. given the names of all the people count
		// max min, avg. and sum of all the chars in the names.
		return null;

	}

	public static Map<Boolean, List<Person>> partitionByAgeBetween(Stream<Person> people, int minAge, int maxAge) {
		//Todo
		//Partition the given stream into a map that will map two lists, one that contain all the people that
		//has an age that is within the given min and max age (inclusive), with that it follows that the other
		//list should have all people that doesn't have an age within the given limits.

		return null;
	}

	public static Map<Integer, List<Person>> groupPeopleByAge(Stream<Person> people) {
		//Todo
		//Create a mapping of the people in the stream to their age.

		 return null;
	}


	public static List<Person> sortByAge(Stream<Person> people) {
		//Todo
		//Sort the stream according to age and return a list of the stream.

		return null;
	}
}
