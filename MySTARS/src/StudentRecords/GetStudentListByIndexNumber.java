package StudentRecords;

import java.io.IOException;
import java.util.ArrayList;

import StudentInfo.Student;

/**
 * GetStudentListByIndexNumber allows a user to select a IndexNum (eg. CZ1003)
 * and displays all students name, gender, and nationality who have registered for this Index Number. 
 * 
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
	 * @param indexNum The indexNum to display all students' information under this index
	 * @throws IOException If an input or output exception occurred
	 */
	public static void printStudentList(ArrayList studentRecordsList, ArrayList studentInfo, String indexNum) throws IOException
	{
		boolean noResult = true;
		System.out.println("\n***List of Students***");
		for(int i=0; i< studentRecordsList.size(); i++)
		{
			StudentRecords studentRecords = (StudentRecords)studentRecordsList.get(i);
			if(studentRecords.getIndexNum().equals(indexNum))
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
		System.out.println();
		if(noResult)
			System.out.println("No Results\n");
	}
}

