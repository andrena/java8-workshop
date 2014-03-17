package de.andrena.java8.time;

import static java.time.Instant.now;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

public class DateTimeDemo1Instants {

	@Test
	public void instant() {
		System.out.println("Jetzt:   " + Instant.now());
		System.out.println("In 1 h:  " + now().plus(1, ChronoUnit.HOURS));
		System.out.println("Fix:     " + Instant.ofEpochMilli(0));
	}
}
