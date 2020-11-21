package Repository;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import AccessPeriod.AccessPeriod;
import CourseRecords.CourseRecord;

/**
 * GlobalAccessPeriodTextRepository is a boundary class which performs read and write operations 
 * on GlobalAccessPeriod.txt, a database that stores all time periods that students are allowed
 * to access the STAR System.<p>
 * Each AccessPeriod has a startAccessPeriod(dd/mm/yyyy) and a endAccessPeriod(dd/mm/yyyy): <p>
 * 
 * @author ?
 *
 */
public class GlobalAccessPeriodTextRepository implements Repository {
	private static final String SEPARATOR = "|";
	private static final String FILENAME = "GlobalAccessPeriod.txt" ;
	private static final String DATFILENAME = "GlobalAccessPeriod.dat" ;
    	/**
	 * Gets all time periods that students are allowed to access the STAR System.<p>
     	 * Each time period is stored as a AccessPeriod object.<p> 
     	 * An ArrayList of AccessPeriod objects are returned.<p>
	 * 
	 * @return An ArrayList of AccessPeriod objects storing 
	 * all allowable access periods for students from the database is returned.
	 * @throws IOException If an input or output exception occurred
	 */
	public ArrayList readToList() throws IOException {
		
		// read String from text file
		ArrayList stringArray = (ArrayList)TextDatabase.read(FILENAME);
		ArrayList alr = new ArrayList() ;// to store Professors data

        for (int i = 0 ; i < stringArray.size() ; i++) {
				String st = (String)stringArray.get(i);
				// get individual 'fields' of the string separated by SEPARATOR
				StringTokenizer star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter ","

				String  startAccessPeriod = star.nextToken().trim();	// first token
				String  endAccessPeriod = star.nextToken().trim();	// first token
				//int  vacancy = Integer.parseInt(star.nextToken().trim());
				// create Professor object from file data
				AccessPeriod accessPeriodObj = new AccessPeriod(startAccessPeriod, endAccessPeriod);
				// add to Professors list
				alr.add(accessPeriodObj);
			}
			return alr ;
	}

	/**
	 * Saves an ArrayList of AccessPeriod objects into the database.
	 * 
	 * @param al an ArrayList of AccessPeriod object to be stored into the database
	 * @throws IOException If an input or output exception occurred
	 */
	public void saveList(List al) throws IOException {
			List alw = new ArrayList() ;// to store Professors data
	
	        for (int i = 0 ; i < al.size() ; i++) {
	        	AccessPeriod accessPeriodObj = (AccessPeriod)al.get(i);
					StringBuilder st =  new StringBuilder() ;
					st.append(accessPeriodObj.getStartAccessPeriod().trim());
					st.append(SEPARATOR);
					st.append(accessPeriodObj.getEndAccessPeriod().trim());
					alw.add(st.toString()) ;
				}
	        TextDatabase.write(FILENAME,alw);
	        DatDatabase.write(DATFILENAME, al);
		}
	//test purpose
	public static void main(String[] aArgs)  {
	    	/*TextDB txtDB = new TextDB();
	    	String filename = "professor.txt" ;
			try {
				// read file containing Professor records.
				ArrayList al = TextDB.readProfessors(filename) ;
				for (int i = 0 ; i < al.size() ; i++) {
						Professor prof = (Professor)al.get(i);
						System.out.println("Name " + prof.getName() );
						System.out.println("Contact " + prof.getContact() );
				}
				Professor p1 = new Professor("Joseph","jos@ntu.edu.sg",67909999);
				// al is an array list containing Professor objs
				al.add(p1);
				// write Professor record/s to file.
				TextDB.saveProfessors(filename, al);
			}catch (IOException e) {
				System.out.println("IOException > " + e.getMessage());
			}*/
		
		try {
			// read file containing Professor records.
			GlobalAccessPeriodTextRepository globalAccessPeriodTextRepository = new GlobalAccessPeriodTextRepository();
			ArrayList al = globalAccessPeriodTextRepository.readToList();
			for (int i = 0 ; i < al.size() ; i++) {
				AccessPeriod accessPeriodObj = (AccessPeriod)al.get(i);
					System.out.println("Start Access Period: "+ accessPeriodObj.getStartAccessPeriod());
					System.out.println("End Access Period: "+ accessPeriodObj.getEndAccessPeriod());
					System.out.println("\n");
				}
			//saveStudentRecords(filename, al);
			}catch (IOException e) {
				System.out.println("IOException > " + e.getMessage());
			}
	  }
}
