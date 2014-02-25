package de.andrena.java8.intro;

import static java.util.Comparator.comparing;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import de.andrena.java8.Person;

public class SortierungDemo8 {

	@Test
	public void sortierePersonenNachNachname() {

		Person antonio = new Person("Antonio", "Calabrese");
		Person julia = new Person("Julia", "Hall");
		Person stefan = new Person("Stefan", "Maier");

		List<Person> personen = Arrays.asList(stefan, antonio, julia);

		personen.sort(comparing(Person::getNachname));
		assertThat(personen, contains(antonio, julia, stefan));

		// Sortierung in umgekehrter Reihenfolge
		personen.sort(comparing(Person::getNachname).reversed());
		assertThat(personen, contains(stefan, julia, antonio));

		// Sortierung nach Nachname und danach (falls gleich) nach Vorname
		personen.sort(comparing(Person::getNachname).thenComparing(Person::getVorname));
		assertThat(personen, contains(antonio, julia, stefan));
	}
}
