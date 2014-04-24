package de.andrena.java8.streams;

import static java.lang.Math.exp;

import java.util.function.DoubleUnaryOperator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

import org.junit.Test;

@SuppressWarnings("unused")
public class StreamDemo8Parallel {

	private final DoubleStream werte = IntStream.range(0, 20_000_000).asDoubleStream();

	@Test
	public void sequentiell() throws Exception {
		performanceTest(werte.sequential(), Math::exp);
	}

	@Test
	public void parallel() throws Exception {
		performanceTest(werte.parallel(), Math::exp);
	}

	private void performanceTest(DoubleStream stream, DoubleUnaryOperator operator) {
		long start = System.currentTimeMillis();

		stream.map(operator).toArray();

		String type = stream.isParallel() ? "parallel" : "sequentiell";
		long time = System.currentTimeMillis() - start;
		System.out.println(type + ": " + time);
	}
}
