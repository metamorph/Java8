package se.hrmsoftware.exercises1.no6;

/**
 * A data-point in a chart that shows the average temperature in relation to the
 * population.
 */
public class ChartEntry {
	private final int population;
	private final double averageTemperature;

	public ChartEntry(int population, double averageTemperature) {
		this.population = population;
		this.averageTemperature = averageTemperature;
	}

	public int getPopulation() {
		return population;
	}

	public double getAverageTemperature() {
		return averageTemperature;
	}
}
