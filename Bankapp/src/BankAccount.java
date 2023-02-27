
public class BankAccount {
	private int acNbr;
	private double amount;
	private Customer holder;

	static private int currentAcNbr = 1;

	/**
	 * Skapar ett nytt bankkonto åt en innehavare med namn 'holderName' och id
	 * 'holderId'. Kontot tilldelas ett unikt kontonummer och innehåller
	 * inledningsvis 0 kr.
	 */
	public BankAccount(String holderName, long holderId) {
		this.holder= new Customer(holderName,holderId);
		acNbr = currentAcNbr;
		currentAcNbr++;
		amount = 0;
	}

	/**
	 * Skapar ett nytt bankkonto med innehavare 'holder'. Kontot tilldelas ett unikt
	 * kontonummer och innehåller inledningsvis 0 kr.
	 */
	public BankAccount(Customer holder) {
		this.holder = holder;
		acNbr = currentAcNbr;
		currentAcNbr++;
		amount = 0;
	}

	/** Tar reda på kontots innehavare. */
	public Customer getHolder() {
		return holder;
	}

	/** Tar reda på det kontonummer som identifierar detta konto. */
	public int getAccountNumber() {
		return acNbr;
	}

	/** Tar reda på hur mycket pengar som finns på kontot. */
	public double getAmount() {
		return amount;
	}

	/** Sätter in beloppet 'amount' på kontot. */
	public void deposit(double amount) {
		this.amount=amount;
	}

	/**
	 * Tar ut beloppet 'amount' från kontot. Om kontot saknar täckning blir saldot
	 * negativt.
	 */
	public void withdraw(double amount) {
		this.amount-=amount;
	}

	/** Returnerar en strängrepresentation av bankkontot. */
	public String toString() {
		return("konto " +acNbr + " (" + holder + "): " + amount);
	}

}
