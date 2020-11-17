package Interface;
public abstract class StudentInterface {
	
	String key = null;

	public static void inStudentInterface()
	{
		System.out.println("1 For Add Course");
		System.out.println("2 For Drop Course");
		System.out.println("3 For Check Course");
      System.out.println("4 For Vacancies Available");
      System.out.println("5 For Change Index Number of Course");
      System.out.println("6 for Swop Index Number with Another Student");
		//student object

		//get method, query to database
		//Student student = new Student(null, null, null);						
	}
	public abstract void addCourse();
	public abstract void dropCourse();
	public abstract String[] getStudentCourse();
	public abstract void changeIndexOfCourse();
	public abstract String getWaitList();
	//public abstract void writeData();

}
