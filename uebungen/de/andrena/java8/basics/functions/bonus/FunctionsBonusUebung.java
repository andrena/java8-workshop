package de.andrena.java8.basics.functions.bonus;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

public class FunctionsBonusUebung {

	static <A, B> void convertAndConsumeIf(Supplier<A> supplier, Predicate<A> predicate, Function<A, B> function,
			Consumer<B> consumer) {
		// TODO Implementieren
	}

	@Test
	public void consumerWirdAufgerufenWennPredicateErfuelltIst() {
		// TODO Aufrufen & Testen
		// convertAndConsumeIf(...);
	}

	@Test
	public void consumerWirdNichtAufgerufenWennPredicateNichtErfuelltIst() {
		// TODO Aufrufen & Testen
		// convertAndConsumeIf(...);
	}
}
