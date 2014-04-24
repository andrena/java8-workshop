package de.andrena.java8.function.suppliers;

import static java.util.stream.Collectors.joining;

import java.util.Map.Entry;
import java.util.Objects;
import java.util.stream.Stream;

import org.junit.Test;

import de.andrena.java8.Person;

public class SupplierDemo3 {

	@Test
	public void mitPerson() {
		Person person = new Person("Stefan", "Maier");
		ueberpruefePerson(person);
	}

	@Test(expected = Exception.class)
	public void ohnePerson() {
		Person person = null;
		ueberpruefePerson(person);
	}

	private void ueberpruefePerson(Person person) {
		String message = "Keine Person\n" + ermittleKomplizierteNachricht();
		Objects.requireNonNull(person, message);
	}

	private static String ermittleKomplizierteNachricht() {
		Stream<Entry<Object, Object>> systemPropertyStream = System.getProperties().entrySet().stream();
		return systemPropertyStream//
				.map(entry -> entry.getKey() + " = '" + entry.getValue() + "'")//
				.collect(joining("\n- ", "System Properties:\n- ", ""));
	}
}
