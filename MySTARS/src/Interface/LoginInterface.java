package Interface;

import java.util.Scanner;

import Login.LoginController;

import java.io.Console;
import java.util.Arrays;
import java.io.IOException;
import java.util.*; 
import java.lang.*; 

/**
 * LoginInterface is a boundary class which prompts the user to enter his login 
 * informations. <p>
 * If the login is successful, the user will be directed to ? <p>
 * If the login fails, ?
 * 
 * @author ?
 *
 */
public class LoginInterface {
	
	private String username, password;
	private String choice;
	
	Scanner sc = new Scanner(System.in);
	
	public void loginAs() //Enter from mySTARSApp
	{

		while(true) {
			System.out.println("\n......Login As......");
			System.out.println("1. Login As Student \n2. Login As Admin ");
			System.out.printf("Enter choice: ");
			choice = sc.next();
			if(choice.equals("1") || choice.equals("2")) //Choosing Admin or Student
			{
				int choice = Integer.parseInt(this.choice);
				adminOrStudent(choice); //Enter AdminOrStudent 
			}
			if(choice.equals("3")){
				System.exit(0);
            }
			else
				System.out.println("Please Enter a Valid Number!\n");
		}
	}
	private void adminOrStudent(int choice)
	{	
		System.out.println("\n......Login......");
		System.out.printf("Please enter Username: ");
		username = sc.next();
      
		//password = consoleReadPass();
      
		System.out.printf("Please Enter Password: ");
		password = sc.next();	
		
		LoginController loginController = new LoginController(); //Enter loginController
		loginController.validateLogin(username, password, choice);
	}
	private String consoleReadPass()
	{
		 Console console = System.console();
	      if(console == null){
	         System.err.println("No console found");
	         return "null";
	         //System.exit(1);
	      }
	      
	      char[] pass = console.readPassword("Please enter password:");
	      return String.valueOf(pass);
	}
	//Testing purpose
	public static void main(String[] args) {
		LoginInterface loginInterface = new LoginInterface();
		loginInterface.loginAs();
	}
}
