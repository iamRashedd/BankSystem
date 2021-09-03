package accounts;
import interfaces.AccountInterface;
import java.util.Scanner;

public class Debit extends account implements AccountInterface{
	private double maxBalance=100000;
	private double maxLimit=20000;
	Scanner scan=new Scanner(System.in);
	
	public Debit(){
	
	}
	
	public Debit(String name,String id,DOB d,String nominee,String type,double balance){
		super.name=name;
		super.id=id;
		super.d=d;
		super.nominee=nominee;
		super.accType=type;
		super.balance=balance;
	
	}
	
	public boolean deposit(double amount){
		if(balance+amount>maxBalance){
			System.out.println("##Account Limit Exceed");
			return false;
		}
		else{
			balance=balance+amount;
			System.out.println("##Money Deposited Successfully");
			return true;
		}
	}
	
	public boolean withdraw(double amount){
		
		if(amount>maxLimit){
			System.out.println("##Single Transaction Limit Exceed");
			return false;
		}
		else{
			balance=balance-amount;
			System.out.println("##Money withdrew Successfully");
			return true;
		}
	}
} 