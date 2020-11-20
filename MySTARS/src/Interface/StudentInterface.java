package Interface;
import Student.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import CourseRecords.GetCourseRecord;
import CourseRecords.GetStudentListByIndexNumber;
import Repository.CourseRecordsTextRepository;
import Repository.GlobalAccessPeriodTextRepository;
import Repository.LoginTextRepository;
import Repository.StudentCoursesTextRepository;
import Repository.StudentPersonalInfoTextRepository;

/**
 * StudentInterface is a boundary class which interacts with the student to perform any operation on MySTARS
 * in the student mode.<p>
 * There are 6 options in student mode: <p>
 * 1. Add a Course <p>
 * 2. Drop a Course <p>
 * 3. Check a Course <p>
 * 4. Check Vancancies <p>
 * 5. Change Index Number of Course <p>
 * 6. Swap Index Number with Another Student <p>
 * 
 * @author ?
 *
 */
public class StudentInterface {
	String key = null;
	private static ArrayList courseRecordList;
	private static ArrayList studentInfo;
	private static ArrayList loginInfo;
	private static ArrayList studentsRecords;
	private static ArrayList accessPeriodList;
	static Scanner sc = new Scanner(System.in);

	
	public static void inStudentInterface() throws IOException
	{
		CourseRecordsTextRepository courseRecordsTextRepository = new CourseRecordsTextRepository();
		StudentPersonalInfoTextRepository studentPersonalInfoTextRepository = new StudentPersonalInfoTextRepository();
		LoginTextRepository loginTextRepository = new LoginTextRepository();
		StudentCoursesTextRepository studentCoursesTextRepository = new StudentCoursesTextRepository();
		GlobalAccessPeriodTextRepository globalAccessPeriodTextRepository = new GlobalAccessPeriodTextRepository();

		int choice = 0;
		while (choice != 7) {
			courseRecordList = courseRecordsTextRepository.readToList();
			studentInfo = studentPersonalInfoTextRepository.readToList();
			loginInfo = loginTextRepository.readToList();
			studentsRecords = studentCoursesTextRepository.readToList();
			accessPeriodList = globalAccessPeriodTextRepository.readToList();
		
			Scanner sc = new Scanner(System.in);
			System.out.println("****STUDENT INTERFACE****");
			System.out.println("1. Add Course");
			System.out.println("2. Drop Course");
			System.out.println("3. Check Course");
			System.out.println("4. Check Vancancies");
			System.out.println("5. Change Index Number of Course");
			System.out.println("6. Swap Index Number with Another Student");
			System.out.println("7. Logout");
			System.out.println("Please choose a number: ");
			choice = sc.nextInt();
			
			switch(choice)
			{
				case 1:
					String courseIndex, temp;
					//query Course record and insert into arraylist
					//the courseIndex you want to add
					courseIndex = "0000";
					AddCourse.addCourse1(courseIndex, courseRecordList);
					
					
					AddCourse addCourse = new AddCourse();
					courseIndex = addCourse.queryCourseIndex();
					temp = addCourse.findRelevantRecord(courseIndex);
					addCourse.addCourse(temp);
					break;
				case 2:
					DropCourse dropCourse = new DropCourse();
					courseIndex = dropCourse.queryCourseIndex();
					String Str = dropCourse.findString(courseIndex);
					dropCourse.dropCourse(Str);
					break;
				case 3:
					printCourseDetails();
					break;
				case 4:
					getCourseVacancy();
					break;
				case 5:
					ChangeIndex changeIndex = new ChangeIndex();
					break;
				case 6:
					SwapIndex swapIndex = new SwapIndex();
					break;
				case 7:
					System.out.println("Goodbye!\n");
					break;
				default:
					System.out.println("Try another choice");
					return;	
			}	
		}
	}


	private static void printCourseDetails() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Please reenter your username to check the course u register:");
		String username = sc.next();
		CheckCourse.getKey(username, studentsRecords,loginInfo);
		
	}


	private static void getCourseVacancy() throws IOException
	{
		GetCourseRecord.showIndexNum(courseRecordList);
		System.out.println("Enter Index Number to check avaliable Vacancy:");
		String indexNum = sc.next();
		GetCourseRecord.getVacancy(indexNum, courseRecordList);
	}

}
