package de.andrena.java8.time;

import static java.time.DayOfWeek.FRIDAY;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalQuery;
import java.util.stream.Stream;

import org.junit.Test;

public class DateTimeDemo2Locals {

	@Test
	public void locals() {
		LocalDate aprilsFool = LocalDate.of(2014, Month.APRIL.getValue(), 1);
		LocalDateTime aprilsFoolLunchTime = aprilsFool.atTime(LocalTime.NOON);

		assertThat(aprilsFoolLunchTime, is(LocalDateTime.of(2014, 4, 1, 12, 00)));

		DayOfWeek dayOfWeek = aprilsFoolLunchTime.getDayOfWeek();
		assertThat(dayOfWeek, is(DayOfWeek.TUESDAY));
	}

	@Test
	public void localsParsed() {
		assertThat(LocalTime.parse("17:42"), is(LocalTime.of(17, 42)));
		assertThat(LocalDate.parse("2014-11-23"), is(LocalDate.of(2014, 11, 23)));
		assertThat(LocalDateTime.parse("2014-11-23T17:42"), is(LocalDateTime.of(2014, 11, 23, 17, 42)));
	}

	@Test
	public void temporalAdjusters() {
		LocalDate nextFriday = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
		assertThat(nextFriday, is(LocalDate.of(2014, 3, 21)));

		LocalDate firstDayOfNextYear = LocalDate.now().with(TemporalAdjusters.firstDayOfNextYear());
		assertThat(firstDayOfNextYear, is(LocalDate.of(2015, 1, 1)));
	}

	@Test
	public void temporalAdjustersCustom() {
		LocalDate nextFriday13th = LocalDate.now().with(nextFridayThirteenth());
		assertThat(nextFriday13th, is(LocalDate.of(2014, 6, 13)));
	}

	private TemporalAdjuster nextFridayThirteenth() {
		return temporal -> Stream.iterate(temporal, t -> t.plus(1, ChronoUnit.DAYS)) //
				.filter(t -> isFridayThirteenth(t)) //
				.findFirst().get();
	}

	private boolean isFridayThirteenth(Temporal temporal) {
		DayOfWeek dayOfWeek = DayOfWeek.from(temporal);
		boolean is13th = temporal.query(is13th());
		return dayOfWeek == FRIDAY && is13th;
	}

	private TemporalQuery<Boolean> is13th() {
		return t -> t.get(ChronoField.DAY_OF_MONTH) == 13;
	}
}
