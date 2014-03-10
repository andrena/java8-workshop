package de.andrena.java8.streams;

import static de.andrena.java8.PersonenGenerator.personenStream;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import de.andrena.java8.Person;

public class StreamDemo6Parallel {

	private final List<Person> personen = personenStream().limit(1_000_000).collect(toList());

	// TODO sequentiell ist bei mir schneller :(

	@Test
	public void sequentiell() throws Exception {
		long start = System.currentTimeMillis();

		long anzahlMuellers = personen.stream() //
				.filter(person -> person.getNachname().equals("Müller")) //
				.count();
		assertThat(anzahlMuellers, is(9928L));

		long time = System.currentTimeMillis() - start;
		System.out.println("sequentiell: " + time);
	}

	@Test
	public void parallel() throws Exception {
		long start = System.currentTimeMillis();

		long anzahlMuellers = personen.stream() //
				.parallel() //
				.filter(person -> person.getNachname().equals("Müller")) //
				.count();
		assertThat(anzahlMuellers, is(9928L));

		long time = System.currentTimeMillis() - start;
		System.out.println("parallel: " + time);
	}
}
