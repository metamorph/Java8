package se.hrmsoftware.exercises1.no6;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

import static se.hrmsoftware.exercises1.no6.Temperatures.findAndMapClosestPoint;

public class TemperaturesTest extends TestCase {

	private final List<CityData> input = Arrays.asList(
			new CityData("Alvesta", 5000, -2, 3, 5, 10, 15, 20, 19, 16, 4, 0),
			new CityData("Vislanda", 2000, -5, 5, 7, 12, 17, 22, 21, 18, 6, 2),
			new CityData("Lammhult", 1300, -0, 1, 3, 7, 12, 18, 13, 8, -2, -6),
			new CityData("Stockholm", 9000000, -4, -3, 2, 3, 15, 21, 22, 23, 2, 1, 3, 0));

	private static double averageForPopulation(Collection<ChartEntry> data, int population) {
		return data.stream()
				.filter(e -> e.getPopulation() == population)
				.findFirst()
				.map(ChartEntry::getAverageTemperature)
				.orElseThrow(() -> new IllegalStateException("No entry with population " + population + " found."));
	}

	@Test
	public void testCalculateAverageTemperatureByPopulation() throws Exception {

		Set<ChartEntry> output = Temperatures.calculateAverageTemperaturByPopulation(input);

		// Check data.
		assertEquals(4, output.size());
		assertEquals(9d, averageForPopulation(output, 5000), 0.1);
		assertEquals(10.5d, averageForPopulation(output, 2000), 0.1);
		assertEquals(5.4d, averageForPopulation(output, 1300), 0.1);
		assertEquals(7.08d, averageForPopulation(output, 9000000), 0.1);
	}

	@Test
	public void testFindAndMap() {
		Supplier<RuntimeException> boom = () -> new RuntimeException("boom");

		assertEquals(5.4d, findAndMapClosestPoint(input, 1000).orElseThrow(boom).getAverageTemperature(), 0.01);
		assertEquals(10.5d, findAndMapClosestPoint(input, 3000).orElseThrow(boom).getAverageTemperature(), 0.01);
		assertFalse(findAndMapClosestPoint(Collections.emptyList(), 1300).isPresent());
		assertFalse(findAndMapClosestPoint(input, 3500).isPresent());
	}
}
