package Admin;

import java.io.IOException;
import java.util.ArrayList;

import Course.CourseRecordsObj;
import TextRepository.CourseRecordsTextRepository;
import TextRepository.GlobalAccessPeriodTextRepository;

public class ViewCourseRecord {

	public static void showIndexNum(ArrayList courseRecordList) throws IOException
	{
		System.out.println("List of Index Number:");
		for (int i=0; i<courseRecordList.size(); i++)
		{
			//get array object 
			CourseRecordsObj courseRecords = (CourseRecordsObj)courseRecordList.get(i);
			if(!courseRecords.getVacancy().equals("nill"))
				System.out.println("Index Number: " + courseRecords.getIndexNum());
		}
	}
	public static void getVacancy(String indexNum, ArrayList courseRecordList)
	{
		for (int i=0; i<courseRecordList.size(); i++)
		{
			//get array object 
			CourseRecordsObj courseRecords = (CourseRecordsObj)courseRecordList.get(i);
			if(courseRecords.getIndexNum().equals(indexNum) && !courseRecords.getVacancy().equals("nill"))
				System.out.println("Avaliable slot for Index Number" + indexNum + ": " + courseRecords.getVacancy());
		}
	}
	public static void viewAccessPeriod(ArrayList accessPeriod)
	{
		for (int i = 0 ; i < accessPeriod.size() ; i++) {
			AccessPeriodObj accessPeriodObj = (AccessPeriodObj)accessPeriod.get(i);

					System.out.println((i+1) + ". Starting Access Period: " + accessPeriodObj.getStartAccessPeriod() + ", Ending Access Period: " + accessPeriodObj.getEndAccessPeriod());
		}
		System.out.println("\n");
	}
	public static String getAccessPeriod(ArrayList accessPeriod, String acessPeriodValue)
	{
		for (int i = 0 ; i < accessPeriod.size() ; i++) {
			AccessPeriodObj accessPeriodObj = (AccessPeriodObj)accessPeriod.get(i);
			if(acessPeriodValue.equals(Integer.toString(i+1)))
			{
				return (accessPeriodObj.getStartAccessPeriod() + " - " + accessPeriodObj.getEndAccessPeriod());
				//System.out.println((i+1) + ". Starting Access Period: " + accessPeriodObj.getStartAccessPeriod() + ", Ending Access Period: " + accessPeriodObj.getEndAccessPeriod());
			}
		}
		System.out.println("Invalid Value");
		return "nill";	
	}
	public static void main(String[] args) throws IOException {
		ArrayList 	accessPeriodList = GlobalAccessPeriodTextRepository.readAccessPeriod();
		getAccessPeriod(accessPeriodList, "5");
	}
		
}
