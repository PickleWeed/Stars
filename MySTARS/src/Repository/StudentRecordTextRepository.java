package Repository;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import StudentRecords.StudentRecords;

/**
 * StudentRecordTextRepository is a boundary class which performs read and write operations 
 * on StudentRecords.txt, a database that stores the information of all courses taken by every student.<p>
 * The information stored for each entry is listed below: <p>
 * key(identifies the student who takes the course) <p>
 * courseIndex(eg. CZ1003) and indexNum(eg. 10088) <p>
 * type(eg. LEC/TUT/LAB).<p>
 * group(eg. CS1, SS2).<p>
 * day, time, venue. <p>
 * remarks. <p>
 * program ????????? <p>
 * Each entry in the database is uniquely identified by the combination: <p>
 * key, CourseIndex, IndexNum <p>
 * Each information has its respective get and set method.
 * 
 * @author ?
 *
 */
public class StudentRecordTextRepository implements Repository{
	private static final String SEPARATOR = "|";
	private static final String FILENAME = "StudentRecords.txt" ;
	private static final String DATFILENAME = "StudentRecords.dat" ;
	
    	/**
	 * Gets the information of all courses taken by every student from the database.<p>
     * Each entry is stored as a StudentRecords object.<p> 
     * An ArrayList of StudentRecords objects are returned.<p>
	 * 
	 * @return An ArrayList of StudentRecords objects storing 
	 * the information of all courses taken by every student from the database is returned.
	 * @throws IOException If an input or output exception occurred
	 */
	public ArrayList readToList() throws IOException {
		// read String from text file
		ArrayList stringArray = (ArrayList)TextDatabase.read(FILENAME);
		ArrayList alr = new ArrayList() ;// to store Professors data

        for (int i = 0 ; i < stringArray.size() ; i++) {
				String st = (String)stringArray.get(i);

				StringTokenizer star = new StringTokenizer(st , SEPARATOR);	
				String  key = star.nextToken().trim();
				String  firstname = star.nextToken().trim();	
				String  lastname = star.nextToken().trim();	
				String  matricNum = star.nextToken().trim();
				String  courseIndex = star.nextToken().trim();
				String  indexNum = star.nextToken().trim();	
				String AU = star.nextToken().trim();
				String courseType = star.nextToken().trim();
				String SU = star.nextToken().trim();
				String GERType = star.nextToken().trim();
				String status = star.nextToken().trim();
		
				StudentRecords studentRecords = new StudentRecords(key, firstname, lastname, matricNum, courseIndex, indexNum, status, AU, courseType, GERType, status);
				
				alr.add(studentRecords) ;
			}
			return alr ;
	}

	/**
	 * Saves an ArrayList of StudentRecords objects into the database.
	 * 
	 * @param al an ArrayList of StudentRecords object to be stored into the database
	 * @throws IOException If an input or output exception occurred
	 */
public void saveList(List al) throws IOException {
		List alw = new ArrayList() ;// to store Professors data
		
        for (int i = 0 ; i < al.size() ; i++) {
        	StudentRecords studentRecords = (StudentRecords)al.get(i);
				StringBuilder st =  new StringBuilder() ;
				st.append(studentRecords.getKey().trim());
				st.append(SEPARATOR);
				st.append(studentRecords.getFirstName().trim());
				st.append(SEPARATOR);
				st.append(studentRecords.getLastName().trim());
				st.append(SEPARATOR);
				st.append(studentRecords.getMatricNum().trim());
				st.append(SEPARATOR);
				st.append(studentRecords.getCourseIndex().trim());
				st.append(SEPARATOR);
				st.append(studentRecords.getIndexNum().trim());
				st.append(SEPARATOR);
				st.append(studentRecords.getStatus().trim());
				st.append(SEPARATOR);
				st.append(studentRecords.getAU().trim());
				st.append(SEPARATOR);
				st.append(studentRecords.getCourseType().trim());
				st.append(SEPARATOR);
				st.append(studentRecords.getSU().trim());
				st.append(SEPARATOR);
				st.append(studentRecords.getGERType().trim());
				st.append(SEPARATOR);
				st.append(studentRecords.getStatus().trim());
				alw.add(st.toString()) ;
				
			}
			TextDatabase.write(FILENAME,alw);
			DatDatabase.write(DATFILENAME, al);
	}
}