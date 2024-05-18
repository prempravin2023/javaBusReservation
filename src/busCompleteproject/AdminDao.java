package busCompleteproject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao extends Get_Connection{

	public void Add(Validation validate) throws SQLException
	{
		String q="insert into Admin_Reg values(?,?,?,?,?)";
		
		java.sql.PreparedStatement pst=con.prepareStatement(q);
		
		pst.setString(1,validate.Aid);
		pst.setString(2,validate.regName);
		pst.setString(3,validate.email);
		pst.setString(4,validate.phonenum);
		pst.setString(5,validate.password);
		
		int r=pst.executeUpdate();
		System.out.println("Register.....");
	}
	
	
	public boolean logincheck1(Validation validate) throws SQLException
    {
		validate.id();
		String q="select Ename from Admin_Reg where Eid=?";
		java.sql.PreparedStatement pst=con.prepareStatement(q);
		String Cname="";
		pst.setString(1,validate.Aid);
		ResultSet r=pst.executeQuery();
		while(r.next())
		{
			Cname=r.getString(1);
			
		}
		
		String q1="select Ename from Admin_Reg where Epass_Word=?";
		java.sql.PreparedStatement pst1=con.prepareStatement(q1);
		
		System.out.println("Enter Your Password");
		String password=s.next();
		String Cname1="";
		pst1.setString(1,password);
		
		ResultSet r1=pst1.executeQuery();
		
	   while(r1.next())
	   {
		   Cname1=r1.getString(1);
		   
	   }
	    if(Cname.equals(Cname1))
	    {
	    	return true;
	    }
	    else
	    {
	    	System.out.println("your password or id is wrong please give a correct password ");
	    	/*System.out.println("Enter your Id");
	    	validate.Aid=i.next();*/
	    	return logincheck1(validate);
	    	
	    }
	
    }

	/*public boolean logincheck() throws SQLException 
	 {
		
		String q="select Epass_Word from Admin_Reg where Epass_Word=?";
		java.sql.PreparedStatement pst=con.prepareStatement(q);
		
		System.out.println("Enter Your Password");
		String password=s.next();
		String Cpass="";
		pst.setString(1,password);
		
		ResultSet r=pst.executeQuery();
		
	   while(r.next())
	   {
		    Cpass=r.getString(1);
	   }
	    if(password.equals(Cpass))
	    {
	    	return true;
	    }
	    else
	    {
	    	System.out.println("Give a correct  Password");
	    	return logincheck();
	    }
	    */
	 }
	

