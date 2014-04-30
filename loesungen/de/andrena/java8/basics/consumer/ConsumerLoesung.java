package de.andrena.java8.basics.consumer;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.function.Consumer;
import java.util.function.Supplier;

import org.junit.Test;

public class ConsumerLoesung {

	private String result;

	static <T> void consume(Supplier<T> supplier, Consumer<T> consumer) {
		consumer.accept(supplier.get());
	}

	@Test
	public void consumerWirdMitWertAusSupplierAufgerufen() {
		consume(() -> "Wert", s -> result = s);
		assertThat(result, is("Wert"));
	}
}
