package de.andrena.java8.streams;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.IntSummaryStatistics;
import java.util.stream.Stream;

import org.junit.Test;

import de.andrena.java8.Person;

public class StreamAufgabe1 extends TestMit100000Personen {

	@Test
	public void esGibtPersonenMitNachnamenMaier() {

		// TODO boolean esGibtPersonenMitNachnamenMaier = newPersonenStream()....
		boolean esGibtPersonenMitNachnamenMaier = false;

		assertTrue(esGibtPersonenMitNachnamenMaier);
	}

	@Test
	public void wieVielePersonenGibtEsMitNachnamenMaier() {

		// TODO long anzahlPersonenMitNachnamenMaier = newPersonenStream()....
		long anzahlPersonenMitNachnamenMaier = 0;

		assertThat(anzahlPersonenMitNachnamenMaier, is(1000L));
	}

	@Test
	public void anzahlVerschiedenerVornamen() {

		// TODO long anzahlVerschiedenerVornamen = newPersonenStream()....
		long anzahlVerschiedenerVornamen = 0;

		assertThat(anzahlVerschiedenerVornamen, is(559L));
	}

	@Test
	public void esGibtPersonenMitNachnamenMitMehrAls8Zeichen() {

		// TODO boolean esGibtPersonenMitNachnamenMitMehrAls8Zeichen = newPersonenStream()....
		boolean esGibtPersonenMitNachnamenMitMehrAls8Zeichen = false;

		assertTrue(esGibtPersonenMitNachnamenMitMehrAls8Zeichen);
	}

	@Test
	public void laengeDerNachnamen() {

		// TODO IntSummaryStatistics laengeDerNachnamenStatistik = newPersonenStream()...
		IntSummaryStatistics laengeDerNachnamenStatistik = new IntSummaryStatistics();

		assertThat(laengeDerNachnamenStatistik.getMin(), is(4));
		assertThat(laengeDerNachnamenStatistik.getMax(), is(10));
		assertThat(laengeDerNachnamenStatistik.getAverage(), is(closeTo(5.95, 0.001)));
	}

	private Stream<Person> newPersonenStream() {
		return personen.stream();
	}
}
