package Student;

import java.io.IOException;
import java.util.ArrayList;

import Course.CourseRecordsObj;
import TextRepository.CourseRecordsTextRepository;

public class CheckCourse {
	

	
	public static void showCourseIndex() throws IOException
	{
		ArrayList courseRecordList = CourseRecordsTextRepository.readCourseRecords();
		
		for (int i=0; i<courseRecordList.size(); i++)
		{
			//get array object 
			CourseRecordsObj courseRecords = (CourseRecordsObj)courseRecordList.get(i);
			
			if(!courseRecords.getVacancy().equals("nill"))
				System.out.println("Course Index: " + courseRecords.getCourseIndex() + ", Vacancy: " + courseRecords.getVacancy());
			
		}
	}

}
