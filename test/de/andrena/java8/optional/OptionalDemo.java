package de.andrena.java8.optional;

import static de.andrena.java8.PersonenGenerator.personenStream;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;
import static org.junit.Assert.assertThat;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.Test;

import de.andrena.java8.Person;

public class OptionalDemo {

	@Test
	public void findetEinePerson() {
		Optional<Person> einMueller = personenStream()//
				.filter(p -> "Müller".equals(p.getNachname()))//
				.findFirst();

		assertThat(einMueller.isPresent(), is(true));
		assertThat(einMueller.get(), isA(Person.class));
		assertThat(einMueller.map(Person::getNachname).orElse("Maier"), is("Müller"));

		einMueller.ifPresent(System.out::println);
	}

	@Test(expected = NoSuchElementException.class)
	public void getWirftExceptionWennKeinWertEnthaltenIst() {
		Optional<Person> person = personenStream()//
				.limit(100)//
				.filter(p -> false)//
				.findFirst();

		assertThat(person.isPresent(), is(false));

		person.get();
	}

	@Test(expected = IllegalArgumentException.class)
	public void eigeneExceptionWennLeer() {
		Optional<Person> optional = Optional.empty();
		optional.orElseThrow(() -> new IllegalArgumentException("Keine Person"));
	}

	@Test
	public void keineExceptionWennBefuellt() {
		Person stefan = new Person("Stefan", "Maier");

		Optional<Person> optional = Optional.of(stefan);
		Person person = optional.orElseThrow(() -> new IllegalArgumentException("Keine Person"));

		assertThat(person, is(stefan));
	}

	@Test
	public void defaultWertMitBefuelltemOptional() {
		Person anton = new Person("Anton", "Mustermann");
		Person stefan = new Person("Stefan", "Maier");

		Optional<Person> optional = Optional.of(anton);
		Person person = optional.orElse(stefan);

		assertThat(person, is(anton));
	}

	@Test
	public void defaultWertMitLeeremOptional() {
		Person stefan = new Person("Stefan", "Maier");

		Optional<Person> optional = Optional.empty();
		Person person = optional.orElse(stefan);

		assertThat(person, is(stefan));
	}

}
