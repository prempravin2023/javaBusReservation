package busCompleteproject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BusDao extends Get_Connection {

	
	Scanner i=new Scanner(System.in);
	Scanner s=new Scanner(System.in);

	public void insert(Validation validate) throws SQLException
	{
		String q="insert into Buses(Bus_No,Bus_name,Time,Bus_Type,Driver_Num,Capacity)values(?,?,?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setString(1,validate.busno);
		pst.setString(2,validate.busname);
		pst.setString(3,validate.Time);
		pst.setString(4,validate.bustype);
		pst.setString(5,validate.phonenum);
		pst.setInt(6,validate.capacity);
		int r=pst.executeUpdate();
		if(r>0)
		{
			System.out.println("bus added.....");
		}
		System.out.println("Enter 1 For || go to Back");
		int option=i.nextInt();
		if(option==1)
		{
		Bus bus=new Bus();
		bus.busdetailes();
		}
	}
	
	public void update(Validation valitate) throws SQLException 
	{
		
		 String q="update Buses set Bus_No=? where Bus_No=?";
      	 java.sql.PreparedStatement pst=con.prepareStatement(q);
     	   pst.setString(1,valitate.busno1);
     	  pst.setString(2,valitate.busno);
     	  int r=pst.executeUpdate();
    	  
     	 if(r>0)
		 {
    		 System.out.println("Updated.......");
		 }
    	 else
    	 {
    		 System.out.println("Invalid detailes.....");
    	 }
    	 System.out.println("Enter 1 For || go to Back");
 		int option=i.nextInt();
 		if(option==1)
 		{
 		Bus bus=new Bus();
 		bus.busdetailes();
 		}
    	 
		 
	}



	public void updatebusname(Validation validate) throws SQLException
	{
		 String q="update Buses set Bus_name=? where Bus_No=?";
      	 java.sql.PreparedStatement pst=con.prepareStatement(q);
    	  pst.setString(1,validate.busname);
    	  pst.setString(2,validate.busno);
    	  int r=pst.executeUpdate();
    	  
    	 if(r>0)
		{
    		 System.out.println("Updated.......");
		}
    	 else
    	 {
    		 System.out.println("Invalid detailes.....");
    	 }
    	 System.out.println("Enter 1 For || go to Back");
 		int option=i.nextInt();
 		if(option==1)
 		{
 		Bus bus=new Bus();
 		bus.busdetailes();
 		}
 		
   }
	
	public void updatetime(Validation validate) throws SQLException 
	{
			
		 String q="update Buses set Time=? where Bus_No=?";
	  	 java.sql.PreparedStatement pst=con.prepareStatement(q);
		  pst.setString(1,validate.Time);
		  pst.setString(2,validate.busno);
		  int r=pst.executeUpdate();
		  
		 if(r>0)
		 {
			 System.out.println("Updated.......");
		 }
		 else
		 {
			 System.out.println("Invalid detailes.....");
		 }
		 System.out.println("Enter 1 For || go to Back");
			int option=i.nextInt();
			if(option==1)
			{
			Bus bus=new Bus();
			bus.busdetailes();
			}
			
	}
	


   public void updatebustype(Validation validate) throws SQLException 
   {
	  String q="update Buses set Bus_Type=? where Bus_No=?";
  	  java.sql.PreparedStatement pst=con.prepareStatement(q);
	  pst.setString(1,validate.bustype);
	  pst.setString(2,validate.busno);
	  int r=pst.executeUpdate();
	  
		 if(r>0)
		 {
			 System.out.println("Updated.......");
		 }
		 else
		 {
			 System.out.println("Invalid detailes.....");
		 }
	  System.out.println("Enter 1 For || go to Back");
	  int option=i.nextInt();
		  if(option==1)
		  {
			Bus bus=new Bus();
			bus.busdetailes();
		  }
	}

	public void updateDrivernum(Validation valitate) throws SQLException 
	{
		  String q="update Buses set Driver_Num=? where Bus_No=?";
	  	  java.sql.PreparedStatement pst=con.prepareStatement(q);
		  pst.setString(1,valitate.phonenum);
		  pst.setString(2,valitate.busno);
		  int r=pst.executeUpdate();
		  
			 if(r>0)
			 {
				 System.out.println("Updated.......");
			 }
			 else
			 {
				 System.out.println("Invalid detailes.....");
			 }
		  System.out.println("Enter 1 For || go to Back");
			int option=i.nextInt();
			if(option==1)
			{
			Bus bus=new Bus();
			bus.busdetailes();
			}
		
	}



	public void updatecapacity(Validation valitate) throws SQLException
	{
		  String q="update Buses set Capacity=? where Bus_No=?";
	 	  java.sql.PreparedStatement pst=con.prepareStatement(q);
		  pst.setInt(1,valitate.capacity);
		  pst.setString(2,valitate.busno);
		  int r=pst.executeUpdate();
		  
			 if(r>0)
			 {
				 System.out.println("Updated.......");
			 }
			 else
			 {
				 System.out.println("Invalid detailes.....");
			 }
		 System.out.println("Enter 1 For || go to Back");
			int option=i.nextInt();
			if(option==1)
			{
			Bus bus=new Bus();
			bus.busdetailes();
			}
		
	}
	

	public void Delete(Validation valitate) throws SQLException
	{
	    String q="delete from Buses where Bus_NO =?";
		
		PreparedStatement pst=con.prepareStatement(q);
		
		pst.setString(1,valitate.busno);
		int r=pst.executeUpdate();
			if(r>0)
			{
			System.out.println("Deleted.....");	
			}
			else
			{
				System.out.println("Invalid detailes.....");	
			}
		 System.out.println("Enter 1 For || go to Back");
			int option=i.nextInt();
			if(option==1)
			{
			Bus bus=new Bus();
			bus.busdetailes();
			}
		
		
	}



	public void Showbuses() throws SQLException 
	{
		String q="select * from Buses";
		PreparedStatement pst=con.prepareStatement(q);
		
		ResultSet r=pst.executeQuery();
		
			while(r.next())
			{
			    int dbusid=r.getInt(1);
			    int  dbusno=r.getInt(2);
			    String dbusname=r.getString(3);
			    String dtime=r.getString(4);
			    String dbustype=r.getString(5);
			    long ddrivernum=r.getLong(6);
			    int dcapacity=r.getInt(7);
			    
			   System.out.println("Bus detailes....");
			   
			   System.out.println("busid                : "+dbusid);
			   System.out.println("busno                : "+dbusno);
			   System.out.println("busname              : "+dbusname);
			   System.out.println("Time                 : "+dtime);
			   System.out.println("bustype              : "+dbustype);
			   System.out.println("Drivernum            : "+ddrivernum);
			   System.out.println("capacity             : "+dcapacity);
			   
			 }
			   System.out.println("Enter 1 For || Go to back");
			   int option=i.nextInt();
			      if(option==1)
		          {
				    Bus bus=new Bus();
					bus.busdetailes();
		       	  }
		
	}
	
	public void Showparticulerbuses(Validation valitate) throws SQLException
	{
		
		String q="select * from Buses where  Bus_No=?";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setString(1, valitate.busno);
		ResultSet r=pst.executeQuery();
		System.out.println("Bus detailes..................................");
			while(r.next())
			{
			    int dbusid=r.getInt(1);
			    int  dbusno=r.getInt(2);
			    String dbusname=r.getString(3);
			    String dtime=r.getString(4);
			    String dbustype=r.getString(5);
			    long ddrivernum=r.getLong(6);
			    int dcapacity=r.getInt(7);
			   
			   
			   System.out.println("busid                : "+dbusid);
			   System.out.println("busno                : "+dbusno);
			   System.out.println("busname              : "+dbusname);
			   System.out.println("Time                 : "+dtime);
			   System.out.println("bustype              : "+dbustype);
			   System.out.println("Drivernum            : "+ddrivernum);
			   System.out.println("capacity             : "+dcapacity);
			   
			  }
			   System.out.println("Enter 1 For || Go to back");
			   int option=i.nextInt();
			   if(option==1)
		          {
				    Bus bus=new Bus();
					bus.busdetailes();
		       	  }
	}

	public void Ddetailes() throws SQLException
	{
		//busid | busno | busname | Time | bustype | Drivernum  | capacity/
	    String q="select Bus_Id,Bus_No,Bus_name,Time,Bus_Type,Driver_Num from Buses";
		java.sql.PreparedStatement pst= con.prepareStatement(q);
		ResultSet r=pst.executeQuery();
		while(r.next())
		{
		int	busid=r.getInt(1);
		int busno=r.getInt(2);
		String	busname=r.getString(3);
		String time=r.getString(4);
		String	bustype=r.getString(5);
		long	Mnum = r.getLong(6);
		    System.out.println("Bus Id          :"+busid);
			System.out.println("Bus no          :"+busno);
			System.out.println("Bus Name        : "+busname);
			System.out.println("Bus time        : "+time);
			System.out.println("Bus Type        : "+bustype);
			System.out.println("Mobile Num      : "+Mnum);
			
			System.out.println("...........................................");
			
		}
	}
//Buses(Bus_Id int primary key auto_increment,Bus_No int,Bus_name varchar(20),Time varchar(20),Bus_Type varchar(20),Driver_Num bigint,Capacity int)/

	public int getCapacity(Validation validate2) throws SQLException 
	{
		String q="select Capacity from Buses where Bus_No=?";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setString(1,validate2.busno);
		ResultSet r=pst.executeQuery();
		r.next();
		return r.getInt(1);
	}
}
