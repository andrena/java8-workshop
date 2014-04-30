package de.andrena.java8.streams;

import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertThat;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import de.andrena.java8.Person;

public class StreamLoesung2 extends TestMit100000Personen {

	@Test
	public void alleVerschiedenenVornamenDerMaiersSortiertAlsListe() {
		List<String> alleVornamenDerMaiers = newPersonenStream() //
				.filter(person -> person.getNachname().equals("Maier")) //
				.map(Person::getVorname) //
				.distinct() //
				.sorted() //
				.collect(Collectors.toList());

		assertThat(alleVornamenDerMaiers, hasSize(472));
		assertThat(alleVornamenDerMaiers.get(0), is("Agnes"));
		assertThat(alleVornamenDerMaiers.get(471), is("Yvonne"));
	}

	@Test
	public void alleVerschiedenenVornamenDerMaiersSortiertAlsLinkedList() {
		LinkedList<String> alleVornamenDerMaiers = newPersonenStream() //
				.filter(person -> person.getNachname().equals("Maier")) //
				.map(Person::getVorname) //
				.distinct() //
				.sorted() //
				.collect(Collectors.toCollection(LinkedList::new));

		assertThat(alleVornamenDerMaiers, hasSize(472));
		assertThat(alleVornamenDerMaiers.get(0), is("Agnes"));
		assertThat(alleVornamenDerMaiers.get(471), is("Yvonne"));
	}

	@Test
	public void alleVerschiedenenVornamenDerMaiersSortiertAlsKommaSeparierterString() {
		String alleVornamenDerMaiers = newPersonenStream() //
				.filter(person -> person.getNachname().equals("Maier")) //
				.map(Person::getVorname) //
				.distinct() //
				.sorted() //
				.collect(Collectors.joining(", "));

		assertThat(alleVornamenDerMaiers, startsWith("Agnes, Agnieszka, Albert, "));
		assertThat(alleVornamenDerMaiers, endsWith("Yannik, Yasemin, Yasmin, Yvonne"));
	}

	@Test
	public void gruppiereNachNachnamen() {
		Map<String, List<Person>> gruppiertNachNachnamen = newPersonenStream() //
				.collect(Collectors.groupingBy(Person::getNachname));

		assertThat(gruppiertNachNachnamen.keySet(), hasSize(100));
		assertThat(gruppiertNachNachnamen.get("Müller"), hasSize(950));
		assertThat(gruppiertNachNachnamen.get("Schuster"), hasSize(981));
	}

	@Test
	public void gruppiereNachNachnamenUndBildeKommaSeparierteListenDerUnterschiedlichenVornamen() {
		Map<String, List<Person>> gruppiertNachNachnamen = newPersonenStream() //
				.collect(Collectors.groupingBy(Person::getNachname));

		List<String> nachnamenMitAllenVornamen = gruppiertNachNachnamen //
				.entrySet() //
				.stream() //
				.map(entry -> entry.getKey() + ": " + listeDerVerschiedenenVornamenKommaSepariert(entry.getValue())) //
				.collect(Collectors.toList());

		assertThat(nachnamenMitAllenVornamen, hasSize(100));
		assertThat(nachnamenMitAllenVornamen, hasItem(startsWith("Müller: Agnes, Agnieszka, Albert, ")));
		assertThat(nachnamenMitAllenVornamen, hasItem(startsWith("Schuster: Agnes, Agnieszka, Alexander, ")));
	}

	private String listeDerVerschiedenenVornamenKommaSepariert(List<Person> personen) {
		return personen //
				.stream() //
				.map(Person::getVorname) //
				.distinct() //
				.sorted() //
				.collect(Collectors.joining(", "));
	}

	private Stream<Person> newPersonenStream() {
		return personen.stream();
	}
}
