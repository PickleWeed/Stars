
import java.util.Scanner;
import java.io.Console;
import java.util.Arrays;
import java.io.IOException;
import java.util.*; 
import java.lang.*; 

public class LoginInterface {
	
	public void loginAs() //Enter from mySTARSApp
	{
		int choice;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Login As..... ");
			System.out.println("1 For Student \n2 For Admin ");
			System.out.printf("Enter choice: ");
			choice = sc.nextInt();
			if(choice == 1 || choice == 2) //Choosing Admin or Student
			{
				adminOrStudent(choice); //Enter AdminOrStudent 
			}
         if(choice == 3){
            System.exit(0);
            }
		}
	}
	private static void adminOrStudent(int choice)
	{
		LoginController loginController = new LoginController(); //Enter loginController
		String username;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\nLogin.....");
		System.out.printf("Please enter Username: ");
		username = sc.next();
      
		String password = consoleReadPass();
      
		//String confirmPass = console.readPassword("Confirm password:");
		//System.out.printf("Please Enter Password: ");
		//password = sc.next();		

		loginController.validateLogin(username, password, choice);
	}
	private static String consoleReadPass()
	{
		 Console console = System.console();
	      if(console == null){
	         System.err.println("No console found");
	         System.exit(1);
	      }
	      
	      char[] pass = console.readPassword("Please enter password:");
	      return String.valueOf(pass);
	}
}
