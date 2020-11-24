package StudentInfo;

import java.util.ArrayList;

/**
 * GetStudentInfo displays student informations based on a given matriculation number.
 * 
 * @author ?
 *
 */
public class GetStudentInfo {
	
	/**
	 * displays all informations of student/students in the database with the same 
	 * key that is passed into the method.
	 * 
	 * @param studentInfo An Arraylist of all studentInfo in the database
	 * @param key The key of the student
	 */
	public static void printStudentInfo(ArrayList studentInfo, String key)
	{
		for (int i = 0 ; i < studentInfo.size() ; i++) {
			Student student = (Student)studentInfo.get(i);
				if(student.getKey().equals(key))
				{
					System.out.println("FirstName: " + student.getFirstName() );
					System.out.println("LastName: " + student.getLastName() );
					System.out.println("Matric Number: " + student.getMatricNum() );
					System.out.println("Gender: " + student.getGender() );
					System.out.println("Nationality: " + student.getNationality() );
					System.out.println("Age: " + student.getAge() );
					System.out.println("Access Period: " + student.getAccessPeriod());
					System.out.println("\n");
				}
		}
	}
	
	/**
	 * finds the key of the student in the database with the same matriculation number that is passed
	 * into the method.
	 * 
	 * @param studentInfo An Arraylist of all studentInfo in the database
	 * @param matricNum matriculation number of the student
	 * @return The key of the student, or nill if the matriculation number is not found in the database.
	 */
	public static String getStudentKey(ArrayList studentInfo, String matricNum)
	{
		//get key
		for (int i = 0; i < studentInfo.size(); i++)
		{
			Student student = (Student)studentInfo.get(i);
			if(student.getMatricNum().equals(matricNum))
				return student.getKey();	
		}
		return "nill";	
	}
	
}
