package Interface;
import Admin.*;
import TextRepository.CourseRecordsTextRepository;
import TextRepository.LoginTextRepository;
import TextRepository.StudentPersonalInfoTextRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminApp{
	
	/*private Student[] sortedCourseNum()
	{
		Student[] sortedbyCourseNum = myStudent.clone();
		//insertion sort
		return null;
	}*/

	public void adminInterface() throws IOException
	{	
		String matricNum, username;
		int choice =0;
		
		//get all the info from txtfile
		ArrayList courseRecordList = CourseRecordsTextRepository.readCourseRecords();
		ArrayList studentInfo = StudentPersonalInfoTextRepository.readStudentInfo();
		ArrayList LoginInfo = LoginTextRepository.readLogin();
		
		while(choice != 8)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("1. Edit student Access Period");
			System.out.println("2. Add student");
			System.out.println("3. Add a Course");
			System.out.println("4. Update a course");
			System.out.println("5. Print Student List by Course Number");
			System.out.println("6. Print Student List by Course Number");
			System.out.println("7. Edit Student's Courses");
			System.out.println("8. Check Avaliable Vacancy for an index number");
			System.out.println("9. To Exit");
			System.out.println("Please choose a number: ");
			choice = sc.nextInt();
			
			switch(choice)
			{
				case 1:
					System.out.println("Enter Student's Matric Number you want to edit");
					matricNum = sc.next();
					break;
				case 2:
					System.out.printf("Enter student First Name: ");
					String firstName = sc.next();
					System.out.printf("Enter student Last Name: ");
					String lastName = sc.next();
					//check duplicate 
					while(true) {
						System.out.printf("Enter student Matric Number: ");
						matricNum = sc.next();
						if(UpdateStudent.checkMatricNum(matricNum, studentInfo) == false) 
								break;
					}	
					System.out.printf("Enter student Gender: ");
					String gender = sc.next();
					System.out.printf("Enter student Nationality: ");
					String nationality = sc.next();
					System.out.printf("Enter student Age: ");
					String age = sc.next();
					System.out.printf("Student Login Info: ");
					//check duplicate
					while(true) {
						System.out.printf("Enter student login username: ");
						username = sc.next();
						if(UpdateStudent.checkUsername(username, LoginInfo) == false) 
								break;
					}	
					System.out.println("Enter student password: ");
					String password = sc.next();
					UpdateStudent.addStudent(studentInfo, LoginInfo, firstName, lastName, matricNum, gender, nationality, age, username, password);
					break;
				case 3:
					//Add a Course
					break;
				case 4:
					//Update a course
					break;
				case 5:
					//Print Student List by Course Number
					break;
				case 6:
					//Print Student List by Course Number
					break;
				case 7:
					System.out.println("Enter Student's Matric Number you want to edit");
					matricNum = sc.next();
					break;
				case 8:
					ViewCourseRecord.showIndexNum(courseRecordList);
					System.out.println("Enter Index Number to check avaliable Vacancy:");
					String indexNum = sc.next();
					ViewCourseRecord.getVacancy(indexNum, courseRecordList);

			}
		}
		
		
	}

}
