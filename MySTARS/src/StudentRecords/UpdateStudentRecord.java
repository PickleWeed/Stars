package StudentRecords;

import java.util.ArrayList;

public class UpdateStudentRecord {

	public static void updateStudentRecord(ArrayList StudentRecord, String courseIndex, String indexNum, String AU)
	{
		for (int i = 0 ; i < StudentRecord.size() ; i++) {
			StudentRecords studentRecord = (StudentRecords)StudentRecord.get(i);
			
			if(studentRecord.getIndexNum().equals(indexNum) && studentRecord.getCourseIndex().equals(StudentRecord))
			{
				System.out.println("Old AU: " + studentRecord.getAU() + ", New AU: " + AU);
				studentRecord.setAU(AU);
			}
		}
	}
}
