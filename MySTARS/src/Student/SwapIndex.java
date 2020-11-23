package Student;

import java.io.IOException;
import java.util.ArrayList;

import CourseRecords.CourseRecord;
import Repository.StudentRecordTextRepository;
import StudentInfo.Student;
import StudentRecords.StudentRecords;

/**
 * SwapIndex is a control class that swaps the indexes of a course between 2 students.
 * @author ?
 *
 */
public class SwapIndex {
	
	public static ArrayList getIndexList(ArrayList studentRecords, String matricNum) throws IOException
	{
		ArrayList<String> indexList = new ArrayList<String>();
		for (int i=0; i<studentRecords.size(); i++)
		{
			//get array object 
			StudentRecords studentRecord = (StudentRecords)studentRecords.get(i);
			if(studentRecord.getMatricNum().contentEquals(matricNum)){
				indexList.add(studentRecord.getIndexNum());
			}
		}
		return indexList;
	}

	public static ArrayList getMatricList(ArrayList studentInfo) throws IOException
	{
		ArrayList<String> matricList = new ArrayList<String>();
		for (int i=0; i<studentInfo.size(); i++)
		{
			//get array object 
			Student studentInfos = (Student)studentInfo.get(i);
			matricList.add(studentInfos.getMatricNum());		
		}
		return matricList;
	}
	public static ArrayList getFriendIndex(ArrayList StudentRecord, String matricNum, String course) throws IOException
	{
		ArrayList<String> iList = new ArrayList<String>();
		for (int i=0; i<StudentRecord.size(); i++)
		{
			//get array object 
			StudentRecords studentRecord = (StudentRecords)StudentRecord.get(i);
			if(studentRecord.getMatricNum().equals(matricNum) && studentRecord.getCourseIndex().equals("course"))
				iList.add(studentRecord.getIndexNum());		
		}
		return iList;
	}
	
	public static void swapIndex(ArrayList studentsRecords, ArrayList courseRecordList,String MatricNum, String oldIndexNum, String newIndexNum, String key) throws IOException {
    int count = 0;
    //print details of old and new index
	for (int i=0; i<courseRecordList.size(); i++)
	{
		CourseRecord courseRecords = (CourseRecord)courseRecordList.get(i);
		if(courseRecords.getIndexNum().equals(oldIndexNum)) {
			System.out.println("Course: "+ courseRecords.getCourseIndex() + "\n");
			break;
		}
	}
	System.out.println("Current Index Number: "+ oldIndexNum + "\n");

	for (int i=0; i<courseRecordList.size(); i++)
	{
		CourseRecord courseRecords = (CourseRecord)courseRecordList.get(i);
		if(courseRecords.getIndexNum().equals(oldIndexNum)) {
			System.out.println("Class Type: " + courseRecords.getType());
			System.out.println("Group: " + courseRecords.getGroup());
			System.out.println("Day: " + courseRecords.getDay());
			System.out.println("Time: " + courseRecords.getTime());
			System.out.println("Venue: " + courseRecords.getVenue());
			System.out.println("Remarks: " + courseRecords.getRemarks());
			System.out.println("\n");
		}
	}
	System.out.println("New Index Number: "+ newIndexNum + "\n");

	for (int i=0; i<courseRecordList.size(); i++)
	{
		CourseRecord courseRecords = (CourseRecord)courseRecordList.get(i);
		if(courseRecords.getIndexNum().equals(newIndexNum)) {
			System.out.println("Class Type: " + courseRecords.getType());
			System.out.println("Group: " + courseRecords.getGroup());
			System.out.println("Day: " + courseRecords.getDay());
			System.out.println("Time: " + courseRecords.getTime());
			System.out.println("Venue: " + courseRecords.getVenue());
			System.out.println("Remarks: " + courseRecords.getRemarks());
			System.out.println("\n");
		}
	}
	
	//change index in StudentRecord
	for (int i = 0 ; i < studentsRecords.size() ; i++) {
		StudentRecords studentRecord = (StudentRecords)studentsRecords.get(i);
		if(studentRecord.getKey().equals(key) && studentRecord.getIndexNum().contentEquals(oldIndexNum)) {
			studentRecord.setIndexNum(newIndexNum);
			
			StudentRecordTextRepository studentRecordsTextRepository = new StudentRecordTextRepository();
			studentRecordsTextRepository.saveList(studentsRecords);
			count++;
			break;
		}	
	}
	
	for (int i = 0 ; i < studentsRecords.size() ; i++) {
		StudentRecords studentRecord = (StudentRecords)studentsRecords.get(i);
		if(studentRecord.getMatricNum().equals(MatricNum) && studentRecord.getIndexNum().contentEquals(newIndexNum)) {
			studentRecord.setIndexNum(oldIndexNum);
			
			StudentRecordTextRepository studentRecordsTextRepository = new StudentRecordTextRepository();
			studentRecordsTextRepository.saveList(studentsRecords);
			count++;
			break;
		}	
	}
	
	if (count > 0) {
		System.out.println("Swap Index Successful!\n");
	}
}
}
