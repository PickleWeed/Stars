package CourseRecords;

import java.io.IOException;
import java.util.ArrayList;

import Repository.CourseRecordsTextRepository;
import StudentInfo.Student;
import StudentRecords.StudentRecords;

public class UpdateCourseRecord {
	public static void addCourse(ArrayList courseRecord, String courseIndex, String indexNum, String type, String group, String day, String time, String venue, String remarks, String vacancy, String name) throws IOException
	{
		CourseRecord newCourseRecord = new CourseRecord(courseIndex, indexNum, type, group, day, time, venue, remarks, vacancy, name);
		courseRecord.add(newCourseRecord);
		
		CourseRecordsTextRepository courseRecordsTextRepository = new CourseRecordsTextRepository();
		courseRecordsTextRepository.saveList(courseRecord);
		
		System.out.println("Course Successfully added!\n");

		System.out.println("CourseIndex: " + newCourseRecord.getCourseIndex() );
		System.out.println("IndexNum: " + newCourseRecord.getIndexNum() );
		System.out.println("Rype: " + newCourseRecord.getType() );
		System.out.println("Froup: " + newCourseRecord.getGroup() );
		System.out.println("Day: " + newCourseRecord.getDay() );
		System.out.println("Time: " + newCourseRecord.getTime() );
		System.out.println("Venue: " + newCourseRecord.getVenue() );
		System.out.println("Remarks: " + newCourseRecord.getRemarks() );
		System.out.println("Vacancy: " + newCourseRecord.getVacancy() );
		System.out.println("Name: " + newCourseRecord.getName() );
	}
	public static boolean checkCourseIndex(ArrayList courseRecord, String courseIndex)
	{
		for(int i=0; i<courseRecord.size(); i++)
		{
			CourseRecord courseRecords = (CourseRecord)courseRecord.get(i);
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
