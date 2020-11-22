package Repository;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

import CourseRecords.CourseRecord;

/**
 * CourseRecordsTextRepository is a boundary class which performs read and write operations 
 * on CourseRecords.txt, a database that stores information about all courses in NTU's MySTARS.<p>
 * The information stored in each course is listed below: <p>
 * courseIndex (eg. CZ1003)<p>
 * indexNum (eg. 10088)<p>
 * type: type of this course (eg. LEC/TUT/LAB)<p>
 * group: group number of this course (eg. SS2)<p>
 * day: the weekday that this course is conducted<p>
 * time: the time that this course is conducted<p>
 * venue: the venue that this course is conducted<p>
 * remarks: any remark for this course<p>
 * vacancy: number of available slots left for this course<p>
 * name: name of this course<p>
 * 
 * @author ? 
 *
 */
public class CourseRecordsTextRepository implements Repository{
	private static final String SEPARATOR = "|";
	private static final String FILENAME = "CourseRecords.txt" ;
	private static final String DATFILENAME = "CourseRecords.dat" ;
    /**
     * gets data of all courses from the database. <p>
     * Information of each course is stored as a CourseRecord object. <p>
     * An ArrayList of CourseRecord objects are returned.
     * 
     * @return an ArrayList of CourseRecord object storing information 
     * of all courses in the database
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

				String  num = star.nextToken().trim();
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
				String  AU = star.nextToken().trim();
				String  courseType = star.nextToken().trim();
				String  SU = star.nextToken().trim();
				//int  vacancy = Integer.parseInt(star.nextToken().trim());
				// create Professor object from file data
				CourseRecord courseRecords = new CourseRecord(num, courseIndex, indexNum, type, group, day, time, venue, remarks, vacancy, name, AU, courseType, SU);
				// add to Professors list
				alr.add(courseRecords);
			}
			return alr ;
	}
	  /**
	   * Saves an ArrayList of CourseRecord objects into the database.
	   * 
	   * @param al an ArrayList of CourseRecord object to be stored into the database
	   * @throws IOException If an input or output exception occurred
	   */
	public void saveList(List al) throws IOException {
			List alw = new ArrayList() ;// to store Professors data
	
	        for (int i = 0 ; i < al.size() ; i++) {
	        	CourseRecord courseRecords = (CourseRecord)al.get(i);
					StringBuilder st =  new StringBuilder() ;
					st.append(courseRecords.getNum().trim());
					st.append(SEPARATOR);
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
					st.append(SEPARATOR);
					st.append(courseRecords.getAU().trim());
					st.append(SEPARATOR);
					st.append(courseRecords.getCourseType().trim());
					st.append(SEPARATOR);
					st.append(courseRecords.getSU().trim());
	
					alw.add(st.toString()) ;
				}
	        TextDatabase.write(FILENAME, alw);
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
			CourseRecordsTextRepository courseRecordsTextRepository = new CourseRecordsTextRepository();
			ArrayList al = courseRecordsTextRepository.readToList();
			for (int i = 0 ; i < al.size() ; i++) {
				CourseRecord courseRecords = (CourseRecord)al.get(i);
					System.out.println("CourseIndex: " + courseRecords.getCourseIndex() );
					System.out.println("IndexNum: " + courseRecords.getIndexNum() );
					System.out.println("Type: " + courseRecords.getType() );
					System.out.println("Group: " + courseRecords.getGroup() );
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
