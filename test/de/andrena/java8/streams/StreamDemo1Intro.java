package de.andrena.java8.streams;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.andrena.java8.Adresse;
import de.andrena.java8.Person;

public class StreamDemo1Intro extends TestMit100000Personen {

	@Test
	public void loopingIsUgly() {
		boolean esGibtJemandAusStuttgartDer2002GeborenWurde = false;
		for (Person person : personen) {
			if (person.getGeburtstag().getYear() == 2002) {
				for (Adresse adresse : person.getAdressen()) {
					if (adresse.getStadt().equals("Stuttgart")) {
						esGibtJemandAusStuttgartDer2002GeborenWurde = true;
						// Bug: breaks inner loop only
						break;
					}
				}
			}
		}

		assertTrue(esGibtJemandAusStuttgartDer2002GeborenWurde);
	}

	@Test
	public void streamingIsBeautiful() {
		boolean esGibtJemandAusStuttgartDer2002GeborenWurde = personen.stream()
				.filter(person -> person.getGeburtstag().getYear() == 2002)
				.flatMap(person -> person.getAdressen().stream())
				.anyMatch(adresse -> adresse.getStadt().equals("Stuttgart"));

		assertTrue(esGibtJemandAusStuttgartDer2002GeborenWurde);
	}
}
