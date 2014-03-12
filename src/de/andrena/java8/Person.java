package de.andrena.java8;

import static java.util.Collections.unmodifiableList;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Person {

	private final String vorname;
	private final String nachname;
	private final LocalDate geburtstag;
	private final List<Adresse> adressen = new LinkedList<>();

	public Person(String vorname, String nachname) {
		this(vorname, nachname, null);
	}

	public Person(String vorname, String nachname, LocalDate geburtstag) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.geburtstag = geburtstag;
	}

	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void add(Adresse adresse) {
		adressen.add(adresse);
	}

	public void remove(Adresse adresse) {
		adressen.remove(adresse);
	}

	public List<Adresse> getAdressen() {
		return unmodifiableList(adressen);
	}

	public LocalDate getGeburtstag() {
		return geburtstag;
	}

	public Person ohneGeburtstag() {
		Person person = new Person(vorname, nachname, null);
		person.adressen.addAll(this.adressen);
		return person;
	}

	@Override
	public String toString() {
		return vorname + " " + nachname;
	}
}
