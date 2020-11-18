package Interface;
import Student.*;
import TextRepository.CourseRecordsTextRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class StudentInterface {
	String key = null;

	public static void inStudentInterface() throws IOException
	{
		while (true) {
			int choice;
			Scanner sc = new Scanner(System.in);
			System.out.println("1 For Add Course");
			System.out.println("2 For Drop Course");
			System.out.println("3 For Check Course");
			System.out.println("4 For Check Vancancies");
			System.out.println("5 For Change Index Number of Course");
			System.out.println("6 for Swap Index Number with Another Student");
			System.out.println("Please choose a number: ");
			choice = sc.nextInt();
			
			switch(choice)
			{
				case 1:
					String courseIndex, temp;
					ArrayList courseRecordList = CourseRecordsTextRepository.readCourseRecords();
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
					CheckCourse checkCourse = new CheckCourse();
					break;
				case 4:
					CheckVacancies CheckVacancies = new CheckVacancies();
					break;
				case 5:
					ChangeIndex changeIndex = new ChangeIndex();
					break;
				case 6:
					SwapIndex swapIndex = new SwapIndex();
					break;
				default:
					System.out.println("Try another choice");
					return;	
			}	
		}
	}
	public abstract void addCourse();
	public abstract void dropCourse();
	public abstract String[] getStudentCourse();
	public abstract void changeIndexOfCourse();
	public abstract String getWaitList();
	//public abstract void writeData();

}
