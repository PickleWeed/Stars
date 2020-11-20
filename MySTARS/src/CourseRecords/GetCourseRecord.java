package CourseRecords;

import java.io.IOException;
import java.util.ArrayList;

import Repository.CourseRecordsTextRepository;
import Repository.GlobalAccessPeriodTextRepository;

public class GetCourseRecord {

	public static void showIndexNum(ArrayList courseRecordList) throws IOException
	{
		System.out.println("List of Index Number:");
		for (int i=0; i<courseRecordList.size(); i++)
		{
			//get array object 
			CourseRecord courseRecords = (CourseRecord)courseRecordList.get(i);
			if(!courseRecords.getVacancy().equals("nill"))
				System.out.println("Index Number: " + courseRecords.getIndexNum());
		}
	}
	public static void getVacancy(String indexNum, ArrayList courseRecordList)
	{
		for (int i=0; i<courseRecordList.size(); i++)
		{
			//get array object 
			CourseRecord courseRecords = (CourseRecord)courseRecordList.get(i);
			if(courseRecords.getIndexNum().equals(indexNum) && !courseRecords.getVacancy().equals("nill"))
				System.out.println("Avaliable slot for Index Number" + indexNum + ": " + courseRecords.getVacancy());
		}
	}
}
