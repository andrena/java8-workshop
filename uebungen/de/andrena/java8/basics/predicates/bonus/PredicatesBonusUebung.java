package de.andrena.java8.basics.predicates.bonus;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

public class PredicatesBonusUebung {

	static <T> void consumeIf(Supplier<T> supplier, Predicate<T> predicate, Consumer<T> consumer) {
		// TODO Implementieren
	}

	@Test
	public void consumerWirdMitWertAusSupplierAufgerufenWennPredicateErfuelltIst() {
		// TODO Test schreiben
	}

	@Test
	public void consumerWirdNichtAufgerufenWennPredicateNichtErfuelltIst() {
		// TODO Test schreiben
	}
}
