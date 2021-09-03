package accounts.newAccounts;
import accounts.DOB;
import interfaces.NewAccountInterface;
import bank.Bank;
import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;

class abstract newAccount implements NewAccountInterface{
	protected Scanner scan=new Scanner(System.in);
	protected String name;
	protected String id;
	protected DOB d;
	protected byte day,month;
	protected short year;
	protected String nominee;
	protected double balance;
	
	public newAccount(){
		try{
		inputName();
		inputDOB();
		inputID();
		inputNominee();
		inputBalance();
		createAccount(name,id,d,nominee,balance);
		}
		catch(InputMismatchException e){
			System.out.println("\t###Input mismatched");
			System.out.println("\t###Unable to create accoount");
			e.printStackTrace();
		}
	}
	
	public void inputName(){
		System.out.print(">>Enter name: ");
		this.name=scan.nextLine();
	}
	public void inputDOB(){
		System.out.println(">>Enter Date of Birth--");
		
		do{
			System.out.print(">>Day: ");
			day=scan.nextByte();
			if(day<=0||day>31){
				day=0;
				System.out.println("\n##Invalid Date!!\n");
			}
		}while(day<=0||day>31);
		
		do{
			System.out.print(">>Month: ");
			month=scan.nextByte();
			if(month<=0||month>12){
				month=0;
				System.out.println("\n##Invalid Month!!\n");
			}
		}while(month<=0||month>12);
		
		do{
			System.out.print(">>Year: ");
			year=scan.nextShort();
			if(year<1800){
				year=0;
				System.out.println("\n##Ops! You are dead!!\n");
			}
		}while(year<1800);
		
		this.d=new DOB(day,month,year);
		scan.skip("\\R");
	}
	public void inputID(){
		this.id=Bank.generateID();
	}
	public void inputNominee(){
		
		System.out.print(">>Enter Nominee name: ");
		nominee=scan.nextLine();
	}
	public void inputBalance(){
		System.out.print(">>Enter balance: ");
		balance=scan.nextDouble();
	}
	public abstract void createAccount(String name,String id,DOB d,String nominee,double balance){
		
	}
}