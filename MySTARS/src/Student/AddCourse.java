package Student;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import CourseRecords.CourseRecord;
import Repository.CourseRecordsTextRepository;

/**
 * AddCourse is a control class which implements the logic of adding a course for 
 * the student if the student enters a valid courseIndex.
 * 
 * @author ?
 *
 */
public class AddCourse {
	/**
	 * Displays the CourseIndex of all courses in the database.
	 * 
	 * @param courseIndex courseIndex
	 * @param courseRecordList Arraylist of CourseRecord objects
	 */
	public static void addCourse1(String courseIndex, ArrayList courseRecordList)
	{
		
		for (int i=0; i<courseRecordList.size(); i++)
		{
			//get array object 
			CourseRecord courseRecords = (CourseRecord)courseRecordList.get(i);
			
			System.out.println(courseRecords.getCourseIndex());
			/*if(courseIndex == courseRecords.getCourseIndex())
			{
				System.out.println("do something");
			}*/
			
		}
	}
	
	
	
	
	
	
	public static final String delimiter = "|";
		/**
		 * prompts the user to enter a CourseIndex
		 * @return the courseIndex entered by the user
		 */
		public String queryCourseIndex() {
			String courseIndex;
			Scanner sc = new Scanner(System.in);
		    System.out.println("Please enter Course Index: ");
		    courseIndex = sc.nextLine();
		    return courseIndex;
		}
		/**
		 * Checks if the courseIndex entered by the user is a valid courseIndex in the database,
		 *  and returns either a valid courseIndex, or "".
		 * 
		 * @param courseIndex courseIndex (eg. CZ1003)
		 * @return if a matching courseIndex is found in the database, return the courseIndex.
		 * Otherwise, return "".
		 */
		public String findRelevantRecord(String courseIndex){
			String data, Str, subData, temp;
	        try {
	            File myObj = new File("CourseRecords.txt");
	            Scanner sc = new Scanner(myObj);
	            sc.nextLine();
	            while (sc.hasNextLine()) {
	            	data = sc.nextLine();
	            	Str = new String(data);
	            	subData = Str.substring(6,12);
	            	temp = Str.substring(0,Str.length()-4);
	            	if (subData.equals(courseIndex)) {
		            	return temp;
	            	}
	            }
	            sc.close();
	          } catch (FileNotFoundException e) {
	            System.out.println("An error occurred.");
	            e.printStackTrace();
	          }	
	        return "";
		}
		/**
		 * Adds the course for the student if the courseIndex is valid.
		 * @param temp temp is either a valid courseIndex(one that is present in the database), 
		 * or "". 
		 */
	    public void addCourse(String temp){
		    try {
		        FileWriter writer = new FileWriter("StudentRecords.txt", true);
		        BufferedWriter bufferedWriter = new BufferedWriter(writer);
		        bufferedWriter.write(temp);
		        bufferedWriter.newLine();
		        //bufferedWriter.write(delimiter);
		        bufferedWriter.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
	    }
}

