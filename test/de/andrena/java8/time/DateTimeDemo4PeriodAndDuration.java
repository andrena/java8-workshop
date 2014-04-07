package de.andrena.java8.time;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

public class DateTimeDemo4PeriodAndDuration {

	@Test
	public void period() {
		Period einMonat = Period.ofMonths(1);
		LocalDateTime endeFebruar = LocalDateTime.of(2014, 3, 31, 0, 0).minus(einMonat);
		assertThat(endeFebruar, is(LocalDateTime.of(2014, 2, 28, 0, 0)));
	}

	@Test
	public void duration() {
		Duration einMonat = ChronoUnit.MONTHS.getDuration();
		LocalDateTime endeFebruar = LocalDateTime.of(2014, 3, 31, 0, 0).minus(einMonat);
		assertThat(endeFebruar, is(LocalDateTime.of(2014, 2, 28, 13, 30, 54)));
	}

	@Test
	public void weihnachten() {
		LocalDate weihnachtenDiesesJahr = Year.now().atMonth(Month.DECEMBER).atDay(24);
		Period period = LocalDate.now().until(weihnachtenDiesesJahr);
		System.out.println("Noch " + period.getMonths() + " Monate und " + period.getDays() + " Tage bis Weihnachten");
	}
}
