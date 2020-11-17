package Interface;

public interface AdminInterface {

	public abstract void editAccessPeriod();
	public abstract void addStudentRecord();
	public abstract void updateAddCourse(int courseCode, String school, int indexNum, int vacancy);
	public abstract String[] getStudentCourse();
	public abstract void checkSlot(int indexNum);
	public abstract void printStudentList();
}
