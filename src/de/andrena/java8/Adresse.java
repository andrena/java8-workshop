package de.andrena.java8;

public class Adresse {

	private final String strasse;
	private final int hausnummer;
	private final String postleitzahl;
	private final String stadt;

	public Adresse(String strasse, int hausnummer, String postleitzahl, String stadt) {
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.postleitzahl = postleitzahl;
		this.stadt = stadt;
	}

	public String getStrasse() {
		return strasse;
	}

	public int getHausnummer() {
		return hausnummer;
	}

	public String getPostleitzahl() {
		return postleitzahl;
	}

	public String getStadt() {
		return stadt;
	}
}
