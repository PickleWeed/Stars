package Student;
public abstract class StudentInterface {
	
	String key = null;

	public static void inStudentInterface()
	{
		System.out.println("whatever student do");
		//student object

		//get method, query to database
		Student student = new Student(null, null, null);						
	}
	public abstract void addCourse();
	public abstract void dropCourse();
	public abstract String[] getStudentCourse();
	public abstract void changeIndexOfCourse();
	public abstract String getWaitList();
	//public abstract void writeData();

}
