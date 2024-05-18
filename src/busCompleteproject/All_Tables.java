package busCompleteproject;

import java.sql.SQLException;
import java.util.Scanner;

public class All_Tables {
	Scanner i=new Scanner(System.in);
	Scanner s=new Scanner(System.in);
	
	
	Validation validate=new Validation();
	EligibleStatus eligiblestatus=new EligibleStatus();
	Common_Booking_Dao commonbookingdao=new Common_Booking_Dao();
	Booking booking=new Booking();
	BookingDao bookingdao=new BookingDao();
	CustomerDao customerdao=new CustomerDao();
	BusDao busdao=new BusDao();
	AdminDao admindao=new AdminDao();
	
	public void begin() throws SQLException
	{
		System.out.println("Select 1 for || Admin Registration ");
		System.out.println("Select 2 for || Admin Login ");
		System.out.println("Select 3 for || Customer  Registration ");
		System.out.println("Select 4 for || Customer Login ");
		System.out.println("Select 5 for || To Exit");
		System.out.println();
	    int  option=i.nextInt();
	    
	    if(option==1) 
		{
			validate.id();
			validate.Register();
			admindao.Add(validate);
			System.out.println("Enter 1 Go to login :");
			System.out.println("Enter 2 Go to Back :");
			int option1=i.nextInt();
			if(option1==1)
			{
				
				if(admindao.logincheck1(validate) )
				{
					System.out.println("login Success....");
					tables();
					
				}
				else
				{
					System.out.println("Invalid id OR password ");
					System.out.println("Please Retry");
				}
			}
			else if(option1==2)
			{
				begin();
			}
		}
		else if(option==2) 
		{
			
			if(admindao.logincheck1(validate))
			{
				System.out.println("login Success....");
				tables();
				
			}
			else
			{
				System.out.println("Invalid Admin id OR password ");
				System.out.println("Please Retry");
			}
		}
		else if(option==3)
		{
		    validate.Register();
		    //validate.Age();
			eligiblestatus.ToCreateTable(validate);
			customerdao.insert(validate);
		    System.out.println("Enter 1 fro Go to login :");
			System.out.println("Enter 2 for Go To Back");
			int login=i.nextInt();
			if(login==1)
				
			{
				//validate.Regname();
				if(customerdao.logincheck(validate))
				{
					System.out.println("login Success....");
					Customertables();
				}
			}
			else if(login==2)
			{
				begin();
			}
		}
		else if(option==4)
		{
			
			if(customerdao.logincheck(validate)  )
			{
				System.out.println("login Success....");
				Customertables();
			}
		}
		else if(option==5)
		{
			System.out.println("Thank you............");  
			
			
		
		}
		else
		{
			System.out.println("Invalid option please select a valid option");
			begin();
		}

	}
	
	public void tables() throws SQLException 
	{
		
		System.out.println("Enter 1  || For Edit a Buses Table");
		System.out.println("Enter 2  || For show a passanger detailes");
		System.out.println("Enter 3  || For Edit a Passanger Wating List");
		System.out.println("Enter 4  || For Logout");
		
	    int option=i.nextInt();
	
		if(option==1)
		{
			Bus bus=new Bus();
			bus.busdetailes();
		}
		else if(option==2)
		{
			booking.bookingdetailes();
		}
		else if(option==3)
		{
			EditCommonBooking();
		}
		else if(option==4)
		{
			begin();
		}
		else 
		{
			System.out.println("Invalid option please give a select option");
			tables();
		}
	
	}

	public void EditCommonBooking() throws SQLException 
	{
		System.out.println("Enter 1 || For Show Passanger Waiting List");
		System.out.println("Enter 2 || For Update To Confirm or Not Confirm To Waiting Ticket ");
		System.out.println("Enter 3 || For Go To Back");
		
		int option1=i.nextInt();
		if(option1==1)
		{
			commonbookingdao.ShowAllBooking();
			EditCommonBooking();
			
		}
		else if(option1==2)
		{
			System.out.println("Enter 1 || For To Update Using by ID");
			System.out.println("Enter 2 || For To Update Using by User_Name");
			System.out.println("Enter 3 || For Go To Back");
			int option=i.nextInt();
			if(option==1)
			{
				commonbookingdao.EditStatusByid(validate);
				commonbookingdao.EligibleTicket();
				commonbookingdao.UpdateNotConfirm();
				commonbookingdao.ConfirmTicket(validate);
				commonbookingdao.DeleteDetailsFromC_Booking();
                System.out.println("Enter 1 || For Go To Back");
				int option3=i.nextInt();
				if(option3==1)
				{
					EditCommonBooking();
				}
			}
			else if(option==2)
			{
				commonbookingdao.EditStatusByUserName(validate);
				commonbookingdao.EligibleTicket();
				commonbookingdao.UpdateNotConfirm();
				commonbookingdao.ConfirmTicket(validate);
				commonbookingdao.DeleteDetailsFromC_Booking();
				System.out.println("Enter 1 || For Go To Back");
				int option3=i.nextInt();
				if(option3==1)
				{
					EditCommonBooking();
				}
			}
			else if(option==3)
			{
				EditCommonBooking();
			}
		}
		else if(option1==3)
		{
			tables();
		}
	}

	public void Customertables () 
	{
		int option=1;
		try 
		{
		while(option==1 || option==2 || option==3)
		{
			
			System.out.println("Enter 1  || For Bus Ticket Booking");
			System.out.println("Enter 2  || For Bus Ticket Cancel");
			System.out.println("Enter 3  || For View the Ticket");
			System.out.println("Enter 4  || For Logout");
			
			option=i.nextInt();
			if(option==1) 
			{
				validate.fromlocation();
				validate.Tolocation();
				if(booking.state(validate)) 
				{
					validate.name();
					validate.Cdate();
					validate.phnum();
					validate.email();
					busdao.Ddetailes();
					validate.no();
					int C_B_Count=commonbookingdao.C_Booking_getCount(validate);
					int bcount=bookingdao.getCount(validate);
					int capacity=busdao.getCapacity(validate);
					int cap=capacity-(bcount+C_B_Count);
					//System.out.println("Available Seates for selected Bus = "+ cap);


					//int cap=capacity-seat;
					System.out.println("Available Seates for selected Bus = "+ cap);
					System.out.println("Enter 1 For || Continue");
					System.out.println("Enter 2 For || Go back....");
					int option1=i.nextInt();
					if(option1==1)
					{
						validate.Howmanyseats();
					}
					else if(option1==2)
					{
						//System.out.println("Choose another bus.....");
						Customertables();
					}
				//capacity-seat<capacity;
					if(cap>=validate.NoOfSeats)
					{
						
					
					if(C_B_Count < capacity && bcount < capacity && bcount+C_B_Count <=capacity)
					{
						
										
						commonbookingdao.Insert_Booking(validate);
						
						eligiblestatus.InsertintoStatus(validate);
					   System.out.println("Your ticket was waiting list please check after some time");
					}				
					else
					{
						System.out.println("Sry bus was full try another bus.....");
					}
				}
					else
					{
						System.out.println("sry select bus has not enough seat please try another bus.....");
					}
			}
				else
				{
					System.out.println("sry this route is not avialable......");
				}
			}
			else if(option==2) 
			{
				bookingdao.viewConfirmTicket(validate);
				if( bookingdao.CancelTicket(validate))
				{
					System.out.println("Your Ticket Was Canceled");
					System.out.println("Enter 1 || Go To Back");
					int Option=i.nextInt();
					if(Option==1)
					{
						Customertables();
					}
				}
				else
				{
					System.out.println("Your Ticket Was Not Canceled please try again");
					System.out.println("Enter 1 || Go To Back");
					int Option=i.nextInt();
					if(Option==1)
					{
						Customertables();
					}
				}
			}
			else if(option==3)
			{
				bookingdao.viewConfirmTicket(validate);
				bookingdao.viewTicket(validate);
			}
			else if(option==4)
			{
				begin();
			}
	
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
