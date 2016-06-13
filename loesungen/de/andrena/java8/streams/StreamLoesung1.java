package de.andrena.java8.streams;

import static java.util.function.Predicate.isEqual;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.IntSummaryStatistics;
import java.util.stream.Stream;

import org.junit.Test;

import de.andrena.java8.Person;

public class StreamLoesung1 extends TestMit100000Personen {

	@Test
	public void esGibtPersonenMitNachnamenMaier() {

		boolean esGibtPersonenMitNachnamenMaier = newPersonenStream() //
				.map(Person::getNachname) //
				.anyMatch(nachname -> nachname.equals("Maier"));

		assertTrue(esGibtPersonenMitNachnamenMaier);
	}

	@Test
	public void wieVielePersonenGibtEsMitNachnamenMaier() {

		long anzahlPersonenMitNachnamenMaier = newPersonenStream() //
				.map(Person::getNachname) //
				.filter(isEqual("Maier")) //
				.count();

		assertThat(anzahlPersonenMitNachnamenMaier, is(1000L));
	}

	@Test
	public void anzahlVerschiedenerVornamen() {

		long anzahlVerschiedenerVornamen = newPersonenStream() //
				.map(person -> person.getVorname()) //
				.distinct() //
				.count();

		assertThat(anzahlVerschiedenerVornamen, is(559L));
	}

	@Test
	public void esGibtPersonenMitNachnamenMitMehrAls8Zeichen() {

		boolean esGibtPersonenMitNachnamenMitMehrAls8Zeichen = newPersonenStream() //
				.map(Person::getNachname) //
				.mapToInt(String::length) //
				.anyMatch(length -> length > 8);

		assertTrue(esGibtPersonenMitNachnamenMitMehrAls8Zeichen);
	}

	@Test
	public void laengeDerNachnamen() {
		IntSummaryStatistics laengeDerNachnamenStatistik = newPersonenStream() //
				.map(Person::getNachname) //
				.mapToInt(String::length) //
				.summaryStatistics();

		assertThat(laengeDerNachnamenStatistik.getMin(), is(4));
		assertThat(laengeDerNachnamenStatistik.getMax(), is(10));
		assertThat(laengeDerNachnamenStatistik.getAverage(), is(closeTo(5.95, 0.001)));
	}

	private Stream<Person> newPersonenStream() {
		return personen.stream();
	}
}
