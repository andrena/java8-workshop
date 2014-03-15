package de.andrena.java8.streams;

import static de.andrena.java8.PersonenGenerator.personenStream;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class StreamDemo4PipelinesShortcuts {

	private int counter = 0;

	@Test
	public void abkuerzendeMethodenMuessenNichtAlleElementeImStreamAnschauen() throws Exception {
		boolean esGibtEinenMueller = personenStream() //
				.limit(10_000) //
				.anyMatch(person -> {
					counter++;
					return "Müller".equals(person.getNachname());
				});

		assertThat(esGibtEinenMueller, is(true));
		assertThat(counter, is(lessThan(10_000)));
		System.out.println(counter);
	}

	@Test
	public void andereMethodenMuessenAlleElementeImStreamAnschauen() throws Exception {
		long anzahlMuellers = personenStream() //
				.limit(10_000) //
				.filter(person -> {
					counter++;
					return "Müller".equals(person.getNachname());
				}).count();

		assertThat(anzahlMuellers, is(greaterThan(0L)));
		assertThat(counter, is(10_000));
	}
}
