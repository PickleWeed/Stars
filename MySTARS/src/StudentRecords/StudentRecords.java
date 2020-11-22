package StudentRecords;

import java.io.Serializable;

/**
 * StudentRecords is an entity class which stores the information of a course taken by a student. <p>
 * Each course has pieces of 10 informations in total, as described below: <p>
 * key(identifies the student who takes the course) <p>
 * courseIndex(eg. CZ1003) and indexNum(eg. 10088) <p>
 * type(eg. LEC/TUT/LAB).<p>
 * group(eg. CS1, SS2).<p>
 * day, time, venue. <p>
 * remarks. <p>
 * program ????????? <p>
 * Each entry in the database is uniquely identified by the combination: <p>
 * key, CourseIndex, IndexNum, Type <p>
 * Each information has its respective get and set method.
 * 
 * @author ?
 *
 */
public class StudentRecords implements Serializable{
	private String key ;
	private String firstName;
	private String lastName;
	private String matricNum;
	private String indexNum;
	private String courseIndex;
	private String AU;
	private String courseType;
	private String SU;
	private String GERType;
	private String status;
	
	/**
	 * Class constructor specifying all 9 pieces of informations of a course taken by a student
	 * @param key Uniquely identifies the student
	 * @param indexNum indexNum(eg. 10088)
	 * @param courseIndex courseIndex(eg. CZ1003)
	 * @param type type(eg. LEC/TUT/LAB)
	 * @param group group(eg. CS1, SS2)
	 * @param day day
	 * @param time time
	 * @param venue venue
	 * @param remark remark 
	 */
<<<<<<< Updated upstream
	public StudentRecords(String key, String firstName, String lastName, String matricNum, String courseIndex,String indexNum, String AU,String courseType,String SU,String GERType,String status)
=======
	public StudentRecords(String key, String firstName, String lastName, String matricNum,  String courseIndex, String indexNum)
>>>>>>> Stashed changes
	{
		this.key = key;
		this.firstName = firstName;
		this.lastName = lastName;
		this.matricNum = matricNum;
		this.courseIndex = courseIndex;
<<<<<<< Updated upstream
		this.AU = AU;
		this.courseType = courseType;
		this.SU = SU;
		this.GERType = GERType;
		this.status = status;
=======
		this.indexNum = indexNum;
>>>>>>> Stashed changes
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMatricNum() {
		return matricNum;
	}

	public void setMatricNum(String matricNum) {
		this.matricNum = matricNum;
	}

	public String getIndexNum() {
		return indexNum;
	}

	public void setIndexNum(String indexNum) {
		this.indexNum = indexNum;
	}

	public String getCourseIndex() {
		return courseIndex;
	}

	public void setCourseIndex(String courseIndex) {
		this.courseIndex = courseIndex;
	}
	public String getAU() {
		return AU;
	}
	public String getCourseType() {
		return courseType;
	}
	public String getSU() {
		return SU;
	}
	public String getGERType() {
		return GERType;
	}
	
	public String getStatus() {
		return status;
	}
}
