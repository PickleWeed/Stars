package Admin;

import java.io.IOException;
import java.util.ArrayList;

import Course.CourseRecordsObj;
import Student.Student;
import Student.StudentRecords;
import TextRepository.CourseRecordsTextRepository;

public class CourseHandler {
	public static void addCourse(ArrayList courseRecordList, String courseIndex, String indexNum, String type, String group, String day, String time, String venue, String remarks, String vacancy, String name) throws IOException
	{
		CourseRecordsObj courseRecordObj = new CourseRecordsObj(courseIndex, indexNum, type, group, day, time, venue, remarks, vacancy, name);
		courseRecordList.add(courseRecordObj);
		
		CourseRecordsTextRepository.saveCourseRecords(courseRecordList);
		
		System.out.println("Course Successfully added!\n");

		System.out.println("CourseIndex: " + courseRecordObj.getCourseIndex() );
		System.out.println("IndexNum: " + courseRecordObj.getIndexNum() );
		System.out.println("Rype: " + courseRecordObj.getType() );
		System.out.println("Froup: " + courseRecordObj.getGroup() );
		System.out.println("Day: " + courseRecordObj.getDay() );
		System.out.println("Time: " + courseRecordObj.getTime() );
		System.out.println("Venue: " + courseRecordObj.getVenue() );
		System.out.println("Remarks: " + courseRecordObj.getRemarks() );
		System.out.println("Vacancy: " + courseRecordObj.getVacancy() );
		System.out.println("Name: " + courseRecordObj.getName() );
	}
	public static boolean checkCourseIndex(ArrayList courseRecordList, String courseIndex)
	{
		for(int i=0; i<courseRecordList.size(); i++)
		{
			CourseRecordsObj courseRecords = (CourseRecordsObj)courseRecordList.get(i);
			if(courseRecords.getCourseIndex().equals(courseIndex))
			{
				return true;
			}	
		}
		System.out.println("Course Index not found.\n");
		return false;
	}
	/*public static void editCourseIndex(ArrayList courseRecordList, String courseIndex, String index, String type, String Group, String day, String time, String venue, String remarks, String vacancy, String name)
	{
		for(int i=0; i<courseRecordList.size(); i++)
		{
			CourseRecordsObj courseRecords = (CourseRecordsObj)courseRecordList.get(i);
			if(courseRecords.getCourseIndex().equals(courseIndex))
			{
				
			}
		}
	}*/
}
