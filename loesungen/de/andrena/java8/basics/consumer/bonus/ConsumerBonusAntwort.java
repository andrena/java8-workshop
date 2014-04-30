package de.andrena.java8.basics.consumer.bonus;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.function.Consumer;
import java.util.function.Supplier;

import org.junit.Test;

public class ConsumerBonusAntwort {

	private Object result;

	static <T> void consume(Supplier<? extends T> supplier, Consumer<? super T> consumer) {
		consumer.accept(supplier.get());
	}

	@Test
	public void consumerWirdMitWertAusSupplierAufgerufen() throws Exception {
		Consumer<Object> consumer = s -> result = s;
		Supplier<String> supplier = () -> "Wert";

		consume(supplier, consumer);

		assertThat(result, is("Wert"));
	}
}
