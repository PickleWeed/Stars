package Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import CourseRecords.CourseRecord;
import Repository.DatDatabase;
import Repository.StudentRecordTextRepository;
import StudentRecords.StudentRecords;


public class AddCourse{
	public static void addCourse(ArrayList studentsRecords, String key, String firstName, 
			String lastName, String matricNum, String courseIndex, String indexNum,String AU) throws IOException{
		
		Scanner sc = new Scanner(System.in);
		ArrayList courseRecordList = (ArrayList)DatDatabase.read("CourseRecords.dat");
		System.out.println("Course Index" + "  " + "Index Number"); 
		System.out.println("***************************"); 		
		for (int i=1; i<courseRecordList.size(); i++) { 
			CourseRecord courseRecords = (CourseRecord)courseRecordList.get(i);	
			if(courseRecords.getCourseIndex().equals(courseIndex)) {
				System.out.println("   "+courseRecords.getCourseIndex() + "        " + courseRecords.getIndexNum()); 		  
			}
		}
		System.out.println("Enter Index Number: "); 
		indexNum = sc.next();
		ArrayList studentRecords;
		StudentRecordTextRepository studentCoursesTextRepository = new StudentRecordTextRepository();
		studentsRecords = studentCoursesTextRepository.readToList();
		StudentRecords newStudentRecord = new StudentRecords(key,firstName,lastName,matricNum,courseIndex,indexNum,AU,"-","-","-","-");
		studentsRecords.add(newStudentRecord);
		studentCoursesTextRepository.saveList(studentsRecords);

		}
  }

