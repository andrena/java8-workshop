package de.andrena.java8.streams;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
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
	public void filterLoop() {
		Person mueller = null;
		for (Person person : personen) {
			if ("Müller".equals(person.getNachname())) {
				mueller = person;
				break;
			}
		}

		assertThat(mueller, is(notNullValue()));
	}

	@Test
	public void filter() {
		Person mueller = personen.stream() //
				.filter(person -> "Müller".equals(person.getNachname())) //
				.findFirst().get();

		assertThat(mueller, is(notNullValue()));
	}

	@Test
	public void mapLoop() {
		List<String> nachnamen = new ArrayList<>();
		for (Person person : personen) {
			nachnamen.add(person.getNachname());
		}

		assertThat(nachnamen, hasSize(100000));
	}

	@Test
	public void map() {
		List<String> nachnamen = personen.stream() //
				.map(person -> person.getNachname()) //
				.collect(toList());

		assertThat(nachnamen, hasSize(100000));
	}

	@Test
	public void mapAndFilter() {
		List<String> vornamen = personen.stream() //
				.filter(person -> "Müller".equals(person.getNachname())) //
				.map(person -> person.getVorname()) //
				.collect(toList());

		assertThat(vornamen, hasSize(950));
	}

	@Test
	public void loopingIsUgly() {
		boolean esGibtJemandAusStuttgartDer2002GeborenWurde = false;
		for (Person person : personen) {
			if (person.getGeburtstag().getYear() == 2002) {
				for (Adresse adresse : person.getAdressen()) {
					if ("Stuttgart".equals(adresse.getStadt())) {
						esGibtJemandAusStuttgartDer2002GeborenWurde = true;
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
				.anyMatch(adresse -> "Stuttgart".equals(adresse.getStadt()));

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
