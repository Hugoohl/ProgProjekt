import java.util.Scanner;

public class BankApplication {
	

	public static void main(String[] args) {
		Bank bank = new Bank();
		Scanner scan = new Scanner(System.in);
		menu();
		bank.addAccount("Erik Johansson", 7208151242L);
		bank.addAccount("Anna Andersson", 9307023397L);
		bank.addAccount("Johan Svensson", 8102107584L);
		bank.addAccount("Sofia Lundqvist", 6408279876L);
		bank.addAccount("Jesus Gustavsson", 7812033218L);
		bank.addAccount("Linda Nilsson", 9503289021L);
		bank.addAccount("Dickbert Carlsson", 8206296643L);
		bank.addAccount("Sara Bergström", 8707225213L);
		bank.addAccount("Kristina Söderberg", 9201218765L);
		bank.addAccount("Magnus Andersson", 6909154321L);
		
		int option = scan.nextInt();
		
		switch (option) {
		
		case 1:
			System.out.println("id:");
			System.out.println(bank.findAccountsForHolder(scan.nextLong()));
			break;
		case 2:
			System.out.println("namn:");
			System.out.println(bank.findByPartofName(scan.next()));
			break;
		case 3:
			System.out.println("konto:");
			BankAccount account = bank.findByNumber(scan.nextInt());
			System.out.println("belopp:");
			double belopp = scan.nextDouble();
			account.deposit(belopp);
			System.out.println(account);
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			System.out.println("namn: ");
			String holderName = scan.next();
			System.out.println("id: ");
			long idNr = scan.nextLong();
			int accnum = bank.addAccount(holderName, idNr);
			System.out.println("konto skapat: " + accnum );
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			break;
		default:
			System.out.println("1");
		}
	}

	public static void menu() {
		System.out.println("--------------------------------------------------------------");
		System.out.println("1. Hitta konton för en viss kontoinnehavare");
		System.out.println("2. Sök kontoinnehavare på (del av) namn");
		System.out.println("3. Sätta in pengare");
		System.out.println("4. Ta ut pengare");
		System.out.println("5. Överföring mellan konton");
		System.out.println("6. Skapa nytt konto");
		System.out.println("7. Ta bort konto");
		System.out.println("8. Skriv ut bankens alla konton");
		System.out.println("9. Avsluta");
		System.out.println("Val: ");
	}

	


	
}
