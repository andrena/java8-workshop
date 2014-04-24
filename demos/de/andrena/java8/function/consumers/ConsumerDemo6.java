package de.andrena.java8.function.consumers;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import de.andrena.java8.Person;

public class ConsumerDemo6 {

	public static void main(String[] args) {
		Person antonio = new Person("Antonio", "Calabrese");
		Person julia = new Person("Julia", "Hall", LocalDate.of(1978, 3, 25));
		Person stefan = new Person("Stefan", "Maier");

		List<Person> personen = Arrays.asList(antonio, julia, stefan);

		personen.forEach(System.out::println);
	}
}
