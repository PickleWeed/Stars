public class Student {
	private String firstName;
	private String lastName;
	private String matricNumber;
	private String gender;
	private String nationality;
	private int age;
	
	private String[] courseCode;
	private String[] school;
	private int[] indexNum;
	private boolean[] vacancy;
	
	private String username;
	private String password;
	private String key;
	
	
	public Student(String n, String e, String k)  {
		username = n ;
		password = e ;
		key = k;
		//retrieve database student info
	}
	public String getUsername() { return username ; }
	public String getPassword() { return password ; }
	public String getKey() { return key ; }



	public Student(String firstName, String lastName, int age, String gender, String nationality, String school, String matricNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.matricNumber = matricNumber;
		this.gender = gender;
		this.nationality = nationality;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getGender() {
		return gender;
	}
	public String getMatric() {
		return matricNumber;
	}
	public String getNationality() {
		return nationality;
	}
	public void setName(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getCourseCode(String courseCode, int numberOfCourse)
	{
		for(int j =0; j <= numberOfCourse; j++)
		{
			if((this.courseCode[j]) == (courseCode))
			{
				return this.courseCode[j];
			}
		}
		return null;
		
		
	}
	public void setCourseCode(String courseCode, int numberOfCourse)
	{
		this.courseCode[numberOfCourse+1] = courseCode;
	}
}