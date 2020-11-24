package Repository;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * TextDatabase is a boundary class which performs read and write operations on 
 * text files.
 * 
 * @author Aaron Tay Han Yen
 *
 */
public class TextDatabase {
	
	/**
	 * Reads all data from a txt file
	 * 
	 * @param fileName name of the file to read from
	 * @return all data in the file as an ArrayList 
	 * @throws IOException If an input or output exception occurred
	 */
	public static List read(String fileName) throws IOException { //enter from readStudentLogin
		List data = new ArrayList(); 
	   Scanner scanner = new Scanner(new FileInputStream(fileName));
	   try {
	      while (scanner.hasNextLine()){
	        data.add(scanner.nextLine());
	      }
	   }
	    finally{
	      scanner.close();
	    }
	    return data;
	  }	  
	
	/**
	 * writes data to a txt file
	 * 
	 * @param fileName name of the file to write to
	 * @param data list data to be written to the file
	 * @throws IOException If an input or output exception occurred
	 */
	public static void write(String fileName, List data) throws IOException  {
	    PrintWriter out = new PrintWriter(new FileWriter(fileName));

	    try {
			for (int i =0; i < data.size() ; i++) {
	      		out.println((String)data.get(i));
			}
	    }
	    finally {
	      out.close();
	    }
	 }
}
