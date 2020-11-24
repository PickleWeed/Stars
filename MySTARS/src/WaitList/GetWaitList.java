package WaitList;

import java.util.ArrayList;

public class GetWaitList {
	public static String getQueue(ArrayList waitList, String courseIndex, String indexNum, String queue)
	{
		for (int i = 0 ; i < waitList.size() ; i++) {
        		WaitList myWaitList = (WaitList)waitList.get(i);
        		if(myWaitList.getCourseIndex().equals(courseIndex) && myWaitList.getIndexNum().equals(indexNum))
        			return queue;
		}
		return null;
	}
	public static boolean hasQueue(ArrayList waitList, String courseIndex, String indexNum)
	{
		for (int i = 0 ; i < waitList.size() ; i++) {
    		WaitList myWaitList = (WaitList)waitList.get(i);
    		if(myWaitList.getCourseIndex().equals(courseIndex) && myWaitList.getIndexNum().equals(indexNum) && myWaitList.getTotalQueue().equals("0"))
    			return false;
		}
		return true;
	}
	
}
