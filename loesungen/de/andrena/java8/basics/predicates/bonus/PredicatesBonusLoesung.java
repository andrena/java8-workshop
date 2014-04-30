package de.andrena.java8.basics.predicates.bonus;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

public class PredicatesBonusLoesung {

	private String result;

	static <T> void consumeIf(Supplier<T> supplier, Predicate<T> predicate, Consumer<T> consumer) {
		T value = supplier.get();
		if (predicate.test(value)) {
			consumer.accept(value);
		}
	}

	@Test
	public void consumerWirdMitWertAusSupplierAufgerufenWennPredicateErfuelltIst() {
		consumeIf(() -> "Wert", s -> s.length() <= 4, s -> result = s);
		assertThat(result, is("Wert"));
	}

	@Test
	public void consumerWirdNichtAufgerufenWennPredicateNichtErfuelltIst() {
		consumeIf(() -> "Wert", s -> s.length() >= 5, s -> result = s);
		assertThat(result, is(nullValue()));
	}
}
