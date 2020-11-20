package Repository;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import CourseRecords.CourseRecord;
import Login.LoginInfo;
import StudentRecords.StudentRecords;

import java.util.ArrayList;
import java.util.Arrays;


// Note : When structure of the Object type (the class file) in the list changed
// the Serialized file may fail.
public class DatRepository
{
	public static List readSerializedObject(String filename) {
		List pDetails = null;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(filename);
			in = new ObjectInputStream(fis);
			pDetails = (ArrayList) in.readObject();
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		// print out the size
		//System.out.println(" Details Size: " + pDetails.size());
		//System.out.println();
		return pDetails;
	}

	public static void writeSerializedObject(String filename, List list) {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(filename);
			out = new ObjectOutputStream(fos);
			out.writeObject(list);
			out.close();
		//	System.out.println("Object Persisted");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	//testing purpose
	public static void main(String[] args) {
		try {
			ArrayList al = CourseRecordsTextRepository.readCourseRecords();
			for (int i = 0 ; i < al.size() ; i++) {
				CourseRecord courseRecords = (CourseRecord)al.get(i);
					System.out.println("CourseIndex: " + courseRecords.getCourseIndex() );
					System.out.println("IndexNum: " + courseRecords.getIndexNum() );
					System.out.println("Rype: " + courseRecords.getType() );
					System.out.println("Froup: " + courseRecords.getGroup() );
					System.out.println("Day: " + courseRecords.getDay() );
					System.out.println("Time: " + courseRecords.getTime() );
					System.out.println("Venue: " + courseRecords.getVenue() );
					System.out.println("Remarks: " + courseRecords.getRemarks() );
					System.out.println("Vacancy: " + courseRecords.getVacancy() );
					System.out.println("Name: " + courseRecords.getName() );
					
					System.out.println("\n");
				}
			
			//DatabaseRepository.writeSerializedObject("CourseRecords.dat", al);
			
			//list = (ArrayList)DatabaseRepository.readSerializedObject("professor.dat");
			ArrayList datFile = (ArrayList)DatRepository.readSerializedObject("CourseRecords.dat");
					for(int i = 0; i < datFile.size(); i++)
					{
						CourseRecord courseRecords = (CourseRecord)datFile.get(i);
						System.out.println("Course Index: " + courseRecords.getCourseIndex());
						System.out.println("Day: " + courseRecords.getDay());
					}
				ArrayList datFile2 = (ArrayList)DatRepository.readSerializedObject("LoginsInfo.dat");
				for(int i = 0; i < datFile2.size(); i++)
				{
					LoginInfo loginInfo = (LoginInfo)datFile2.get(i);
					System.out.println("password: " + loginInfo.getPassword());
					System.out.println("Type: " + loginInfo.getType());
					
				}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}