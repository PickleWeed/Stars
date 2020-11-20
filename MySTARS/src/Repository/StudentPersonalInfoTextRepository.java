package Repository;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

import StudentInfo.Student;

/**
 * StudentPersonalInfoTextRepository is a boundary class which performs read and write operations 
 * on StudentsInfo.txt, a database that stores the information of all students.<p>
 * The information stored for each student is listed below: <p>
 * key: Uniquely identifies a student <p>
 * firstName, lastName, matricNum, gender, nationality, age <p>
 * accessPeriod: The period of time that the student is allowed to access MySTARS <p>
 * Each information has its respective get and set method.
 * 
 * @author ?
 *
 */
public class StudentPersonalInfoTextRepository implements Repository{
	private static final String SEPARATOR = "|";
	private static final  String filename = "StudentsInfo.txt" ;

    	/**
	 * Gets the information of all students from the database.<p>
     * Each student's information is stored as a Student object.<p> 
     * An ArrayList of Student objects are returned.<p>
	 * 
	 * @return An ArrayList of Student objects storing 
	 * the information of all students from the database is returned.
	 * @throws IOException If an input or output exception occurred
	 */
	public ArrayList readToList() throws IOException {
		// read String from text file
		ArrayList stringArray = (ArrayList)read(filename);
		ArrayList alr = new ArrayList() ;// to store Professors data

        for (int i = 0 ; i < stringArray.size() ; i++) {
				String st = (String)stringArray.get(i);
				// get individual 'fields' of the string separated by SEPARATOR
				StringTokenizer star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter ","

				String  key = star.nextToken().trim();
				String  firstName = star.nextToken().trim();	// first token
				String  lastName = star.nextToken().trim();	// second token
				String  matricNum = star.nextToken().trim();	// third token
				String  gender = star.nextToken().trim();
				String  nationality = star.nextToken().trim();
				String  age = star.nextToken().trim();
				String accessPeriod = star.nextToken().trim();
				String email = star.nextToken().trim();
				//int  vacancy = Integer.parseInt(star.nextToken().trim());
				// create Professor object from file data
				Student student = new Student(key, firstName, lastName, matricNum, gender, nationality, age, accessPeriod, email);
				// add to Professors list
				alr.add(student) ;
			}
			return alr ;
	}

		/**
	 * Saves an ArrayList of Student objects into the database.
	 * 
	 * @param al an ArrayList of Student object to be stored into the database
	 * @throws IOException If an input or output exception occurred
	 */
	public void saveList(List al) throws IOException {
			List alw = new ArrayList() ;// to store Professors data
	
	        for (int i = 0 ; i < al.size() ; i++) {
	        	Student student = (Student)al.get(i);
					StringBuilder st =  new StringBuilder() ;
					st.append(student.getKey().trim());
					st.append(SEPARATOR);
					st.append(student.getFirstName().trim());
					st.append(SEPARATOR);
					st.append(student.getLastName().trim());
					st.append(SEPARATOR);
					st.append(student.getMatricNum().trim());
					st.append(SEPARATOR);
					st.append(student.getGender().trim());
					st.append(SEPARATOR);
					st.append(student.getNationality().trim());
					st.append(SEPARATOR);
					st.append(student.getAge().trim());
					st.append(SEPARATOR);
					st.append(student.getAccessPeriod().trim());
					st.append(SEPARATOR);
					st.append(student.getEmail().trim());
					alw.add(st.toString()) ;
				}
				write(filename,alw);
		}

  /** Write fixed content to the given file. */
  public void write(String fileName, List data) throws IOException  {
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

  /** Read the contents of the given file. */
  public List read(String fileName) throws IOException {
	List data = new ArrayList() ;
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

	public static void main(String[] aArgs)  {
	    	/*TextDB txtDB = new TextDB();
	    	String filename = "professor.txt" ;
			try {
				// read file containing Professor records.
				ArrayList al = TextDB.readProfessors(filename) ;
				for (int i = 0 ; i < al.size() ; i++) {
						Professor prof = (Professor)al.get(i);
						System.out.println("Name " + prof.getName() );
						System.out.println("Contact " + prof.getContact() );
				}
				Professor p1 = new Professor("Joseph","jos@ntu.edu.sg",67909999);
				// al is an array list containing Professor objs
				al.add(p1);
				// write Professor record/s to file.
				TextDB.saveProfessors(filename, al);
			}catch (IOException e) {
				System.out.println("IOException > " + e.getMessage());
			}*/
		
		StudentPersonalInfoTextRepository studentRecTextRepository = new StudentPersonalInfoTextRepository();
		try {
			// read file containing Professor records.
			ArrayList al = studentRecTextRepository.readToList() ;
			for (int i = 0 ; i < al.size() ; i++) {
				Student student = (Student)al.get(i);
					System.out.println("Key: " + student.getKey() );
					System.out.println("FirstName: " + student.getFirstName() );
					System.out.println("LastName: " + student.getLastName() );
					System.out.println("Matric Number: " + student.getMatricNum() );
					System.out.println("Gender: " + student.getGender() );
					System.out.println("Nationality: " + student.getNationality() );
					System.out.println("Age: " + student.getAge() );
					System.out.println("Access Period: " + student.getAccessPeriod());
					System.out.println("Email: " + student.getEmail());
					System.out.println("\n");
				}
			//saveStudentRecords(filename, al);
			}catch (IOException e) {
				System.out.println("IOException > " + e.getMessage());
			}
	  }
}
