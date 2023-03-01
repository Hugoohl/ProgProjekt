import java.util.ArrayList;
import java.util.Scanner;

public class BankApplication {
	static Bank bank = new Bank();
	static Scanner scan = new Scanner(System.in).useDelimiter(System.lineSeparator()); // Scannern använder ny rad för
																						// att markerar slutet på en
																						// sträng, istället för
																						// mellanslag (hitta på internet
	/*
	 * Programmet körs tills run() returnerar true. Vilket sker då man väljer
	 * alterantiv 9.
	 */

	public static void main(String[] args) {
		test();
		while (true) {
			menu();
			if (run()) {
				return;
			}
		}

	}
	/*
	 * Switch case sats som kör motsvarande metod för varje alternativ. case 9
	 * sätter quit = true => programmet stängs av. else if kollar om man skriver en
	 * String och skriver isf ut ett felmeddelande.
	 */

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

	/*
	 * Gör 1 ifall man matar in en long. Annars felmeddelande.
	 */
	public static void one() {
		System.out.print("id:");
		if (scan.hasNextLong()) {
			ArrayList<BankAccount> listOfAc = bank.findAccountsForHolder(scan.nextLong());
			if (listOfAc.isEmpty()) {
				System.out.println("Finns inga konton på detta ID");
			} else {
				for (int i = 0; i < listOfAc.size(); i++) {
					System.out.println(listOfAc.get(i));
				}
			}
		} else {
			scan.nextLine();
			scan.nextLine(); // Tar bort String för att motverka oändlig loop.
			System.out.println("Välj ett giltigt id");

		}
	}

	/*
	 * gör 2 om den kunden har konto.
	 */
	public static void two() {
		System.out.print("namn:");
		ArrayList<Customer> customerSearch = bank.findByPartofName(scan.next());
		if (customerSearch.isEmpty()) {
			System.out.println("Inget liknade konto existerar");
		} else {
			for (int i = 0; i < customerSearch.size(); i++)
				System.out.println(customerSearch.get(i));
		}

	}

	/*
	 * gör 3 om rätt typer matas in, kontot existerar, beloppet inte är negativt.
	 * 
	 */
	public static void three() {
		System.out.print("konto:");
		if (scan.hasNextInt()) {
			BankAccount searchedAc = bank.findByNumber(scan.nextInt());
			if (searchedAc == null) {
				System.out.println("Kontot existerar ej.");
			} else {
				System.out.print("belopp:");
				if (scan.hasNextDouble()) {
					double belopp = scan.nextDouble();
					if (belopp < 0) {
						System.out.println("Vänligen ange ett positivt belopp");
					} else {
						searchedAc.deposit(belopp);
						System.out.println(searchedAc);
					}
				} else {
					scan.nextLine();
					scan.nextLine();
					System.out.println("Välj ett giltigt belopp");
				}
			}
		} else {
			scan.nextLine();
			scan.nextLine();
			System.out.println("Välj ett giltigt kontonummer");

		}
	}

	/*
	 * gör 4 om rätt typer matas in, kontot existerar, beloppet inte är negativt och
	 * kontot har tillräckligt med cash.
	 */
	public static void four() {
		System.out.print("från konto:");
		if (scan.hasNextInt()) {
			int acNbr = scan.nextInt();
			if (bank.findByNumber(acNbr) == null) {
				System.out.println("Kontot existerar ej.");
			} else {
				System.out.print("belopp:");
				if (scan.hasNextDouble()) {
					double amount = scan.nextDouble();
					if (amount > bank.findByNumber(acNbr).getAmount()) {
						System.out.println("Konto saknar täckning");
					} else if (amount < 0) {
						System.out.println("Välj ett giltigt belopp");
					} else {

						bank.findByNumber(acNbr).withdraw(amount);
						System.out.println(bank.findByNumber(acNbr));
					}
				} else {
					scan.nextLine();
					scan.nextLine();
					System.out.println("Välj ett giltigt belopp");
				}

			}
		} else {
			scan.nextLine();
			scan.nextLine();
			System.out.println("Välj ett giltigt kontonummer");
		}
	}

	/*
	 * Gör 5 om rätt typer matas in, det är två olika existerande konton, beloppet
	 * är positivt och från kontot har tillräckligt med cash.
	 */
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
					} else if (tk == fk) {
						System.out.println("Välj olika konton");
					} else {
						System.out.print("belopp:");
						if (scan.hasNextDouble()) {
							double amount = scan.nextDouble();
							if (amount > bank.findByNumber(fk).getAmount()) {
								System.out.println("Konto saknar täckning");
							} else if (amount < 0) {
								System.out.println("Välj ett giltigt belopp");
							} else {
								bank.findByNumber(fk).withdraw(amount);
								bank.findByNumber(tk).deposit(amount);
								System.out.println(bank.findByNumber(fk));
								System.out.println(bank.findByNumber(tk));
							}
						} else {
							scan.nextLine();
							scan.nextLine();
							System.out.println("Välj ett giltigt belopp");
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

	/*
	 * gör 6 om rätt typer skrivs in
	 */
	public static void six() {
		System.out.print("namn: ");
		if (scan.hasNextInt()) {
			scan.nextLine();
			scan.nextLine();
			System.out.println("Välj ett giltigt namn");
		} else {
			String namn = scan.next();
			System.out.print("id: ");
			if (scan.hasNextLong()) {
				long idNbr = scan.nextLong();
				System.out.println("konto skapat: " + bank.addAccount(namn, idNbr));
			} else {
				scan.nextLine();
				scan.nextLine();
				System.out.println("Välj ett giltigt idnummer");
			}
		}
	}

	/*
	 * Gör 7 om kontot finns.
	 */
	public static void seven() {
		System.out.print("konto: ");
		if (scan.hasNextInt()) {
			if (!bank.removeAccount(scan.nextInt())) {
				System.out.println("Finns inget matchande konot");
			} else {
				System.out.println("Kontot borttaget");
			}
		} else {
			scan.nextLine();
			scan.nextLine();
			System.out.println("Välj ett giltigt kontonummer");
		}
	}
	/*
	 * gör 8 om banken inte är tom.
	 */

	public static void eight() {
		ArrayList<BankAccount> sortedList = bank.getAllAccounts();
		if (sortedList.isEmpty()) {
			System.out.println("Inga konton finns på banken");
		} else {
			for (int i = 0; i < sortedList.size(); i++)
				System.out.println(sortedList.get(i));
		}

	}

	/*
	 * lite testfall
	 */
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
