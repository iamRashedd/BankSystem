package menu;
import accounts.newAccounts.*;
import java.util.Scanner;

public class newSelection
{
	Scanner scan=new Scanner(System.in);
	protected byte select;
	
	public newSelection()
	{
			menu.createAccountMenu();
			select=scan.nextByte();
			switch(select)
			{
				case 1:
					new newDebit();
					break;
				case 2:
					new newCredit();
					break;
				case 3:
					new newSavings();
					break;
				case 0:
					break;
				default:
					System.out.println("\n##INVALID SELECTION");
					
			}
		
	}
}
			
			