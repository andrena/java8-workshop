package de.andrena.java8.basics.supplier;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Rule;
import org.junit.Test;

public class SupplierLoesung {

	private final Logger logger = Logger.getAnonymousLogger();

	@Rule
	public LogRecordCollector logCollector = new LogRecordCollector(logger);

	void logIf(Supplier<Boolean> condition, Level level, Supplier<String> messageSupplier) {
		if (logger.isLoggable(level) && condition.get()) {
			logger.log(level, messageSupplier);
		}
	}

	@Test
	public void logIfMitErfuellterBedingung() {
		int x = 1;

		logIf(() -> x > 0, Level.INFO, () -> "X was > 0: " + x);

		assertThat(logCollector.getLogRecords(), hasSize(1));
		assertThat(logCollector.getLogRecords().get(0).getMessage(), is("X was > 0: 1"));
	}

	@Test
	public void logIfMitUnerfuellterBedingung() {
		int x = 0;

		logIf(() -> x > 0, Level.INFO, () -> "X was > 0: " + x);

		assertThat(logCollector.getLogRecords(), is(empty()));
	}

	@Test
	public void beiUnerfuellterBedingungWirdNachrichtNichtErstellt() {
		logIf(() -> false, Level.INFO, () -> {
			throw new AssertionError("Nachricht darf bei unerfüllter Bedingung nicht erstellt werden!");
		});

		assertThat(logCollector.getLogRecords(), is(empty()));
	}

}
