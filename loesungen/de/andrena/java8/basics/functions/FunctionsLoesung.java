package de.andrena.java8.basics.functions;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Function;
import java.util.function.Predicate;

import org.junit.Test;

import de.andrena.java8.Person;

public class FunctionsLoesung {

	static <T> void replaceIf(List<T> list, Predicate<T> predicate, Function<T, T> function) {
		for (ListIterator<T> iterator = list.listIterator(); iterator.hasNext();) {
			T value = iterator.next();
			if (predicate.test(value)) {
				iterator.set(function.apply(value));
			}
		}
	}

	@Test
	public void ersetztElementeFuerDiePredicateErfuelltIstMitWertAusFunction() {
		Person antonio = new Person("Antonio", "Calabrese");
		Person julia = new Person("Julia", "Hall");
		Person stefan = new Person("Stefan", "Maier");

		List<Person> personen = Arrays.asList(stefan, julia);

		replaceIf(personen, p -> "Stefan".equals(p.getVorname()), p -> antonio);

		assertThat(personen, contains(antonio, julia));
	}
}
