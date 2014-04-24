package de.andrena.java8.basics.supplier;

import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

public class SupplierFrage {

	/**
	 * Wie kann man das gleiche erreichen, ohne ein `if`-Statement zu verwenden?
	 */
	@Test
	public void frage() {
		Logger logger = Logger.getGlobal();
		if (logger.isLoggable(Level.INFO)) {
			logger.info(ermittleKomplizierteNachricht());
		}
	}

	private static String ermittleKomplizierteNachricht() {
		List<String> entriesAlsString = new LinkedList<>();
		for (Entry<Object, Object> entry : System.getProperties().entrySet()) {
			entriesAlsString.add("- " + entry.getKey() + " = '" + entry.getValue() + "'");
		}
		return "\n" + String.join("\n", entriesAlsString);
	}

}
