package busCompleteproject;

import java.sql.SQLException;
import java.util.Scanner;

public class Bus {

	Scanner i=new Scanner(System.in);
	Scanner s=new Scanner(System.in);
	public void busdetailes() throws SQLException
	{
		System.out.println("Select 1 For || Insert the new Bus Details");
		System.out.println("Select 2 For || Update the Bus Details");
		System.out.println("Select 3 For || Delete the Bus Details");
		System.out.println("Select 4 For || Show the Bus Details");
		System.out.println("Select 5 For || Go to Back");
		
		int option=i.nextInt();
		
		if(option==1)
		{
			
			Validation valitate=new Validation(); 
			valitate.BNumber();
			valitate.Bus_name();
			valitate.B_Time();
			valitate.B_Type();
			valitate.phnum();
			valitate.Capacity();
			BusDao busdao=new BusDao();
			busdao.insert(valitate);
			
		}
		else if(option==2)
		{
			System.out.println("Enter 1 For || Update the Bus_No column ");
			System.out.println("Enter 2 For || Update the busName column ");
			System.out.println("Enter 3 For || Update the Time column ");
			System.out.println("Enter 4 For || Update the Bus_Type column ");
			System.out.println("Enter 5 For || Update the Drivernum column ");
			System.out.println("Enter 6 For || Update the Capacity column ");
			int optionU=i.nextInt();
			if(optionU==1)
			{
				Validation valitate=new Validation(); 
				valitate.Update_Bno();
				valitate.Updated_Bus_no();
				BusDao busdao=new BusDao();
				busdao.update(valitate);
				
			}
			else if(optionU==2)
			{
				Validation valitate=new Validation(); 
				valitate.Update_Bno();
				valitate.Updated_Bus_name();
				BusDao busdao=new BusDao();
				busdao.updatebusname(valitate);
				
			}
			else if(optionU==3)
			{
				Validation valitate=new Validation(); 
				valitate.Update_Bno();
				valitate.Upadated_B_Time();
				BusDao busdao=new BusDao();
				busdao.updatetime(valitate);
			}
			else if(optionU==4)
			{
				Validation valitate=new Validation(); 
				valitate.Update_Bno();
				valitate.B_Type();
				BusDao busdao=new BusDao();
				busdao.updatebustype(valitate);
			}
			else if(optionU==5)
			{
				Validation valitate=new Validation(); 
				valitate.Update_Bno();
				valitate.Upodated_bus_Mnumber();
				BusDao busdao=new BusDao();
				busdao.updateDrivernum(valitate);
			}
			else if(optionU==6)
			{
				Validation valitate=new Validation(); 
				valitate.Update_Bno();
				valitate.Upodated_bus_Capacity();
				BusDao busdao=new BusDao();
				busdao.updatecapacity(valitate);
			}
		}
		
		else if(option==3)
		{
			
			Validation valitate=new Validation(); 
			valitate.Delete_Bno();
			BusDao busdao=new BusDao();
			busdao.Delete(valitate);	
		}
		else if(option==4)
		{
			System.out.println("Enter 1 For || show the All buses:");
			System.out.println("Enter 2 For || show the paritculer bus:");
			int optionS=i.nextInt();
			if(optionS==1)
			{
				
				BusDao busdao=new BusDao();
				busdao.Showbuses();	
			}
			else if(optionS==2)
			{
				Validation valitate=new Validation(); 
				BusDao busdao=new BusDao();
				valitate.Selecte_Bus();
				busdao.Showparticulerbuses(valitate);	
			}
		}
		else if(option==5)
		{
			All_Tables all_table=new All_Tables();
			all_table.tables();
		}
		
		
	}
}
