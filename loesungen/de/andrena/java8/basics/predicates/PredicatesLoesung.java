package de.andrena.java8.basics.predicates;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;

import org.junit.Test;

import de.andrena.java8.Person;

public class PredicatesLoesung {

	static <T> void removeIf(Collection<T> collection, Predicate<T> predicate) {
		for (Iterator<T> iterator = collection.iterator(); iterator.hasNext();) {
			if (predicate.test(iterator.next())) {
				iterator.remove();
			}
		}
	}

	@Test
	public void removeWirdNurBeiErfuelltemPredicateAufgerufen() {
		Person julia = new Person("Julia", "Hall");
		Person stefan = new Person("Stefan", "Maier");
		Collection<Person> collection = new ArrayList<>(Arrays.asList(julia, stefan));

		removeIf(collection, p -> "Stefan".equals(p.getVorname()));

		assertThat(collection, contains(julia));
	}
}
