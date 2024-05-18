package busCompleteproject;

import java.sql.DriverManager;
import java.util.Scanner;

public class Get_Connection {

	
	
	java.sql.Connection con;
	Scanner i=new Scanner(System.in);
	Scanner s=new Scanner(System.in);
	    Get_Connection()
		{
			try 
			{
				String url="jdbc:mysql://localhost:3306/busreservation";
				String user="root";
				String pass="";
				
			    con=DriverManager.getConnection(url,user,pass);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
}
