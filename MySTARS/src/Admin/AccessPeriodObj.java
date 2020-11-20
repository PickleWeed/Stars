package Admin;

import java.io.Serializable;

public class AccessPeriodObj implements Serializable{
	private String startAccessPeriod;
	private String endAccessPeriod;
	
	public AccessPeriodObj(String startAccessPeriod, String endAccessPeriod)
	{
		this.startAccessPeriod = startAccessPeriod;
		this.endAccessPeriod = endAccessPeriod;
	}
	
	public String getStartAccessPeriod() {
		return startAccessPeriod;
	}

	public void setStartAccessPeriod(String startAccessPeriod) {
		this.startAccessPeriod = startAccessPeriod;
	}

	public String getEndAccessPeriod() {
		return endAccessPeriod;
	}

	public void setEndAccessPeriod(String endAccessPeriod) {
		this.endAccessPeriod = endAccessPeriod;
	}
	
}
