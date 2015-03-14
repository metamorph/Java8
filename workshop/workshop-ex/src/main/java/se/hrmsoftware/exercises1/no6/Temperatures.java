package se.hrmsoftware.exercises1.no6;

import java.util.Collection;
import java.util.HashSet;
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
	public static Set<ChartEntry> calculateAverageTemperatureByPopulation(Collection<CityData> data) {
		// TODO:  This works, but it's not very pretty. Rewrite to a more functional design!
		Set<ChartEntry> result = new HashSet<>();
		for (CityData cityData : data) {
			int runningSum = 0;
			for (Integer temp : cityData.getTemperatures()) {
				runningSum += temp;
			}
			result.add(new ChartEntry(cityData.getPopulation(),
					((double) runningSum / cityData.getTemperatures().size())));
		}

		return result;
	}


}
