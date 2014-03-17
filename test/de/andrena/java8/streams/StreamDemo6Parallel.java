package de.andrena.java8.streams;

import static de.andrena.java8.PersonenGenerator.personenStream;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import de.andrena.java8.Person;

public class StreamDemo6Parallel {

	private final List<Person> personen = personenStream().limit(1_000_000).collect(toList());

	@Test
	public void sequentiell() throws Exception {
		performanceTest(personen.stream());
	}

	@Test
	public void parallel() throws Exception {
		performanceTest(personen.stream().parallel());
	}

	private void performanceTest(Stream<Person> stream) {
		long start = System.currentTimeMillis();

		long anzahlMuellers = stream //
				.filter(person -> "Müller".equals(person.getNachname())) //
				.count();
		assertThat(anzahlMuellers, is(9928L));

		long time = System.currentTimeMillis() - start;
		String type = stream.isParallel() ? "parallel" : "sequentiell";
		System.out.println(type + ": " + time);
	}
}
