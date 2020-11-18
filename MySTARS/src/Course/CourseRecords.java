package Course;

public class CourseRecords {
	
	private String  indexNum;
	private String  courseIndex;
	private String  programme;
	private String  type;
	private String  group;
	private String  day ;
	private String  time;
	private String  venue; 
	private String  remark;
	private String  vacancy ;
	
	public CourseRecords()
	{
		
	}
	
	public CourseRecords(String indexNum, String courseIndex, String programme, String type, String group, String day, String time,String venue, String remark, String vacancy)
	{
		this.indexNum = indexNum;
		this.courseIndex = courseIndex;
		this.programme = programme;
		this.type = type;
		this.group = group;
		this.day = day;
		this.time = time;
		this.venue = venue; 
		this.remark = remark;
		this.vacancy = vacancy;
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
		public String getProgramme() {
			return programme;
		}
		public void setProgramme(String programme) {
			this.programme = programme;
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
		public String getVacancy() {
			return vacancy;
		}
		public void setVacancy(String vacancy) {
			this.vacancy = vacancy;
		}
}
