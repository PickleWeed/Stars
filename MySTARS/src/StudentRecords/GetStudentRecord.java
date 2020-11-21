package StudentRecords;

import java.util.ArrayList;

public class GetStudentRecord {
	
	public static void getStudentRecord(ArrayList StudentRecord, String key)
	{
		for (int i = 0 ; i < StudentRecord.size() ; i++) {
			StudentRecords studentRecord = (StudentRecords)StudentRecord.get(i);
				if(studentRecord.getKey().equals(key))
				{
					System.out.println("IndexNum: " + studentRecord.getIndexNum() );
					System.out.println("CourseIndex: " + studentRecord.getCourseIndex() );
					System.out.println("First Name: " + studentRecord.getFirstName() );
					System.out.println("Last Name: " + studentRecord.getLastName() );
					System.out.println("Matric Number: " + studentRecord.getMatricNum() );
					System.out.println("\n");
				}
		}
	}

}
