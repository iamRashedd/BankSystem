package menu;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;


public class editFile{
	private static String path=System.getProperty("user.dir")+"/data/";
	
	public static void setBalance(String id,double amount){
		editLine(id,"Balance: ",String.valueOf(amount));
	}
	public static void setLastDeposit(String id,double amount){
		editLine(id,"Last Deposit: ",String.valueOf(amount));
	}
	public static void setLastWithdraw(String id,double amount){
		editLine(id,"Last Withdraw: ",String.valueOf(amount));
	}
	public static void setName(String id,String value){
		editLine(id,"Name: ",value);
	}
	public static void setNominee(String id,String value){
		editLine(id,"Nominee: ",value);
	}
	
	private static void editLine(String id,String work,String value){
		try{
			File oldFile = new File(path+id+".txt");
			File newFile = new File(path+"temp.txt");
			FileWriter file = new FileWriter(newFile);
			Scanner scan=new Scanner(oldFile);
			String line;
			while(scan.hasNextLine()){
				line=scan.nextLine();
				if(line.startsWith(work)){
					line=work+value;
				}
			
				file.write(line+"\n");
			}
			scan.close();
			file.close();
			oldFile.delete();
			File temp = new File(path+id+".txt");
			newFile.renameTo(temp);
		
		}
		catch ( IOException e ){
			System.out.println("An error occured");
			e.printStackTrace();
		}
		
	}
	
}