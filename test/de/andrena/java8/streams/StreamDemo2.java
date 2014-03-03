package de.andrena.java8.streams;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.stream.Stream;

import org.junit.Test;

import de.andrena.java8.Person;
import de.andrena.java8.PersonenGenerator;

public class StreamDemo2 {

	@Test
	public void streamsKoennenNichtWiederverwendetWerden() throws Exception {
		Stream<Person> stream = new PersonenGenerator().generiereStream();

		stream.filter(person -> "Müller".equals(person.getNachname()));

		assertThat(stream.count(), is(greaterThan(1L)));
	}

	@Test
	public void streamsKoennenNichtWiederverwendetWerden_Richtig() throws Exception {
		Stream<Person> stream = new PersonenGenerator().generiereStream();

		stream = stream.filter(person -> "Müller".equals(person.getNachname()));

		assertThat(stream.count(), is(greaterThan(1L)));
	}
}
