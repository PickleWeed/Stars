package TextRepository;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

import Course.CourseRecordsObj;

public class CourseRecordsTextRepository {
	public static final String SEPARATOR = "|";
	public static final String filename = "CourseRecords.txt" ;
    // an example of reading
	public static ArrayList readCourseRecords() throws IOException {
		
		// read String from text file
		ArrayList stringArray = (ArrayList)read(filename);
		ArrayList alr = new ArrayList() ;// to store Professors data

        for (int i = 0 ; i < stringArray.size() ; i++) {
				String st = (String)stringArray.get(i);
				// get individual 'fields' of the string separated by SEPARATOR
				StringTokenizer star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter ","

				String  courseIndex = star.nextToken().trim();	// first token
				String  indexNum = star.nextToken().trim();	// second token
				String  type = star.nextToken().trim();	// third token
				String  group =star.nextToken().trim();
				String  day = star.nextToken().trim();
				String  time = star.nextToken().trim();
				String  venue = star.nextToken().trim();
				String  remarks = star.nextToken().trim();
				String  vacancy = star.nextToken().trim();
				String  name = star.nextToken().trim();
				//int  vacancy = Integer.parseInt(star.nextToken().trim());
				// create Professor object from file data
				CourseRecordsObj courseRecords = new CourseRecordsObj(courseIndex, indexNum, type, group, day, time, venue, remarks, vacancy, name);
				// add to Professors list
				alr.add(courseRecords);
			}
			return alr ;
	}

  // an example of saving
public static void saveCourseRecords(List al) throws IOException {
		List alw = new ArrayList() ;// to store Professors data

        for (int i = 0 ; i < al.size() ; i++) {
        	CourseRecordsObj courseRecords = (CourseRecordsObj)al.get(i);
				StringBuilder st =  new StringBuilder() ;
				st.append(courseRecords.getCourseIndex().trim());
				st.append(SEPARATOR);
				st.append(courseRecords.getIndexNum().trim());
				st.append(SEPARATOR);
				st.append(courseRecords.getType().trim());
				st.append(SEPARATOR);
				st.append(courseRecords.getGroup().trim());
				st.append(SEPARATOR);
				st.append(courseRecords.getDay().trim());
				st.append(SEPARATOR);
				st.append(courseRecords.getTime().trim());
				st.append(SEPARATOR);
				st.append(courseRecords.getVenue().trim());
				st.append(SEPARATOR);
				st.append(courseRecords.getRemarks().trim());
				st.append(SEPARATOR);
				st.append(courseRecords.getVacancy().trim());
				st.append(SEPARATOR);
				st.append(courseRecords.getName().trim());
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
		ArrayList al = CourseRecordsTextRepository.readCourseRecords();
		for (int i = 0 ; i < al.size() ; i++) {
			CourseRecordsObj courseRecords = (CourseRecordsObj)al.get(i);
				System.out.println("CourseIndex: " + courseRecords.getCourseIndex() );
				System.out.println("IndexNum: " + courseRecords.getIndexNum() );
				System.out.println("Rype: " + courseRecords.getType() );
				System.out.println("Froup: " + courseRecords.getGroup() );
				System.out.println("Day: " + courseRecords.getDay() );
				System.out.println("Time: " + courseRecords.getTime() );
				System.out.println("Venue: " + courseRecords.getVenue() );
				System.out.println("Remarks: " + courseRecords.getRemarks() );
				System.out.println("Vacancy: " + courseRecords.getVacancy() );
				System.out.println("Name: " + courseRecords.getName() );
				
				System.out.println("\n");
			}
		//saveStudentRecords(filename, al);
		}catch (IOException e) {
			System.out.println("IOException > " + e.getMessage());
		}
  }
}