package de.andrena.java8.time;

import static de.andrena.java8.PersonenGenerator.personenStream;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import de.andrena.java8.Person;

public class DateTimeLoesungen {

	@Test
	public void anzahlPersonenGeborenAmFreitagDer13te() {
		Predicate<LocalDate> isAtFriday = date -> date.getDayOfWeek() == DayOfWeek.FRIDAY;
		Predicate<LocalDate> isAt13th = date -> date.getDayOfMonth() == 13;
		long anzahlPersonenGeborenAmFreitagDer13te = newPersonenStream() //
				.map(Person::getGeburtstag) //
				.filter(isAtFriday.and(isAt13th)) //
				.count();

		assertThat(anzahlPersonenGeborenAmFreitagDer13te, is(491L));
	}

	@Test
	public void wochentagDes1tenApril2014() {
		DayOfWeek wochentagDes1tenApril2014 = LocalDate.of(2014, Month.APRIL, 1).getDayOfWeek();

		assertThat(wochentagDes1tenApril2014, is(DayOfWeek.TUESDAY));
	}

	@Test
	public void alterInJahrenMonatenTagen() {
		Period alter = LocalDate.of(1976, Month.MARCH, 12).until(LocalDate.now());

		assertThat(alter, is(Period.ofYears(38).plusMonths(1).plusDays(24)));
	}

	@Test
	public void alleZeitzonen() {
		ZoneId.getAvailableZoneIds().stream().sorted().forEach(System.out::println);
	}

	@Test
	public void jahrMitDenMeistenGeburten() {
		Map<Integer, List<Person>> nachJahrGruppiert = newPersonenStream().collect(
				Collectors.groupingBy(p -> p.getGeburtstag().getYear()));
		int jahrMitDenMeistenGeburten = nachJahrGruppiert.keySet().stream()
				.max(Comparator.comparingInt(jahr -> nachJahrGruppiert.get(jahr).size())).get();
		int anzahlGeburtenDiesesJahres = nachJahrGruppiert.get(jahrMitDenMeistenGeburten).size();

		assertThat(jahrMitDenMeistenGeburten, is(1923));
		assertThat(anzahlGeburtenDiesesJahres, is(1093));
	}

	private Stream<Person> newPersonenStream() {
		return personenStream().limit(100_000);
	}
}
