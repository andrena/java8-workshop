package de.andrena.java8;

import java.time.LocalDate;

public class Person {

	private final String vorname;
	private final String nachname;
	private final Adresse adresse;
	private final LocalDate geburtstag;

	public Person(String vorname, String nachname, Adresse adresse, LocalDate geburtstag) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.adresse = adresse;
		this.geburtstag = geburtstag;
	}

	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public LocalDate getGeburtstag() {
		return geburtstag;
	}
}
