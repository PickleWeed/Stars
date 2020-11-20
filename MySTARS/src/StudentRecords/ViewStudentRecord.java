package StudentRecords;

import java.util.ArrayList;

public class ViewStudentRecord {
	
	public static void getStudentRecord(ArrayList StudentInfoList, String key)
	{
		for (int i = 0 ; i < StudentInfoList.size() ; i++) {
			StudentRecords studentRecord = (StudentRecords)StudentInfoList.get(i);
				if(studentRecord.getKey().equals(key))
				{
					System.out.println("IndexNum: " + studentRecord.getIndexNum() );
					System.out.println("CourseIndex: " + studentRecord.getCourseIndex() );
					System.out.println("Type: " + studentRecord.getType() );
					System.out.println("Group: " + studentRecord.getGroup() );
					System.out.println("Day: " + studentRecord.getDay() );
					System.out.println("Time: " + studentRecord.getTime() );
					System.out.println("Venue: " + studentRecord.getVenue() );
					System.out.println("Remark: " + studentRecord.getRemark() );
					System.out.println("\n");
				}
		}
	}

}
