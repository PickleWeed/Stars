package Interface;

import Student.*;
import StudentRecords.StudentRecords;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import CourseRecords.*;
import Repository.CourseRecordsTextRepository;
import Repository.DatDatabase;
import Repository.GlobalAccessPeriodTextRepository;
import Repository.LoginTextRepository;
import Repository.StudentRecordTextRepository;
import Repository.StudentPersonalTextRepository;

/**
 * StudentInterface is a boundary class which interacts with the student to perform any operation on MySTARS
 * in the student mode.<p>
 * There are 6 options in student mode: <p>
 * 1. Add Course <p>
 * 2. Drop Course <p>
 * 3. Check/Print Courses Registered <p>
 * 4. Check Vancancies <p>
 * 5. Change Index Number of Course <p>
 * 6. Swap Index Number with Another Student <p>
 * 
 * @author ?
 *
 */
public class StudentInterface {
	private String choice = "0";
	
	private static ArrayList courseRecordList;
	private static ArrayList studentInfo;
	private static ArrayList loginInfo;
	private static ArrayList studentsRecords;
	private static ArrayList accessPeriodList;
	
	static Scanner sc = new Scanner(System.in);

	
	public void inStudentInterface(String key) throws IOException
	{
		CourseRecordsTextRepository courseRecordsTextRepository = new CourseRecordsTextRepository();
		StudentPersonalTextRepository studentPersonalInfoTextRepository = new StudentPersonalTextRepository();
		LoginTextRepository loginTextRepository = new LoginTextRepository();
		StudentRecordTextRepository studentCoursesTextRepository = new StudentRecordTextRepository();
		GlobalAccessPeriodTextRepository globalAccessPeriodTextRepository = new GlobalAccessPeriodTextRepository();

		while (!choice.equals("7")) {
			courseRecordList = courseRecordsTextRepository.readToList(); 
			studentInfo = studentPersonalInfoTextRepository.readToList();
			loginInfo = loginTextRepository.readToList();
			studentsRecords = studentCoursesTextRepository.readToList();
			accessPeriodList = globalAccessPeriodTextRepository.readToList();
			
			DatDatabase.write("CourseRecords.dat", courseRecordList);
			DatDatabase.write("StudentInfo.dat", studentInfo);
			DatDatabase.write("LoginsInfo.dat", loginInfo);
			DatDatabase.write("StudentRecords.dat", studentsRecords);
			DatDatabase.write("GlobalAccessPeriod.dat", accessPeriodList);
			
			//read again from Serial File
			courseRecordList = (ArrayList)DatDatabase.read("CourseRecords.dat");
			studentInfo = (ArrayList)DatDatabase.read("StudentInfo.dat");
			loginInfo = (ArrayList)DatDatabase.read("LoginsInfo.dat");
			studentsRecords = (ArrayList)DatDatabase.read("StudentRecords.dat");
			accessPeriodList = (ArrayList)DatDatabase.read("GlobalAccessPeriod.dat");
			
			System.out.println("****STUDENT INTERFACE****");
			System.out.println("1. Add Course");
			System.out.println("2. Drop Course");
			System.out.println("3. Check/Print Courses Registered");
			System.out.println("4. Check Vancancies Available");
			System.out.println("5. Change Index Number of Course");
			System.out.println("6. Swap Index Number with Another Student");
			System.out.println("7. Logout");
			System.out.println("Please choose a number: ");
			
			choice = sc.next();

			switch(choice)
			{
				case "1":
					addCourse(key);
					break;
				case "2":
					dropCourse(key);
					break;
				case "3":
					printCourseDetails(key);
					break;
				case "4":
					getCourseVacancy();
					break;
				case "5":
					changeIndex(key);
					break;
				case "6":
					SwapIndex(key);
					break;
				case "7":
					System.out.println("Goodbye!\n");
					break;
				default:
					System.out.println("Try another choice");
					return;	
			}	
		}
	}
	
	//case 1
	private static void addCourse(String key) throws IOException{
		String courseIndex;
		System.out.println("Enter Course Index:");
		courseIndex = sc.next();
		String firstName = "", lastName = "", matricNum = "",indexNum = "";
		for (int i = 0 ; i < studentsRecords.size() ; i++) {
			StudentRecords studentRecord = (StudentRecords)studentsRecords.get(i);
			if(studentRecord.getKey().equals(key)) {
				firstName = studentRecord.getFirstName();
				lastName = studentRecord.getLastName();
				matricNum = studentRecord.getMatricNum();
				break;
				}	
			}
		AddCourse.addCourse(studentsRecords, key, firstName, lastName, matricNum, courseIndex, indexNum);
	}
	
	//case 2
	private static void dropCourse(String key) throws IOException {
		System.out.println("Enter Index Number:");
		String indexNum = sc.next();
		DropCourse.dropCourse(studentsRecords, key, indexNum);
	}
	
	//case 3
	private static void printCourseDetails(String key) throws IOException {
		CheckCourse.getCourseDetails(studentsRecords, key);	
	}

	//case 4
	private static void getCourseVacancy() throws IOException
	{
		// still need add check if valid index based on user registered course
		System.out.println("Enter Index Number:");
		String indexNum = sc.next();
		GetCourseRecord.printVacancy(indexNum, courseRecordList);
	}
	
	//case 5
	private static void changeIndex(String key) throws IOException
	{
		// still need add check if valid index 
		System.out.println("Enter Old Index Number:");
		String oldIndex = sc.next();
		System.out.println("Enter New Index Number:");
		String newIndex = sc.next();
		ChangeIndex.changeIndex(studentsRecords,courseRecordList, oldIndex, newIndex, key);
	}
	
	//case 6
	private void SwapIndex(String key)  throws IOException
	{
		// still need add check if valid index 
		System.out.println("Enter Your Index Number:");
		String oldIndex = sc.next();
		System.out.println("Enter Your friend's Index Number:");
		String newIndex = sc.next();
		System.out.println("Enter Friend Matric Number:");
		String MatricNum = sc.next();
		SwapIndex.swapIndex(studentsRecords,courseRecordList,MatricNum, oldIndex, newIndex, key);
		
	}
}
