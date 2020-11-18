package Admin;

import java.io.IOException;
import java.util.ArrayList;
import Login.Encrypt;
import Login.LoginInfo;
import Student.Student;
import TextRepository.LoginTextRepository;
import TextRepository.StudentPersonalInfoTextRepository;

public class UpdateStudent {
	
	public static void addStudent(ArrayList StudentInfoArray, ArrayList loginArray, String firstName, String lastName, String matricNum, String gender, String nationality, String age, String username, String password) throws IOException
	{
		String key = Encrypt.getKey();
		String accessPeriod = "20/06/2020 - 20/08/2020";
		String hashPassword = Encrypt.hashing(password);
		
		//ArrayList StudentInfoArray = StudentPersonalInfoTextRepository.readStudentInfo();
		//ArrayList loginArray = LoginTextRepository.readLogin();
		
		Student student = new Student(key, firstName, lastName, matricNum, gender, nationality, age, accessPeriod);
		StudentInfoArray.add(student) ;
		
		LoginInfo loginInfo = new LoginInfo(username, hashPassword, "Student", key);
		loginArray.add(loginInfo);
		
		StudentPersonalInfoTextRepository.saveStudentInfo(StudentInfoArray);
		LoginTextRepository.saveLogin(loginArray);
		
	}
	public static boolean checkMatricNum(String matricNum, ArrayList studentInfoList)
	{
		for(int i=0; i<studentInfoList.size(); i++)
		{
			Student student = (Student)studentInfoList.get(i);
			if(student.getMatricNum().equals(matricNum))
				return false;
		}
		System.out.println("Matric Number already Exist");
		return true;
	}
	public static boolean checkUsername(String username, ArrayList LoginArray)
	{
		for(int i=0; i<LoginArray.size(); i++)
		{
			LoginInfo loginInfo = (LoginInfo)LoginArray.get(i);
			if(loginInfo.getUsername().equals(username))
				return false;
		}
		System.out.println("Username already Exist");
		return true;
		
	}
	public static void main(String[] args) throws IOException {
		String firstName = "hi", lastName = "key", matricNum = "12312", gender = "Male", age = "25", nationality = "Singaporean", password = "whatever", username = "hello";
		
		String key = Encrypt.getKey();
		String accessPeriod = "20/06/2020 - 20/08/2020";
		String hashPassword = Encrypt.hashing(password);
		
		ArrayList StudentInfoArray = StudentPersonalInfoTextRepository.readStudentInfo();
		ArrayList loginArray = LoginTextRepository.readLogin();
		
		Student student = new Student(key, firstName, lastName, matricNum, gender, nationality, age, accessPeriod);
		StudentInfoArray.add(student) ;
		
		LoginInfo loginInfo = new LoginInfo(username, hashPassword, "Student", key);
		loginArray.add(loginInfo);
		
		StudentPersonalInfoTextRepository.saveStudentInfo(StudentInfoArray);
		LoginTextRepository.saveLogin(loginArray);
	}
	

}
