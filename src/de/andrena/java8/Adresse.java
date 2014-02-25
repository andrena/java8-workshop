package de.andrena.java8;

public class Adresse {

	private final String strasse;
	private final String hausnummer;
	private final int postleitzahl;
	private final String stadt;

	public Adresse(String strasse, String hausnummer, int postleitzahl, String stadt) {
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.postleitzahl = postleitzahl;
		this.stadt = stadt;
	}

	public String getStrasse() {
		return strasse;
	}

	public String getHausnummer() {
		return hausnummer;
	}

	public int getPostleitzahl() {
		return postleitzahl;
	}

	public String getStadt() {
		return stadt;
	}
}
