package interfaces;
import accounts.DOB;

public interface AccountInterface{
	public boolean deposit(double amount);
	public boolean withdraw(double amount);
	public void setAccountName(String name);
	public void setAccountNominee(String name);
	public void setAccountType(String type);
	public String getAccountName();
	public String getAccountID();
	public DOB getAccountDate();
	public String getAccountNominee();
	public double getAccountBalance();
	public String getAccountType();
	public void printAccount();
}