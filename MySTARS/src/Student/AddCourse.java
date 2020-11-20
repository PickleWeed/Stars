package Student;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import CourseRecords.CourseRecordObj;
import TextRepository.CourseRecordsTextRepository;
public class AddCourse {
	public static void addCourse1(String courseIndex, ArrayList courseRecordList)
	{
		
		for (int i=0; i<courseRecordList.size(); i++)
		{
			//get array object 
			CourseRecordObj courseRecords = (CourseRecordObj)courseRecordList.get(i);
			
			System.out.println(courseRecords.getCourseIndex());
			/*if(courseIndex == courseRecords.getCourseIndex())
			{
				System.out.println("do something");
			}*/
			
		}
	}
	
	
	
	
	
	
	public static final String delimiter = "|";
		public String queryCourseIndex() {
			String courseIndex;
			Scanner sc = new Scanner(System.in);
		    System.out.println("Please enter Course Index: ");
		    courseIndex = sc.nextLine();
		    return courseIndex;
		}
		public String findRelevantRecord(String courseIndex){
			String data, Str, subData, temp;
	        try {
	            File myObj = new File("CourseRecords.txt");
	            Scanner sc = new Scanner(myObj);
	            sc.nextLine();
	            while (sc.hasNextLine()) {
	            	data = sc.nextLine();
	            	Str = new String(data);
	            	subData = Str.substring(6,12);
	            	temp = Str.substring(0,Str.length()-4);
	            	if (subData.equals(courseIndex)) {
		            	return temp;
	            	}
	            }
	            sc.close();
	          } catch (FileNotFoundException e) {
	            System.out.println("An error occurred.");
	            e.printStackTrace();
	          }	
	        return "";
		}
	    public void addCourse(String temp){
		    try {
		        FileWriter writer = new FileWriter("StudentRecords.txt", true);
		        BufferedWriter bufferedWriter = new BufferedWriter(writer);
		        bufferedWriter.write(temp);
		        bufferedWriter.newLine();
		        //bufferedWriter.write(delimiter);
		        bufferedWriter.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
	    }
}

