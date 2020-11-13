package Admin;
import Student.Student;

public abstract class AdminInterface {
	private Student[] myStudent;
	public AdminInterface()
	{
		
	}
	
	public abstract void printstudentList();
	private Student[] sortedCourseNum()
	{
		Student[] sortedbyCourseNum = myStudent.clone();
		//insertion sort
		return null;
	}
	public abstract void editAccessPeriod();
	public abstract void addStudentRecord();
	public abstract void updateAddCourse(int courseCode, String school, int indexNum, int vacancy);
	public abstract String[] getStudentCourse();
	public abstract void checkSlot(int indexNum);
	public abstract void printStudentList();
}
