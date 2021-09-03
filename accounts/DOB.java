package accounts;

public class DOB{
	public int day,month,year;
	
	public DOB(){
		day=0;
		month=0;
		year=0;
	}
	
	public DOB(int day,int month,int year){
		this.day=day;
		this.month=month;
		this.year=year;
	}
	
	public String toString(){
		return String.format("%02d-%02d-%04d",day,month,year);
	}
}