import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class LoginController {
	String filename = null;
	String key = null;
	String password = null;
	
	public LoginController()
	{
		//retrieve login information from txt file
	}
	public void validateLogin(String username, String password, int choice) // Called from LoginInterface
	{
		try {
			if(choice == 1) //If student is chosen..
			{
				filename = "StudentLogins.txt"; 
				this.password = hashPassword(password);
				key = TextDatabase.readLoginDetail(filename, username, this.password); //Query to TextDatabase
				if(key != null)
				{
					System.out.println("\nSuccessful Login\n");	
					StudentInterface.inStudentInterface();
				}
		    	else
		    	{
		    		System.out.println("Incorrect Password or Username!");
		    	}	
    		}
			else if(choice == 2) //If admin is chosen..
			{
				filename = "AdminLogins.txt";
				this.password = hashPassword(password);
				key = TextDatabase.readLoginDetail(filename, username, this.password); //Query to TextDatabase
				if(key != null)
    			{
    				System.out.println("Successful Login");
    				Admin admin = new Admin();
    			}
    		}
	    	System.out.println("Incorrect username or password.");
    	  		 		
    	}catch (IOException e) {
			System.out.println("IOException > " + e.getMessage());
    	}
	}
	private String hashPassword(String password)
	{
		//insert hash
		return password;
	}
}
