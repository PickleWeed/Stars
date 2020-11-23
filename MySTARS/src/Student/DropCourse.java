package Student;

import java.io.*;
import java.util.ArrayList;
import Repository.StudentRecordTextRepository;
import StudentRecords.StudentRecords;

/**
 * DropCourse is a control class which implements the logic of dropping a course for 
 * the student if the student enters a valid courseIndex.
 * 
 * @author ?
 *
 */
public class DropCourse {
	/**
	 * prompts the user to enter the courseIndex to drop.
	 * @return courseIndex to be dropped
	 */

  public static void dropCourse(ArrayList studentsRecords, String key, String indexNum) throws IOException {
	    int count = 0;
	    //print details of dropped course
		for (int i = 0 ; i < studentsRecords.size() ; i++) {
			StudentRecords studentRecord = (StudentRecords)studentsRecords.get(i);
			if(studentRecord.getKey().equals(key) && studentRecord.getIndexNum().equals(indexNum)) {
				System.out.println("Index Number: "+ indexNum + "       Course: "+ studentRecord.getCourseIndex());
				System.out.println("Course Type: "+ studentRecord.getCourseType() + "       Status: "+ studentRecord.getStatus());
				System.out.println("\n");
				break;
			}	
		}
		
		//delete row from StudentRecords
		for (int i = 0 ; i < studentsRecords.size() ; i++) {
			StudentRecords studentRecord = (StudentRecords)studentsRecords.get(i);
			if(studentRecord.getKey().equals(key) && studentRecord.getIndexNum().contentEquals(indexNum)) {
				studentsRecords.remove(studentsRecords.get(i));
				StudentRecordTextRepository studentRecordsTextRepository = new StudentRecordTextRepository();
				studentRecordsTextRepository.saveList(studentsRecords);
				count++;
				break;
			}	
		}
		
		if (count > 0) {
			System.out.println("Drop Course Successful!\n");
		}
  }
}
