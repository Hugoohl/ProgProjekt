import java.util.ArrayList;

public class Bank {
	private ArrayList<BankAccount> bankAccounts;
	
	/** Skapar en ny bank utan konton. */
	public Bank() {
		bankAccounts = new ArrayList<BankAccount>();
	}
	/**
	* Öppna ett nytt konto i banken. Om det redan finns en kontoinnehavare
	* med de givna uppgifterna ska inte en ny Customer skapas, utan istället
	* den befintliga användas. Det nya kontonumret returneras.
	*/
	/*public int addAccount(String holderName, long idNr) {
		bankAccounts.add( new BankAccount(holderName, idNr));
		bankAccounts.add(new BankAccount())
		
		return 1;
	}*/
	
	/**
	* Returnerar den kontoinnehavaren som har det givna id-numret,
	* eller null om ingen sådan finns.
	*/
	Customer findHolder(long idNr) {
	for(int i = 0; i<bankAccounts.size(); i++) {
		//BankAccount b = bankAccounts.get(i);
		if(bankAccounts.get(i).getAccountNumber() == idNr);
			return bankAccounts.get(i).getHolder();
	}
	return null;
	}
	
	/**
	* Tar bort konto med nummer 'number' från banken. Returnerar true om
	* kontot fanns (och kunde tas bort), annars false.
	*/
	public boolean removeAccount(int number) {
		for(int i = 0; i<bankAccounts.size(); i++) {
			BankAccount b = bankAccounts.get(i);
			if(bankAccounts.get(i).getAccountNumber() == number) {
				
			}
		}
	}
	/**
	* Returnerar en lista innehållande samtliga bankkonton i banken.
	* Listan är sorterad på kontoinnehavarnas namn.
	*/
	public ArrayList<BankAccount> getAllAccounts(){
		return bankAccounts;
	}
	/**
	* Söker upp och returnerar bankkontot med kontonummer 'accountNumber'.
	* Returnerar null om inget sådant konto finns.
	*/
	public BankAccount findByNumber(int accountNumber) {
		return BankAccount
	}
	/**
	* Söker upp alla bankkonton som innehas av kunden med id-nummer 'idNr'.
	* Kontona returneras i en lista. Kunderna antas ha unika id-nummer.
	*/
	ArrayList<BankAccount> findAccountsForHolder(long idNr);
	/*
	* Söker upp kunder utifrån en sökning på namn eller del av namn. Alla
	* personer vars namn innehåller strängen 'namePart' inkluderas i
	* resultatet, som returneras som en lista. Samma person kan förekomma
	* flera gånger i resultatet. Sökningen är "case insensitive", det vill
	* säga gör ingen skillnad på stora och små bokstäver.
	*/
	ArrayList<Customer> findByPartofName(String namePart);

}
