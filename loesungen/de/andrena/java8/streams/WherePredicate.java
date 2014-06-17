package de.andrena.java8.streams;

import static java.util.function.Predicate.isEqual;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class WherePredicate<A, B> {

	public static <A, B> WherePredicate<A, B> where(Function<? super A, ? extends B> function) {
		return new WherePredicate<>(function);
	}

	public static <A, B> Predicate<A> where(Function<? super A, ? extends B> function, Predicate<? super B> predicate) {
		return new WherePredicate<A, B>(function).is(predicate);
	}

	private final Function<? super A, ? extends B> function;

	private WherePredicate(Function<? super A, ? extends B> function) {
		this.function = function;
	}

	public Predicate<A> isNull() {
		return is(Objects::isNull);
	}

	public Predicate<A> isNotNull() {
		return is(Objects::nonNull);
	}

	public Predicate<A> is(B value) {
		return is(isEqual(value));
	}

	public Predicate<A> is(Predicate<? super B> predicate) {
		return a -> predicate.test(function.apply(a));
	}
}
