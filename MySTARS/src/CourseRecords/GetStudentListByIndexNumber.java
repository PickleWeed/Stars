package CourseRecords;

import java.io.IOException;
import java.util.ArrayList;

import StudentRecords.StudentRecords;



public class GetStudentListByIndexNumber {

	public static void showIndexNum(ArrayList StudentRecordsList) throws IOException
	{
		System.out.println("List of Index Number:");
		for (int i=0; i<StudentRecordsList.size(); i++)
		{
			//get array object 
			StudentRecords studentRecords = (StudentRecords)StudentRecordsList.get(i);
			if(!studentRecords.getKey().equals("nill"))
				System.out.println("Index Number: " + studentRecords.getIndexNum());
		}
	}
	public static void getKey(String indexNum, ArrayList StudentRecordsList)
	{
		for (int i=0; i<StudentRecordsList.size(); i++)
		{
			//get array object 
			StudentRecords studentRecords = (StudentRecords)StudentRecordsList.get(i);
			if(studentRecords.getIndexNum().equals(indexNum) && !studentRecords.getKey().equals("nill"))
				System.out.println("Avaliable slot for Index Number" + indexNum + ": " + studentRecords.getKey());
		}
	}
}
