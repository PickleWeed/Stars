package Student;

import java.io.Serializable;

public class Student implements Serializable{

	private String  key ;
	private String  firstName;
	private String  lastName;
	private String  matricNum;
	private String  gender;
	private String  nationality;
	private String  age ;
	private String accessPeriod;
	private String email;

	public Student(String key, String firstName, String lastName, String matricNum, String gender, 
			String nationality, String age, String accessPeriod, String email)
	{
		this.key = key;
		this.firstName = firstName;
		this.lastName = lastName;
		this.matricNum = matricNum;
		this.gender = gender;
		this.nationality = nationality;
		this.age = age;
		this.accessPeriod = accessPeriod;
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAccessPeriod() {
		return accessPeriod;
	}

	public void setAccessPeriod(String accessPeriod) {
		this.accessPeriod = accessPeriod;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMatricNum() {
		return matricNum;
	}

	public void setMatricNum(String matricNum) {
		this.matricNum = matricNum;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}