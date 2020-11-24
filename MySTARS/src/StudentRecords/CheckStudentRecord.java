package StudentRecords;

import java.util.ArrayList;

public class CheckStudentRecord {
	public static boolean checkStudent(ArrayList studentRecordsList, String courseIndex, String key)
	{
		for(int i=0; i< studentRecordsList.size(); i++)
		{
			StudentRecords studentRecord = (StudentRecords)studentRecordsList.get(i);
			if(studentRecord.getCourseIndex().equals(courseIndex) && studentRecord.getKey().equals(key))
			{
				System.out.println("Cannot Add this Course. You already have this course\n");
				return true;
			}
				
		}
		return false;
	}
}
