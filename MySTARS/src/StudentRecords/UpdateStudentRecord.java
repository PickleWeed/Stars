package StudentRecords;

import java.io.IOException;
import java.util.ArrayList;

import Repository.StudentRecordTextRepository;

public class UpdateStudentRecord {

	public static void updateStudentRecord(ArrayList StudentRecord, String courseIndex, String indexNum, String AU) throws IOException
	{
		boolean updateRecord = false;
		for (int i = 0 ; i < StudentRecord.size() ; i++) {
			StudentRecords studentRecord = (StudentRecords)StudentRecord.get(i);
			
			if(studentRecord.getIndexNum().equals(indexNum) && studentRecord.getCourseIndex().equals(courseIndex))
			{
				updateRecord = true;
				System.out.println("Old AU: " + studentRecord.getAU() + ", New AU: " + AU);
				studentRecord.setAU(AU);
			}
		}
		if(updateRecord == true)
		{
			StudentRecordTextRepository studentRecordTextRepository = new StudentRecordTextRepository();
			studentRecordTextRepository.saveList(StudentRecord);
		}
		
	}
}
