import java.util.ArrayList;
import java.util.Scanner;

public class BankApplication {
	static Bank bank = new Bank();
	static Scanner scan = new Scanner(System.in).useDelimiter(System.lineSeparator()); // hitta på internätetet

	public static void main(String[] args) {
		test();
		while (true) {
			menu();
			if (run()) {
				return;
			}
		}

	}

	public static boolean run() {
		boolean quit = false;
		if (scan.hasNextInt()) {
			int option = scan.nextInt();
			switch (option) {
			case 1:
				one();
				break;
			case 2:
				two();
				break;
			case 3:
				three();
				break;
			case 4:
				four();
				break;
			case 5:
				five();
				break;
			case 6:
				six();
				break;
			case 7:
				seven();
				break;
			case 8:
				eight();
				break;
			case 9:
				quit = true;
				System.out.println("--------------------------------------------------------------");
				break;
			default:
				System.out.println("Välj ett av de tillgängliga alternativen.");

			}

		} else {
			scan.nextLine();
			System.out.println("Välj ett av de tillgängliga alternativen.");
		}
		return quit;

	}

	public static void menu() {
		System.out.println("--------------------------------------------------------------");
		System.out.println("1. Hitta konton för en viss kontoinnehavare");
		System.out.println("2. Sök kontoinnehavare på (del av) namn");
		System.out.println("3. Sätta in pengar");
		System.out.println("4. Ta ut pengar");
		System.out.println("5. Överföring mellan konton");
		System.out.println("6. Skapa nytt konto");
		System.out.println("7. Ta bort konto");
		System.out.println("8. Skriv ut bankens alla konton");
		System.out.println("9. Avsluta");
		System.out.print("Val: ");
	}

	public static void one() {
		System.out.print("id:");
		while (scan.hasNextLong()) {
			
			ArrayList<BankAccount> list = bank.findAccountsForHolder(scan.nextLong());
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
			if (list.isEmpty()) {
				System.out.println("Ogiltigt id: ");
			}
		}
	}

	public static void two() {
		System.out.print("namn:");
		ArrayList<Customer> listOfAc = bank.findByPartofName(scan.next());
		for (int i = 0; i < listOfAc.size(); i++)
			System.out.println(listOfAc.get(i));

	}

	public static void three() { // Möjligtvis gör nån loop
		System.out.print("konto:");
		BankAccount account = bank.findByNumber(scan.nextInt());
		if (account == null) {
			System.out.println("Kontot existerar ej.");
		} else {
			System.out.print("belopp:");
			double belopp = scan.nextDouble();
			if (belopp < 0) {
				System.out.println("Vänligen ange ett positivt belopp!?");
			} else {
				account.deposit(belopp);
				System.out.println(account);
			}
		}

	}

	public static void four() {
		System.out.print("från konto:");
		int k = scan.nextInt();
		System.out.print("belopp:");
		double wd = scan.nextDouble();
		bank.findByNumber(k).withdraw(wd);
		System.out.println(bank.findByNumber(k));

	}

	public static void five() {
		System.out.print("från konto:");
		int fk = scan.nextInt();
		System.out.print("till konto:");
		int tk = scan.nextInt();
		System.out.print("belopp:");
		double b = scan.nextDouble();
		bank.findByNumber(fk).withdraw(b);
		bank.findByNumber(tk).deposit(b);
		System.out.println(bank.findByNumber(fk));
		System.out.println(bank.findByNumber(tk));

	}

	public static void six() {
		System.out.print("namn: ");
		String namn = scan.next();
		System.out.print("id: ");
		long id = scan.nextLong();
		System.out.println("konto skapat: " + bank.addAccount(namn, id));

	}

	public static void seven() {
		System.out.print("konto: ");
		bank.removeAccount(scan.nextInt());

	}

	public static void eight() { // (valfritt) fixa inbördes ordning på en personer med samma namn
		ArrayList<BankAccount> list = bank.getAllAccounts();
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));

	}

	public static void test() {
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
		bank.addAccount("Magnus Andersson", 6909154321L);
	}
}
