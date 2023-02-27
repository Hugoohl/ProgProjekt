
public class Customer {
	private String name;
	private long idNr;
	private int cuNr;
	static private int currentkdNr = 101; // samma variabel fär alla objekt.

	/**
	 * Skapar en kund (kontoinnehavare) med namnet 'name' och id-nummer 'idNr'.
	 * Kunden tilldelas också ett unikt kundnummer.
	 */
	public Customer(String name, long idNr) {
		this.name = name;
		this.idNr = idNr;
		cuNr = currentkdNr;
		currentkdNr++;
	}

	/** Tar reda på kundens namn. */
	public String getName() {
		return name;
	}

	/** Tar reda på kundens personnummer. */
	public long getIdNr() {
		return idNr;
	}

	/** Tar reda på kundens kundnummer. */
	public int getCustomerNr() {
		return cuNr;
	}

	/** Returnerar en strängbeskrivning av kunden. */
	public String toString() {
		return (name + ", id " + idNr + ", kundnr " + cuNr);

	}

}
