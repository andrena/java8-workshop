package de.andrena.java8.functional;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import de.andrena.java8.Person;

public class FunctionDemo1 {

	@Test
	public void allePersonenMitGeburtsdatumErsetzen() throws Exception {
		Person antonio = new Person("Antonio", "Calabrese");
		Person julia = new Person("Julia", "Hall", LocalDate.of(1978, 3, 25));
		Person stefan = new Person("Stefan", "Maier");

		List<Person> personen = new ArrayList<>(Arrays.asList(antonio, julia, stefan));

		// TODO Ersetze Personen mit Geburtsdatum durch gleiche Person ohne
		// Geburtsdatum

		assertThat(personen.get(0), is(antonio));
		assertThat(personen.get(1).getVorname(), is("Julia"));
		assertThat(personen.get(1).getGeburtstag(), is(nullValue()));
		assertThat(personen.get(2), is(stefan));
	}
}
