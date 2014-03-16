package de.andrena.java8.functional;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Ignore;
import org.junit.Test;

import de.andrena.java8.Person;

public class PersonFunctionalDemo1 {

	@Ignore("TODO: Nachnamen der Person auslesen")
	@Test
	public void function() {
		Person person = new Person("Albrecht", "Müller");

		Function<Person, String> function = null;
		String result = function.apply(person);

		assertThat(result, is("Müller"));
	}

	@Ignore("TODO: Herausfinden, ob Person mit Nachnamen 'Müller' heißt")
	@Test
	public void predicate() {
		Person person = new Person("Albrecht", "Müller");

		Predicate<Person> predicate = null;
		boolean result = predicate.test(person);

		assertThat(result, is(true));
	}

	@Ignore("TODO: Neue Person mit Nachnamen 'Müller' instantiieren")
	@Test
	public void supplier() {
		Supplier<Person> supplier = null;
		Person result = supplier.get();

		assertThat(result.getNachname(), is("Müller"));
	}

	@Ignore("TODO: Personen aufsammeln")
	@Test
	public void consumer() {
		Set<Person> personen = new HashSet<>();
		Consumer<Person> consumer = null;

		Person person = new Person("Albrecht", "Müller");
		consumer.accept(person);

		assertThat(personen, contains(person));
	}
}
