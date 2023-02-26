import java.util.Scanner;

public class BankApplication {
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		menu();
		Bank bank = new Bank();
		int option = scan.nextInt(); 
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
	
	
}
