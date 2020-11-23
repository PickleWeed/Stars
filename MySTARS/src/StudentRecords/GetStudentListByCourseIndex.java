package StudentRecords;

import java.io.IOException;
import java.util.ArrayList;

import StudentInfo.Student;
import StudentRecords.StudentRecords;

/**
 * GetStudentListByCourseIndex is a control class which allows a user to select a CourseIndex (eg. CZ1003)
 * and displays all students name, gender, and nationality who have registered for this course. 
 * 
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
	public static void printStudentList(ArrayList studentRecordsList, ArrayList studentInfo, String courseIndex) throws IOException
	{
		boolean noResult = true;
		System.out.println("\n***List of Students***");
		for(int i=0; i< studentRecordsList.size(); i++)
		{
			StudentRecords studentRecords = (StudentRecords)studentRecordsList.get(i);
			if(studentRecords.getCourseIndex().equals(courseIndex))
			{
				String key = studentRecords.getKey();
				for(int j=0; j<studentInfo.size(); j++)
				{
					Student student = (Student)studentInfo.get(j);
					if(student.getKey().equals(key))
					{
						//print name, gender, nationality
						noResult = false;
						System.out.println("Name: " + student.getFirstName() + " " + student.getLastName() + ", Gender: " + student.getGender() + ", Nationality: "
								+ student.getNationality());
					}
				}
			}
		}
		if(noResult)
			System.out.println("No Results\n");
	}
}
