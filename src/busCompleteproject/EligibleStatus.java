package busCompleteproject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class EligibleStatus extends Get_Connection{

	public void ToCreateTable(Validation validate) throws SQLException {
		
		String q="create table "+validate.regName+" (Cid int primary key auto_increment,User_Name varchar(30),"
				+ "Pname varchar(30),From_Location varchar(30),To_Location varchar(30),Fdate date,"
				+ "P_mail_Id varchar(30),P_mobile_Num bigint,Bus_no int,status varchar(20),NoOfSeats bigint)";
		 java.sql.PreparedStatement pst=con.prepareStatement(q);
		int r=pst.executeUpdate();
		if(r>0)
		{
			//System.out.println("created");
		}
		
	}

	public void InsertintoStatus(Validation validate) throws SQLException {
	
		String q="insert into "+validate.regName+"(User_Name,Pname,From_Location,To_Location,Fdate,P_mail_Id,P_mobile_Num,"
				+ "Bus_no,status,NoOfSeats) values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(q);
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
		
		//System.out.println(status);
		pst.setString(9,status);
		pst.setInt(10,validate.NoOfSeats);
		int r=pst.executeUpdate();
		if(r>0)
		{
			//System.out.println("Inserted into eligible status");
		}
	}
	public void ShowBookingToCancel(Validation validate) throws SQLException {
		
		String q="select * from "+validate.regName+" where status=?"; 
		java.sql.PreparedStatement pst=con.prepareStatement(q);
		pst.setString(1,"Confirm");
		ResultSet r=pst.executeQuery();
		
		while(r.next())
		{
			int id=r.getInt(1);
			String Uname=r.getString(2);
		    String dname=r.getString(3);
		    String dfrompoint=r.getString(4);
		    String ddetination=r.getString(5);
		    Date dFdate=r.getDate(6);
		    String dEmail=r.getString(7);
		    long dpnum=r.getLong(8);
		    int dbusNo=r.getInt(9);
		    String status=r.getString(10);
		   System.out.println("Booking detailes....");
		   System.out.println("Ticketr_No                        : "+id);
		   System.out.println("User Name                         : "+Uname);
		   System.out.println("Passanger name                    : "+dname);
		   System.out.println("Passanger pickup-point            : "+dfrompoint);
		   System.out.println("Passanger destination             : "+ddetination);
		   System.out.println("date                              : "+dFdate);
		   System.out.println("Passanger Email                   : "+dEmail);
		   System.out.println("Passanger phone num               : "+dEmail);
		   System.out.println("Booking busno                     : "+dbusNo);
		   System.out.println("Status                            : "+status);
		   
		}
		
		
	}
}
