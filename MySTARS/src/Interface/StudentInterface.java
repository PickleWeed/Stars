package Interface;
import Student.*;
import StudentInfo.Student;
import StudentInfo.ViewStudentInfo;
import StudentRecords.GetStudentListByIndexNumber;
import StudentRecords.StudentRecords;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import CourseRecords.*;
import Repository.CourseRecordsTextRepository;
import Repository.DatDatabase;
import Repository.GlobalAccessPeriodTextRepository;
import Repository.LoginTextRepository;
import Repository.StudentRecordTextRepository;
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
	private static ArrayList courseRecordList;
	private static ArrayList studentInfo;
	private static ArrayList loginInfo;
	private static ArrayList studentsRecords;
	private static ArrayList accessPeriodList;
	static Scanner sc = new Scanner(System.in);

	
	public void inStudentInterface() throws IOException
	{
		CourseRecordsTextRepository courseRecordsTextRepository = new CourseRecordsTextRepository();
		StudentPersonalInfoTextRepository studentPersonalInfoTextRepository = new StudentPersonalInfoTextRepository();
		LoginTextRepository loginTextRepository = new LoginTextRepository();
		StudentRecordTextRepository studentCoursesTextRepository = new StudentRecordTextRepository();
		GlobalAccessPeriodTextRepository globalAccessPeriodTextRepository = new GlobalAccessPeriodTextRepository();

		int choice = 0;
		while (choice != 7) {
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
					addCourse();
//					String courseIndex, temp;
//					//query Course record and insert into arraylist
//					//the courseIndex you want to add
//					courseIndex = "0000";
//					AddCourse.addCourse1(courseIndex, courseRecordList);
//					AddCourse addCourse = new AddCourse();
//					courseIndex = addCourse.queryCourseIndex();
//					temp = addCourse.findRelevantRecord(courseIndex);
//					addCourse.addCourse(temp);
					break;
				case 2:
					DropCourse dropCourse = new DropCourse();
					//courseIndex = dropCourse.queryCourseIndex();
					//String Str = dropCourse.findString(courseIndex);
					//dropCourse.dropCourse(Str);
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
	//case 1
	private static void addCourse() {
		String courseIndex = "0000", indexNumber; 
		Scanner sc = new Scanner(System.in); 
		for (int i=0; i<courseRecordList.size(); i++) { 
			CourseRecord courseRecords = (CourseRecord)courseRecordList.get(i);	  
			System.out.println(courseRecords.getCourseIndex()); 		  
		}
		System.out.println("Please enter Course Index: ");
		courseIndex = sc.nextLine();
		System.out.println("Please enter Index number for " + courseIndex + ":");
		indexNumber = sc.nextLine();
		for (int i=0; i<courseRecordList.size(); i++) { 
			CourseRecord courseRecords = (CourseRecord)courseRecordList.get(i);	
			if(((courseRecords.getCourseIndex()).equals(courseIndex)) && ((courseRecords.getIndexNum()).equals(indexNumber))) {
				Student student = (Student)studentInfo.get(i);
				String firstName = student.getFirstName();
				String lastName = student.getLastName();

				for(int j=0;j<studentsRecords.size();j++) {
					StudentRecords studentRecords = (StudentRecords)studentsRecords.get(j);
					if(studentRecords.getFirstName().equals(firstName) && studentRecords.getLastName().equals(lastName)) {
						String key = studentRecords.getKey();
						String matricNum = studentRecords.getMatricNum();
						break;
					}
				}
			}
		}
		StudentRecords studentRecords = new StudentRecords(key,firstName,lastName,matricNum,courseIndex,IndexNum);
		studentsRecords.add(studentRecords);
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

	public static void main(String[] args) throws IOException{
		StudentInterface studentApp = new StudentInterface();
		studentApp.inStudentInterface();
	}
}
