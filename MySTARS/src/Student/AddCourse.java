package Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import CourseRecords.CourseRecord;
import Repository.CourseRecordsTextRepository;
import Repository.DatDatabase;
import Repository.StudentRecordTextRepository;
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
	public static void addCourse(ArrayList studentsRecords, ArrayList courseRecordList, String key, String firstName, String lastName, String matricNum, String courseIndex, String indexNum,String AU,String CourseType,String SU, String GERType) throws IOException{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Course Index" + "  " + "Index Number" +"    "+"Day"+"          "+"Time"+"                "+ "Type"); 
		System.out.println("************************************************************************************"); 		
		for (int i=1; i<courseRecordList.size(); i++) { 
			CourseRecord courseRecords = (CourseRecord)courseRecordList.get(i);	
			if(courseRecords.getCourseIndex().equals(courseIndex)) {
				System.out.println("   "+courseRecords.getCourseIndex() + "        " + courseRecords.getIndexNum()+ "        " + courseRecords.getDay()+ "        " + courseRecords.getTime()+"             "+ courseRecords.getType()+ "        " ); 		  
			}

		}
		System.out.println("Enter Index Number: "); 
		indexNum = sc.next();
		for (int i=1; i<courseRecordList.size(); i++) { 
			CourseRecord courseRecords = (CourseRecord)courseRecordList.get(i);	
			if(courseRecords.getCourseIndex().equals(courseIndex) && courseRecords.getIndexNum().equals(indexNum) && courseRecords.getType().equals("LEC/STUDIO")) {
				String vacancy = courseRecords.getVacancy();
				
				int intVacancy = Integer.parseInt(vacancy);
				intVacancy -= 1;
				String strVacancy = String.valueOf(intVacancy);
				courseRecords.setVacancy(strVacancy);
				
				StudentRecordTextRepository studentCoursesTextRepository = new StudentRecordTextRepository();
				studentCoursesTextRepository.saveList(studentsRecords);
				CourseRecordsTextRepository courseRecordsTextRepository = new CourseRecordsTextRepository();
				courseRecordsTextRepository.saveList(courseRecordList);
				break;
			}

		}
		ArrayList studentRecords;
		StudentRecordTextRepository studentCoursesTextRepository = new StudentRecordTextRepository();
		studentsRecords = studentCoursesTextRepository.readToList();
		StudentRecords newStudentRecord = new StudentRecords(key,firstName,lastName,matricNum,courseIndex,indexNum,AU, CourseType, SU, GERType,"-");
		studentsRecords.add(newStudentRecord);
		studentCoursesTextRepository.saveList(studentsRecords);

		}
  }

