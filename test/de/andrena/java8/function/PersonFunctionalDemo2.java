package de.andrena.java8.function;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

import de.andrena.java8.Person;

public class PersonFunctionalDemo2 {

	@Test
	public void function() {
		Person person = new Person("Albrecht", "Müller");

		Function<Person, String> function = p -> p.getNachname();
		String result = function.apply(person);

		assertThat(result, is("Müller"));
	}

	@Test
	public void predicate() {
		Person person = new Person("Albrecht", "Müller");

		Predicate<Person> predicate = p -> "Müller".equals(p.getNachname());
		boolean result = predicate.test(person);

		assertThat(result, is(true));
	}

	@Test
	public void supplier() {
		Supplier<Person> supplier = () -> new Person("Albrecht", "Müller");
		Person result = supplier.get();

		assertThat(result.getNachname(), is("Müller"));
	}

	@Test
	public void consumer() {
		Set<Person> personen = new HashSet<>();
		Consumer<Person> consumer = p -> personen.add(p);

		Person person = new Person("Albrecht", "Müller");
		consumer.accept(person);

		assertThat(personen, contains(person));
	}
}
