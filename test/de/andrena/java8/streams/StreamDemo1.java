package de.andrena.java8.streams;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import de.andrena.java8.Person;
import de.andrena.java8.PersonenGenerator;

public class StreamDemo1 {

	@Test
	public void collectionStreamsSindNichtEntlos() throws Exception {

		Person antonio = new Person("Antonio", "Calabrese");
		Person julia = new Person("Julia", "Hall");
		Person stefan = new Person("Stefan", "Maier");
		List<Person> personenListe = Arrays.asList(antonio, julia, stefan);

		Stream<Person> stream = personenListe.stream();

		assertThat(stream.count(), is(3L));
	}

	@Test
	public void streamsSindPotentiellEndlos() throws Exception {
		Stream<Person> stream = new PersonenGenerator().generiereStream();

		assertThat(stream.count(), is(greaterThan(3L)));
	}
}
