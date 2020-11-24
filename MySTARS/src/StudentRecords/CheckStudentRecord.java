package StudentRecords;

import java.util.ArrayList;

import CourseRecords.CourseRecord;

public class CheckStudentRecord {
	public static boolean checkStudent(ArrayList studentRecordsList, String courseIndex, String key)
	{
		for(int i=0; i< studentRecordsList.size(); i++)
		{
			StudentRecords studentRecord = (StudentRecords)studentRecordsList.get(i);
			if(studentRecord.getCourseIndex().equals(courseIndex) && studentRecord.getKey().equals(key))
			{
				System.out.println("Cannot Add this Course. You already have this course!\n");
				return true;
			}
				
		}
		return false;
	}
	public static boolean checkTiming(ArrayList courseRecordList, ArrayList studentsRecords, String courseIndex, String indexNum, String key)
	{
		ArrayList<String> courseListTiming = new ArrayList<String>();
		for(int i=0; i< courseRecordList.size(); i++)
		{
			CourseRecord courseRecord = (CourseRecord)courseRecordList.get(i);
			if(courseRecord.getCourseIndex().equals(courseIndex) && courseRecord.getIndexNum().equals(indexNum))
				courseListTiming.add(courseRecord.getDay() + "|" + courseRecord.getTime());
		}
		ArrayList<String> studentListTiming = new ArrayList<String>();
		for(int i=0; i< studentsRecords.size(); i++)
		{
			StudentRecords studentRecordList = (StudentRecords)studentsRecords.get(i);
			if(studentRecordList.getKey().equals(key))
				studentListTiming.add(studentRecordList.getCourseIndex() + "|" + studentRecordList.getIndexNum());
		}
		for(int i=0; i< courseRecordList.size(); i++)
		{
			CourseRecord courseRecord = (CourseRecord)courseRecordList.get(i);
			
		}
		System.out.println(courseListTiming);
		System.out.println(studentListTiming);
		
		return false;
	}
}
