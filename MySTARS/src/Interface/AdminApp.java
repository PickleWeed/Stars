package Interface;
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
		
	}

}
