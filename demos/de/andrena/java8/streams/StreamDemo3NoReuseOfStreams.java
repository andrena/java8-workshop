package de.andrena.java8.streams;

import static de.andrena.java8.PersonenGenerator.personenStream;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.stream.Stream;

import org.junit.Test;

import de.andrena.java8.Person;

public class StreamDemo3NoReuseOfStreams {

	@Test
	public void streamsKoennenNichtWiederverwendetWerden() throws Exception {
		Stream<Person> stream = personenStream().limit(1_000) //
				.filter(person -> "Müller".equals(person.getNachname()));

		assertThat(stream.count(), is(greaterThan(1L)));

		// Stream bereits geschlossen -> schlägt fehl!
		stream.filter(person -> "Hans".equals(person.getVorname()));
	}

	@Test
	public void streamsKoennenNichtWiederverwendetWerden2() throws Exception {
		Stream<Person> stream = personenStream().limit(1_000);

		stream.filter(person -> "Müller".equals(person.getNachname()));

		// stream wurde nicht neu zugewiesen -> schlägt fehl!
		assertThat(stream.count(), is(greaterThan(1L)));
	}
}
