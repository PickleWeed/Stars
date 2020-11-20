package Login;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;

import Interface.AdminApp;
import Interface.StudentInterface;
import TextRepository.LoginTextRepository;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * LoginController is a control class which checks the correctness of the user's login information 
 * and directs the user to the appropriate interface.
 * 
 * @author ?
 * 
 */
public class LoginController {
	/**
	 * Class constructor. 
	 */
	public LoginController()
	{
		//retrieve login information from txt file
	}
	
	/**
	 * Verifies the correctness of the user's login information and directs the user to the appropriate 
	 * interface (user/admin) if the login is successful. Otherwise, displays an error message.
	 * 
	 * @param username The user's name
	 * @param password The user's password
	 * @param choice The user's identity, taking an integer value of <code>1</code> or <code>2</code>
	 * (<code>1</code> for admin and <code>2</code> for student).
	 */
	public void validateLogin(String username, String password, int choice)// Called from LoginInterface
	{
		String filename = null;
		String key = null;
		String userType;
		
		switch(choice)
		{
			case 1:
				userType = "Student";
				break;
			case 2:
				userType = "Admin";
				break;
			default:
				System.out.println("Try another choice");
				return;	
		}
		try {	
			
			password = Encrypt.hashing(password);
			//System.out.println(password);
			
			key = LoginTextRepository.readLoginDetail(username, password, userType); //Query to TextDatabase
			if(key != null)
			{
				System.out.println("\nSuccessful Login\n");	
			    try {
			        FileWriter writer = new FileWriter("StudentRecords.txt", true);
			        BufferedWriter bufferedWriter = new BufferedWriter(writer);
			        bufferedWriter.write(key);
			        bufferedWriter.write("|");
			        bufferedWriter.close();
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
			    if(choice == 1)
			    {
			    	StudentInterface studentInterface = new StudentInterface();
			    	studentInterface.inStudentInterface();
			    }
			    	
			    else if(choice == 2)
			    {
			    	AdminApp adminApp = new AdminApp();
			    	adminApp.adminInterface();
			    }
			}
	    	else
	    	{
	    		System.out.println("Incorrect Password or Username!");
	    	}	
    	 	  		 		
    	}catch (Exception e) {
			System.out.println("eException > " + e.getMessage());
    	}
	}
}
