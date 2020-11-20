package Student;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * DropCourse is a control class which implements the logic of dropping a course for 
 * the student if the student enters a valid courseIndex.
 * 
 * @author ?
 *
 */
public class DropCourse {
	/**
	 * prompts the user to enter the courseIndex to drop.
	 * @return courseIndex to be dropped
	 */
	public String queryCourseIndex() {
		String courseIndex;
		Scanner sc = new Scanner(System.in);
	    System.out.println("Please enter Course Index you wish to drop: ");
	    courseIndex = sc.nextLine();
	    return courseIndex;
	}
	
	/**
	 * Checks if the courseIndex entered by the user is a valid courseIndex in the database,
     	 * and returns either a valid courseIndex, or "".
	 * @param courseIndex courseIndex (eg. CZ1003)
	 * @return if a matching courseIndex is found in the database, return the courseIndex.
	 * Otherwise, return "".
	 */
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
	
    	/**
     	 * Drops the course for the student if the courseIndex is valid.
	 * @param fileLine fileLine is either a valid courseIndex(one that is present in the database), 
	 * or "". 
	 */
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
