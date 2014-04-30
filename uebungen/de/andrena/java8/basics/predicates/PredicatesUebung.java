package de.andrena.java8.basics.predicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;

import org.junit.Test;

import de.andrena.java8.Person;

public class PredicatesUebung {

	static <T> void removeIf(Collection<T> collection, Predicate<T> predicate) {
		// TODO Implementieren
	}

	@Test
	public void removeWirdNurBeiErfuelltemPredicateAufgerufen() {
		Person julia = new Person("Julia", "Hall");
		Person stefan = new Person("Stefan", "Maier");
		Collection<Person> collection = new ArrayList<>(Arrays.asList(julia, stefan));

		// TODO Aufrufen
		// removeIf(...);

		// TODO Testen
		// assertThat(collection, contains(...));
	}
}
