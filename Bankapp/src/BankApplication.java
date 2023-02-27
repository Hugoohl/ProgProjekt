import java.util.Scanner;

public class BankApplication {
	static Bank bank = new Bank();
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		menu();
		
		int option = scan.nextInt(); 
		switch (option) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			break;
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
			}
	
	public static void test() {
			bank.addAccount("Erik Johansson", 7208151245L);
			bank.addAccount("Anna Andersson", 9307023397L);
			bank.addAccount("Johan Svensson", 8102107584L);
			bank.addAccount("Sofia Lundqvist", 6408279876L);
			bank.addAccount("Jesus Gustavsson", 7812033218L);
			bank.addAccount("Linda Nilsson", 9503289021L);
			bank.addAccount("Dickbert Carlsson", 8206296643L);
			bank.addAccount("Sara Bergström", 8707225213L);
			bank.addAccount("Kristina Söderberg", 9201218765L);
			bank.addAccount("Magnus Andersson", 6909154321L);
		
	}
}
