package busCompleteproject;

import java.sql.SQLException;
import java.util.Scanner;

public class Booking {

	Scanner s=new Scanner(System.in);
	Scanner i=new Scanner(System.in);
	
	
	public void bookingdetailes() throws SQLException 
	{
		System.out.println("Enter 1 For || show the passenger list");
		System.out.println("Enter 2 For || Go to back");
		int option=i.nextInt();
		if(option==1)
		{
			BookingDao bookingdao=new BookingDao();
			bookingdao.Showpassangeralist();
		}
		else if(option==2)
		{
			All_Tables all_table=new All_Tables();
			all_table.tables();
		}
		
	}
	
	public boolean state(Validation validate) 
	{
		int f=0,k;
		String floc[]= {"chennai","coimbatore","tirunelveli","tenkasi","bengalore","tirchy","madurai","salem"};
		String dloc[]= {"chennai","coimbatore","tirunelveli","tenkasi","bengalore","tirchy","madurai","salem"};
		if(!validate.fromlocation.equalsIgnoreCase(validate.Tolocation)) 
		{
			for( k=0;k<floc.length;k++)
			{
				if(validate.fromlocation.equalsIgnoreCase(floc[k]))
				{
				    f++;
			    }
			    if(validate.Tolocation.equalsIgnoreCase(floc[k])) 
			    {
			        f++;
		        }
			}
		
	   }
	   else
	   {
			return false;
	   }
		return f==2;
	 }
	


	public boolean isAvailable(Validation validate2) throws SQLException
	{
		int capacity=0;
		int booked=0;
		//System.out.println("Check1");
		BusDao busdao=new BusDao();
		capacity=busdao.getCapacity(validate2);
		//System.out.println(capacity);
		BookingDao bookingdao=new BookingDao();
		booked=bookingdao.getCount(validate2);
		//System.out.println(booked);
	    return booked<capacity;
		
	}

	public void getvalue1() 
	{
		Validation validate=new Validation();
		validate.no();
	}
}
