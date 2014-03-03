package de.andrena.java8.streams;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import de.andrena.java8.PersonenGenerator;

public class StreamDemo4 {

	private int counter = 0;

	@Test
	public void abkuerzendeMethodenMuessenNichtAlleElementeImStreamAnschauen() throws Exception {
		boolean esGibtEinenMueller = new PersonenGenerator().generiereStream() //
				.limit(10000) //
				.anyMatch(person -> {
					counter++;
					return "Müller".equals(person.getNachname());
				});

		assertThat(esGibtEinenMueller, is(true));
		assertThat(counter, is(lessThan(10000)));
		System.out.println(counter);
	}

	@Test
	public void andereMethodenMuessenAlleElementeImStreamAnschauen() throws Exception {
		long anzahlMuellers = new PersonenGenerator().generiereStream() //
				.limit(10000) //
				.filter(person -> {
					counter++;
					return "Müller".equals(person.getNachname());
				}).count();

		assertThat(anzahlMuellers, is(greaterThan(0L)));
		assertThat(counter, is(10000));
	}
}
