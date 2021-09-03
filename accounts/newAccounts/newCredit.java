package accounts.newAccounts;
import interfaces.NewAccountInterface;
import accounts.Credit;
import accounts.DOB;
import java.util.Scanner;

public class newCredit extends newAccount{
	private double minBalance=-100000;
	public void inputBalance(){
		System.out.print(">>Enter balance: ");
		balance=scan.nextDouble();
		while(balance<minBalance){
			System.out.println("Minimum balance should be above "+minBalance);
			System.out.print(">>Enter balance: ");
			balance=scan.nextDouble();
		};
	}
	public void createAccount(String name,String id,DOB d,String nominee,double balance){
		
		new Credit(name,id,d,nominee,"Credit",balance);
		newFile n=new newFile();
		n.createFile(id);
		n.insertData(name,id,d,nominee,"Credit",balance);
		System.out.println("\n##The account has been successfully created with ID ["+id+"]\n");
	}
}