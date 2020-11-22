package StudentInfo;

import java.util.ArrayList;


public class GetStudentInfo {
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
