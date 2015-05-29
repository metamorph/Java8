package se.hrmsoftware.exercises1.no6;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

/**
 * See http://www.smashingmagazine.com/2014/07/02/dont-be-scared-of-functional-programming/ for background.
 */
public class Temperatures {

	/**
	 * Take a bunch of data-points {@link CityData} and transforms those to
	 * a set of {@link ChartEntry} that can be used to draw a diagram over how the
	 * population size effects the average temperature in a city.
	 *
	 * @param data the data points.
	 * @return the massaged data.
	 */
	public static Set<ChartEntry> calculateAverageTemperaturByPopulation(Collection<CityData> data) {
		return Collections.emptySet();
	}

	/**
	 * Utility method that might useful ..
	 */
	private static ChartEntry toEntry(CityData data) {
		return null;
	}

	/**
	 * From the list of CityData points, find the city with the population that is 'closest' to the
	 * specified population. If more than one city are equally 'close' to the 'forPopulation' return the
	 * 'smallest' city.
	 * @param data the data points.
	 * @param forPopulation the population for which to find the matching CityEntry
	 * @return a ChartEntry or Optional.empty if no entry can be found.
	 */
	public static Optional<ChartEntry> findAndMapClosestPoint(Collection<CityData> data, int forPopulation) {
		return Optional.empty();
	}

}
