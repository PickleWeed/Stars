package TextRepository;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import AccessPeriod.AccessPeriodObj;
import CourseRecords.CourseRecordObj;

public class GlobalAccessPeriodTextRepository {
	private static final String SEPARATOR = "|";
	private static final String filename = "GlobalAccessPeriod.txt" ;
    // an example of reading
	public static ArrayList readAccessPeriod() throws IOException {
		
		// read String from text file
		ArrayList stringArray = (ArrayList)read(filename);
		ArrayList alr = new ArrayList() ;// to store Professors data

        for (int i = 0 ; i < stringArray.size() ; i++) {
				String st = (String)stringArray.get(i);
				// get individual 'fields' of the string separated by SEPARATOR
				StringTokenizer star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter ","

				String  startAccessPeriod = star.nextToken().trim();	// first token
				String  endAccessPeriod = star.nextToken().trim();	// first token
				//int  vacancy = Integer.parseInt(star.nextToken().trim());
				// create Professor object from file data
				AccessPeriodObj accessPeriodObj = new AccessPeriodObj(startAccessPeriod, endAccessPeriod);
				// add to Professors list
				alr.add(accessPeriodObj);
			}
			return alr ;
	}

	// an example of saving
	public static void saveAccessPeriod(List al) throws IOException {
			List alw = new ArrayList() ;// to store Professors data
	
	        for (int i = 0 ; i < al.size() ; i++) {
	        	AccessPeriodObj accessPeriodObj = (AccessPeriodObj)al.get(i);
					StringBuilder st =  new StringBuilder() ;
					st.append(accessPeriodObj.getStartAccessPeriod().trim());
					st.append(SEPARATOR);
					st.append(accessPeriodObj.getEndAccessPeriod().trim());
					alw.add(st.toString()) ;
				}
				write(filename,alw);
		}

	  /** Write fixed content to the given file. */
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
	
	  /** Read the contents of the given file. */
	  private static List read(String fileName) throws IOException {
		List data = new ArrayList() ;
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
			ArrayList al = GlobalAccessPeriodTextRepository.readAccessPeriod();
			for (int i = 0 ; i < al.size() ; i++) {
				AccessPeriodObj accessPeriodObj = (AccessPeriodObj)al.get(i);
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
