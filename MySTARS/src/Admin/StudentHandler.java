package Admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Login.Encrypt;
import Login.LoginInfo;
import Student.Student;
import Student.StudentRecords;
import TextRepository.LoginTextRepository;
import TextRepository.StudentPersonalInfoTextRepository;

public class StudentHandler {
	
	public static void addStudent(ArrayList StudentInfoArray, ArrayList loginArray, String firstName, String lastName, String matricNum, String gender, String nationality, String age, String username, String password, String accessPeriod) throws IOException
	{
		String key = Encrypt.getKey();
		String hashPassword = Encrypt.hashing(password);
		
		//ArrayList StudentInfoArray = StudentPersonalInfoTextRepository.readStudentInfo();
		//ArrayList loginArray = LoginTextRepository.readLogin();
		
		Student student = new Student(key, firstName, lastName, matricNum, gender, nationality, age, accessPeriod);
		StudentInfoArray.add(student) ;
		
		LoginInfo loginInfo = new LoginInfo(username, hashPassword, "Student", key);
		loginArray.add(loginInfo);
		
		StudentPersonalInfoTextRepository.saveStudentInfo(StudentInfoArray);
		LoginTextRepository.saveLogin(loginArray);
		
		System.out.println("Student Successfully added!\n");
		
		System.out.println("FirstName: " + student.getFirstName() );
		System.out.println("LastName: " + student.getLastName() );
		System.out.println("Matric Number: " + student.getMatricNum() );
		System.out.println("Gender: " + student.getGender() );
		System.out.println("Nationality: " + student.getNationality() );
		System.out.println("Age: " + student.getAge() );
		System.out.println("Access Period: " + student.getAccessPeriod());
		System.out.println("\n");
	}
	public static boolean checkMatricNum(String matricNum, ArrayList studentInfoList)
	{
		for(int i=0; i<studentInfoList.size(); i++)
		{
			Student student = (Student)studentInfoList.get(i);
			if(student.getMatricNum().equals(matricNum))
			{
				System.out.println("Matric Number already Exist.\n");
				return true;
			}	
		}
		
		return false;
	}
	public static boolean checkUsername(String username, ArrayList LoginArray)
	{
		for(int i=0; i<LoginArray.size(); i++)
		{
			LoginInfo loginInfo = (LoginInfo)LoginArray.get(i);
			if(loginInfo.getUsername().equals(username))
			{
				System.out.println("Username already Exist.\n");
				return true;
			}		
		}
		return false;
		
	}
	public static String getStudentKey(ArrayList studentInfo, String matricNum)
	{
		//get key
		for (int i = 0; i < studentInfo.size(); i++)
		{
			Student student = (Student)studentInfo.get(i);
			if(student.getMatricNum().equals(matricNum))
				return student.getKey();	
		}
		return "nill";	
	}
	public static void editStudentAC(ArrayList studentInfo, String accessPeriod, String key) throws IOException
	{
		for (int i = 0 ; i < studentInfo.size() ; i++) {
			Student student = (Student)studentInfo.get(i);
			if(student.getKey().equals(key))
			{
				student.setAccessPeriod(accessPeriod);
				System.out.println("Access Period Updated!");
			}
			StudentPersonalInfoTextRepository.saveStudentInfo(studentInfo);
		}
	}
}
