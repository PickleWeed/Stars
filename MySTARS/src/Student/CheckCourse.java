package Student;

import java.io.IOException;
import java.util.ArrayList;

import CourseRecords.CourseRecord;
import Repository.CourseRecordsTextRepository;

/**
 * CheckCourse is a control class that displays the course informations for all
 * courses registered by the student.
 * 
 * @author ?
 *
 */
public class CheckCourse {
	

	
	public static void showCourseIndex() throws IOException
	{
		/*ArrayList courseRecordList = CourseRecordsTextRepository.readCourseRecords();
		
		for (int i=0; i<courseRecordList.size(); i++)
		{
			//get array object 
			CourseRecord courseRecords = (CourseRecord)courseRecordList.get(i);
			
			if(!courseRecords.getVacancy().equals("nill"))
				System.out.println("Course Index: " + courseRecords.getCourseIndex() + ", Vacancy: " + courseRecords.getVacancy());
			
		}*/
	}

}
