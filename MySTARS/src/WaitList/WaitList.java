package WaitList;

import java.io.Serializable;

public class WaitList implements Serializable{
	private String courseIndex;
	private String indexNum;
	private String totalQueue;
	
	public WaitList(String courseIndex, String indexNum, String totalQueue)
	{
		this.courseIndex = courseIndex;
		this.indexNum = indexNum;
		this.totalQueue = totalQueue;
	}

	public String getCourseIndex() {
		return courseIndex;
	}

	public void setCourseIndex(String courseIndex) {
		this.courseIndex = courseIndex;
	}

	public String getIndexNum() {
		return indexNum;
	}

	public void setIndexNum(String indexNum) {
		this.indexNum = indexNum;
	}

	public String getTotalQueue() {
		return totalQueue;
	}

	public void setTotalQueue(String totalQueue) {
		this.totalQueue = totalQueue;
	}
	
}
