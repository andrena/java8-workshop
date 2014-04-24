package de.andrena.java8.basics.supplier;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

public class SupplierLoesung {

	private static final Logger logger = Logger.getGlobal();

	@Test
	public void logIfUebung() {
		int x = 1;
		logIf(() -> x > 0, Level.INFO, () -> "X was > 0: " + x);
	}

	static void logIf(Supplier<Boolean> condition, Level level, Supplier<String> messageSupplier) {
		if (logger.isLoggable(level) && condition.get()) {
			logger.log(level, messageSupplier);
		}
	}

}
