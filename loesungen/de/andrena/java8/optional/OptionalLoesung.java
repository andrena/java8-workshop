package de.andrena.java8.optional;

import static de.andrena.java8.PersonenGenerator.personenStream;
import static org.hamcrest.Matchers.either;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;

import de.andrena.java8.Person;
import de.andrena.java8.streams.TestMit100000Personen;

public class OptionalLoesung extends TestMit100000Personen {

	@Test
	public void personAusOptionalAuslesen() {
		Optional<Person> einMueller = newPersonenStream()//
				.filter(p -> "Müller".equals(p.getNachname()))//
				.findFirst();

		assertThat(einMueller.isPresent(), is(true));

		Person person = einMueller.get();

		assertThat(person.getNachname(), is("Müller"));
	}

	@Test
	public void defaultWertVerwendenWennKeinePersonGefundenWurde() {
		Optional<Person> person = newPersonenStream()//
				.limit(100)//
				.filter(p -> false)//
				.findFirst();

		Person defaultWert = new Person("John", "Doe");
		Person result = person.orElse(defaultWert);

		assertThat(result, is(defaultWert));
	}

	@Test
	public void personAusgebenFallsVorhanden() {
		Optional<Person> einMueller = newPersonenStream()//
				.filter(p -> "Müller".equals(p.getNachname()))//
				.findFirst();

		einMueller.ifPresent(System.out::println);
	}

	@Test
	public void personAusgebenFallsVornameDaniel() {
		Optional<Person> einMueller = newPersonenStream()//
				.filter(p -> "Müller".equals(p.getNachname()))//
				.findFirst();

		einMueller.filter(p -> "Daniel".equals(p.getVorname())).ifPresent(System.out::println);
	}

	@Test
	public void nachnameOderDefaultWertOhneIfUndGet() {
		Optional<Person> einMueller = newPersonenStream()//
				.filter(p -> "Müller".equals(p.getNachname()))//
				.findFirst();

		String nachname = einMueller.map(Person::getNachname).orElse("Maier");

		assertThat(nachname, is(either(equalTo("Müller")).or(equalTo("Maier"))));
	}

	@Test
	public void befuelltesOptionalSelbstErzeugen() throws Exception {
		Person stefan = new Person("Stefan", "Maier");
		Optional<Person> person = Optional.of(stefan);

		assertTrue(person.isPresent());
	}

	@Test
	public void leeresOptionalSelbstErzeugen() throws Exception {
		Optional<Person> person = Optional.empty();

		assertFalse(person.isPresent());
	}

	@Test
	public void eigeneExceptionWennLeer() {
		Person stefan = new Person("Stefan", "Maier");

		Optional<Person> optional = Optional.of(stefan);
		Person person = optional.orElseThrow(() -> new IllegalArgumentException("Keine Person"));

		assertThat(person, is(stefan));
	}

	private Stream<Person> newPersonenStream() {
		return personenStream().limit(100_000);
	}

}
