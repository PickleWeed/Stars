package Student;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class DropCourse {
	public String queryCourseIndex() {
		String courseIndex;
		Scanner sc = new Scanner(System.in);
	    System.out.println("Please enter Course Index you wish to drop: ");
	    courseIndex = sc.nextLine();
	    return courseIndex;
	}
    public String findString(String courseIndex){
    	String data, Str, subData, temp;
    	try {
	        File fileName = new File("StudentRecords.txt");
	        Scanner sc = new Scanner(fileName);
	        sc.nextLine();
	        while (sc.hasNextLine()) {
	        	data = sc.nextLine();
	        	Str = new String(data);
	        	subData = Str.substring(9,15);
	        	if (subData.equals(courseIndex)) {
	            	return Str;
	        	}
	        }
    	}
    	catch(FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
    	}
        return "";
    }
   public void dropCourse(String fileLine) {
   		try { 
	       	File fileName = new File("StudentRecords.txt");
	        Scanner sc = new Scanner(fileName);
	        while (sc.hasNextLine()) {
	        	String data = sc.nextLine();
	        	if (data != fileLine) {
	        	    try {
	    		        FileWriter writer = new FileWriter("StudentRecords.txt", false);
	    		        writer.write(data);
	    		        writer.close();
	        	      } 
	        	    catch (IOException e) {
	        	        System.out.println("An error occurred.");
	        	        e.printStackTrace();
	        	      }
	        	}
	        }
   		}
    	catch(FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
    	}
   }

}
