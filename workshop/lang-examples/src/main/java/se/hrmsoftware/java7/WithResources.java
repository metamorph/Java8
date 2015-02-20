package se.hrmsoftware.java7;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Demonstrate new features introduced in Java7 in the IO-department.
 */
public class WithResources {

	/**
	 * Write a row to a file.
	 */
	static void example1() {
		try (FileWriter wr = new FileWriter("out.data")) {
			wr.write("A row, ");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Read data
	 * @param con the database connection.
	 */
	static void example2(Connection con) {
		try (Statement stm = con.createStatement()) {
			ResultSet resultSet = stm.executeQuery("Select * from table1");

			while(resultSet.next()) {
				System.out.println(resultSet.getString("column1"));
			}

		}
		catch (SQLException  e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		example1();
	}
}
