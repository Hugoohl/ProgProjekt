import java.util.ArrayList;

public class Bank {
	private ArrayList<BankAccount> bankAccounts;

	/** Skapar en ny bank utan konton. */
	public Bank() {
		bankAccounts = new ArrayList<BankAccount>();
		// bankAccounts.add(new BankAccount("test", 12345678));
	}

	/*
	 * Öppna ett nytt konto i banken. Om det redan finns en kontoinnehavare med de
	 * givna uppgifterna ska inte en ny Customer skapas, utan istället den
	 * befintliga användas. Det nya kontonumret returneras.
	 */

	public int addAccount(String holderName, long idNr) {

		if (findHolder(idNr) != null) { // Om det finns ett konto med dessa
			bankAccounts.add(new BankAccount(findHolder(idNr))); // skapa ett ny konto med samma kun
			return bankAccounts.get(bankAccounts.size() - 1).getAccountNumber();
		} else {

			bankAccounts.add(new BankAccount(holderName, idNr)); // Skapa ett nytt konto med dessa uppgifter.
			return bankAccounts.get(bankAccounts.size() - 1).getAccountNumber(); // Retunerar kontonumret på sista
																					// elemnetet
																					// i listan med kontonummer, alltså
																					// kontot vi precis la till.
		}
	}
	/**
	* Returnerar den kontoinnehavaren som har det givna id-numret,
	* eller null om ingen sådan finns.
	*/
	Customer findHolder(long idNr) {
		for (int i = 0; i < bankAccounts.size(); i++) {
			if (bankAccounts.get(i).getHolder().getIdNr() == idNr) {

				return bankAccounts.get(i).getHolder();
			}
		}
		return null;
	}

	/**
	 * Tar bort konto med nummer 'number' från banken. Returnerar true om kontot
	 * fanns (och kunde tas bort), annars false.
	 */
	public boolean removeAccount(int number) {
		for (int i = 0; i < bankAccounts.size(); i++) {
			if (bankAccounts.get(i).getAccountNumber() == number) {
				bankAccounts.remove(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * Returnerar en lista innehållande samtliga bankkonton i banken. Listan är
	 * sorterad på kontoinnehavarnas namn.
	 */
	public ArrayList<BankAccount> getAllAccounts() {
		ArrayList<BankAccount> sortedList = new ArrayList<BankAccount>(bankAccounts);
		for (int i = 0; i < sortedList.size(); i++) {
			for (int j = sortedList.size() - 1; j > i; j--) {
				if (sortedList.get(i).getHolder().getName()
						.compareToIgnoreCase(sortedList.get(j).getHolder().getName()) > 0) {
					BankAccount temp = sortedList.get(i);
					sortedList.set(i, sortedList.get(j));
					sortedList.set(j, temp);
				}

			}
		}

		return sortedList;
	}

	/**
	 * Söker upp och returnerar bankkontot med kontonummer 'accountNumber'.
	 * Returnerar null om inget sådant konto finns.
	 */
	public BankAccount findByNumber(int accountNumber) {
		BankAccount searchedAcNbr = null;
		for (int i = 0; i < bankAccounts.size(); i++) {
			if (bankAccounts.get(i).getAccountNumber() == accountNumber) {
				searchedAcNbr = bankAccounts.get(i);
			}
		}
		return searchedAcNbr;

	}

	/**
	 * Söker upp alla bankkonton som innehas av kunden med id-nummer 'idNr'. Kontona
	 * returneras i en lista. Kunderna antas ha unika id-nummer.
	 */
	ArrayList<BankAccount> findAccountsForHolder(long idNr) {
		ArrayList<BankAccount> listOfAc = new ArrayList<BankAccount>();
		for (int i = 0; i < bankAccounts.size(); i++) {
			if (bankAccounts.get(i).getHolder().getIdNr() == idNr) {
				listOfAc.add(bankAccounts.get(i));
			}
		}
		return listOfAc;
	}

	/**
	 * Söker upp kunder utifrån en sökning på namn eller del av namn. Alla personer
	 * vars namn innehåller strängen 'namePart' inkluderas i resultatet, som
	 * returneras som en lista. Samma person kan förekomma flera gånger i
	 * resultatet. Sökningen är "case insensitive", det vill säga gör ingen skillnad
	 * på stora och små bokstäver.
	 */
	ArrayList<Customer> findByPartofName(String namePart) {
		ArrayList<Customer> customerSearch = new ArrayList<Customer>();
		for (int i = 0; i < bankAccounts.size(); i++) {
			if (bankAccounts.get(i).getHolder().getName().toLowerCase().contains(namePart.toLowerCase())) {
				customerSearch.add(bankAccounts.get(i).getHolder());
			}
		}
		return customerSearch;
	}

}
