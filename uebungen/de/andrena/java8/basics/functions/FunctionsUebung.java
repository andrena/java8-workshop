package de.andrena.java8.basics.functions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import org.junit.Test;

import de.andrena.java8.Person;

public class FunctionsUebung {

	static <T> void replaceIf(List<T> list, Predicate<T> predicate, Function<T, T> function) {
		// TODO Implementieren
	}

	@Test
	public void ersetztElementeFuerDiePredicateErfuelltIstMitWertAusFunction() {
		Person antonio = new Person("Antonio", "Calabrese");
		Person julia = new Person("Julia", "Hall");
		Person stefan = new Person("Stefan", "Maier");

		List<Person> personen = Arrays.asList(stefan, julia);

		// TODO Aufrufen
		// replaceIf(...);

		// TODO Testen
		// assertThat(personen, contains(...));
	}
}
