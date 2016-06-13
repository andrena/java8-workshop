package de.andrena.java8.streams;

import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.Test;

import de.andrena.java8.Person;

public class StreamAufgabe2 extends TestMit100000Personen {

	@Test
	public void alleVerschiedenenVornamenDerMaiersSortiertAlsListe() {
		// TODO List<String> alleVornamenDerMaiers = newPersonenStream()....
		List<String> alleVornamenDerMaiers = Collections.emptyList();

		assertThat(alleVornamenDerMaiers, hasSize(559));
		assertThat(alleVornamenDerMaiers.get(0), is("Agnes"));
		assertThat(alleVornamenDerMaiers.get(558), is("Yvonne"));
	}

	@Test
	public void alleVerschiedenenVornamenDerMaiersSortiertAlsLinkedList() {
		// TODO LinkedList<String> alleVornamenDerMaiers = newPersonenStream()....
		LinkedList<String> alleVornamenDerMaiers = new LinkedList<>();

		assertThat(alleVornamenDerMaiers, hasSize(559));
		assertThat(alleVornamenDerMaiers.get(0), is("Agnes"));
		assertThat(alleVornamenDerMaiers.get(558), is("Yvonne"));
	}

	@Test
	public void alleVerschiedenenVornamenDerMaiersSortiertAlsKommaSeparierterString() {
		// TODO String alleVornamenDerMaiers = newPersonenStream()....
		String alleVornamenDerMaiers = "";

		assertThat(alleVornamenDerMaiers, startsWith("Agnes, Agnieszka, Albert, "));
		assertThat(alleVornamenDerMaiers, endsWith("Yannik, Yasemin, Yasmin, Yvonne"));
	}

	@Test
	public void gruppiereNachNachnamen() {
		// TODO Map<String, List<Person>> gruppiertNachNachnamen = newPersonenStream()....
		Map<String, List<Person>> gruppiertNachNachnamen = Collections.emptyMap();

		assertThat(gruppiertNachNachnamen.keySet(), hasSize(100));
		assertThat(gruppiertNachNachnamen.get("Müller"), hasSize(1000));
		assertThat(gruppiertNachNachnamen.get("Schuster"), hasSize(1000));
	}

	@Test
	public void gruppiereNachNachnamenUndBildeKommaSeparierteListenDerUnterschiedlichenVornamen() {
		// TODO List<String> nachnamenMitAllenVornamen = newPersonenStream()....
		List<String> nachnamenMitAllenVornamen = Collections.emptyList();

		assertThat(nachnamenMitAllenVornamen, hasSize(100));
		assertThat(nachnamenMitAllenVornamen, hasItem(startsWith("Müller: Agnes, Agnieszka, Albert, ")));
		assertThat(nachnamenMitAllenVornamen, hasItem(startsWith("Scholz: Agnes, Agnieszka, Albert, ")));
	}

	private Stream<Person> newPersonenStream() {
		return personen.stream();
	}
}
