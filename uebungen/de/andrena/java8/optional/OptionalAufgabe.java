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

public class OptionalAufgabe extends TestMit100000Personen {

	@Test
	public void personAusOptionalAuslesen() {
		Optional<Person> einMueller = newPersonenStream()//
				.filter(p -> "Müller".equals(p.getNachname()))//
				.findFirst();

		assertThat(einMueller.isPresent(), is(true));

		Person person = null; // TODO Person aus einMueller auslesen

		assertThat(person.getNachname(), is("Müller"));
	}

	@Test
	public void defaultWertVerwendenWennKeinePersonGefundenWurde() {
		Optional<Person> person = newPersonenStream()//
				.limit(100)//
				.filter(p -> false)//
				.findFirst();

		Person defaultWert = new Person("John", "Doe");
		Person result = null; // TODO Person aus Optional oder Default-Wert zuweisen

		assertThat(result, is(defaultWert));
	}

	@Test
	public void personAusgebenFallsVorhanden() {
		Optional<Person> einMueller = newPersonenStream()//
				.filter(p -> "Müller".equals(p.getNachname()))//
				.findFirst();

		// TODO Person aus Optional ausgeben
	}

	@Test
	public void personAusgebenFallsVornameDaniel() {
		Optional<Person> einMueller = newPersonenStream()//
				.filter(p -> "Müller".equals(p.getNachname()))//
				.findFirst();

		// TODO Person aus Optional ausgeben, falls sie mit Vornamen "Daniel" heißt
	}

	@Test
	public void nachnameOderDefaultWertOhneIfUndGet() {
		Optional<Person> einMueller = newPersonenStream()//
				.filter(p -> "Müller".equals(p.getNachname()))//
				.findFirst();

		String nachname = null; // TODO Nachname der Person oder Default-Wert "Maier" zuweisen

		assertThat(nachname, is(either(equalTo("Müller")).or(equalTo("Maier"))));
	}

	@Test
	public void befuelltesOptionalSelbstErzeugen() throws Exception {
		Person stefan = new Person("Stefan", "Maier");
		Optional<Person> person = null; // TODO Befülltes Optional erzeugen

		assertTrue(person.isPresent());
	}

	@Test
	public void leeresOptionalSelbstErzeugen() throws Exception {
		Optional<Person> person = null; // TODO Leeres Optional erzeugen

		assertFalse(person.isPresent());
	}

	@Test
	public void eigeneExceptionWennLeer() {
		Person stefan = new Person("Stefan", "Maier");

		Optional<Person> optional = Optional.of(stefan);

		// TODO Person auslesen oder IllegalArgumentException werfen, wenn das Optional leer ist
		Person person = null;

		assertThat(person, is(stefan));
	}

	private Stream<Person> newPersonenStream() {
		return personenStream().limit(100_000);
	}

}
