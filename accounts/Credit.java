package accounts;
import interfaces.AccountInterface;
import java.util.Scanner;

public class Credit extends account implements AccountInterface{
	private double minBalance=-100000;
	private double maxLimit=20000;
	private double maxLimit2;
	Scanner scan=new Scanner(System.in);
	
	public Credit(){
	
	}
	
	public Credit(String name,String id,DOB d,String nominee,String type,double balance){
		super.name=name;
		super.id=id;
		super.d=d;
		super.nominee=nominee;
		super.accType=type;
		super.balance=balance;
	}
	
	public boolean deposit(double amount){
		if(balance+amount<minBalance){
			System.out.println("##Account Limit did not match");
			return false;
		}
		else{
			balance=balance+amount;
			System.out.println("##Money Deposited Successfully");
			return true;
		}
	}
	
	public boolean withdraw(double amount){
		maxLimit2=balance/2;
		
		if((balance-amount)<minBalance){
			System.out.println("##Minimum balance should be above"+minBalance);
			System.out.println("##Insufficient Balance");
			return false;
		}
		else if(amount>maxLimit || amount>maxLimit2){
			System.out.println("##Withdraw limit excceed");
			return false;
		}
		else {
			balance=balance-amount;
			System.out.println("##Money withdrew Successfull");
			return true;
		}
	}
}