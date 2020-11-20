package TextRepository;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import Login.LoginInfo;

/**
 * LoginTextRepository is a boundary class which performs read and write operations 
 * on LoginsInfo.txt, a database that stores login information of all users in NTU's MySTARS.<p>
 * The information stored for each user is listed below: <p>
 * username <p>
 * password<p>
 * type (Student or Admin)<p>
 * key: Uniquely identifies a user in the database (In case 2 users have the same 
 * username, password and type) <p>
 * 
 * @author ?
 *
 */
public class LoginTextRepository {
	public static final String SEPARATOR = "|";	
	
	public static String readLoginDetail(String userUsername, String userPassword, String userType) throws IOException { //enter from LoginController
		String filename = "LoginsInfo.txt"; 
		ArrayList stringArray = (ArrayList)read(filename); // read String from text file
		ArrayList alr = new ArrayList() ;// to store Professors data
        for (int i = 0 ; i < stringArray.size() ; i++) {
				String st = (String)stringArray.get(i);
				StringTokenizer star = new StringTokenizer(st , SEPARATOR);	//read String from text filepass in the string to the string tokenizer using delimiter ","
				String username = star.nextToken().trim();	
				String password = star.nextToken().trim();	
				String type = star.nextToken().trim();
				if(userUsername.equals(username) && userPassword.equals(password) && type.equals(userType))
				{
					return star.nextToken().trim();
				}
			}
			return null;
	}	
	
	/**
	 * Gets login information of all users from the database.<p>
     * Each user's login information is stored as a {@link Login.LoginInfo} object.<p> 
     * An ArrayList of {@link Login.LoginInfo} objects are returned.<p>
	 * 
	 * @return An ArrayList of {@link Login.LoginInfo} objects storing 
	 * the login information of all users is returned.
	 * @throws IOException If an input or output exception occurred
	 */
	public static ArrayList readLogin() throws IOException {
		// read String from text file
		String filename = "LoginsInfo.txt"; 
		ArrayList stringArray = (ArrayList)read(filename);
		ArrayList alr = new ArrayList() ;// to store Professors data

        for (int i = 0 ; i < stringArray.size() ; i++) {
				String st = (String)stringArray.get(i);
				// get individual 'fields' of the string separated by SEPARATOR
				StringTokenizer star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter ","

				String  username = star.nextToken().trim();
				String  password = star.nextToken().trim();	// first token
				String  type = star.nextToken().trim();	// second token
				String  key = star.nextToken().trim();	// third token
				//int  vacancy = Integer.parseInt(star.nextToken().trim());
				// create Professor object from file data
				LoginInfo loginInfo = new LoginInfo(username, password, type, key);
				// add to Professors list
				alr.add(loginInfo) ;
			}
			return alr ;
	}

	/**
	 * Saves an ArrayList of {@link Login.LoginInfo} objects into the database.
	 * 
	 * @param al an ArrayList of {@link Login.LoginInfo} object to be stored into the database
	 * @throws IOException If an input or output exception occurred
	 */
	public static void saveLogin(List al) throws IOException {
			String filename = "LoginsInfo.txt"; 
			List alw = new ArrayList() ;// to store Professors data
	
	        for (int i = 0 ; i < al.size() ; i++) {
	        	LoginInfo loginInfo = (LoginInfo)al.get(i);
					StringBuilder st =  new StringBuilder() ;
					st.append(loginInfo.getUsername().trim());
					st.append(SEPARATOR);
					st.append(loginInfo.getPassword().trim());
					st.append(SEPARATOR);
					st.append(loginInfo.getType().trim());
					st.append(SEPARATOR);
					st.append(loginInfo.getKey().trim());
					alw.add(st.toString()) ;
				}
				write(filename,alw);
		}
	
  private static List read(String fileName) throws IOException { //enter from readStudentLogin
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
  private static void write(String fileName, List data) throws IOException  {
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
}
