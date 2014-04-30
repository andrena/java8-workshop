package de.andrena.java8.basics.predicates.bonus;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;

import org.junit.Test;

import de.andrena.java8.Person;

public class PredicatesBonusFrage {

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

		Collection<Person> collection = new ArrayList<>(Arrays.asList(julia, stefan, null));
		Predicate<Object> predicate = o -> o == null;

		// TODO
		// removeIf(collection, predicate);

		assertThat(collection, contains(julia, stefan));
	}
}
