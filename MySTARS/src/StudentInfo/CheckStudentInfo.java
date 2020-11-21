package StudentInfo;

import java.util.ArrayList;

import Login.LoginInfo;

public class CheckStudentInfo {
	public static boolean checkMatricNum(String matricNum, ArrayList studentInfo)
	{
		for(int i=0; i<studentInfo.size(); i++)
		{
			Student student = (Student)studentInfo.get(i);
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
	public static boolean checkEmail(String email, ArrayList studentInfo)
	{
		for(int i=0; i<studentInfo.size(); i++)
		{
			Student student = (Student)studentInfo.get(i);
			if(student.getEmail().equals(email))
			{
				System.out.println("Email already Exist.\n");
				return true;
			}	
		}		
		return false;
	}
}
