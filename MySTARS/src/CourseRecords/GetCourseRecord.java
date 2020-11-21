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
	public static void getVacancy(String indexNum, ArrayList courseRecord)
	{
		for (int i=0; i<courseRecord.size(); i++)
		{
			//get array object 
			CourseRecord courseRecords = (CourseRecord)courseRecord.get(i);
			if(courseRecords.getIndexNum().equals(indexNum) && !courseRecords.getVacancy().equals("nill"))
				System.out.println("Avaliable slot for Index Number" + indexNum + ": " + courseRecords.getVacancy());
		}
	}
	public static void getCourseData(ArrayList courseRecord) throws IOException
	{
		for (int i = 0 ; i < courseRecord.size() ; i++) {
			CourseRecord courseRecords = (CourseRecord)courseRecord.get(i);
				System.out.println("CourseIndex: " + courseRecords.getCourseIndex() );
				System.out.println("IndexNum: " + courseRecords.getIndexNum() );
				System.out.println("Type: " + courseRecords.getType() );
				System.out.println("Group: " + courseRecords.getGroup() );
				System.out.println("Day: " + courseRecords.getDay() );
				System.out.println("Time: " + courseRecords.getTime() );
				System.out.println("Venue: " + courseRecords.getVenue() );
				System.out.println("Remarks: " + courseRecords.getRemarks() );
				System.out.println("Vacancy: " + courseRecords.getVacancy() );
				System.out.println("Name: " + courseRecords.getName() );
				
				System.out.println("\n");
			}
	}
}
