package se.hrmsoftware.exercises1.no3;

import java.time.LocalDate;

public class Salary {
	private LocalDate fromDate;
	private LocalDate toDate;
	private double salary;

	public Salary(LocalDate fromDate, LocalDate tomDate, double salary) {
		this.fromDate=fromDate;
		this.toDate= tomDate;
		this.salary=salary;
	}

	public LocalDate getFromDate() { return fromDate; }
	public LocalDate getToDate() { return toDate; }
	public double getSalary() { return salary; }
}
