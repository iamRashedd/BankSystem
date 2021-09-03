package bank;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.IOException;

public class Bank
{
	public static int serial=0;
	private static String path=System.getProperty("user.dir")+"/data/";
	public static SimpleDateFormat f=new SimpleDateFormat("yyyy-MM");
	
	public static String generateID(){
		
		String id;
		Date date=new Date();
		String d=f.format(date);
		
		do{
		
			Bank.serial++;
			
			id = String.format("%s-%05d" , d , serial );
		
		}while(idExists(id));
		
		return id;
	}
	
	private static boolean idExists(String id){
		boolean check=false;
		try{
			File file=new File(path+id+".txt");
			if(file.exists())
				check=true;
		}
		catch(NullPointerException e){
			
		}
		return check;
	}
	
}