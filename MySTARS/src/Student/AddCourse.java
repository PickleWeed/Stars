package Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import CourseRecords.CourseRecord;
import Repository.CourseRecordsTextRepository;
import Repository.DatDatabase;
import Repository.StudentRecordTextRepository;
import StudentInfo.Student;
import StudentRecords.StudentRecords;

/**
 * AddCourse implements the logic of adding a course
 * for the student if the student enters a valid courseIndex.
 * 
 * @author ?
 *
 */
public class AddCourse{
	/**
	 * Displays all indexNum under the courseIndex, prompts the user to enter an indexNum and
	 * add new entry into the StudentRecords and CourseRecords database 
	 * 
	 * @param studentsRecords An ArrayList of StudentRecords currently in the database
	 * @param courseRecordList An ArrayList of courseRecords currently in the database
	 * @param key The key used to identify a student
	 * @param firstName firstName
	 * @param lastName lastName
	 * @param matricNum matricNum
	 * @param courseIndex courseIndex
	 * @param indexNum indexNum
	 * @param AU AU of the course
	 * @param SU SU option
	 * @param CourseType CourseType(eg CORE)
	 * @param GERType(eg BM)
	 * @throws IOException If an input or output exception occurs
	 */
	public static void addCourse(ArrayList studentsRecords, ArrayList courseRecordList, ArrayList studentInfo, String key, String courseIndex, String indexNum, int index) throws IOException
	{
		
		//print non Distinct information
		for (int i=1; i<courseRecordList.size(); i++) { 
			CourseRecord courseRecords = (CourseRecord)courseRecordList.get(i);	
			if(courseRecords.getCourseIndex().equals(courseIndex) && courseRecords.getIndexNum().equals(indexNum)) 
			{
				System.out.println("Course Index: "+courseRecords.getCourseIndex() + ", Index Number: " + courseRecords.getIndexNum()+ ", Day:" +
			courseRecords.getDay()+ ", Time:" + courseRecords.getTime()+", Type: "+ courseRecords.getType() + ", Group: " + courseRecords.getGroup() + ", venue: " + courseRecords.getVenue()
			+ ", Remarks: " + courseRecords.getRemarks()); 		  
			}
		}
		//print Distinct information
		System.out.println();
		CourseRecord courseRecords = (CourseRecord)courseRecordList.get(index);
		System.out.println("Name: " + courseRecords.getName() +  ", AU:" + courseRecords.getAU() + ", CourseType: " + courseRecords.getCourseType() + ", SU: " + 
		courseRecords.getSU() + ", GERType: " + courseRecords.getGERType()+ ", Vacancy Left: " + courseRecords.getVacancy());
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you Want to add this Course(Yes or No): ");
		String add = sc.next();
		if(add.equals("Yes"))
		{
			String status;
			CourseRecord courseRecord = (CourseRecord)courseRecordList.get(index);
			
			String vacancy = courseRecords.getVacancy();
			int intVacancy = Integer.parseInt(vacancy);
			if(intVacancy == 0)
				status = "WAITLIST";
			else
			{
				status = "REGISTERED";
				intVacancy -= 1;
				String strVacancy = String.valueOf(intVacancy);
				courseRecords.setVacancy(strVacancy);
			}
			for (int i=1; i<studentInfo.size(); i++) { 
				Student student = (Student)studentInfo.get(i);	
				if(studentInfo)
			}
			
			CourseRecordsTextRepository courseRecordsTextRepository = new CourseRecordsTextRepository();
			courseRecordsTextRepository.saveList(courseRecordList);
			StudentRecords newStudentRecord = new StudentRecords(key,firstName,lastName,matricNum,courseIndex,indexNum,AU, CourseType, SU, GERType,"-");
			studentsRecords.add(newStudentRecord);
		}
		else
		{
			System.out.println("Exited\n");
			return;
		}

		
		
		

		}
	}
