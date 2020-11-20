package StudentInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Login.Encrypt;
import Login.LoginInfo;
import TextRepository.LoginTextRepository;
import TextRepository.StudentPersonalInfoTextRepository;

public class UpdateStudentInfo {
	
	public static void addStudent(ArrayList StudentInfoArray, ArrayList loginArray, String firstName, String lastName, 
			String matricNum, String gender, String nationality, String age, 
			String username, String password, String accessPeriod, String email) throws IOException
	{
		String key = Encrypt.getKey();
		String hashPassword = Encrypt.hashing(password);
		
		//ArrayList StudentInfoArray = StudentPersonalInfoTextRepository.readStudentInfo();
		//ArrayList loginArray = LoginTextRepository.readLogin();
		
		Student student = new Student(key, firstName, lastName, matricNum, gender, nationality, age, accessPeriod, email);
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
