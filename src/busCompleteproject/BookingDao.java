package busCompleteproject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class BookingDao extends Get_Connection{

	Scanner i=new Scanner(System.in);
	Scanner s=new Scanner(System.in);
	// Ticket_No | Pname | From_Location | To_Location | Fdate   
	 //| P_mail_Id      | P_mobile_Num | Bus_name    | Time   | Bus_Type    | Driver_Num | Bus_no
	public void Showpassangeralist() throws SQLException
	{
		String q="select Pname,From_Location,To_Location,Fdate,P_mail_Id,P_mobile_Num,Bus_no,NoOfSeats from Booking";
		PreparedStatement pst=con.prepareStatement(q);
		int a=0;
		ResultSet r=pst.executeQuery();
		System.out.println("Booked detailes....");
			while(r.next()) 
			{
				//int t_no=r.getInt(1);
			    String dname=r.getString(1);
			    String dfrompoint=r.getString(2);
			    String ddetination=r.getString(3);
			    Date dFdate=r.getDate(4);
			    String dEmail=r.getString(5);
			    long dpnum=r.getLong(6);
			    int dbusNo=r.getInt(7);
			    int noofseat=r.getInt(8);
			   
			    System.out.println("Passenger list...................................");
			   System.out.println("Passanger name                    : "+dname);
			   System.out.println("Passanger pickup-point            : "+dfrompoint);
			   System.out.println("Passanger destination             : "+ddetination);
			   System.out.println("date                              : "+dFdate);
			   System.out.println("Passanger Email                   : "+dEmail);
			   System.out.println("Passanger phone num               : "+dpnum);
			   System.out.println("Booking busno                     : "+dbusNo);
			   System.out.println("NoOfSeats                         : "+noofseat);
			   
			   System.out.println("...................................................................");
			   a=1;
			   
			  }
			if(a==0)
			{
				System.out.println("Booking list is empty");
			}
			   System.out.println("Enter 1 For || Go to back");
			   int option=i.nextInt();
			   if(option==1)
		          {
					All_Tables all_table=new All_Tables();
					all_table.tables();
		       	  }
	}

	//Booking(Pname varchar(20),From_Location varchar(20),To_Location varchar(20),Fdate date,P_mail_Id varchar(30),P_mobile_Num bigint,Bus_no int/
	
	public int getCount(Validation validate) throws SQLException 
	{
		
		 
		 String q="select sum(NoOfSeats) from Booking where Bus_no=? and Fdate=? and From_Location=? and To_Location=?";
				 java.sql.PreparedStatement pst=con.prepareStatement(q);
				 
				 pst.setString(1,validate.busno);
				 java.sql.Date sqldate=new java.sql.Date(validate.fromdate.getTime());
				 pst.setDate(2,sqldate);
				 pst.setString(3,validate.fromlocation);
				 pst.setString(4,validate.Tolocation);
				 ResultSet  r=pst.executeQuery();
				
				 r.next();
				
				 return  r.getInt(1);
	}
	//Booking(Pname varchar(20),From_Location varchar(20),To_Location varchar(20),Fdate date,P_mail_Id varchar(30),P_mobile_Num bigint,Bus_no int/			

		public void book(Validation validate) throws SQLException 
		{
		
			String q="insert into Booking values(?,?,?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(q);
			pst.setString(1,validate.name);
			pst.setString(2,validate.fromlocation);
			pst.setString(3,validate.Tolocation);
			
			java.sql.Date sqldate=new java.sql.Date(validate.fromdate.getTime());
			
			pst.setDate(4,sqldate);
			
			pst.setString(5,validate.email);
			pst.setString(6,validate.phonenum);
			pst.setString(7,validate.busno);
			int r=pst.executeUpdate();
			
			
		}



		public boolean isCancelled(Validation validate) throws SQLException
		{
		String q="delete from Booking where Bus_no =? and Fdate=? and P_mobile_Num=?";
			
			PreparedStatement pst=con.prepareStatement(q);
			
			pst.setString(1,validate.busno);
			java.sql.Date sqldate=new java.sql.Date(validate.fromdate.getTime());
			pst.setDate(2,sqldate);
			
			pst.setString(3,validate.phonenum);
			int r=pst.executeUpdate();
			return r>0;
			
		}

		/*public boolean view(Validation validate) throws SQLException
		{
			
			String q="select Pname,From_Location,To_Location,Fdate,Bus_name,Bus_Type,Driver_Num,Time from Booking inner join Buses where"
					+ " Booking.Bus_no=? and Booking.P_mobile_Num=? and Booking.Fdate=? and Buses.Bus_No=? ";
			PreparedStatement pst=con.prepareStatement(q);
			pst.setString(1,validate.busno);
			pst.setString(2,validate.phonenum);
			java.sql.Date sqldate=new java.sql.Date(validate.fromdate.getTime());
			pst.setDate(3,sqldate);
			pst.setString(4,validate.busno);
			
			
			ResultSet r=pst.executeQuery();
			int a=0;
				while(r.next())
				{
					
				    String name=r.getString(1);
				    String dfrompoint=r.getString(2);
				    String ddetination=r.getString(3);
				    Date Fdate=r.getDate(4);
				    String dbusname=r.getString(5);
				    String dbustype=r.getString(6);
				    long Mnum=r.getLong(7);
				    String time=r.getString(8);
				    System.out.println("Booking detailes.....................");
				    System.out.println();
				    
				   System.out.println("Passanger name       : "+name);
				   System.out.println("Bus name             : "+dbusname);
				   System.out.println("From                 : "+dfrompoint);
				   System.out.println("To                   : "+ddetination);
				   System.out.println("date                 : "+Fdate);
				   System.out.println("Time                 : "+time);
				   System.out.println("Bustype              : "+dbustype);
				   System.out.println("DriverMobilenum      : "+Mnum);
				   System.out.println("........................................");
				   a=1;
				  
				  }
		
			if(a>0)
			{
		
				return true;
			}
			
			else
			{
				
				return false;
			}
		}*/
int a=0;
		public void viewConfirmTicket(Validation validate) throws SQLException 
		{
			String con1="Confirm Ticket";
			String q="select Pname,Bus_no,P_mobile_Num,Fdate from "+validate.regName+" where status=?"; 
			java.sql.PreparedStatement pst=con.prepareStatement(q);
			
			pst.setString(1,con1);
			
			ResultSet r=pst.executeQuery();
			//int a=0;
			while(r.next())
			{
				String Pname=r.getString(1);
				String busno=r.getString(2);
				String phno=r.getString(3);
				Date F1date=r.getDate(4);
			
					String q1="select Pname,From_Location,To_Location,Fdate,P_mail_Id,P_mobile_Num,"
							+ "Bus_name,Bus_Type,Driver_Num,"
							+ "Time,Bus_no,Ticket_No,NoOfSeats from Booking where Bus_no=? "
							+ "and P_mobile_Num=? and Fdate=? and Pname=?";
					java.sql.PreparedStatement pst1=con.prepareStatement(q1);
					pst1.setString(1,busno);
					pst1.setString(2,phno);
					java.sql.Date sqldate=new java.sql.Date(F1date.getTime());
					pst1.setDate(3,sqldate);
					pst1.setString(4,Pname);
					
					
					
					ResultSet r1=pst1.executeQuery();
					
						while(r1.next())
						{
							String name=r1.getString(1);
						    String dfrompoint=r1.getString(2);
						    String ddetination=r1.getString(3);
						    Date Fdate=r1.getDate(4);
						    String mail=r1.getString(5);
						    String Pmob=r1.getString(6);
						    String dbusname=r1.getString(7);
						    String dbustype=r1.getString(8);
						    long Mnum=r1.getLong(9);
						    String time=r1.getString(10);
						    int bus_no=r1.getInt(11);
						    int tickno=r1.getInt(12);
						    int noofseats=r1.getInt(13);
						    
					System.out.println("Your Tickets.........................................");	 
						    
						   System.out.println("Ticket Number        : "+tickno);
						   System.out.println("Passanger name       : "+name);
						   System.out.println("Bus name             : "+dbusname);
						   System.out.println("From                 : "+dfrompoint);
						   System.out.println("To                   : "+ddetination);
						   System.out.println("Passenger Mobile No  : "+Pmob);
						   System.out.println("Passenger Mail Id    : "+mail);
						   System.out.println("date                 : "+Fdate);
						   System.out.println("Time                 : "+time);
						   System.out.println("Bustype              : "+dbustype);
						   System.out.println("DriverMobilenum      : "+Mnum);
						   System.out.println("Booked Bus No        : "+bus_no);
						   System.out.println("NoOfSeats            : "+noofseats);
						   
						   System.out.println("................................................");
						   a=1;
							break;
						    						   
						}
						//break;
						
				}
			
			}
				
			

		public void viewTicket(Validation validate) throws SQLException {
			/*String q="select Pname,From_Location,To_Location,Fdate,P_mail_Id,P_mobile_Num,Bus_no,status from "+validate.regName+" where status=?"; */
			String q="select Pname,From_Location,To_Location,Fdate,P_mail_Id,P_mobile_Num,Bus_no,status,NoOfSeats "
					+ "from "+validate.regName+" where status=? or status=?";
			PreparedStatement pst=con.prepareStatement(q);
			pst.setString(1,"NotConfirm");
			pst.setString(2,"Waiting");
			ResultSet r=pst.executeQuery();
        // System.out.println("prem");
			
		    
			while(r.next()) 
			{
			    String dname=r.getString(1);
			    String dfrompoint=r.getString(2);
			    String ddetination=r.getString(3);
			    Date dFdate=r.getDate(4);
			    String dEmail=r.getString(5);
			    long dpnum=r.getLong(6);
			    int dbusNo=r.getInt(7);
			    String Status=r.getString(8);
			    int noofseats=r.getInt(9);
			    
			   System.out.println("Passanger name                    : "+dname);
			   System.out.println("Passanger pickup-point            : "+dfrompoint);
			   System.out.println("Passanger destination             : "+ddetination);
			   System.out.println("date                              : "+dFdate);
			   System.out.println("Passanger Email                   : "+dEmail);
			   System.out.println("Passanger phone num               : "+dpnum);
			   System.out.println("Booking busno                     : "+dbusNo);
			   System.out.println("Booking Status                    : "+Status);
			   System.out.println("NoOfSeats                         : "+noofseats);
			   System.out.println(".....................................................");
			   a=1;
			   
			  }
			if(a==0)
			{
				System.out.println("Still no tickets booked");
			}
			
			
			
		}
		



		public boolean CancelTicket(Validation validate) throws SQLException {
			
			validate.Ticket_No();
			String q1="select Pname,Fdate,P_mail_Id,P_mobile_Num,Bus_no from booking where Ticket_No=?";
			java.sql.PreparedStatement pst1=con.prepareStatement(q1);
			pst1.setString(1,validate.T_no);
			ResultSet r1=pst1.executeQuery();
			int a=0,b=0;
			while(r1.next())
			{
				String name=r1.getString(1);
			    Date Fdate=r1.getDate(2);
			    String mail=r1.getString(3);
			    String Pmob=r1.getString(4);
			    int bus_no=r1.getInt(5);
			   String q="delete from "+validate.regName+" where Pname=? and Fdate=? "
			   		+ "and P_mail_Id=? and P_mobile_Num=? and Bus_no=?"; 
				//System.out.println("Check4 ");
			   java.sql.PreparedStatement pst=con.prepareStatement(q);
				pst.setString(1,name);
				java.sql.Date sql=new java.sql.Date(Fdate.getTime());
				pst.setDate(2,sql);
				pst.setString(3,mail);
				pst.setString(4,Pmob);
				pst.setInt(5,bus_no);
			    int r=pst.executeUpdate();
			    a=1;
			    String q2="delete from booking where Ticket_No=?";
	            PreparedStatement pst2=con.prepareStatement(q2);
				pst2.setString(1,validate.T_no);
				int r2=pst2.executeUpdate();
				if(r2>0)
				{
					b=1;
				}
				
			}
			
			if(a>0 && b>0)
			{
				return true;
			}
			else
			{
				return false;
			}
			
			
			
			
		}
}
