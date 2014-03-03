package de.andrena.java8.streams;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.stream.Stream;

import org.junit.Test;

import de.andrena.java8.Person;
import de.andrena.java8.PersonenGenerator;

public class StreamDemo3 {

	@Test
	public void streamsPipelinesSindLazy() throws Exception {
		Stream<Person> stream = new PersonenGenerator().generiereStream();

		stream = stream.limit(10000).filter(person -> {
			return "Müller".equals(person.getNachname());
		});

		System.out.println("warten");
		Thread.sleep(5 * 1000);
		System.out.println("warten beendet");

		assertThat(stream.count(), is(greaterThan(1L)));
	}
}
