package de.andrena.java8.basics.consumer.bonus;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.function.Consumer;
import java.util.function.Supplier;

import org.junit.Test;

public class ConsumerBonusFrage {

	private Object result;

	// TODO Bessere Signatur
	static <T> void consume(Supplier<T> supplier, Consumer<T> consumer) {
		consumer.accept(supplier.get());
	}

	@Test
	public void consumerWirdMitWertAusSupplierAufgerufen() {
		Consumer<Object> consumer = s -> result = s;
		Supplier<String> supplier = () -> "Wert";

		// TODO
		// consume(supplier, consumer);

		assertThat(result, is("Wert"));
	}
}
