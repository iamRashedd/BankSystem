package menu;
import java.util.Scanner;
import accounts.*;
import interfaces.AccountInterface;

public class fileAssign{
	private byte accType;
	private double balance;
	private String id;
	private String name;
	private String nominee;
	private DOB d;
	private AccountInterface account;
	searchFile sf;
	
	public fileAssign(searchFile sf){
		this.id=sf.getId();
		this.sf=sf;
		setType();
		setName();
		setNominee();
		setBalance();
		setDOB();
		
		assignInterface();
		
	}
	
	
	public void setType(){
		String line=sf.searchLine("Account Type");
		line = line.replaceAll("Account Type: ","");
		line = line.trim();
	
		if(line.compareTo("Debit")==0)
			accType=1;
		else if(line.compareTo("Credit")==0)
			accType=2;
		else if(line.compareTo("Savings")==0)
			accType=3;
	}
	public void setName(){
		String line=sf.searchLine("Name");
		line =line.replaceAll("Name: ","");
		name=line.trim();
	}
	
	public void setNominee(){
		String line=sf.searchLine("Nominee");
		line =line.replaceAll("Nominee: ","");
		nominee=line.trim();
	}
	
	public void setDOB(){
		String line=sf.searchLine("Date-of-Birth");
		line =line.replaceAll("Date-of-Birth: ","");
		line=line.trim();
		String[] line2=line.split("-");
		int day     = Integer.parseInt(line2[0]);
		int month = Integer.parseInt(line2[1]);
		int year    = Integer.parseInt(line2[2]);
		
		d=new DOB(day,month,year);
		
	}
	public void setBalance(){
		String line=sf.searchLine("Balance");
		line =line.replaceAll("Balance: ","");
		balance=Double.parseDouble(line);
		
	}
	
	public void assignInterface(){
		
		if(accType==1){
			account=new Debit(name,id,d,nominee,"Debit",balance);
		}
		else if(accType==2){
			account=new Credit(name,id,d,nominee,"Credit",balance);
		}
		else{
			account=new Savings(name,id,d,nominee,"Savings",balance);
		}
	}
	
	public AccountInterface getInterface(){
		return account;
	}
	
}