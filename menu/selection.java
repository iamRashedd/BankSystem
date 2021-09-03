package menu;
import interfaces.AccountInterface;
import java.util.Scanner;
import java.util.InputMismatchException;

public class selection{
	protected byte i;
	protected String id;
	protected byte select;
	protected byte select2;
	protected String name;
	protected boolean value;
	Scanner scan=new Scanner(System.in);
	
	public selection(){
	}
	
	public void select(){
		do{
			try{
				menu.mainMenu();
				select = 10;
				select = scan.nextByte();
				
				switch(select){
					case 0:
						break;
					case 1:
						new newSelection();
						break;
					case 2:
						scan.skip ( "\\R" ); 
						System.out.print("\n>>Enter ID: ");
						String input=scan.nextLine();
						input=input.trim();
						System.out.println("Line-38");
						searchFile sf=new searchFile(input);
						if(sf.exists()){
							fileAssign f = new fileAssign(sf);
							AccountInterface account=f.getInterface();
							String id=input;
							do{
								double amount;
								double iBalance;
								menu.loginMenu();
								select2=scan.nextByte();
								switch(select2){
									case 0:
										break;
									case 1:
										System.out.println(">>Account Balance: "+ account.getAccountBalance());
										break;
									case 2:
										iBalance=account.getAccountBalance();
										System.out.print(">>Enter Amount to Deposit: ");
										amount=scan.nextDouble();
										value=account.deposit(amount);
										if(value){
											editFile.setBalance(id,account.getAccountBalance());
											editFile.setLastDeposit(id,account.getAccountBalance()-iBalance);
										}
										break;
									case 3:
										iBalance=account.getAccountBalance();
										System.out.print(">>Enter Amount to Withdraw: ");
										amount=scan.nextDouble();
										value=account.withdraw(amount);
										if(value){
											editFile.setBalance(id,account.getAccountBalance());
											editFile.setLastWithdraw(id,iBalance-account.getAccountBalance());
										}
										break;
									case 4:
										System.out.print(">>Enter Correct Name: ");
										scan.skip("\\R");
										name=scan.nextLine();
										account.setAccountName(name);
										editFile.setName(id,name);
										System.out.println("##Account name changed successfully");
										account.printAccount();
										break;
									case 5:
										System.out.print(">>Enter New Nominee: ");
										scan.skip("\\R");
										name=scan.nextLine();
										account.setAccountNominee(name);
										editFile.setNominee(id,name);
										System.out.println("##Account Nominee changed successfully");
										account.printAccount();
										break;
									default:
										System.out.println("\n##Invalid selection!!");
								}
							}while(select2!=0);
						}
						else 
							System.out.println("\n##ID not Found!!");
					
						break;
					default:
						System.out.println("\n##Invalid selection!!");
					
				}
			}
			catch(InputMismatchException e){
				System.out.println("\n##Input mismatched\n");
				e.printStackTrace();
				scan = new Scanner(System.in);
			}
			
		}while(select!=0);
	
	}
}