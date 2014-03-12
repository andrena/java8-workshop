package de.andrena.java8.streams;

import static de.andrena.java8.PersonenGenerator.personenStream;
import static java.lang.Math.exp;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

import de.andrena.java8.Person;

@SuppressWarnings("unused")
public class StreamDemo7Parallel {

	private final List<Person> personen = personenStream().limit(100).collect(toList());

	@Test
	public void sequentiell() throws Exception {
		performanceTest("sequentiell", personen.stream(), p -> langsameOperation(p));
	}

	@Test
	public void parallel() throws Exception {
		performanceTest("parallel", personen.parallelStream(), p -> langsameOperation(p));
	}

	private void langsameOperation(Person person) {
		IntStream.range(0, 1_000_000).asDoubleStream().forEach(Math::exp);
	}

	private void performanceTest(String type, Stream<Person> stream, Consumer<? super Person> action) {
		long start = System.currentTimeMillis();

		stream.forEach(action);

		long time = System.currentTimeMillis() - start;

		System.out.println(type + ": " + time);
	}
}
