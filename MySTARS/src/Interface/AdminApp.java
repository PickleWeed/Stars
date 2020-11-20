package Interface;
import CourseRecords.CourseHandler;
import CourseRecords.ViewCourseRecord;
import Student.StudentHandler;
import Student.ViewStudentInfo;
import TextRepository.CourseRecordsTextRepository;
import TextRepository.GlobalAccessPeriodTextRepository;
import TextRepository.LoginTextRepository;
import TextRepository.StudentCoursesTextRepository;
import TextRepository.StudentPersonalInfoTextRepository;
import DatRepository.DatabaseRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import AccessPeriod.ViewAccessPeriod;

/**
 * AdminApp is a boundary class which interacts with the admin to perform any operation on MySTARS
 * in the admin mode.<p>
 * There are 9 options in admin mode: <p>
 * 1. Edit student Access Period <p>
 * 2. Add a student <p>
 * 3. Add a Course <p>
 * 4. Update a course <p>
 * 5. Print Student List by Course Number <p>
 * 6. Print Student List by Course Number ? <p>
 * 7. Edit Student's Courses <p>
 * 8. Check Avaliable Vacancy for an index number <p>
 * 9. Exit <p>
 * 
 * @author ?
 *
 */
public class AdminApp{
	private String matricNum;
	private String username;
	private String password;
	private String firstName, lastName;
	private String gender, nationality, age, email;
	private String courseIndex, indexNum;
	private String type, group, day, time, venue, remarks, vacancy, courseName;
	private String key;
	private String accessPeriod;
	
<<<<<<< HEAD
	private String choice = "0";
	
=======
>>>>>>> c97d5a680182be1903053d89a2380ba5d9ed1e3d
	private static ArrayList courseRecordList;
	private static ArrayList studentInfo;
	private static ArrayList loginInfo;
	private static ArrayList studentsRecords;
	private static ArrayList accessPeriodList;

	Scanner sc = new Scanner(System.in);
	/**
	 * Displays a menu for the admin, and performs the appropriate operation based on the admin's choice.<p>
	 * There are 9 possible choices in the menu: <p>
	 * 1. Edit student Access Period <p>
	 * 2. Add a student <p>
	 * 3. Add a Course <p>
	 * 4. Update a course <p>
	 * 5. Print Student List by Course Number <p>
	 * 6. Print Student List by Course Number ? <p>
	 * 7. Edit Student's Courses <p>
	 * 8. Check Avaliable Vacancy for an index number <p>
	 * 9. Exit <p><p>
	 * Relevent informations from the txtfile are also acquired in order to carry out certain operations.<p>
	 * 
	 * @throws IOException If an input or output exception occurs
	 */
	public void adminInterface() throws Exception
	{	
		int choice = 0;	

		while(choice != 8)
		{
			//get Data from txtfile
			courseRecordList = CourseRecordsTextRepository.readCourseRecords();
			studentInfo = StudentPersonalInfoTextRepository.readStudentInfo();
			loginInfo = LoginTextRepository.readLogin();
			studentsRecords = StudentCoursesTextRepository.readStudentRecords();
			accessPeriodList = GlobalAccessPeriodTextRepository.readAccessPeriod();
			
			//write onto Serial File
			DatabaseRepository.writeSerializedObject("CourseRecords.dat", courseRecordList);
			DatabaseRepository.writeSerializedObject("studentInfo.dat", studentInfo);
			DatabaseRepository.writeSerializedObject("LoginsInfo.dat", loginInfo);
			DatabaseRepository.writeSerializedObject("StudentRecords.dat", studentsRecords);
			DatabaseRepository.writeSerializedObject("GlobalAccessPeriod.dat", accessPeriodList);
			
			//read again from Serial File
 			courseRecordList = (ArrayList)DatabaseRepository.readSerializedObject("CourseRecords.dat");
			studentInfo = (ArrayList)DatabaseRepository.readSerializedObject("studentInfo.dat");
			loginInfo = (ArrayList)DatabaseRepository.readSerializedObject("LoginsInfo.dat");
			studentsRecords = (ArrayList)DatabaseRepository.readSerializedObject("StudentRecords.dat");
			accessPeriodList = (ArrayList)DatabaseRepository.readSerializedObject("GlobalAccessPeriod.dat");
						
			System.out.println("****ADMIN INTERFACE****");
			System.out.println("1. Edit Student Access Period");
			System.out.println("2. Add Student");
			System.out.println("3. Add Course");
			System.out.println("4. Update Course");
			System.out.println("5. Print Student List by Course Number");
			System.out.println("6. Print Student List by Course Number");
			System.out.println("7. Check Avaliable Vacancy By Index Number");
			System.out.println("8. Logout");
			System.out.printf("Please choose a number: ");

			choice = sc.nextInt();
			
			switch(choice)
			{
				case 1:
					editStudentAccess();
					break;
				case 2:
					addStudent();
					break;
				case 3:
					addCourse();
					break;
				case 4:
					updateCourse();
					break;
				case 5:
					//Print Student List by Course Number
					break;
				case 6:
					//Print Student List by Course Number
					break;
				case 7:
					getCourseVacancy();
					break;
				case 8:
					System.out.println("Goodbye!\n");
					break;
				default:
					System.out.println("Please Enter a Valid Number!\n");
					break;
			}
		}
	}
	private void editStudentAccess() throws IOException
	{	
		System.out.println("Edit a Student Access Period");
		System.out.printf("Enter Student's Matric Number: ");
		matricNum = sc.next();
		key = StudentHandler.getStudentKey(studentInfo, matricNum);
		if(key != "nill")
		{
			ViewStudentInfo.viewStudentInfo(studentInfo, key);
			System.out.printf("Enter Access Period to change to (DD/MM/YYYY):");
			//enter date, day, year
			accessPeriod = sc.next();
			StudentHandler.editStudentAC(studentInfo, accessPeriod, key);
		}
		else
			System.out.println("No matching Matric Number!");
	}
	private void addStudent() throws IOException
	{
		System.out.printf("Enter student First Name: ");
		firstName = sc.next();
		System.out.printf("Enter student Last Name: ");
		lastName = sc.next();
		//check duplicate 
		while(true) {
			System.out.printf("Enter student Matric Number: ");
			matricNum = sc.next();
			if(StudentHandler.checkMatricNum(matricNum, studentInfo) == false) 
					break;
		}	
		System.out.printf("Enter student Gender: ");
		gender =  sc.next();
		System.out.printf("Enter student Nationality: ");
		nationality = sc.next();
		System.out.printf("Enter student Age: ");
		age = sc.next();
		System.out.printf("Student Login Info: ");
		//check duplicate
		while(true) {
			System.out.printf("Enter Student email:");
			email = sc.next();
			if(StudentHandler.checkEmail(email, studentInfo) == false)
				break;
		}
		//check duplicate
		while(true) {
			System.out.printf("Enter Student login Username: ");
			username = sc.next();
			if(StudentHandler.checkUsername(username, loginInfo) == false) 
					break;
		}	
		System.out.printf("Enter student password: ");
		password = sc.next();
		ViewAccessPeriod.viewAccessPeriod(accessPeriodList);
		while(true) {
			System.out.println("Choose a value which Access Period you want to add: ");
			accessPeriod = sc.next();
			accessPeriod = ViewAccessPeriod.getAccessPeriod(accessPeriodList, accessPeriod);
			if(!accessPeriod.equals("nill"))
				break;	
		}
		//create student login info and Student Info
		StudentHandler.addStudent(studentInfo, loginInfo, firstName, lastName, matricNum, gender, nationality, age, username, password, accessPeriod, email);
	}
	private void addCourse() throws IOException
	{
		System.out.printf("Enter the course Index you want to add: ");
		courseIndex = sc.next();
		System.out.printf("Enter Index Number: ");
		indexNum = sc.next();
		System.out.printf("Enter Type: ");
		type = sc.next();
		System.out.printf("Enter Group Index");
		group = sc.next();
		System.out.printf("Enter Day: ");
		day = sc.next();
		System.out.printf("Enter time: ");
		time = sc.next();
		System.out.printf("Enter Venue: ");
		venue = sc.next();
		System.out.printf("Enter Any remarks you want to add(enter nill if nothing): ");
		remarks = sc.next();
		System.out.println("Enter Vacancy number: ");
		vacancy = sc.next();
		System.out.printf("Name of the Course: ");
		courseName = sc.next();
		//add course
		CourseHandler.addCourse(courseRecordList, courseIndex, indexNum, type, group, day, time, venue, remarks, vacancy, courseName);
	}
	private void updateCourse() throws Exception
	{
		//remember update a course also must update student course
		System.out.println("Enter Course code you want to update");
		//check course code
		//if true
		//enter all the details of the new updated course
		//update course 
		//update student's corresponding course as well
	}
	private void getCourseVacancy() throws IOException
	{
		ViewCourseRecord.showIndexNum(courseRecordList);
		System.out.println("Enter Index Number to check avaliable Vacancy:");
		indexNum = sc.next();
		ViewCourseRecord.getVacancy(indexNum, courseRecordList);
	}
	//Testing purpose
	public static void main(String[] args) throws Exception {
		AdminApp adminApp = new AdminApp();
		adminApp.adminInterface();
	}

}
