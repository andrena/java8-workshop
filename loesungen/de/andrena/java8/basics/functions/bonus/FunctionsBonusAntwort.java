package de.andrena.java8.basics.functions.bonus;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Function;
import java.util.function.Predicate;

import org.junit.Test;

import de.andrena.java8.Person;

public class FunctionsBonusAntwort {

	static <T> void replaceIf(List<T> list, Predicate<? super T> predicate, Function<? super T, T> function) {
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

		List<Person> personen = Arrays.asList(null, julia);

		Predicate<Object> predicate = o -> o == null;
		Function<Object, Person> function = o -> antonio;

		replaceIf(personen, predicate, function);

		assertThat(personen, contains(antonio, julia));
	}
}
