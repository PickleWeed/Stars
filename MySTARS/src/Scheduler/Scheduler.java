package Scheduler;

import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Scheduler {
	/*
	public void run() {
		// Executing getDataSet method after schedule runs. 
		try {
			//
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Calculating the next timing for scheduler to execute
		private long getInitialDelayTime() {
			// current means current time
			Calendar current = Calendar.getInstance();

			// runTime means the deadline
			Calendar runTime = Calendar.getInstance();

			// setting runTime date to first day of next month
			if (rc.getRetrieveAtStartOfMonth() == 1) {
				runTime.set(Calendar.MONTH, current.get(Calendar.MONTH) + 1);
				runTime.set(Calendar.DAY_OF_MONTH, 1);
				runTime.set(Calendar.HOUR_OF_DAY, 0);
				runTime.set(Calendar.MINUTE, 0);
				runTime.set(Calendar.SECOND, 0);
				runTime.set(Calendar.MILLISECOND, 0);
			} else {
				runTime.add(Calendar.DATE, rc.getRetrieveByDays());
			}

			// calculate the difference between runTime and current
			long differenceInMillis = runTime.getTimeInMillis() - current.getTimeInMillis();
			long seconds = differenceInMillis / 1000;

			return seconds;
		}
		*/
}
