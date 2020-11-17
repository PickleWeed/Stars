import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class StudentInfoTextRepository {
	public static final String SEPARATOR = "|";

    // an example of reading
	public static ArrayList readStudentRecords(String filename) throws IOException {
		// read String from text file
		ArrayList stringArray = (ArrayList)read(filename);
		ArrayList alr = new ArrayList() ;// to store Professors data

        for (int i = 0 ; i < stringArray.size() ; i++) {
				String st = (String)stringArray.get(i);
				// get individual 'fields' of the string separated by SEPARATOR
				StringTokenizer star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter ","

				String  key = star.nextToken().trim();
				String  indexNum = star.nextToken().trim();	// first token
				String  courseIndex = star.nextToken().trim();	// second token
				String  programme = star.nextToken().trim();	// third token
				String  type = star.nextToken().trim();
				String  group = star.nextToken().trim();
				String  day = star.nextToken().trim();
				String  time = star.nextToken().trim();
				String  venue = star.nextToken().trim();
				String  remark = star.nextToken().trim();
				//int  vacancy = Integer.parseInt(star.nextToken().trim());
				// create Professor object from file data
				StudentRecords studentRecords = new StudentRecords(key, indexNum, courseIndex, programme, type, group, day, time, venue, remark);
				// add to Professors list
				alr.add(studentRecords) ;
			}
			return alr ;
	}

  // an example of saving
public static void saveStudentRecords(String filename, List al) throws IOException {
		List alw = new ArrayList() ;// to store Professors data

        for (int i = 0 ; i < al.size() ; i++) {
        	StudentRecords studentRecords = (StudentRecords)al.get(i);
				StringBuilder st =  new StringBuilder() ;
				st.append(studentRecords.getKey().trim());
				st.append(SEPARATOR);
				st.append(studentRecords.getIndexNum().trim());
				st.append(SEPARATOR);
				st.append(studentRecords.getCourseIndex().trim());
				st.append(SEPARATOR);
				st.append(studentRecords.getProgramme().trim());
				st.append(SEPARATOR);
				st.append(studentRecords.getType().trim());
				st.append(SEPARATOR);
				st.append(studentRecords.getGroup().trim());
				st.append(SEPARATOR);
				st.append(studentRecords.getDay().trim());
				st.append(SEPARATOR);
				st.append(studentRecords.getTime().trim());
				st.append(SEPARATOR);
				st.append(studentRecords.getVenue().trim());
				st.append(SEPARATOR);
				st.append(studentRecords.getRemark().trim());
				alw.add(st.toString()) ;
			}
			write(filename,alw);
	}

  /** Write fixed content to the given file. */
  private static void write(String fileName, List data) throws IOException  {
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
  private static List read(String fileName) throws IOException {
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
	
	String filename = "StudentRecords.txt" ;
	StudentInfoTextRepository studentRecTextRepository = new StudentInfoTextRepository();
	try {
		// read file containing Professor records.
		ArrayList al = studentRecTextRepository.readStudentRecords(filename) ;
		for (int i = 0 ; i < al.size() ; i++) {
			StudentRecords studentRecord = (StudentRecords)al.get(i);
				System.out.println("Key: " + studentRecord.getKey() );
				System.out.println("IndexNum: " + studentRecord.getIndexNum() );
				System.out.println("CourseIndex: " + studentRecord.getCourseIndex() );
				System.out.println("Programme: " + studentRecord.getProgramme() );
				System.out.println("Type: " + studentRecord.getType() );
				System.out.println("Group: " + studentRecord.getGroup() );
				System.out.println("Day: " + studentRecord.getDay() );
				System.out.println("Time: " + studentRecord.getTime() );
				System.out.println("Venue: " + studentRecord.getVenue() );
				System.out.println("Remark: " + studentRecord.getRemark() );
				System.out.println("\n");
			}
		//saveStudentRecords(filename, al);
		}catch (IOException e) {
			System.out.println("IOException > " + e.getMessage());
		}
  }
}