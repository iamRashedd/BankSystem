package accounts;
import interfaces.AccountInterface;

public abstract class account implements AccountInterface{
	protected String name;
	protected String id;
	protected DOB d;
	protected String nominee;
	protected double balance;
	protected String accType;
	
	public account(){
		this.name="";
		this.id="";
		this.d=new DOB();
		this.nominee="";
		this.balance=0;
	}
	
	public account(String name,String id,DOB d,String nominee,double balance){
		this.name=name;
		this.d=d;
		this.id=id;
		this.nominee=nominee;
		this.balance=balance;
	}
	
	public boolean deposit(double amount){
		if(amount>0)
		{
			this.balance=this.balance+amount;
			System.out.println("##Money Deposited Successfull");
			return true;
			
		}
		else
			return false;
		
	}
	
	public boolean withdraw(double amount){
		if(this.balance>=amount){
			this.balance=this.balance-amount;
			System.out.println("##Money withdrew successfully");
			return true;
		}
		else{
			System.out.println("\n##Withdraw Failed\n##Insufficient Balance!!\n");
			return false;
		}
	}
	
	public void setAccountName(String name){this.name=name;}
	public void setAccountNominee(String name){this.nominee=name;}
	public void setAccountType(String type){this.accType=type;}
	public String getAccountName(){return this.name;}
	public String getAccountID(){return this.id;}
	public DOB getAccountDate(){return this.d;}
	public String getAccountNominee(){return this.nominee;}
	public double getAccountBalance(){return this.balance;}
	public String getAccountType(){return this.accType;}
	
	public void printAccount(){
		System.out.println("\n\t**Account Details**\n");
		System.out.println("Name: "+this.name);
		System.out.println("ID: "+this.id);
		System.out.println("Date-of-Birth: "+this.d);
		System.out.println("Nominee: "+this.nominee);
		System.out.println("Account Type: "+this.accType);
		System.out.println("Balance: "+this.balance);	
	}
}