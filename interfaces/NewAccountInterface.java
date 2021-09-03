package interfaces;
import accounts.DOB;

public interface NewAccountInterface{
		void inputName();
		void inputDOB();
		void inputID();
		void inputNominee();
		void inputBalance();
		void createAccount( String name, String id, DOB d, String nominee, double balance);
}