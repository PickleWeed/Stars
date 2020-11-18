package Login;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Interface.AdminApp;
import Interface.StudentInterface;
import TextRepository.LoginTextRepository;
import java.io.BufferedWriter;
import java.io.FileWriter;
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
			    	StudentInterface.inStudentInterface();
			    else if(choice == 2)
			    {
			    	AdminApp adminApp = new AdminApp();
			    }
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
