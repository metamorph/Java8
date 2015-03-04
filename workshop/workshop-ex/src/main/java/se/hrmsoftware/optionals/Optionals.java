package se.hrmsoftware.optionals;

import java.util.Optional;

import static se.hrmsoftware.model.OptionalModel.*;

public class Optionals {

	public static final String SYS_PROP = "some.property";

	public static int readSystemProperty(int defaultValue) {
		// TODO:
		// Get a property configuration value
                return -1;
	}

	public static String addressOfStandinProjectLeader(Project project) {
		// TODO:
		// Given a project, return the name of the street where the standin project leader lives. If the street is missing of the
		// standin - return the name of the street of the primary project leader. If that is missing, return "N/A".
                return "";
	}

	public static String checkLengthString(String s) {
		// TODO:
		// If the provided string 's' is null or its length is less then 5 (starting/ending whitespaces not counted)
		// return 'default'. Otherwise return the string in UPPER-CASE.
                return "";
	}
}
