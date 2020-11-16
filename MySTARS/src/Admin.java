
public class Admin{	
	private Student[] student;
	private static int numberOfStudent = 15;
	private int i = 0;
	//student access period has to be store in
	private String username;
	private String password;
	private String key;
	public Admin()
	{
		//change to dynamic	
		student = new Student[i];
		for (int j=0; j<numberOfStudent; j++) {
			student[j] = new Student(null, null, i, null, null, null, null); 
		}
	}
	public Admin(String n, String e, String k){ //enter from TextDatabase - n = Admin, e = Admin, k = CE
		username = n; //Username = Admin
		password = e; //Password = Admin
		key = k; //key = CE
	}
	public String getUsername() { 
      return username; 
      }
	public String getPassword() { 
      return password; 
      }
	public String getKey() { 
      return key; 
      }	
	//public String AddStudent() {i
	//	
	//}
}
