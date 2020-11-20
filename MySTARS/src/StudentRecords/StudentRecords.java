package StudentRecords;

import java.io.Serializable;

/**
 * StudentRecords is an entity class which stores all information of a course. <p>
 * Each course has pieces of 10 informations in total, as described below: <p>
 * courseIndex(eg. CZ1003) and indexNum(eg. 10088), which unqiuely defines a course. <p>
 * type(eg. LEC/TUT/LAB).<p>
 * group(eg. CS1, SS2).<p>
 * day, time, venue. <p>
 * name of the course. <p>
 * vacancy. <p>
 * remarks. <p>
 * Each information has its respective get and set method.
 * 
 * @author ?
 *
 */
public class StudentRecords implements Serializable{
	private String  key ;
	private String  indexNum;
	private String  courseIndex;
	private String  programme;
	private String  type;
	private String  group;
	private String  day ;
	private String  time;
	private String  venue; 
	private String  remark;
	
	public StudentRecords(String key, String indexNum, String courseIndex, String type, String group, String day, String time,String venue, String remark)
	{
		this.key = key;
		this.indexNum = indexNum;
		this.courseIndex = courseIndex;
		this.programme = programme;
		this.type = type;
		this.group = group;
		this.day = day;
		this.time = time;
		this.venue = venue; 
		this.remark = remark;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
