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
			System.out.println("WELCOME TO NTU STARS");
			System.out.println("****CHOOSE DOMAIN****");
			System.out.println("1. Student \n2. Admin \n3. Exit");
			System.out.printf("Enter choice: ");
			choice = sc.next();
			if(choice.equals("1") || choice.equals("2")) //Choosing Admin or Student
			{
				int choice = Integer.parseInt(this.choice);
				adminOrStudent(choice); //Enter AdminOrStudent 
			}
			else if(choice.equals("3")){
				System.out.println("Exiting System...");
				System.exit(0);
            }
			else {
				System.out.println("Please Enter a Valid Number!\n");
			}
		}
	}
	private void adminOrStudent(int choice)
	{	
		System.out.println("*****LOGIN*****");

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
	      
	      char[] pass = console.readPassword("Please Enter password:");
	      return String.valueOf(pass);
	}
	//Testing purpose
	public static void main(String[] args) {
		LoginInterface loginInterface = new LoginInterface();
		loginInterface.loginAs();
	}
}
