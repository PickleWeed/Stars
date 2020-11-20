package Interface;
import CourseRecords.UpdateCourseRecord;
import Repository.CourseRecordsTextRepository;
import Repository.DatRepository;
import Repository.GlobalAccessPeriodTextRepository;
import Repository.LoginTextRepository;
import Repository.StudentCoursesTextRepository;
import Repository.StudentPersonalInfoTextRepository;
import CourseRecords.GetCourseRecord;
import CourseRecords.GetStudentListByCourseIndex;
import CourseRecords.GetStudentListByIndexNumber;
import StudentInfo.CheckStudentInfo;
import StudentInfo.UpdateStudentInfo;
import StudentInfo.ViewStudentInfo;
import StudentRecords.StudentRecords;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import AccessPeriod.GetAccessPeriod;

/**
 * AdminApp is a boundary class which interacts with the admin to perform any operation on MySTARS
 * in the admin mode.<p>
 * There are 9 options in admin mode: <p>
 * 1. Edit student Access Period <p>
 * 2. Add a student <p>
 * 3. Add a Course <p>
 * 4. Update a course <p>
 * 5. Print Student List by Course Number <p>
 * 6. Print Student List by Index Number <p>
 * 7. Edit Student's Courses <p>
 * 8. Check Avaliable Vacancy for an index number <p>
 * 9. Exit <p>
 * 
 * @author ?
 *
 */
public class AdminApp {
	private String choice = "0";
	

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
		CourseRecordsTextRepository courseRecordsTextRepository = new CourseRecordsTextRepository();
		StudentPersonalInfoTextRepository studentPersonalInfoTextRepository = new StudentPersonalInfoTextRepository();
		LoginTextRepository loginTextRepository = new LoginTextRepository();
		StudentCoursesTextRepository studentCoursesTextRepository = new StudentCoursesTextRepository();
		GlobalAccessPeriodTextRepository globalAccessPeriodTextRepository = new GlobalAccessPeriodTextRepository();

		while(!choice.equals("8"))
		{
			//get Data from txtfile
			courseRecordList = courseRecordsTextRepository.readToList();
			studentInfo = studentPersonalInfoTextRepository.readToList();
			loginInfo = loginTextRepository.readToList();
			studentsRecords = studentCoursesTextRepository.readToList();
			accessPeriodList = globalAccessPeriodTextRepository.readToList();
			
			//write onto Serial File
			DatRepository.writeSerializedObject("CourseRecords.dat", courseRecordList);
			DatRepository.writeSerializedObject("studentInfo.dat", studentInfo);
			DatRepository.writeSerializedObject("LoginsInfo.dat", loginInfo);
			DatRepository.writeSerializedObject("StudentRecords.dat", studentsRecords);
			DatRepository.writeSerializedObject("GlobalAccessPeriod.dat", accessPeriodList);
			
			//read again from Serial File
 			courseRecordList = (ArrayList)DatRepository.readSerializedObject("CourseRecords.dat");
			studentInfo = (ArrayList)DatRepository.readSerializedObject("studentInfo.dat");
			loginInfo = (ArrayList)DatRepository.readSerializedObject("LoginsInfo.dat");
			studentsRecords = (ArrayList)DatRepository.readSerializedObject("StudentRecords.dat");
			accessPeriodList = (ArrayList)DatRepository.readSerializedObject("GlobalAccessPeriod.dat");
						
			System.out.println("****ADMIN INTERFACE****");
			System.out.println("1. Edit Student Access Period");
			System.out.println("2. Add Student");
			System.out.println("3. Add Course");
			System.out.println("4. Update Course");
			System.out.println("5. Print Student List by Index Number");
			System.out.println("6. Print Student List by Course Index");
			System.out.println("7. Check Avaliable Vacancy By Index Number");
			System.out.println("8. Logout");
			System.out.printf("Please choose a number: ");

			choice = sc.next();
			
			switch(choice)
			{
				case "1":
					editStudentAccess();
					break;
				case "2":
					addStudent();
					break;
				case "3":
					addCourse();
					break;
				case "4":
					updateCourse();
					break;
				case "5":
					//Print Student List by Course Number
					printStudentListByCourseIndex();
					break;
				case "6":
					//Print Student List by Index Number
					printStudentListByIndexNumber();
					break;
				case "7":
					getCourseVacancy();
					break;
				case "8":
					System.out.println("Goodbye!\n");
					break;
				default:
					System.out.println("Please Enter a Valid Number!\n");
					break;
			}
		}
	}
	private void printStudentListByIndexNumber() throws IOException {
		// TODO Auto-generated method stub
		GetStudentListByIndexNumber.showIndexNum(studentsRecords,studentInfo);
		System.out.println("Enter Index Number to check avaliable Key:");
		String indexNum = sc.next();
		GetStudentListByIndexNumber.getKey(indexNum, studentsRecords,studentInfo);
		
	}
	private void printStudentListByCourseIndex() throws IOException{
		// TODO Auto-generated method stub
		GetStudentListByCourseIndex.showcourseIndex(studentsRecords,studentInfo);
		System.out.println("Enter Index Number to check avaliable Vacancy:");
		String courseIndex = sc.next();
		GetStudentListByCourseIndex.getKey(courseIndex, studentsRecords,studentInfo);
	}
	private void editStudentAccess() throws IOException
	{	
		System.out.println("Edit a Student Access Period");
		System.out.printf("Enter Student's Matric Number: ");
		String matricNum = sc.next();
		String key = ViewStudentInfo.getStudentKey(studentInfo, matricNum);
		String startAccessPeriod, endAccessPeriod, accessPeriod;
		
		if(key != "nill")
		{
			ViewStudentInfo.viewStudentInfo(studentInfo, key);
			System.out.printf("Enter Starting Access Period to change to (DD/MM/YYYY):");
			//enter date, day, year
			startAccessPeriod = sc.next();
			System.out.printf("Enter Ending Access Period to change to (DD/MM/YYYY):");
			endAccessPeriod = sc.next();
			accessPeriod = startAccessPeriod + " - " + endAccessPeriod;
			UpdateStudentInfo.updateStudentAC(studentInfo, accessPeriod, key);
		}
		else
			System.out.println("No matching Matric Number!");
	}
	private void addStudent() throws IOException
	{
		System.out.printf("Enter student First Name: ");
		String firstName = sc.next();
		System.out.printf("Enter student Last Name: ");
		String lastName = sc.next();
		//check duplicate 
		String matricNum;
		while(true) {
			System.out.printf("Enter student Matric Number: ");
			matricNum = sc.next();
			if(CheckStudentInfo.checkMatricNum(matricNum, studentInfo) == false) 
					break;
		}	
		System.out.printf("Enter student Gender: ");
		String gender =  sc.next();
		System.out.printf("Enter student Nationality: ");
		String nationality = sc.next();
		System.out.printf("Enter student Age: ");
		String age = sc.next();
		System.out.printf("Student Login Info: ");
		//check duplicate
		String email;
		while(true) {
			System.out.printf("Enter Student email:");
			email = sc.next();
			if(CheckStudentInfo.checkEmail(email, studentInfo) == false)
				break;
		}
		String username;
		//check duplicate
		while(true) {
			System.out.printf("Enter Student login Username: ");
			username = sc.next();
			if(CheckStudentInfo.checkUsername(username, loginInfo) == false) 
					break;
		}	
		System.out.printf("Enter student password: ");
		String password = sc.next();
		GetAccessPeriod.viewAccessPeriod(accessPeriodList);
		String accessPeriod;
		//check dupicate
		while(true) {
			System.out.println("Choose a value which Access Period you want to add: ");
			accessPeriod = sc.next();
			accessPeriod = GetAccessPeriod.getAccessPeriod(accessPeriodList, accessPeriod);
			if(!accessPeriod.equals("nill"))
				break;	
		}
		//create student login info and Student Info
		UpdateStudentInfo.addStudent(studentInfo, loginInfo, firstName, lastName, matricNum, gender, nationality, age, username, password, accessPeriod, email);
	}
	private void addCourse() throws IOException
	{
		System.out.printf("Enter the course Index you want to add: ");
		String courseIndex = sc.next();
		System.out.printf("Enter Index Number: ");
		String indexNum = sc.next();
		System.out.printf("Enter Type: ");
		String type = sc.next();
		System.out.printf("Enter Group Index");
		String group = sc.next();
		System.out.printf("Enter Day: ");
		String day = sc.next();
		System.out.printf("Enter time: ");
		String time = sc.next();
		System.out.printf("Enter Venue: ");
		String venue = sc.next();
		System.out.printf("Enter Any remarks you want to add(enter nill if nothing): ");
		String remarks = sc.next();
		System.out.println("Enter Vacancy number: ");
		String vacancy = sc.next();
		System.out.printf("Name of the Course: ");
		String courseName = sc.next();
		//add course
		UpdateCourseRecord.addCourse(courseRecordList, courseIndex, indexNum, type, group, day, time, venue, remarks, vacancy, courseName);
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
		GetCourseRecord.showIndexNum(courseRecordList);
		System.out.println("Enter Index Number to check avaliable Vacancy:");
		String indexNum = sc.next();
		GetCourseRecord.getVacancy(indexNum, courseRecordList);
	}
	//Testing purpose
	public static void main(String[] args) throws Exception {
		AdminApp adminApp = new AdminApp();
		adminApp.adminInterface();
		
	}

}
