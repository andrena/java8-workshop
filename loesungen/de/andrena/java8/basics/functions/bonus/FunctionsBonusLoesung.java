package de.andrena.java8.basics.functions.bonus;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

public class FunctionsBonusLoesung {

	private Integer result;

	static <A, B> void convertAndConsumeIf(Supplier<A> supplier, Predicate<A> predicate, Function<A, B> function,
			Consumer<B> consumer) {
		A value = supplier.get();
		if (predicate.test(value)) {
			consumer.accept(function.apply(value));
		}
	}

	@Test
	public void consumerWirdAufgerufenWennPredicateErfuelltIst() {
		convertAndConsumeIf(() -> "Wert", s -> s.length() <= 4, s -> s.length(), i -> result = i);
		assertThat(result, is(4));
	}

	@Test
	public void consumerWirdNichtAufgerufenWennPredicateNichtErfuelltIst() {
		convertAndConsumeIf(() -> "Wert", s -> s.length() >= 5, s -> s.length(), i -> result = i);
		assertThat(result, is(nullValue()));
	}
}
