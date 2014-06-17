package de.andrena.java8.streams;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.function.Predicate;

import org.junit.Test;

import de.andrena.java8.Person;

public class WherePredicateTest {

	@Test
	public void test() throws Exception {
		Predicate<Person> predicate = WherePredicate.where(Person::getVorname).is("Horst");
		assertThat(predicate.test(new Person("Horst", "Kaiser")), is(true));
	}

}
