package accounts;
import interfaces.AccountInterface;
import java.util.Scanner;

public class Savings extends account implements AccountInterface{
	public Savings(){
		
	}
	
	public Savings(String name,String id,DOB d,String nominee,String type,double balance){
		super.name=name;
		super.id=id;
		super.d=d;
		super.nominee=nominee;
		super.accType=type;
		super.balance=balance;
	}
}
	
	