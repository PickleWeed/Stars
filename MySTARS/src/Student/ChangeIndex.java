package Student;

import java.io.IOException;
import java.util.ArrayList;

import CourseRecords.CourseRecord;
import Repository.StudentRecordTextRepository;
import StudentRecords.StudentRecords;

/**
 * ChangeIndex is a control class that allows the user to changes the index of a course
 * to another index of the same course.
 * 
 * @author ?
 *
 */
public class ChangeIndex {

	public static void changeIndex(ArrayList studentsRecords, ArrayList courseRecordList, String oldIndexNum, String newIndexNum, String key) throws IOException {
	    int count = 0;
	    //print details of old and new index
		for (int i=0; i<courseRecordList.size(); i++)
		{
			CourseRecord courseRecords = (CourseRecord)courseRecordList.get(i);
			if(courseRecords.getIndexNum().equals(oldIndexNum)) {
				System.out.println("Course: "+ courseRecords.getCourseIndex() + "\n");
				break;
			}
		}
		System.out.println("Current Index Number: "+ oldIndexNum + "\n");

		for (int i=0; i<courseRecordList.size(); i++)
		{
			CourseRecord courseRecords = (CourseRecord)courseRecordList.get(i);
			if(courseRecords.getIndexNum().equals(oldIndexNum)) {
				System.out.println("Class Type: " + courseRecords.getType());
				System.out.println("Group: " + courseRecords.getGroup());
				System.out.println("Day: " + courseRecords.getDay());
				System.out.println("Time: " + courseRecords.getTime());
				System.out.println("Venue: " + courseRecords.getVenue());
				System.out.println("Remarks: " + courseRecords.getRemarks());
				System.out.println("\n");
			}
		}
		System.out.println("New Index Number: "+ newIndexNum + "\n");

		for (int i=0; i<courseRecordList.size(); i++)
		{
			CourseRecord courseRecords = (CourseRecord)courseRecordList.get(i);
			if(courseRecords.getIndexNum().equals(newIndexNum)) {
				System.out.println("Class Type: " + courseRecords.getType());
				System.out.println("Group: " + courseRecords.getGroup());
				System.out.println("Day: " + courseRecords.getDay());
				System.out.println("Time: " + courseRecords.getTime());
				System.out.println("Venue: " + courseRecords.getVenue());
				System.out.println("Remarks: " + courseRecords.getRemarks());
				System.out.println("\n");
			}
		}
		
		//change index in StudentRecord
		for (int i = 0 ; i < studentsRecords.size() ; i++) {
			StudentRecords studentRecord = (StudentRecords)studentsRecords.get(i);
			if(studentRecord.getKey().equals(key) && studentRecord.getIndexNum().contentEquals(oldIndexNum)) {
				studentRecord.setIndexNum(newIndexNum);
				
				StudentRecordTextRepository studentRecordsTextRepository = new StudentRecordTextRepository();
				studentRecordsTextRepository.saveList(studentsRecords);
				count++;
				break;
			}	
		}
		
		if (count > 0) {
			System.out.println("Change Index Successful!\n");
		}
	}
}
