package Interface;
import java.util.Scanner;

import Student.Student;

public abstract class AdminApp implements AdminInterface{
	private Student[] myStudent;
	
	
	public AdminApp()
	{
		
	}
	
	public abstract void printstudentList();
	private Student[] sortedCourseNum()
	{
		Student[] sortedbyCourseNum = myStudent.clone();
		//insertion sort
		return null;
	}
	public void adminInterface()
	{	
		int choice =0;
		while(choice != 8)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("1 For Edit student Access Period");
			System.out.println("2 For Add student");
			System.out.println("3 For Add a Course");
			System.out.println("4 For Update a course");
			System.out.println("5 For Print Student List by Course Number");
			System.out.println("6 for Print Student List by Course Number");
			System.out.println("7 for Edit Student Courses");
			System.out.println("Please choose a number: ");
			choice = sc.nextInt();
			
			switch(choice)
			{
				case 1:
					System.out.println("Enter Student's Matric Number you want to edit");
					String matricNum = sc.next();
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
				
			}
		}
		
		
	}

}
