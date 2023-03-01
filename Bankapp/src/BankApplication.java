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

		} else if (scan.hasNext()) {
			scan.nextLine();
			System.out.println("Välj ett av de tillgängliga alternativen.");
		} else {
			return quit;
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
		if (scan.hasNextLong()) {
			ArrayList<BankAccount> list = bank.findAccountsForHolder(scan.nextLong());
			if (list.isEmpty()) {
				System.out.println("Finns inga konton");
			} else {
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i));
				}
			}
		} else {
			scan.nextLine();
			scan.nextLine();
			System.out.println("Välj ett giltigt id");


		}
	}

	public static void two() {
		System.out.print("namn:");
		ArrayList<Customer> listOfAc = bank.findByPartofName(scan.next());
		if (listOfAc.isEmpty()) {
			System.out.println("Inget liknade kontot existerar");
		} else {
			for (int i = 0; i < listOfAc.size(); i++)
				System.out.println(listOfAc.get(i));
		}

	}

	public static void three() {
		System.out.print("konto:");
		if (scan.hasNextInt()) {
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
		} else {
			scan.nextLine();
			scan.nextLine();
			System.out.println("Välj ett giltigt kontonummer");

		}
	}

	public static void four() {
		System.out.print("från konto:");
		if (scan.hasNextInt()) {
			int k = scan.nextInt();
			if (bank.findByNumber(k) == null) {
				System.out.println("Kontot existerar ej.");
			} else {
				System.out.print("belopp:");
				double wd = scan.nextDouble();
				if (wd > bank.findByNumber(k).getAmount()) {
					System.out.println("Konto saknar täckning");
				} else {
					bank.findByNumber(k).withdraw(wd);
					System.out.println(bank.findByNumber(k));
				}
			}
		} else {
			scan.nextLine();
			scan.nextLine();
			System.out.println("Välj ett giltigt kontonummer");
		}
	}

	public static void five() {
		System.out.print("från konto:");
		if (scan.hasNextInt()) {
			int fk = scan.nextInt();
			if (bank.findByNumber(fk) == null) {
				System.out.println("Kontot existerar ej.");
			} else {
				System.out.print("till konto:");
				if (scan.hasNextInt()) {
					int tk = scan.nextInt();
					if (bank.findByNumber(tk) == null) {
						System.out.println("Kontot existerar ej.");
					} else {
						System.out.print("belopp:");
						double b = scan.nextDouble();
						if (b > bank.findByNumber(fk).getAmount()) {
							System.out.println("Konto saknar täckning");
						} else {
							bank.findByNumber(fk).withdraw(b);
							bank.findByNumber(tk).deposit(b);
							System.out.println(bank.findByNumber(fk));
							System.out.println(bank.findByNumber(tk));
						}
					}
				} else {
					scan.nextLine();
					scan.nextLine();
					System.out.println("Välj ett giltigt kontonummer");
				}
			}
		} else {
			scan.nextLine();
			scan.nextLine();
			System.out.println("Välj ett giltigt kontonummer");

		}
	}

	public static void six() {
		System.out.print("namn: ");
		String namn = scan.next();
		System.out.print("id: ");
		if (scan.hasNextLong()) {
			long id = scan.nextLong();
			System.out.println("konto skapat: " + bank.addAccount(namn, id));
		} else {
			scan.nextLine();
			scan.nextLine();
			System.out.println("Välj ett giltigt idnummer");
		}
	}

	public static void seven() {
		System.out.print("konto: ");
		if (scan.hasNextInt()) {
			if(!bank.removeAccount(scan.nextInt())) {
				System.out.println("Finns inget matchande konot");
			}else {
				System.out.println("Kontot borttaget");
			}
		} else {
			scan.nextLine();
			scan.nextLine();
			System.out.println("Välj ett giltigt kontonummer");
		}
	}

	public static void eight() {
		ArrayList<BankAccount> list = bank.getAllAccounts();
		if (list.isEmpty()) {
			System.out.println("Inga konton finns på banken");
		} else {
			for (int i = 0; i < list.size(); i++)
				System.out.println(list.get(i));
		}

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
		bank.findByNumber(1001).deposit(200);
		bank.findByNumber(1002).deposit(2000);
		bank.findByNumber(1003).deposit(50);

	}
}
