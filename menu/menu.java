package menu;

public class menu
{
	
	public static void mainMenu()
	{
		System.out.println("\n\t\tWelcome to Custom Bank\n");
		System.out.println("\t1.Create Account");
		System.out.println("\t2.Login");
		System.out.println("\t0.Exit");
		
		System.out.print(">>Option: ");
	}
	public static void createAccountMenu()
	{
		
		System.out.println("\n\t1.Debit Account");
		System.out.println("\t2.Credit account");
		System.out.println("\t3.Saving Accounts");
		System.out.println("\t0.Back to Menu");
		System.out.print(">>Option: ");
	}
	
	public static void loginMenu()
	{
		System.out.println("\n\t1.Check Balance");
		System.out.println("\t2.Deposit Money");
		System.out.println("\t3.Withdraw Money");
		System.out.println("\t4.Change Account Name");
		System.out.println("\t5.Change Nominee");
		System.out.println("\t0.Back to menu");
		System.out.print(">>Option: ");
	}
}