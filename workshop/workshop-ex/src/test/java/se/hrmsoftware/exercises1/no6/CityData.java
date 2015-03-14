package se.hrmsoftware.exercises1.no6;

import java.util.Collections;
import java.util.List;

/**
 * Some statistics from a City (population and measured temperatures).
 */
public class CityData {
	private final String name;
	private final int population;
	private final List<Integer> temperatures;

	public CityData(String name, int population, List<Integer> temperatures) {
		this.name = name;
		this.population = population;
		this.temperatures = Collections.unmodifiableList(temperatures); // Maintain that immutability!
	}

	public String getName() {
		return name;
	}

	public int getPopulation() {
		return population;
	}

	public List<Integer> getTemperatures() {
		return temperatures;
	}
}
