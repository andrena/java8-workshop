package de.andrena.java8.functional.predicates;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import de.andrena.java8.Person;

public class PredicateDemo2 {

	@Test
	public void allePersonenOhneGeburtsdatumEntfernen() throws Exception {
		Person antonio = new Person("Antonio", "Calabrese");
		Person julia = new Person("Julia", "Hall", LocalDate.of(1978, 3, 25));
		Person stefan = new Person("Stefan", "Maier");

		List<Person> personen = new ArrayList<>(Arrays.asList(stefan, antonio, julia));

		for (Iterator<Person> iterator = personen.iterator(); iterator.hasNext();) {
			Person person = iterator.next();
			if (person.getGeburtstag() == null) {
				iterator.remove();
			}
		}

		assertThat(personen, contains(julia));
	}
}
