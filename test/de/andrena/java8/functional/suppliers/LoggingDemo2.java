package de.andrena.java8.functional.suppliers;

import static java.util.stream.Collectors.joining;

import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import org.junit.Test;

public class LoggingDemo2 {

	@Test
	public void loggingOhneLogging() {
		Logger logger = Logger.getGlobal();
		logger.setLevel(Level.SEVERE);
		logger.info(() -> ermittleKomplizierteNachricht());
	}

	private static String ermittleKomplizierteNachricht() {
		Stream<Entry<Object, Object>> systemPropertyStream = System.getProperties().entrySet().stream();
		return systemPropertyStream//
				.map(entry -> entry.getKey() + " = '" + entry.getValue() + "'")//
				.collect(joining("\n- ", "System Properties:\n- ", ""));
	}
}
