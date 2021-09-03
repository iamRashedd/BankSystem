package accounts.newAccounts;
import interfaces.NewAccountInterface;
import accounts.Debit;
import accounts.DOB;

public class newDebit extends newAccount{
	
	
	public void inputBalance(){
		double maxBalance=100000;
		System.out.print(">>Enter Balance: ");
		balance=scan.nextDouble();
		while(balance>maxBalance){
			System.out.println("Maximum amount limit(100000) excceed");
			System.out.print(">>Enter balance: ");
			balance=scan.nextDouble();
		}
	}
	
	public void createAccount(String name,String id,DOB d,String nominee,double balance){
		new Debit(name,id,d,nominee,"Debit",balance);
		newFile n=new newFile();
		n.createFile(id);
		n.insertData(name,id,d,nominee,"Debit",balance);
		System.out.println("\n##The account has been successfully created with ID [ "+id+" ]\n");
		
	}
}