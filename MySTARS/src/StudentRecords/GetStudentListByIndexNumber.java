package StudentRecords;

import java.io.IOException;
import java.util.ArrayList;

import StudentInfo.Student;

/**
 * GetStudentListByIndexNumber is a boundary class which allows a user to select an indexNum (eg. 10088)
 * from a list of all possible indexNum and displays all students who have registered for a course 
 * under this index.
 * 
 * @author ?
 *
 */
public class GetStudentListByIndexNumber {

	/**
	 * Displays all possible indexNum
	 * 
	 * @param StudentRecordsList Entire database of StudentRecords
	 * @param studentInfo Entire database of StudentInfo
	 * @throws IOException If an input or output exception occurred
	 */
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
	
	/**
	 * Displays all students who have registered a course with the indexNum
	 * 
	 * @param indexNum all students who have registered a course with this indexNum will be displayed
	 * @param StudentRecordsList Entire database of StudentRecords
	 * @param studentInfo Entire database of StudentInfo
	 */
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

