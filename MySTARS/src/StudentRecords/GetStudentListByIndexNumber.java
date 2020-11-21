package StudentRecords;

import java.io.IOException;
import java.util.ArrayList;

import StudentInfo.Student;



public class GetStudentListByIndexNumber {

	public static void showIndexNum(ArrayList StudentRecordsList,ArrayList studentInfo) throws IOException
	{

		System.out.println("List of Index Number:");
		for (int i=0; i<StudentRecordsList.size(); i++)
			for (int j=0; j<studentInfo.size(); j++)
		{
			//get array object 
			StudentRecords studentRecords = (StudentRecords)StudentRecordsList.get(i);
			Student StudentInfo = (Student)studentInfo.get(j);
			if(!studentRecords.getKey().equals("nill")&& studentRecords.getKey().equals(StudentInfo.getKey()))
				System.out.println("Index Number: " + studentRecords.getIndexNum());
		}
	}
	public static void getKey(String indexNum, ArrayList StudentRecordsList,ArrayList studentInfo)
	{
		for (int i=0; i<StudentRecordsList.size(); i++)
			for (int j=0; j<studentInfo.size(); j++)
		{
			//get array object 
			StudentRecords studentRecords = (StudentRecords)StudentRecordsList.get(i);
			Student StudentInfo = (Student)studentInfo.get(j);

			if(studentRecords.getIndexNum().equals(indexNum) && !studentRecords.getKey().equals("nill")&& studentRecords.getKey().equals(StudentInfo.getKey()))
				System.out.println ("Name : "+ StudentInfo.getFirstName()+ " "+StudentInfo.getLastName()+ ", Gender : " + StudentInfo.getGender()+ ", Nationality : " + StudentInfo.getNationality());
			
			}
		}	
	}

