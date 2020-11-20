package CourseRecords;

import java.io.IOException;
import java.util.ArrayList;

import StudentRecords.StudentRecords;



public class GetStudentListByCourseIndex {

	public static void showcourseIndex(ArrayList StudentRecordsList) throws IOException
	{
		System.out.println("List of Index Number:");
		for (int i=0; i<StudentRecordsList.size(); i++)
		{
			//get array object 
			StudentRecords studentRecords = (StudentRecords)StudentRecordsList.get(i);
			if(!studentRecords.getKey().equals("nill"))
				System.out.println("Index Number: " + studentRecords.getCourseIndex());
		}
	}
	public static void getKey(String courseIndex, ArrayList StudentRecordsList)
	{
		for (int i=0; i<StudentRecordsList.size(); i++)
		{
			//get array object 
			StudentRecords studentRecords = (StudentRecords)StudentRecordsList.get(i);
			if(studentRecords.getCourseIndex().equals(courseIndex) && !studentRecords.getKey().equals("nill"))
				System.out.println("Avaliable slot for Index Number" + courseIndex + ": " + studentRecords.getKey());
		}
	}
}
