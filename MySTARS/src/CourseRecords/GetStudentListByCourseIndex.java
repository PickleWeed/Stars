package CourseRecords;

import java.io.IOException;
import java.util.ArrayList;

import StudentInfo.Student;
import StudentRecords.StudentRecords;

/**
 * GetStudentListByCourseIndex is a boundary class which allows a user to select an CourseIndex (eg. CZ1003)
 * from a list of all possible CourseIndex and displays all students who have registered for a course 
 * under this CourseIndex.
 * 
 * @author ?
 *
 */
public class GetStudentListByCourseIndex {

	/**
	 * Displays all possible CourseIndex
	 * 
	 * @param StudentRecordsList Entire database of StudentRecords
	 * @param studentInfo Entire database of StudentInfo
	 * @throws IOException If an input or output exception occurred
	 */
	public static void showcourseIndex(ArrayList StudentRecordsList,ArrayList studentInfo) throws IOException
	{
		System.out.println("List of Index Number:");
		for (int i=0; i<StudentRecordsList.size(); i++)
			for (int j=0; j<studentInfo.size(); j++)
		{
			//get array object 
			StudentRecords studentRecords = (StudentRecords)StudentRecordsList.get(i);
			Student StudentInfo = (Student)studentInfo.get(j);
			if(!studentRecords.getKey().equals("nill")&& studentRecords.getKey().equals(StudentInfo.getKey()))
				System.out.println("Index Number: " + studentRecords.getCourseIndex());
		}
	}
	
	/**
	 * Displays all students who have registered a course with the CourseIndex
	 * 
	 * @param courseIndex all students who have registered a course with this CourseIndex will be displayed
	 * @param StudentRecordsList Entire database of StudentRecords
	 * @param studentInfo Entire database of StudentInfo
	 */
	public static void getKey(String courseIndex, ArrayList StudentRecordsList,ArrayList studentInfo)
	{
		for (int i=0; i<StudentRecordsList.size(); i++)
			for (int j=0; j<studentInfo.size(); j++)
		{
			//get array object 
				StudentRecords studentRecords = (StudentRecords)StudentRecordsList.get(i);
				Student StudentInfo = (Student)studentInfo.get(j);
			if(studentRecords.getCourseIndex().equals(courseIndex) && !studentRecords.getKey().equals("nill")&& studentRecords.getKey().equals(StudentInfo.getKey()))
				System.out.println ("Name : "+ StudentInfo.getFirstName()+ " "+StudentInfo.getLastName()+ ", Gender : " + StudentInfo.getGender()+ ", Nationality : " + StudentInfo.getNationality());
		}
	}
}
