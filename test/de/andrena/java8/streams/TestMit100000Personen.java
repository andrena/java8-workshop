package de.andrena.java8.streams;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.junit.Before;

import de.andrena.java8.Person;
import de.andrena.java8.PersonenGenerator;

public class TestMit100000Personen {

	protected List<Person> personen;

	@Before
	public void setUp() throws Exception {
		personen = new PersonenGenerator().generiereStream().limit(100_000).collect(toList());
	}
}
