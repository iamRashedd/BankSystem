package menu;
import bank.Bank;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.lang.NullPointerException;
import java.io.FileNotFoundException;

public class searchFile{
	protected String id;
	protected boolean result=false;
	private String path=System.getProperty("user.dir")+"/data/";
	
	public searchFile(String id){
		this.id=id;
		if(value())
		{
			System.out.println("\n##The Account File has been found\n");
			System.out.println("Reading from file......");
			printAccount();
		}
	}
	
	public boolean value(){
		boolean check=false;
		try{
			File file=new File(path+id+".txt");
			if(file.exists()){
				System.out.println("The Account File has been found\n");
				check=true;
				result=true;
			}
			else
				System.out.println("The Account File has not been found\n");
		}
		catch(NullPointerException e){
		}
		return check;
		
	}
	
	public void printAccount(){
		try{
			File file=new File(path+id+".txt");
		
			Scanner scan=new Scanner(file);
			while(scan.hasNextLine()){
			String line=scan.nextLine();
			System.out.println(line);
			}
			scan.close();
		
		}
		catch(FileNotFoundException e){
			System.out.println("An error occured");
			e.printStackTrace();
		}
	}
	public String getId(){return id;}
	public boolean exists(){return result;}
	
	
	public String searchLine(String data){
		String gotLine="";
		try{
			String line;
			File file=new File(path+id+".txt");
			Scanner fscan = new Scanner(file);
			while(fscan.hasNextLine()){
				line=fscan.nextLine();
				if(line.startsWith(data)){
					gotLine=line;
					break;
				}
			}
			fscan.close();
		}
		catch(IOException e){
			System.out.println("An error occured");
			e.printStackTrace();
		}
		return gotLine;
	}	
}