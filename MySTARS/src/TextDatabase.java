import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TextDatabase {
	public static final String SEPARATOR = "|";
	public static String readLoginDetail(String filename, String userUsername, String userPassword) throws IOException { //enter from LoginController
		ArrayList stringArray = (ArrayList)read(filename); // read String from text file
        for (int i = 0 ; i < stringArray.size() ; i++) {
				String st = (String)stringArray.get(i);
				StringTokenizer star = new StringTokenizer(st , SEPARATOR);	//read String from text filepass in the string to the string tokenizer using delimiter ","
				String username = star.nextToken().trim();	
				String password = star.nextToken().trim();	
				//System.out.println(username + password); 
				if(userUsername.equals(username) && userPassword.equals(password))
				{
					return star.nextToken().trim();
				}
			}
			return null;
	
	}
	
	
/*	public static String readStudentInfo()
	{
		ArrayList stringArray = (ArrayList)read(filename); //Read AdminLogins.txt
		//ArrayList alr = new ArrayList() ;// to store Professors data
	}*/
	
	  public static List read(String fileName) throws IOException { //enter from readStudentLogin
			List data = new ArrayList(); 
		   Scanner scanner = new Scanner(new FileInputStream(fileName));
		   try {
		      while (scanner.hasNextLine()){
		        data.add(scanner.nextLine());
		      }
		   }
		    finally{
		      scanner.close();
		    }
		    return data;
		  }
	
	  
	  
	  
	  public static void write(String fileName, List data) throws IOException  {
		    PrintWriter out = new PrintWriter(new FileWriter(fileName));

		    try {
				for (int i =0; i < data.size() ; i++) {
		      		out.println((String)data.get(i));
				}
		    }
		    finally {
		      out.close();
		    }
		  }



	public static void main(String[] aArgs)  {
		/*TextDatabase textDatabase = new TextDatabase();
    	String filename = "StudentLogins.txt" ;
    	try {
    		ArrayList al = TextDatabase.readStudentsLogin(filename) ;
    		for (int i = 0 ; i < al.size() ; i++) {
    			Student student = (Student)al.get(i);
				System.out.println("Username: " + student.getUsername() );
				System.out.println("Password: " + student.getPassword() );
		}
    		
    		/*Professor p1 = new Professor("Joseph","jos@ntu.edu.sg",67909999);
			// al is an array list containing Professor objs
			al.add(p1);
			// write Professor record/s to file.
			TextDB.saveProfessors(filename, al);
    		
    		
    		
    		
    	}catch (IOException e) {
			System.out.println("IOException > " + e.getMessage());
    	}*/
    	
  
	}
	
}
