package busCompleteproject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDao extends Get_Connection{
	public void insert(Validation validate) throws SQLException 
	{
	         	String q="insert into Customer_Reg values(?,?,?,?,?)";
				
				java.sql.PreparedStatement pst=con.prepareStatement(q);
				pst.setString(1,validate.regName);
				
				pst.setString(2,validate.phonenum);
				pst.setString(3,validate.email);
				pst.setString(4,validate.password);
				pst.setString(5,validate.Age);
				
				int r=pst.executeUpdate();
				System.out.println("Register...........................");
	}

	public boolean logincheck(Validation validate) throws SQLException 
	{
		validate.Regname();
		String q="select Cmail_Id from Customer_Reg where Name=?"; 
		java.sql.PreparedStatement pst=con.prepareStatement(q);
		pst.setString(1,validate.regName);
		ResultSet r=pst.executeQuery();
		String Cmail="";
		while(r.next())
		{
			Cmail=r.getString(1);
		}
		
		String q1="select Cmail_Id from Customer_Reg where Cpass_Word=? ";  
		java.sql.PreparedStatement pst1=con.prepareStatement(q1);
		System.out.println("Enter Your Password");
		String password=s.nextLine();
		
		pst1.setString(1,password);
		ResultSet r1=pst1.executeQuery();
		String Cmail1="";
		while(r1.next())
		{
			Cmail1=r1.getString(1);
		}
		
	    if(Cmail.equals(Cmail1))
	    {
	    	return true;
	    }
	    else
	    {
	    	System.out.println("Give a correct Name or password");
	    	//System.out.println("Enter your Name");
	    	//validate.name=s.nextLine();
	    	return logincheck(validate);
	    }



		
	}

	/*public boolean logincheck2() throws SQLException 
	{
		String q="select count(Name) from Customer_Reg where Cpass_Word=? ";  
		java.sql.PreparedStatement pst=con.prepareStatement(q);
		System.out.println("Enter Your Password");
		String password=s.nextLine();
		pst.setString(1,password);
		ResultSet r=pst.executeQuery();
		r.next();
	    if(r.getInt(1)>0)
	    {
	    	return true;
	    }
	    else
	    {
	    	System.out.println("Give a correct Password");
	    	return logincheck2();
	    }
		*/
	}


