package de.andrena.java8.time;

import static de.andrena.java8.PersonenGenerator.personenStream;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.time.DayOfWeek;
import java.time.Period;
import java.time.ZoneId;
import java.util.stream.Stream;

import org.junit.Test;

import de.andrena.java8.Person;

public class DateTimeAufgaben {

	@Test
	public void anzahlPersonenGeborenAmFreitagDer13te() {
		// long anzahlPersonenGeborenAmFreitagDer13te = TODO newPersonenStream(). ...
		long anzahlPersonenGeborenAmFreitagDer13te = 0;

		assertThat(anzahlPersonenGeborenAmFreitagDer13te, is(336L));
	}

	@Test
	public void wochentagDes1tenApril2014() {
		// DayOfWeek wochentagDes1tenApril2014 = TODO ...;
		DayOfWeek wochentagDes1tenApril2014 = null;

		assertThat(wochentagDes1tenApril2014, is(DayOfWeek.TUESDAY));
	}

	@Test
	public void alterInJahrenMonatenTagen() {
		// Period alter = TODO ...;
		Period alter = null;

		assertThat(alter.getYears(), is(greaterThan(37)));
	}

	@Test
	public void alleZeitzonen() {
		ZoneId.getAvailableZoneIds()
		// ... TODO
		;
	}

	@Test
	public void jahrMitDenMeistenGeburten() {
		// Map<Integer, List<Person>> nachJahrGruppiert = newPersonenStream()... TODO
		// int jahrMitDenMeistenGeburten = nachJahrGruppiert... TODO
		// int anzahlGeburtenDiesesJahres = nachJahrGruppiert.get(jahrMitDenMeistenGeburten).size();
		int jahrMitDenMeistenGeburten = 0;
		int anzahlGeburtenDiesesJahres = 0;

		assertThat(jahrMitDenMeistenGeburten, is(1916));
		assertThat(anzahlGeburtenDiesesJahres, is(1000));
	}

	private Stream<Person> newPersonenStream() {
		return personenStream().limit(100_000);
	}
}
