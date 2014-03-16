package de.andrena.java8.function.functions;

import static de.andrena.java8.function.functions.FunctionExperiments.FluentFunction.given;
import static de.andrena.java8.function.functions.FunctionExperiments.FluentPredicate.when;
import static java.util.Objects.nonNull;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import org.junit.Test;

import de.andrena.java8.Person;

public class FunctionExperiments {

	@Test
	public void allePersonenMitGeburtsdatumErsetzen() throws Exception {
		Person antonio = new Person("Antonio", "Calabrese");
		Person julia = new Person("Julia", "Hall", LocalDate.of(1978, 3, 25));
		Person stefan = new Person("Stefan", "Maier");

		List<Person> personen = new ArrayList<>(Arrays.asList(antonio, julia, stefan));

		personen.replaceAll(when(Person::getGeburtstag, Objects::nonNull).then(Person::ohneGeburtstag));
		personen.replaceAll(given(Person::getGeburtstag).when(Objects::nonNull).then(Person::ohneGeburtstag));

		assertThat(personen.get(0), is(antonio));
		assertThat(personen.get(1).getVorname(), is("Julia"));
		assertThat(personen.get(1).getGeburtstag(), is(nullValue()));
		assertThat(personen.get(2), is(stefan));
	}

	interface FluentPredicate<T> extends Predicate<T> {

		static <T, R> FluentPredicate<T> when(Function<T, R> feature, Predicate<? super R> predicate) {
			return t -> predicate.test(feature.apply(t));
		}

		default UnaryOperator<T> then(UnaryOperator<T> operator) {
			return t -> test(t) ? operator.apply(t) : t;
		}
	}

	interface FluentFunction<T, R> extends Function<T, R> {

		static <T, R> FluentFunction<T, R> given(Function<T, R> feature) {
			return t -> feature.apply(t);
		}

		default FluentPredicate<T> when(Predicate<? super R> predicate) {
			return t -> predicate.test(apply(t));
		}
	}

	public static void workaroundForSaveActionBug() {
		Objects.nonNull(null);
		nonNull(null);
	}
}
