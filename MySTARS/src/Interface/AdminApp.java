package Interface;
import Admin.*;
import BatRepository.DatabaseRepository;
import Login.LoginInfo;
import TextRepository.CourseRecordsTextRepository;
import TextRepository.LoginTextRepository;
import TextRepository.StudentCoursesTextRepository;
import TextRepository.StudentPersonalInfoTextRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminApp{
	private String matricNum, username, password;
	private String firstName, lastName;
	private String gender, nationality, age;
	private String courseIndex, indexNum;
	private String type, group, day, time, venue, remarks, vacancy, courseName;
	private String key;
	private String accessPeriod;
	
	int choice =0;
	
	private ArrayList courseRecordList;
	private ArrayList studentInfo;
	private ArrayList LoginInfo;
	private ArrayList StudentsRecords;
	

	public void adminInterface() throws IOException
	{	
		while(choice != 8)
		{
			//get all the info from txtfile
			courseRecordList = CourseRecordsTextRepository.readCourseRecords();
			studentInfo = StudentPersonalInfoTextRepository.readStudentInfo();
			LoginInfo = LoginTextRepository.readLogin();
			StudentsRecords = StudentCoursesTextRepository.readStudentRecords();
			
			//write onto the Serial
			DatabaseRepository.writeSerializedObject("CourseRecords.dat", courseRecordList);
			DatabaseRepository.writeSerializedObject("studentInfo.dat", studentInfo);
			DatabaseRepository.writeSerializedObject("LoginsInfo.dat", LoginInfo);
			DatabaseRepository.writeSerializedObject("StudentRecords.dat", StudentsRecords);
			
			//read again from dat file
 			courseRecordList = (ArrayList)DatabaseRepository.readSerializedObject("CourseRecords.dat");
			studentInfo = (ArrayList)DatabaseRepository.readSerializedObject("studentInfo.dat");
			LoginInfo = (ArrayList)DatabaseRepository.readSerializedObject("LoginsInfo.dat");
			StudentsRecords = (ArrayList)DatabaseRepository.readSerializedObject("StudentRecords.dat");
						
			Scanner sc = new Scanner(System.in);
			System.out.println("1. Edit a Student Access Period");
			System.out.println("2. Add a Student");
			System.out.println("3. Add a Course");
			System.out.println("4. Update a course");
			System.out.println("5. Print Student List by Course Number");
			System.out.println("6. Print Student List by Course Number");
			System.out.println("8. Check Avaliable Vacancy for an index number");
			System.out.println("9. To Exit");
			System.out.printf("Please choose a number: ");
			choice = sc.nextInt();
			
			switch(choice)
			{
				case 1:
					System.out.println("Edit a Student Access Period");
					System.out.printf("Enter Student's Matric Number: ");
					matricNum = sc.next();
					key = StudentHandler.getStudentKey(studentInfo, matricNum);
					if(key != "nill")
					{
						ViewStudentInfo.getStudentInfo(studentInfo, key);
						System.out.printf("Enter Access Period to change to:");
						accessPeriod = sc.next();
						StudentHandler.editStudentAC(studentInfo, accessPeriod, key);
					}
					else
						System.out.println("No matching Matric Number!");
					break;
				case 2:
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
					gender = sc.next();
					System.out.printf("Enter student Nationality: ");
					nationality = sc.next();
					System.out.printf("Enter student Age: ");
					age = sc.next();
					System.out.printf("Student Login Info: ");
					//check duplicate
					while(true) {
						System.out.printf("Enter Student login Username: ");
						username = sc.next();
						if(StudentHandler.checkUsername(username, LoginInfo) == false) 
								break;
					}	
					System.out.println("Enter student password: ");
					password = sc.next();
					//create student login info and Student Info
					StudentHandler.addStudent(studentInfo, LoginInfo, firstName, lastName, matricNum, gender, nationality, age, username, password);
					break;
				case 3:
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
					break;
				case 4:
					//remember update a course also must update student course
					System.out.println("Enter Course code you want to update");
					//check course code
					//if true
					//enter all the details of the new updated course
					//update course 
					//update student's corresponding course as well
					break;
				case 5:
					//Print Student List by Course Number
					break;
				case 6:
					//Print Student List by Course Number
					break;
				case 7:
					ViewCourseRecord.showIndexNum(courseRecordList);
					System.out.println("Enter Index Number to check avaliable Vacancy:");
					indexNum = sc.next();
					ViewCourseRecord.getVacancy(indexNum, courseRecordList);

			}
		}
		
		/*
		 * case 7:	
					//edit a student's course
					System.out.printf("Enter Student's Matric Number: ");
					matricNum = sc.next();
					key = StudentHandler.getStudentKey(studentInfo, matricNum);
					if(key != "nill")
					{
						//view that student courses
						ViewStudentRecord.getStudentRecord(StudentRecord, key);
						System.out.println("Enter Student's Course Number you wish to edit: ");
						courseIndex = sc.next();
					}
					else
						System.out.println("No matching Matric Number!");
					break;
		 */
		
		
	}
	public static void main(String[] args) throws IOException {
		AdminApp adminApp = new AdminApp();
		adminApp.adminInterface();
	}

}
