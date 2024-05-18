package busCompleteproject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Common_Booking_Dao extends Get_Connection{
	public void Insert_Booking(Validation validate) throws SQLException
	{
	
		String q="insert into common_booking (CReg_Name,Pname,From_Location,To_Location,Fdate,"
				+ "P_mail_Id,P_mobile_Num,Bus_no,status,NoOfSeats) values(?,?,?,?,?,?,?,?,?,?)";
		 java.sql.PreparedStatement pst=con.prepareStatement(q);
		 
		    String status="Waiting";
		    pst.setString(1,validate.regName);
			pst.setString(2,validate.name);
			pst.setString(3,validate.fromlocation);
			pst.setString(4,validate.Tolocation);
			
			java.sql.Date sqldate=new java.sql.Date(validate.fromdate.getTime());
			
			pst.setDate(5,sqldate);
			
			pst.setString(6,validate.email);
			pst.setString(7,validate.phonenum);
			pst.setString(8,validate.busno);
			pst.setString(9,status);
			pst.setInt(10,validate.NoOfSeats);
		int r=pst.executeUpdate();
		
		
		
	}

	public void ShowAllBooking() throws SQLException 
	{
		
		String q="select * from common_booking";
        PreparedStatement pst=con.prepareStatement(q);
		
		ResultSet r=pst.executeQuery();
		int a=0;
		System.out.println("Waiting  list....");
			while(r.next()) 
			{
				int id=r.getInt(1);
				String Uname=r.getString(2);
			    String dname=r.getString(3);
			    String dfrompoint=r.getString(4);
			    String ddetination=r.getString(5);
			    Date dFdate=r.getDate(6);
			    String dEmail=r.getString(7);
			    long ppnum=r.getLong(8);
			    int dbusNo=r.getInt(9);
			    String status=r.getString(10);
			   int noofseats=r.getInt(11);
			   
			   System.out.println("Booking Id                        : "+id);
			   System.out.println("User Name                         : "+Uname);
			   System.out.println("Passanger name                    : "+dname);
			   System.out.println("Passanger pickup-point            : "+dfrompoint);
			   System.out.println("Passanger destination             : "+ddetination);
			   System.out.println("date                              : "+dFdate);
			   System.out.println("Passanger Email                   : "+dEmail);
			   System.out.println("Passanger phone num               : "+ppnum);
			   System.out.println("Booking busno                     : "+dbusNo);
			   System.out.println("Status                            : "+status);
			   System.out.println("NoOfSeats                         : "+noofseats);
			   
			   System.out.println("...............................................................");
			   a=1;
			  }
		if(a==0)
		{
			 System.out.println("Passanger waiting list was empty....");
		}
	}

	public void EditStatusByid(Validation validate) throws SQLException 
	{
		validate.EditByid();
		String Status="";
		System.out.println("Enter 1 || For Update Confirm");
		System.out.println("Enter 2 || For Update NotConfirm");
		int option=i.nextInt();
		if(option==1)
		{
			Status="Confirm";
	
		}
		if(option==2)
		{
			Status="NotConfirm";
		}
		
		
		String q="update common_booking set status=? where Cid=?";
		 java.sql.PreparedStatement pst=con.prepareStatement(q);

		 pst.setString(1,Status);
			pst.setString(2,validate.id);

		int r=pst.executeUpdate();
		if(r>0)
		{
		System.out.println("Status was Updated...");
		}
		
	}

	public void EditStatusByUserName(Validation validate) throws SQLException {
		
		validate.EditByname();
		String Status="";
		System.out.println("Enter 1 || For Update Confirm");
		System.out.println("Enter 2 || For Update NotConfirm");
		int option=i.nextInt();
		if(option==1)
		{
			Status="Confirm";
	
		}
		if(option==2)
		{
			Status="NotConfirm";
		}
		

		String q="update common_booking set status=? where CReg_Name=?";
		 java.sql.PreparedStatement pst=con.prepareStatement(q);
			pst.setString(1,Status);
			pst.setString(2,validate.Uname);
		int r=pst.executeUpdate();
		if(r>0)
		{
			System.out.println("Status was Updated...");
		}
		
		
		
	}



	public void EligibleTicket() throws SQLException
	{	
		
		
		String q="select CReg_Name,Pname,From_Location,To_Location,Fdate,P_mail_Id,P_mobile_Num,Bus_no from common_booking where status=?";
		PreparedStatement pst=con.prepareStatement(q);
	
		pst.setString(1,"Confirm");
		ResultSet r=pst.executeQuery();
		//System.out.println("eligible ticket");
		while(r.next())
		{
			String reg_name=r.getString(1);
			String P_name=r.getString(2);
			String floc=r.getString(3);
			String Toloc=r.getString(4);
			Date DFdate=r.getDate(5);
			String pmail=r.getString(6);
			Long phno=r.getLong(7);
			String Busno=r.getString(8);
			String status="Confirm";
			String Q="update "+reg_name+" set status=? where User_Name=? and Pname=? and From_Location=? "
					+ "and To_Location=? and Fdate=? and P_mail_Id=? and P_mobile_Num=? and Bus_no=?";
			PreparedStatement pst1=con.prepareStatement(Q);
			pst1.setString(1,status);
			pst1.setString(2,reg_name);
			pst1.setString(3,P_name);
			pst1.setString(4,floc);
			pst1.setString(5,Toloc);
			java.sql.Date sql=new java.sql.Date(DFdate.getTime());
			pst1.setDate(6,sql);
			pst1.setString(7,pmail);
			pst1.setLong(8,phno);
			pst1.setString(9,Busno);
			
			int r1=pst1.executeUpdate();
			
			
		}	
		
		
	}
	
	public void UpdateNotConfirm() throws SQLException
	{
		String q="select CReg_Name,Pname,From_Location,To_Location,Fdate,P_mail_Id,P_mobile_Num,Bus_no"
				+ " from common_booking where status=?";
		PreparedStatement pst=con.prepareStatement(q);
		//String notConfirm="NotConfirm";
		pst.setString(1,"NotConfirm");
		ResultSet r=pst.executeQuery();
		while(r.next())
		{

			/* Cid           | int(11)     | NO   | PRI | NULL    | auto_increment |
			 | CReg_Name     | varchar(30) | YES  |     | NULL    |                |
			 | Pname         | varchar(30) | YES  |     | NULL    |                |
			 | From_Location | varchar(30) | YES  |     | NULL    |                |
			 | To_Location   | varchar(30) | YES  |     | NULL    |                |
			 | Fdate         | date        | YES  |     | NULL    |                |
			 | P_mail_Id     | varchar(30) | YES  |     | NULL    |                |
			 | P_mobile_Num  | bigint(20)  | YES  |     | NULL    |                |
			 | Bus_no        | int(11)     | YES  |     | NULL    |                |
			 | status*/
			String status="NotConfirm";
			String reg_name=r.getString(1);
			String P_name=r.getString(2);
			String floc=r.getString(3);
			String Toloc=r.getString(4);
			Date DFdate=r.getDate(5);
			String Pmail=r.getString(6);
			Long Phno=r.getLong(7);
			String Busno=r.getString(8);
			String Q="update "+reg_name+" set status=? where User_Name=? and Pname=? and From_Location=? "
					+ "and To_Location=? and Fdate=? and P_mail_Id=? and P_mobile_Num=? and Bus_no=?";
			PreparedStatement pst1=con.prepareStatement(Q);
			pst1.setString(1,status);
			pst1.setString(2,reg_name);
			pst1.setString(3,P_name);
			pst1.setString(4,floc);
			pst1.setString(5,Toloc);
			java.sql.Date sql=new java.sql.Date(DFdate.getTime());
			pst1.setDate(6,sql);
			pst1.setString(7,Pmail);
			pst1.setLong(8,Phno);
			pst1.setString(9,Busno);
			int r1=pst1.executeUpdate();
			
			
		}	
	}




	public void ConfirmTicket(Validation validate) throws SQLException 
	{
		
		String q3="select CReg_Name from common_booking where status=?";
		PreparedStatement pst3=con.prepareStatement(q3);
		//String conFirm="Confirm";
		pst3.setString(1,"Confirm");
		ResultSet r3=pst3.executeQuery();
		String RTable_name="";
		String busno="";
		while(r3.next())
		{
	        RTable_name=r3.getString(1);
		
			String q="select Bus_no,P_mobile_Num,Fdate from "+RTable_name+" where status=?";
			java.sql.PreparedStatement pst=con.prepareStatement(q);
			//String CONfirm="Confirm";
			pst.setString(1,"Confirm");
			ResultSet r=pst.executeQuery();
		
			while(r.next())
			{
				
				 busno=r.getString(1);
				String phno=r.getString(2);
				Date F1date=r.getDate(3);
					String q1="select Pname,From_Location,To_Location,Fdate,P_mail_Id,P_mobile_Num,"
							+ "Bus_name,Bus_Type,Driver_Num,"
							+ "Time,NoOfSeats from "+RTable_name+" inner join Buses where "+RTable_name+".Bus_no=? "
							+ "and "+RTable_name+".P_mobile_Num=? and "+RTable_name+".Fdate=? and Buses.Bus_No=? ";
					java.sql.PreparedStatement pst1=con.prepareStatement(q1);
					pst1.setString(1,busno);
					
					pst1.setString(2,phno);
					java.sql.Date sqldate=new java.sql.Date(F1date.getTime());
					pst1.setDate(3,sqldate);
					pst1.setString(4,busno);
					
					
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
					    int noofseats=r1.getInt(11);
					   String q2="insert into Booking (Pname,From_Location,To_Location,Fdate,"
					    		+ "P_mail_Id,P_mobile_Num,Bus_name,Time,Bus_Type,Driver_Num,Bus_no,NoOfSeats)values(?,?,?,?,?,?,?,?,?,?,?,?)";
						PreparedStatement pst2=con.prepareStatement(q2);
						pst2.setString(1,name);
						pst2.setString(2,dfrompoint);
						pst2.setString(3,ddetination);
						java.sql.Date sqldate1=new java.sql.Date(Fdate.getTime());
						pst2.setDate(4,sqldate1);
						pst2.setString(5,mail);
						pst2.setString(6,Pmob);
						pst2.setString(7,dbusname);
						pst2.setString(8,time );
						pst2.setString(9,dbustype);
						pst2.setLong(10,Mnum);
						pst2.setString(11,busno);
						pst2.setInt(12,noofseats);
						int r2=pst2.executeUpdate();	    
						
					   String q4="update "+RTable_name+" set status=? where status=?";
					   PreparedStatement pst4=con.prepareStatement(q4);
					   
						pst4.setString(1,"Confirm Ticket");
						pst4.setString(2,"Confirm");
						int r4=pst4.executeUpdate();
						break;
					  }
				
					
		}
		}
		
	}

	public void DeleteDetailsFromC_Booking() throws SQLException
	{
		 String q="delete from common_booking where status=? or status=?";
		 java.sql.PreparedStatement pst=con.prepareStatement(q);
		 String Dconfirm="Confirm";
		 pst.setString(1,Dconfirm);
		 String Dnotconfirm="NotConfirm";
			pst.setString(2,Dnotconfirm);
			int r=pst.executeUpdate();
	}
	
	
	/*public boolean isAvailableC(Validation validate) throws SQLException {
		
		int capacity=0;
		int booked=0;
		int Cbooked=0;
		BusDao busdao=new BusDao();
		System.out.println("isavilablec");
		capacity=busdao.getCapacity(validate);
		System.out.println("buscapacity"+capacity);
		BookingDao bookingdao=new BookingDao();
		booked=bookingdao.getCount(validate);
		System.out.println("bookedcount"+booked);
		Cbooked=C_Booking_getCount(validate);
		System.out.println("common booked count"+Cbooked);
	    return booked+Cbooked<capacity;
	}*/

	public int C_Booking_getCount(Validation validate) throws SQLException {
		
		 String q="select sum(NoOfSeats) from common_booking where Bus_no=? and Fdate=? and From_Location=? and To_Location=?";
		 
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

}
