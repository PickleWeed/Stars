package AccessPeriod;

import java.util.ArrayList;

public class GetAccessPeriod {
	public static void printAccessPeriod(ArrayList accessPeriod)
	{
		for (int i = 0 ; i < accessPeriod.size() ; i++) {
			AccessPeriod accessPeriodObj = (AccessPeriod)accessPeriod.get(i);

					System.out.println((i+1) + ". Starting Access Period: " + accessPeriodObj.getStartAccessPeriod() + ", Ending Access Period: " + accessPeriodObj.getEndAccessPeriod());
		}
		System.out.println("\n");
	}
	public static String getAccessPeriod(ArrayList accessPeriod, String accessPeriodValue)
	{
		for (int i = 0 ; i < accessPeriod.size() ; i++) {
			AccessPeriod accessPeriodObj = (AccessPeriod)accessPeriod.get(i);
			if(accessPeriodValue.equals(Integer.toString(i+1)))
			{
				return (accessPeriodObj.getStartAccessPeriod() + " - " + accessPeriodObj.getEndAccessPeriod());
				//System.out.println((i+1) + ". Starting Access Period: " + accessPeriodObj.getStartAccessPeriod() + ", Ending Access Period: " + accessPeriodObj.getEndAccessPeriod());
			}
		}
		System.out.println("Invalid Value");
		return "nill";	
	}	
}
