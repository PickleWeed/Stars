package CourseRecords;

import java.io.IOException;
import java.util.ArrayList;

import Repository.CourseRecordsTextRepository;
import Repository.GlobalAccessPeriodTextRepository;

public class GetCourseRecord {

	public static void showIndexNum(ArrayList courseRecord) throws IOException
	{
		System.out.println("List of Index Number:");
		for (int i=0; i<courseRecord.size(); i++)
		{
			//get array object 
			CourseRecord courseRecords = (CourseRecord)courseRecord.get(i);
			if(!courseRecords.getVacancy().equals("nill"))
				System.out.println("Index Number: " + courseRecords.getIndexNum());
		}
	}
	public static void printVacancy(String indexNum, ArrayList courseRecord)
	{
		for (int i=0; i<courseRecord.size(); i++)
		{
			CourseRecord courseRecords = (CourseRecord)courseRecord.get(i);
			if(courseRecords.getIndexNum().equals(indexNum)) {
				System.out.println("Index Number: "+ indexNum + "     Course: "+ courseRecords.getCourseIndex() + "\n");
				break;
			}
		}
		for (int i=0; i<courseRecord.size(); i++)
		{
			//get array object 
			CourseRecord courseRecords = (CourseRecord)courseRecord.get(i);
			if(courseRecords.getIndexNum().equals(indexNum)) {
				System.out.println("Class Type: " + courseRecords.getType());
				System.out.println("Group: " + courseRecords.getGroup());
				System.out.println("Day: " + courseRecords.getDay());
				System.out.println("Time: " + courseRecords.getTime());
				System.out.println("Venue: " + courseRecords.getVenue());
				System.out.println("Remarks: " + courseRecords.getRemarks());
				System.out.println("\n");
			}
		}
		
		for (int i=0; i<courseRecord.size(); i++)
		{
			CourseRecord courseRecords = (CourseRecord)courseRecord.get(i);
			if(courseRecords.getIndexNum().equals(indexNum)) {
				System.out.println("Place Available: " + courseRecords.getVacancy() + "\n");
				break;
			}
		}
	}
	
	public static void getAllCourseData(ArrayList courseRecord) throws IOException
	{
		for (int i = 0 ; i < courseRecord.size() ; i++) {
			CourseRecord courseRecordList = (CourseRecord)courseRecord.get(i);
				System.out.println("CourseIndex: " + courseRecordList.getCourseIndex() );
				System.out.println("IndexNum: " + courseRecordList.getIndexNum() );
				System.out.println("Type: " + courseRecordList.getType() );
				System.out.println("Group: " + courseRecordList.getGroup() );
				System.out.println("Day: " + courseRecordList.getDay() );
				System.out.println("Time: " + courseRecordList.getTime() );
				System.out.println("Venue: " + courseRecordList.getVenue() );
				System.out.println("Remarks: " + courseRecordList.getRemarks() );
				System.out.println("Vacancy: " + courseRecordList.getVacancy() );
				System.out.println("Name: " + courseRecordList.getName() );
				
				System.out.println("\n");
			}
	}
	public static void getCourseCode(ArrayList courseRecord, String courseIndex, String indexNum)
	{
		for (int i = 0 ; i < courseRecord.size() ; i++) {
			CourseRecord courseRecordList = (CourseRecord)courseRecord.get(i);
			if(courseRecordList.getCourseIndex().equals(courseIndex) && courseRecordList.getIndexNum().equals(indexNum))
			{
				System.out.println("\n");
				System.out.println("*********No." + courseRecordList.getNum() + "*********");
				System.out.println("CourseIndex: " + courseRecordList.getCourseIndex() );
				System.out.println("IndexNum: " + courseRecordList.getIndexNum() );
				System.out.println("Type: " + courseRecordList.getType() );
				System.out.println("Group: " + courseRecordList.getGroup() );
				System.out.println("Day: " + courseRecordList.getDay() );
				System.out.println("Time: " + courseRecordList.getTime() );
				System.out.println("Venue: " + courseRecordList.getVenue() );
				System.out.println("Remarks: " + courseRecordList.getRemarks() );
				System.out.println("Vacancy: " + courseRecordList.getVacancy() );
				System.out.println("Name: " + courseRecordList.getName() );				
			}

		}
	}
	public static void getCourseCode(ArrayList courseRecord) throws IOException
	{
		for (int i = 0 ; i < courseRecord.size() ; i++) {
			CourseRecord courseRecordList = (CourseRecord)courseRecord.get(i);
			if(!courseRecordList.getVacancy().equals("nill"))
				System.out.println("Course Index: " + courseRecordList.getCourseIndex() + ", Index Number: " + courseRecordList.getIndexNum());
		}
	}
	
}
