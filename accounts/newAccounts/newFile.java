package accounts.newAccounts;
import accounts.DOB;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class newFile{
	private String path=System.getProperty("user.dir")+"/data/";
	public void createFile(String id){
		try{
			
			File file=new File(path+id+".txt");
			System.out.println("Path:"+file.getAbsolutePath());
			Scanner scan=new Scanner(System.in);
			if(file.exists()){
				System.out.println("The file already exixts\n");
				while(true){
					System.out.println("Do you want to overwrite?\n1.Yes\t2.No\n>>Option: ");
					byte op=scan.nextByte();
					if(op==1){
						file.delete();
						file.createNewFile();
						break;
					}
					else if(op==2){
						copyFile(id);
						break;
					}
				}
			}
			else{
				file.createNewFile();
				System.out.println("File created successfully");
			}
		}
		catch(IOException e){
			System.out.println("An error occured .Failed to proccess file.\n");
			e.printStackTrace();
		}
	}
	
	public void copyFile(String id){
		try{
			File oldFile=new File(id+".txt");
			File newFile=new File(id+"_2.txt");
			FileWriter file=new FileWriter(newFile);
			Scanner scan=new Scanner(oldFile);
			String line;
			while(scan.hasNextLine()){
				line=scan.nextLine();
				file.write(line+"\n");
			}
			System.out.println("Old file renamed as: "+newFile.getPath());
			scan.close();
			file.close();
		}
		catch(IOException e){
			System.out.println("An error occured");
			e.printStackTrace();
		}
	}
	public void insertData(String name,String id,DOB d,String nominee,String type,double balance){
		try{
			double withdraw=0;
			FileWriter file=new FileWriter(new File(path+id+".txt"));
			file.write("\t**Account Details**\n");
			file.write("ID: "+id+"\n");
			file.write("Name: "+name+"\n");
			file.write("Date-of-Birth: "+d+"\n");
			file.write("Nominee: "+nominee+"\n");
			file.write("Account Type: "+type+"\n");
			file.write("Balance: "+balance+"\n");
			file.write("Last Deposit: "+balance+"\n");
			file.write("Last Withdraw: "+withdraw+"\n");
			file.close();
			System.out.println("Data stored successfully\n");
		}
		catch(IOException e){
			System.out.println("An error occured .Failed to store data.\n");
			e.printStackTrace();
		}
	}
}