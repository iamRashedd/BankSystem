package accounts.newAccounts;
import interfaces.NewAccountInterface;
import accounts.Savings;
import accounts.DOB;
import bank.Bank;

public class newSavings extends newAccount{
	
	public void createAccount(String name,String id,DOB d,String nominee,double balance){
		new Savings(name,id,d,nominee,"Savings",balance);
		newFile n=new newFile();
		n.createFile(id);
		n.insertData(name,id,d,nominee,"Savings",balance);
		System.out.println("\n##The account has been successfully created with ID ["+id+"]\n");
		
	}
}