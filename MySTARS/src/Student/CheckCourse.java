package Student;

import java.io.IOException;
import java.util.ArrayList;

import CourseRecords.CourseRecord;
import Login.LoginInfo;
import Repository.CourseRecordsTextRepository;
import StudentInfo.Student;
import StudentRecords.StudentRecords;

/**
 * CheckCourse is a control class that displays the course informations for all
 * courses registered by the student.
 * 
 * @author ?
 *
 */
public class CheckCourse {

	public static void showIndexNum(ArrayList StudentRecordsList,ArrayList loginInfo) throws IOException
	{

		System.out.println("List of Index Number:");
		for (int i=0; i<StudentRecordsList.size(); i++)
			for (int j=0; j<loginInfo.size(); j++)
		{
			//get array object 
			StudentRecords studentRecords = (StudentRecords)StudentRecordsList.get(i);
			LoginInfo LoginInfo = (LoginInfo)loginInfo.get(j);
			if(!studentRecords.getKey().equals("nill")&& studentRecords.getKey().equals(LoginInfo.getKey()))
				System.out.println("Index Number: " + studentRecords.getIndexNum());
		}
	}
	public static void getKey(String username, ArrayList StudentRecordsList,ArrayList loginInfo)
	{
		for (int i=0; i<StudentRecordsList.size(); i++)
			for (int j=0; j<loginInfo.size(); j++)
		{
			//get array object 
			StudentRecords studentRecords = (StudentRecords)StudentRecordsList.get(i);
			LoginInfo LoginInfo = (LoginInfo)loginInfo.get(j);

			if(!LoginInfo.getKey().equals("nill")&& LoginInfo.getKey().equals(studentRecords.getKey())&&LoginInfo.getUsername().equals(username))
				//System.out.println ("Name : "+ LoginInfo.getKey() + " "+LoginInfo.getKey()+ ", Gender : ");
				System.out.print(studentRecords.getCourseIndex()+studentRecords.getKey()+LoginInfo.getUsername());
			}
		}	
	}

