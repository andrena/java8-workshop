package de.andrena.java8.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

import org.junit.Test;

public class DateTimeDemo3Zoned {

	@Test
	public void zoneIds() {
		ZoneId.getAvailableZoneIds().stream().sorted().forEach(System.out::println);
	}

	@Test
	public void fromLocalDateTime() {
		LocalDate date = LocalDate.of(2014, 3, 18);
		LocalTime time = LocalTime.of(18, 30);
		LocalDateTime local = LocalDateTime.of(date, time);

		System.out.println(local.atZone(ZoneId.systemDefault()));
		System.out.println(local.atZone(ZoneOffset.ofHours(2)));
		System.out.println(local.atZone(ZoneId.of("Jamaica")));
		System.out.println(local.atZone(ZoneId.systemDefault()).toInstant().atZone(ZoneId.of("Jamaica")));
	}
}
