package CourseRecords;

import java.util.ArrayList;

public class CheckCourseRecord {
	public static boolean checkCourse(ArrayList courseRecord, String courseIndex, String indexNum)
	{
		for (int i = 0 ; i < courseRecord.size() ; i++) {
			CourseRecord courseRecordList = (CourseRecord)courseRecord.get(i);
			if(courseRecordList.getCourseIndex().equals(courseIndex) && courseRecordList.getIndexNum().equals(indexNum))
				return true;
		}
		System.out.println("Invalid Course Index & Index Number\n");
		return false;
	}
	public static boolean checkNum(ArrayList courseRecord, String num, String courseIndex, String indexNum)
	{
		for (int i = 0 ; i < courseRecord.size() ; i++) {
			CourseRecord courseRecordList = (CourseRecord)courseRecord.get(i);
			if(courseRecordList.getNum().equals(num) && courseRecordList.getCourseIndex().equals(courseIndex) && courseRecordList.getIndexNum().equals(indexNum))
				return true;
		}
		System.out.println("Invalid No. \n");
		return false;
	}
	public static boolean checkDuplicate(ArrayList courseRecord, String courseIndex, String indexNum)
	{
		for (int i = 0 ; i < courseRecord.size() ; i++) {
			CourseRecord courseRecordList = (CourseRecord)courseRecord.get(i);
			if(courseRecordList.getCourseIndex().equals(courseIndex) && courseRecordList.getIndexNum().equals(indexNum))
			{
				System.out.println("Cannot add a course that already exist");
				return true;
			}
				
		}
		return false;
	}
	
}
