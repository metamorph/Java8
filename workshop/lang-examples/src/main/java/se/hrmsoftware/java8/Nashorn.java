package se.hrmsoftware.java8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Show some java script evaluations using the nashorn engine.
 */
public class Nashorn {

	public static void main(String... args) throws ScriptException {
		ScriptEngineManager engineManager = new ScriptEngineManager();
		ScriptEngine engine = engineManager.getEngineByName("nashorn");

		engine.eval("function subtract(a, b) { return a - b; }");
		engine.eval("function sum(a, b) { return a + b; }");

		System.out.println(engine.eval("sum(subtract(1, 2), 4);"));
	}
}
