package Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import WaitList.WaitList;

public class WaitListTextRepository implements Repository{
	private static final String SEPARATOR = "|";
	private static final String FILENAME = "WaitList.txt" ;
	private static final String DATFILENAME = "WaitList.dat" ;
	
    	/**
	 * Gets the information of all courses taken by every student from the database.<p>
     * Each entry is stored as a StudentRecords object.<p> 
     * An ArrayList of StudentRecords objects are returned.<p>
	 * 
	 * @return An ArrayList of WaitList objects storing 
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
				String  courseIndex = star.nextToken().trim();
				String  indexNum = star.nextToken().trim();	
				String  totalQueue = star.nextToken().trim();	
		
				WaitList waitList = new WaitList(courseIndex, indexNum, totalQueue);
				alr.add(waitList) ;
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
        	WaitList waitList = (WaitList)al.get(i);
				StringBuilder st =  new StringBuilder() ;
				st.append(waitList.getCourseIndex().trim());
				st.append(SEPARATOR);
				st.append(waitList.getIndexNum().trim());
				st.append(SEPARATOR);
				st.append(waitList.getTotalQueue().trim());
				alw.add(st.toString()) ;
				
			}
			TextDatabase.write(FILENAME,alw);
			DatDatabase.write(DATFILENAME, al);
	}
}
