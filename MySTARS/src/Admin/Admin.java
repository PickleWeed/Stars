package Admin;
import Student.Student;

public class Admin{	
	private Student[] student;
	private static int numberOfStudent = 15;
	private int i = 0;
	
	
	//student access period has to be store in
	private String username;
	private String password;
	private String key;
	
	public Admin(String n, String e, String k){ //enter from TextDatabase - n = Admin, e = Admin, k = CE
		username = n; //Username = Admin
		password = e; //Password = Admin
		key = k; //key = CE
	}
	
}
