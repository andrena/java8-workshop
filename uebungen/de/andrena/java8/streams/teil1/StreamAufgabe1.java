package de.andrena.java8.streams.teil1;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.IntSummaryStatistics;
import java.util.stream.Stream;

import org.junit.Test;

import de.andrena.java8.Person;
import de.andrena.java8.streams.TestMit100000Personen;

public class StreamAufgabe1 extends TestMit100000Personen {

	@Test
	public void esGibtPersonenMitNachnahmenMaier() {

		// TODO boolean esGibtPersonenMitNachnahmenMaier = newPersonenStream()....
		boolean esGibtPersonenMitNachnahmenMaier = false;

		assertTrue(esGibtPersonenMitNachnahmenMaier);
	}

	@Test
	public void wieVielePersonenGibtEsMitNachnahmenMaier() {

		// TODO long anzahlPersonenMitNachnahmenMaier = newPersonenStream()....
		long anzahlPersonenMitNachnahmenMaier = 0;

		assertThat(anzahlPersonenMitNachnahmenMaier, is(1006L));
	}

	@Test
	public void anzahlVerschiedenerVornamen() {

		// TODO long anzahlVerschiedenerVornamen = newPersonenStream()....
		long anzahlVerschiedenerVornamen = 0;

		assertThat(anzahlVerschiedenerVornamen, is(559L));
	}

	@Test
	public void esGibtPersonenMitNachnahmenMitMehrAls8Zeichen() {

		// TODO boolean esGibtPersonenMitNachnahmenMitMehrAls8Zeichen = newPersonenStream()....
		boolean esGibtPersonenMitNachnahmenMitMehrAls8Zeichen = false;

		assertTrue(esGibtPersonenMitNachnahmenMitMehrAls8Zeichen);
	}

	@Test
	public void laengeDerNachnamen() {

		// TODO IntSummaryStatistics laengeDerNachnamenStatistik = newPersonenStream()...
		IntSummaryStatistics laengeDerNachnamenStatistik = new IntSummaryStatistics();

		assertThat(laengeDerNachnamenStatistik.getMin(), is(4));
		assertThat(laengeDerNachnamenStatistik.getMax(), is(10));
		assertThat(laengeDerNachnamenStatistik.getAverage(), is(closeTo(5.954, 0.001)));
	}

	private Stream<Person> newPersonenStream() {
		return personen.stream();
	}
}
