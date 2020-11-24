package StudentRecords;

import java.util.ArrayList;

import AccessPeriod.AccessPeriod;

/**
 * Displays the select student's course informations
 * 
 * @author Aaron Tay Han Yen
 * @author Samantha Tan Swee Yun
 */
public class GetStudentRecord {
	
	/**
	 * Displays the select student's course informations
	 * 
	 * @param StudentRecord An Array of all studentInfo in the database
	 * @param key the key used to identify the student
	 */
	public static void printStudentRecord(ArrayList StudentRecord, String key)
	{
		for (int i = 0 ; i < StudentRecord.size() ; i++) {
			StudentRecords studentRecord = (StudentRecords)StudentRecord.get(i);
				if(studentRecord.getKey().equals(key))
				{
					System.out.println("IndexNum: " + studentRecord.getIndexNum() );
					System.out.println("CourseIndex: " + studentRecord.getCourseIndex() );
					System.out.println("First Name: " + studentRecord.getFirstName() );
					System.out.println("Last Name: " + studentRecord.getLastName() );
					System.out.println("Matric Number: " + studentRecord.getMatricNum() );
					System.out.println("\n");
				}
		}
	}
	/**
	 * Displays the detail of all courses registered by the student, and his total AU
	 * 
	 * @param StudentRecord An ArrayList of StudentRecords currently in the database
	 * @param key The key used to identify a student
	 */
	public static void getCourseDetails(ArrayList StudentRecord, String key)
	{
		int count = 0;
		int totalAU = 0;
		
		for (int i = 0 ; i < StudentRecord.size() ; i++) {
			StudentRecords studentRecord = (StudentRecords)StudentRecord.get(i);
			if(studentRecord.getKey().equals(key)) {
				System.out.println("Registered Courses for " + studentRecord.getFirstName() +" " + studentRecord.getLastName()+":");
				break;
			}
		}
		for (int i = 0 ; i < StudentRecord.size() ; i++) {
			StudentRecords studentRecord = (StudentRecords)StudentRecord.get(i);
			if(studentRecord.getKey().equals(key))
			{
					System.out.println("Course: " + studentRecord.getCourseIndex());
					System.out.println("AU: " + studentRecord.getAU());
					System.out.println("Course Type: " + studentRecord.getCourseType());
					System.out.println("S/U Grade Option: " + studentRecord.getSU());
					System.out.println("GER Type: " + studentRecord.getGERType());
					System.out.println("Index Number: " + studentRecord.getIndexNum());
					System.out.println("Status: " + studentRecord.getStatus());
					System.out.println("\n");
					if(studentRecord.getStatus().equals("REGISTERED")) {
						totalAU += Integer.parseInt(studentRecord.getAU());
					}
					count++;
			}
		}
		if(count == 0) {
			System.out.println("You have no registered courses.");
		} else {
			System.out.println("Total AU Registered: " + totalAU);
		}
	}
}
