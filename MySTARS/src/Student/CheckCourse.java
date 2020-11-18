package Student;

import java.io.IOException;
import java.util.ArrayList;

import Course.CourseRecords;
import TextRepository.CourseRecordsTextRepository;

public class CheckCourse {
	

	
	public static void main(String[] args) throws IOException
	{
		ArrayList courseRecordList = CourseRecordsTextRepository.readCourseRecords();
		
		for (int i=0; i<courseRecordList.size(); i++)
		{
			//get array object 
			CourseRecords courseRecords = (CourseRecords)courseRecordList.get(i);
			
			if(!courseRecords.getVacancy().equals("nill"))
				System.out.println("Course Index: " + courseRecords.getCourseIndex() + ", Vacancy: " + courseRecords.getVacancy());
			
		}
	}

}
