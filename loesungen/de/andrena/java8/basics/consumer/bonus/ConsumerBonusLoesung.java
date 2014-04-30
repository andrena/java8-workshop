package de.andrena.java8.basics.consumer.bonus;

import java.util.Arrays;
import java.util.List;

import de.andrena.java8.Person;

public class ConsumerBonusLoesung {

	public static void main(String[] args) {
		Person antonio = new Person("Antonio", "Calabrese");
		Person julia = new Person("Julia", "Hall");
		Person stefan = new Person("Stefan", "Maier");

		List<Person> personen = Arrays.asList(stefan, antonio, julia);

		personen.forEach(System.out::println);
	}
}
