package Login;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Interface.StudentInterface;
import TextRepository.LoginTextRepository;

public class LoginController {

	
	public LoginController()
	{
		//retrieve login information from txt file
	}
	public void validateLogin(String username, String password, int choice) // Called from LoginInterface
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
			filename = "LoginsInfo.txt"; 
			
			password = Hash.hashing(password);
			//System.out.println(password);
			
			key = LoginTextRepository.readLoginDetail(filename, username, password, userType); //Query to TextDatabase
			if(key != null)
			{
				System.out.println("\nSuccessful Login\n");	
				StudentInterface.inStudentInterface();
			}
	    	else
	    	{
	    		System.out.println("Incorrect Password or Username!");
	    	}	
    	 	  		 		
    	}catch (IOException e) {
			System.out.println("IOException > " + e.getMessage());
    	}
	}
}
