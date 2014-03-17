package de.andrena.java8;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class PersonenGenerator {

	public static Stream<Person> personenStream() {
		try {
			return new PersonenGenerator().generiereStream();
		} catch (URISyntaxException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	private final List<String> vornamen;
	private final List<String> nachnamen;
	private final List<Ort> orte;

	private final Random random;

	private PersonenGenerator() throws URISyntaxException, IOException {
		this(new Random(42));
	}

	public PersonenGenerator(long seed) throws URISyntaxException, IOException {
		this(new Random(seed));
	}

	private PersonenGenerator(Random random) throws URISyntaxException, IOException {
		this.random = random;
		vornamen = readFile("vornamen.txt");
		nachnamen = readFile("nachnamen.txt");

		try (BufferedReader reader = newBufferedReader("Liste-Staedte-in-Deutschland.csv")) {
			orte = reader.lines() //
					.skip(1) //
					.map(line -> line.split(";")) //
					.map(parts -> new Ort(parts[2], parts[1])) //
					.collect(toList());
		}
	}

	public Stream<Person> generiereStream() {
		return Stream.generate(() -> generierePerson());
	}

	private Person generierePerson() {
		Person person = generierePersonOhneAdresse();
		person.add(generiereAdresse());
		return person;
	}

	private Person generierePersonOhneAdresse() {
		String vorname = vornamen.get(random.nextInt(vornamen.size()));
		String nachname = nachnamen.get(random.nextInt(nachnamen.size()));
		LocalDate geburtstag = generiereGeburtstag();
		return new Person(vorname, nachname, geburtstag);
	}

	private Adresse generiereAdresse() {
		String strasse = "Demostrasse";
		int hausnummer = random.nextInt(100);
		Ort ort = orte.get(random.nextInt(orte.size()));
		return new Adresse(strasse, hausnummer, ort.plz, ort.name);
	}

	private LocalDate generiereGeburtstag() {
		Year year = Year.now().minusYears(100).plusYears(random.nextInt(100));
		Month month = zufaelligerMonat();
		int dayOfMonth = 1 + random.nextInt(month.length(year.isLeap()));
		return LocalDate.now().with(year).with(month).withDayOfMonth(dayOfMonth);
	}

	private Month zufaelligerMonat() {
		return Month.values()[random.nextInt(Month.values().length)];
	}

	private BufferedReader newBufferedReader(String file) throws IOException, URISyntaxException {
		return Files.newBufferedReader(toPath(file));
	}

	private List<String> readFile(String file) throws URISyntaxException, IOException {
		return Files.readAllLines(toPath(file));
	}

	private Path toPath(String file) throws URISyntaxException {
		return Paths.get(getClass().getResource("/" + file).toURI());
	}

	private class Ort {
		String plz;
		String name;

		Ort(String plz, String name) {
			this.plz = plz;
			this.name = name;
		}
	}

}
