package busCompleteproject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	Scanner i=new Scanner(System.in);
	Scanner s=new Scanner(System.in);
	String Aid;
	String id;
	String T_no;
	String name;
	String regName;
    String email;
	String phonenum;
	String password;
	String fromlocation;
	String Tolocation;
	Date locdate;
	Date fromdate;
	Date usefromdate;
	String busno;
	String Uname;
	String busid;
	String busno1;
	String busname;
	String Time;
	String bustype;
	String Age;
	int capacity,NoOfSeats;


	public  void Register() 
	{
		
		Regname();
		email();
		phnum();
		
		System.out.println("Create  your password : ");
		password=s.nextLine();
		
	}

	
	/*public boolean Age()
	{

		System.out.println("Enter your Age : ");
	    String cAge=s.nextLine();
	    String regex="^(?:1[01]|[0-9]|120|1[8-9]|[2-9][0-9])$";
		//Pattern p=Pattern.compile(regex);
	    Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(cAge);
		
		if(m.matches())
		{
			Age=cAge;
			return true;
		}
		else if(cAge==null)
		{
			System.out.println("age is empty please give a one age .....");
			return Age();
		}
		else
		{
			System.out.println("sry age should more than Eighteen years or only numbers...... ");
			return Age();
		}
		
	}*/


	public boolean id()
	{
		System.out.println("Enter your Id : ");
	    String cAid=s.nextLine();
	    String regex="^[0-9]{1,6}$";
		//Pattern p=Pattern.compile(regex);
	    Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(cAid);
		if(m.matches())
		{
			Aid=cAid;
			return true;
		}
		else if(cAid==null)
		{
			System.out.println("id is empty please give a one id .....");
			return id();
		}
		else
		{
			System.out.println("sry id should mininum three numbers or only numbers...... ");
			return id();
		}
	}



     public boolean name() 
     {
		System.out.println("Enter your Name : ");
		String cname=s.nextLine();
		String regex="^[A-Za-z\\s]{2,15}$";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(cname);
		if(m.matches())
		{
			name=cname;
			return true;
		}
		else if(cname==null)
		{
			System.out.println("Name is Empty please give a one name ");
			return name();
		}
		else
		{
			System.out.println("sry name should minimum three char or only characters...... ");
			return name();
		}
		
	}
     
     public boolean Regname() 
     {
		System.out.println("Enter your Name : ");
		String cname=s.nextLine();
		String regex="^[A-Za-z\\s]{2,15}$";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(cname);
		if(m.matches())
		{
			regName=cname;
			return true;
		}
		else if(cname==null)
		{
			System.out.println("Name is Empty please give a one name ");
			return Regname();
		}
		else
		{
			System.out.println("sry name should minimum three char or only characters...... ");
			return Regname();
		}
		
	}
     
   
	public boolean email()
	{
		System.out.println("Enter your Email : ");
		String cemail=s.nextLine();
		String regex="^[a-zA-Z]{1}[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]{5}[.]{1}[a-zA-z]+$";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(cemail);
		if(m.matches()) 
		{
			email=cemail;
			return true;
		}
		else if(cemail==null)
		{
			System.out.println("Email is empty please give a email ");
			return email();
		}
		else
		{
			System.out.println("Email Formate are wrong please give a correct email id ...... ");
			return email();
		}
		
	}
	
	public boolean phnum()
	{
		System.out.println("Enter the phone Number : ");
		String cphnum=s.nextLine();
		String regex="^[7-9]{1}[0-9]{5,10}$";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(cphnum);
		if(m.matches()) 
		{
			phonenum=cphnum;
			return true;
		}
		else if(cphnum==null)
		{
			System.out.println("phonenum is empty please give a phone number ");
			return phnum();
		}
		else
		{
			System.out.println(" phone number should only numbers or proper phone number...... ");
			return phnum();
		}
		
	}

	public boolean fromlocation() 
	{
		System.out.println("Enter your From Loacation : ");
		String cfromlocation=s.nextLine();
		String regex="^[A-Za-z]\\w{2,20}$";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(cfromlocation);
		if(m.matches()) 
		{
			fromlocation=cfromlocation;
			return true;
		}
		else if(cfromlocation==null)
		{
			System.out.println("Fromlocation is Empty please give a From Location ");
			return fromlocation();
		}
		else
		{
			System.out.println("sry fromlocation should only characters ...... ");
			return fromlocation();
		}
		
	}
	
	public boolean Tolocation()
	{
		System.out.println("Enter your Destination : ");
		String cTolocation=s.nextLine();
		String regex="^[A-Za-z]\\w{2,20}$";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(cTolocation);
		if(m.matches())
		{
			Tolocation=cTolocation;
			return true;
		}
		else if(cTolocation==null)
		{
			System.out.println("Destination  is Empty please give a one Destination ");
			return Tolocation();
		}
		else
		{
			System.out.println("sry Destination should only characters...... ");
			return Tolocation();
		}
		
	}
	public boolean Cdate() throws ParseException 
	{
		try {
		System.out.println("Enter your journey date yyyy-MM-dd: ");
		String inputdate=s.nextLine();
		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
		String ldate=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		
		usefromdate=simple.parse(inputdate);
		locdate=simple.parse(ldate);
		
		if(!locdate.after(usefromdate))
		{
			fromdate=usefromdate;
			//System.out.println(fromdate);
	
			return true;
		}
		else if(inputdate==null)
		{
			System.out.println("Date is empty please give a one date ....");
			return Cdate();
		}
		
		else
			
		{
			System.out.println("oops! you enter already passed date.... ");
			return Cdate();
		}
		}
		catch(Exception e)
		{
			System.out.println("Give a correct Date format.... " );
			return Cdate();
		}
		 
	}

	public void no()
	{
		System.out.println("choose your flexible bus no");
		busno=s.nextLine();
			
	}
	public void noforview()
	{
		System.out.println("Enter your booked busno : ");
		busno=s.nextLine();
		
	}

	public boolean BNumber()
	{
		System.out.println("Enter the Bus_No :");
		String num=s.nextLine();
		System.out.println();
		String regex="^[0-9]{1,10}$";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(num);
		if(m.matches())
		{
			busno=num;
			return true;
		}
		else if(num==null)
		{
			System.out.println("Bus no is empty please enter a number....");
			return BNumber();
		}
		else
		{
			System.out.println("Bus no should be a number....");
			return BNumber();
		}
	
		
	}
	
	 public boolean Bus_name() 
     {
		System.out.println("Enter the Bus_Name :");
		String	cname=s.nextLine();
		String regex="^[A-Za-z\\s]{3,15}$";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(cname);
		if(m.matches())
		{
			busname=cname;
			return true;
		}
		else if(cname==null)
		{
			System.out.println("Bus_Name is Empty please give a one name ");
			return Bus_name();
		}
		else
		{
			System.out.println("sry Bus_Name should minimum three char or only characters...... ");
			return Bus_name();
		}
		
	}
     
	 public boolean B_Time() 
     {
		 System.out.println("Enter the Bus_Time 0:00 pm|am :");
		 String time=s.nextLine();
		String regex="^(1[012]|[1-9]):[0-5][0-9](\\s)?(?i)(am|pm)$";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(time);
		if(m.matches())
		{
			Time=time;
			return true;
		}
		else if(time==null)
		{
			System.out.println("Bus_Time is Empty please give a Time ");
			return B_Time();
		}
		else
		{
			System.out.println("sry Bus_Time is incorrect formate please give a correct formate...... ");
			return B_Time();
		}
		
	 }
	 
	 public boolean B_Type() 
     {
		 System.out.println("Please select a Bus_Type");
		 System.out.println("Enter 1 to Ac/Sleeper");
		 System.out.println("Enter 2 to Ac/Seated");
		 System.out.println("Enter 3 to Ac/Sleeper-seated");
		 System.out.println("Enter 4 to Non-Ac/Sleeper");
		 System.out.println("Enter 5 to Non-Ac/Seated");
		 System.out.println("Enter 6 to Non-Ac/Sleeper-seated");
		 int op=i.nextInt();
		
		 if(op==1)
		 {
			 bustype=" Ac/Sleeper"; 
			 return true;
		 }
		 else if(op==2)
		 {
			 bustype=" Ac/Seated"; 
			 return true;
		 }
		 else if(op==3)
		 {
			 bustype="Ac/Sleeper-seated ";
			 return true;
		 }
		 else if(op==4)
		 {
			 bustype="Non-Ac/Sleeper "; 
			 return true;
		 }
		 else if(op==5)
		 {
			 bustype="Non-Ac/Seated ";
			 return true;
		 }
		 else if(op==6)
		 {
			 bustype="Non-Ac/Sleeper-seated"; 
			 return true;
		 }
		 else 
		 {
			 System.out.println("Please select a valid option");
			 return B_Type();
		 }

	
		
	 }
	 
	 public boolean Capacity()
	 {
			System.out.println("Enter the Bus Capacity :");
			int num=i.nextInt();
			if(num>0 && num<=40)
			{
				capacity=num;
				return true;
			}
			else if(num==0)
			{
				System.out.println("Capacity  is empty please enter a number....");
				return Capacity();
			}
			else
			{
				System.out.println("Capacity should be a number....");
				return Capacity();
			}
		
			
	}
	 
	 public boolean Update_Bno()
		{
		   
		    System.out.println("Enter which Bus_no you want to Edit :");
	    	String num=s.nextLine();
			
			String regex="^[0-9]{1,3}$";
			Pattern p=Pattern.compile(regex);
			Matcher m=p.matcher(num);
			if(m.matches())
			{
				busno=num;
				return true;
			}
			else if(num==null)
			{
				System.out.println("Bus no is empty please enter a number....");
				return Update_Bno();
			}
			else
			{
				System.out.println("Bus no should be a number....");
				return Update_Bno();
			}
		
			
		}
	 
	 public boolean Updated_Bus_no()
		{
		   
		    System.out.println("Enter your updated Bus_Number detailes :");
	    	String num=s.nextLine();
			
			String regex="^[0-9]{1,3}$";
			Pattern p=Pattern.compile(regex);
			Matcher m=p.matcher(num);
			if(m.matches())
			{
				busno1=num;
				return true;
			}
			else if(num==null)
			{
				System.out.println("Bus no is empty please enter a number....");
				return Updated_Bus_no();
			}
			else
			{
				System.out.println("Bus no should be a number....");
				return Updated_Bus_no();
			}
		
			
		}
	 
	 public boolean Updated_Bus_name() 
     {
		 System.out.println("Enter updated  Bus_Name :");
		 String	cname=s.nextLine();
		String regex="^[A-Za-z\\s]{3,20}$";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(cname);
		if(m.matches())
		{
			busname=cname;
			return true;
		}
		else if(cname==null)
		{
			System.out.println("Bus_Name is Empty please give a one name ");
			return Updated_Bus_name();
		}
		else
		{
			System.out.println("sry Bus_Name should minimum three char or only characters...... ");
			return Updated_Bus_name();
		}
		
	}
	 
	 public boolean Upadated_B_Time() 
     {
		 System.out.println("Enter Updated  Bus_Time - 00:00 pm-:");
		 String time=s.nextLine();
		String regex="^(1[012]|[1-9]):[0-5][0-9](\\\\s)?(?i)(am|pm)$";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(time);
		if(m.matches())
		{
			Time=time;
			return true;
		}
		else if(time==null)
		{
			System.out.println("Bus_Time is Empty please give a Time ");
			return Upadated_B_Time();
		}
		else
		{
			System.out.println("sry Bus_Time is incorrect formate please give a correct formate...... ");
			return Upadated_B_Time();
		}
		
	 }


	public boolean Upodated_bus_Mnumber() {
	
		System.out.println("Enter the Updated mobile Number : ");
		String cphnum=s.nextLine();
		String regex="^[7-9]{1}[0-9]{5,10}$";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(cphnum);
		if(m.matches()) 
		{
			phonenum=cphnum;
			return true;
		}
		else if(cphnum==null)
		{
			System.out.println("phonenum is empty please give a phone number ");
			return Upodated_bus_Mnumber();
		}
		else
		{
			System.out.println(" phone number should only numbers or give a proper phone number...... ");
			return Upodated_bus_Mnumber();
		}
		
	}
	 
	 public boolean Upodated_bus_Capacity()
	 {
		 System.out.println("Enter the Updated Bus Capacity :");
			int num=i.nextInt();
			if(num>0 && num<=40)
			{
				capacity=num;
				return true;
			}
			else if(num==0)
			{
				System.out.println("Capacity  is empty please enter a number....");
				return Upodated_bus_Capacity();
			}
			else
			{
				System.out.println("Capacity should be a number or less than 40....");
				return Upodated_bus_Capacity();
			}
	 }

	 public boolean Delete_Bno()
		{
		   
		    System.out.println("Enter a Bus_No to delete a Bus   :");
	    	String num=s.nextLine();
			
			String regex="^[0-9]{1,3}$";
			Pattern p=Pattern.compile(regex);
			Matcher m=p.matcher(num);
			if(m.matches())
			{
				busno=num;
				return true;
			}
			else if(num==null)
			{
				System.out.println("Bus no is empty please enter a number....");
				return Delete_Bno();
			}
			else
			{
				System.out.println("Bus no should be a number....");
				return Delete_Bno();
			}
		
			
		}

	 
	  public boolean  Selecte_Bus()
		{
		   
		    System.out.println("Enter a Bus_No to select a Bus   :");
	    	String num=s.nextLine();
			
			String regex="^[0-9]{1,3}$";
			Pattern p=Pattern.compile(regex);
			Matcher m=p.matcher(num);
			if(m.matches())
			{
				busno=num;
				return true;
			}
			else if(num==null)
			{
				System.out.println("Bus no is empty please enter a number....");
				return Selecte_Bus();
			}
			else
			{
				System.out.println("Bus no should be a number....");
				return Selecte_Bus();
			}
		
			
		}
	  
	  public boolean EditByid()
	  {
		  System.out.println("Enter which  Id you want to update : ");
		    String cAid=s.nextLine();
		    String regex="^[0-9]{1,5}$";
			Pattern p=Pattern.compile(regex);
			Matcher m=p.matcher(cAid);
			if(m.matches())
			{
				id=cAid;
				return true;
			}
			else if(cAid==null)
			{
				System.out.println("id is empty please give a one id .....");
				return EditByid();
			}
			else
			{
				System.out.println("sry id should  only numbers...... ");
				return EditByid();
			}
		  
	  }


	public boolean EditByname() {
		
		System.out.println("Enter which userName you want to update  : ");
		String cname=s.nextLine();
		String regex="^[A-Za-z\\s]{2,15}$";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(cname);
		if(m.matches())
		{
			Uname=cname;
			return true;
		}
		else if(cname==null)
		{
			System.out.println("Name is Empty please give a one name ");
			return EditByname();
		}
		else
		{
			System.out.println("sry name should only characters...... ");
			return EditByname();
		}
		
		
		
	}


	public boolean Ticket_No() {
		
		System.out.println("Enter which Ticket_No you want to Cancel ");
		String cAid=s.nextLine();
	    String regex="^[0-9]{1,5}$";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(cAid);
		if(m.matches())
		{
			T_no=cAid;
			return true;
		}
		else if(cAid==null)
		{
			System.out.println("Ticket Number is empty please give a one id .....");
			return Ticket_No();
		}
		else
		{
			System.out.println("sry Ticket Number should  only numbers...... ");
			return Ticket_No();
		}
	  
		
	}


	public boolean Howmanyseats() {
		
		System.out.println("Enter How many seats you want to book : ");
		int seat=i.nextInt();
		if(seat>0 && seat<=40)
		{
			NoOfSeats=seat;
			return true;
		}
		else if(seat==0)
		{
			System.out.println("Seat is empty please enter a numbar......");
			return Howmanyseats();
		}
		else 
		{
			System.out.println("Seat should be a numbar......");
			return Howmanyseats();	
		}
	}

}
