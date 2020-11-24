package Student;

import java.io.*;
import java.util.ArrayList;
import Repository.StudentRecordTextRepository;
import StudentRecords.StudentRecords;

/**
 * DropCourse implements the logic of dropping a course
 * for the student if the student enters a valid indexNum.
 * 
 * @author Samantha Tan Swee Yun
 *
 */
public class DropCourse {
	/**
	 * prompts the user to enter the courseIndex to drop.
	 * @return courseIndex to be dropped
	 */
	public static void dropCourse(ArrayList studentsRecords, String key, String courseIndex) throws IOException {
	    //print details of dropped course
		for (int i = 0 ; i < studentsRecords.size() ; i++) {
			StudentRecords studentRecord = (StudentRecords)studentsRecords.get(i);
			if(studentRecord.getKey().equals(key) && studentRecord.getCourseIndex().equals(courseIndex)) {
				System.out.println("Index Number: "+ courseIndex + "\tCourse: "+ studentRecord.getCourseIndex());
				System.out.println("Course Type: "+ studentRecord.getCourseType() + "\tStatus: "+ studentRecord.getStatus());
				System.out.println("\n");
				break;
			}	
		}
		
		//delete row from StudentRecords
		for (int i = 0 ; i < studentsRecords.size() ; i++) {
			StudentRecords studentRecord = (StudentRecords)studentsRecords.get(i);
			if(studentRecord.getKey().equals(key) && studentRecord.getCourseIndex().contentEquals(courseIndex)) {
				studentsRecords.remove(studentsRecords.get(i));
				StudentRecordTextRepository studentRecordsTextRepository = new StudentRecordTextRepository();
				studentRecordsTextRepository.saveList(studentsRecords);
				System.out.println("Drop Course Successful!\n");
				break;
			}	
		}
		
		//if there anyone in that waiting list
	}
}
