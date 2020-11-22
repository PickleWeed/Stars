package Student;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import CourseRecords.CourseRecord;
import Repository.CourseRecordsTextRepository;
import Repository.DatDatabase;
import Repository.StudentPersonalTextRepository;
import Repository.StudentRecordTextRepository;
import StudentInfo.*;
import StudentRecords.StudentRecords;


public class AddCourse{
	public static void addCourse(ArrayList studentsRecords, String key, String firstName, 
			String lastName, String matricNum, String courseIndex, String indexNum) throws IOException{
		
		Scanner sc = new Scanner(System.in);
		ArrayList courseRecordList = (ArrayList)DatDatabase.read("CourseRecords.dat");
		System.out.println("Course Index" + "  " + "Index Number"); 
		System.out.println("***************************"); 		
		for (int i=1; i<courseRecordList.size(); i++) { 
			CourseRecord courseRecords = (CourseRecord)courseRecordList.get(i);	
			if(courseRecords.getCourseIndex().equals(courseIndex)) {
				System.out.println("   "+courseRecords.getCourseIndex() + "        " + courseRecords.getIndexNum()); 		  
			}
		}
		System.out.println("Enter Index Number: "); 
		indexNum = sc.next();
		ArrayList studentRecords;
		StudentRecordTextRepository studentCoursesTextRepository = new StudentRecordTextRepository();
		studentsRecords = studentCoursesTextRepository.readToList();
		//get the information from Course Record & insert onto student Record
		StudentRecords newStudentRecord = new StudentRecords(key,firstName,lastName,matricNum,courseIndex,indexNum,"-","-","-","-","-");
		studentsRecords.add(newStudentRecord);
		studentCoursesTextRepository.saveList(studentsRecords);
		/*
		 * StudentPersonalInfoTextRepository studentPersonalInfoTextRepository = new
		 * StudentPersonalInfoTextRepository(); ArrayList studentInfo; studentInfo =
		 * studentPersonalInfoTextRepository.readToList();
		 * System.out.println(studentInfo); DatDatabase.write("StudentInfo.dat",
		 * studentInfo); studentInfo = (ArrayList)DatDatabase.read("StudentInfo.dat");
		 * UpdateStudentInfo updateStudentInfo = new UpdateStudentInfo();
		 * //updateStudentInfo.addStudent();
		 */
		}

/**
 * AddCourse is a control class which implements the logic of adding a course
 * for the student if the student enters a valid courseIndex.
 * 
 * @author ?
 *
 */


 /**
	 * Displays the CourseIndex of all courses in the database.
	 * 
	 * @param courseIndex      courseIndex
	 * @param courseRecordList Arraylist of CourseRecord objects
	 */

  public static void addCourse1(String courseIndex, ArrayList courseRecordList)
  {
  
  for (int i=0; i<courseRecordList.size(); i++) { //get array object
  CourseRecord courseRecords = (CourseRecord)courseRecordList.get(i);
  
  System.out.println(courseRecords.getCourseIndex()); if(courseIndex ==
  courseRecords.getCourseIndex()) { System.out.println("do something"); }
  
  } }
  
  
  
  
  
  
  
  public static final String delimiter = "|";
 /**
	 * prompts the user to enter a CourseIndex
	 * 
	 * @return the courseIndex entered by the user
	 */

  public String queryCourseIndex() { String courseIndex; Scanner sc = new
  Scanner(System.in); System.out.println("Please enter Course Index: ");
  courseIndex = sc.nextLine(); return courseIndex; }
 /**
	 * Checks if the courseIndex entered by the user is a valid courseIndex in the
	 * database, and returns either a valid courseIndex, or "".
	 * 
	 * @param courseIndex courseIndex (eg. CZ1003)
	 * @return if a matching courseIndex is found in the database, return the
	 *         courseIndex. Otherwise, return "".
	 */

  public String findRelevantRecord(String courseIndex){ 
	  String data, Str,subData, temp; 
	  try { 
		  File myObj = new File("CourseRecords.txt"); 
		  Scanner sc = new Scanner(myObj); 
		  sc.nextLine(); 
		  while (sc.hasNextLine()) { 
			  data = sc.nextLine();
			  Str = new String(data); 
			  subData = Str.substring(6,12); 
			  temp =Str.substring(0,Str.length()-4); 
			  if (subData.equals(courseIndex)) { 
				  return temp; } 
			  } 
		  sc.close(); 
		  } 
	  catch (FileNotFoundException e) {
		  System.out.println("An error occurred."); 
		  e.printStackTrace(); 
		  } 
	  return ""; 
	  }
  }
 /**
	 * Adds the course for the student if the courseIndex is valid.
	 * 
	 * @param temp temp is either a valid courseIndex(one that is present in the
	 *             database), or "".
	 */
	/*
	 * public void addCourse(String temp){ try { FileWriter writer = new
	 * FileWriter("StudentRecords.txt", true); BufferedWriter bufferedWriter = new
	 * BufferedWriter(writer); bufferedWriter.write(temp); bufferedWriter.newLine();
	 * //bufferedWriter.write(delimiter); bufferedWriter.close(); } catch
	 * (IOException e) { e.printStackTrace(); } } }
	 */
