package de.andrena.java8.streams;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

	@Test
	public void loopingIsUgly2() {
		List<String> nachnamenDie2002GeburtstagHaben = new ArrayList<>();
		for (Person person : personen) {
			if (person.getGeburtstag().getYear() == 2002) {
				if (!nachnamenDie2002GeburtstagHaben.contains(person.getNachname())) {
					nachnamenDie2002GeburtstagHaben.add(person.getNachname());
				}
			}
		}
		nachnamenDie2002GeburtstagHaben.sort(Comparator.naturalOrder());

		assertThat(nachnamenDie2002GeburtstagHaben, hasSize(100));
		assertThat(nachnamenDie2002GeburtstagHaben.get(0), is("Albrecht"));
		assertThat(nachnamenDie2002GeburtstagHaben.get(99), is("Zimmermann"));
	}

	@Test
	public void streamingIsBeautiful2() {
		List<String> nachnamenDie2002GeburtstagHaben = personen.stream()
				.filter(person -> person.getGeburtstag().getYear() == 2002) //
				.map(person -> person.getNachname()) //
				.distinct() //
				.sorted() //
				.collect(Collectors.toList());

		assertThat(nachnamenDie2002GeburtstagHaben, hasSize(100));
		assertThat(nachnamenDie2002GeburtstagHaben.get(0), is("Albrecht"));
		assertThat(nachnamenDie2002GeburtstagHaben.get(99), is("Zimmermann"));
	}
}
