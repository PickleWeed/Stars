package CourseRecords;

import java.io.IOException;
import java.util.ArrayList;

import Repository.CourseRecordsTextRepository;

public class UpdateCourseRecord {
	public static void addCourse(ArrayList courseRecord, String num, String courseIndex, String indexNum, String type, 
			String group, String day, String time, String venue, String remarks, String vacancy, String name, String AU, String courseType, String SU,String GERType) throws IOException
	{
		CourseRecord newCourseRecord = new CourseRecord(num, courseIndex, indexNum, type, group, day, time, venue, remarks, vacancy, name, AU, courseType,  SU, GERType);
		courseRecord.add(newCourseRecord);
		
		CourseRecordsTextRepository courseRecordsTextRepository = new CourseRecordsTextRepository();
		courseRecordsTextRepository.saveList(courseRecord);
		
		System.out.println("CourseIndex: " + newCourseRecord.getCourseIndex() );
		System.out.println("IndexNum: " + newCourseRecord.getIndexNum() );
		System.out.println("Type: " + newCourseRecord.getType() );
		System.out.println("Group: " + newCourseRecord.getGroup() );
		System.out.println("Day: " + newCourseRecord.getDay() );
		System.out.println("Time: " + newCourseRecord.getTime() );
		System.out.println("Venue: " + newCourseRecord.getVenue() );
		System.out.println("Remarks: " + newCourseRecord.getRemarks() );
		System.out.println("Vacancy: " + newCourseRecord.getVacancy() );
		System.out.println("Name: " + newCourseRecord.getName() );
		System.out.println("Name: " + newCourseRecord.getAU() );
		System.out.println("Name: " + newCourseRecord.getName() );
		System.out.println("Name: " + newCourseRecord.getSU() );
		System.out.println("Name: " + newCourseRecord.getCourseType());
		System.out.println("GERType: " + newCourseRecord.getGERType() );
		System.out.println("Course Successfully added!\n");
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
	public static void editCourse(ArrayList courseRecord, String num, String courseIndex, String indexNum, String type,
			String group, String day, String time, String venue, String remarks, String vacancy, String AU,String courseType,String  SU,String GERType) throws IOException
	{
		for(int i=0; i<courseRecord.size(); i++)
		{
			CourseRecord courseRecords = (CourseRecord)courseRecord.get(i);
			
			if(courseRecords.getCourseIndex().equals(courseIndex) && courseRecords.getIndexNum().equals(indexNum) && courseRecords.getNum().equals(num))
			{
				courseRecords.setTime(type);
				courseRecords.setGroup(group);
				courseRecords.setDay(day);
				courseRecords.setTime(time);
				courseRecords.setVenue(venue);
				courseRecords.setRemarks(remarks);
				courseRecords.setVacancy(vacancy);
				courseRecords.setAU(AU);
				courseRecords.setCourseType(courseType) ;
				courseRecords.setSU(SU);
				courseRecords.setGERType(GERType);
				CourseRecordsTextRepository courseRecordsTextRepository = new CourseRecordsTextRepository();
				courseRecordsTextRepository.saveList(courseRecord);
				
				System.out.println("CourseIndex: " + courseRecords.getCourseIndex() );
				System.out.println("IndexNum: " + courseRecords.getIndexNum() );
				System.out.println("Rype: " + courseRecords.getType() );
				System.out.println("Froup: " + courseRecords.getGroup() );
				System.out.println("Day: " + courseRecords.getDay() );
				System.out.println("Time: " + courseRecords.getTime() );
				System.out.println("Venue: " + courseRecords.getVenue() );
				System.out.println("Remarks: " + courseRecords.getRemarks() );
				System.out.println("Vacancy: " + courseRecords.getVacancy() );
				System.out.println("Name: " + courseRecords.getName() );
				System.out.println("AU: " + courseRecords.getAU() );
				System.out.println("course Type: " + courseRecords.getCourseType() );
				System.out.println("SU: " + courseRecords.getSU() );
				System.out.println("GERType: " + courseRecords.getGERType() );
				System.out.println("\n");
				
				System.out.println("Successful edited!\n");
				return;
			}
			
		}
	}
}
