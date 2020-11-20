package AccessPeriod;

import java.io.IOException;
import java.util.ArrayList;

import Repository.GlobalAccessPeriodTextRepository;

public class GetAccessPeriod {
	public static void viewAccessPeriod(ArrayList accessPeriod)
	{
		for (int i = 0 ; i < accessPeriod.size() ; i++) {
			AccessPeriod accessPeriodObj = (AccessPeriod)accessPeriod.get(i);

					System.out.println((i+1) + ". Starting Access Period: " + accessPeriodObj.getStartAccessPeriod() + ", Ending Access Period: " + accessPeriodObj.getEndAccessPeriod());
		}
		System.out.println("\n");
	}
	public static String getAccessPeriod(ArrayList accessPeriod, String acessPeriodValue)
	{
		for (int i = 0 ; i < accessPeriod.size() ; i++) {
			AccessPeriod accessPeriodObj = (AccessPeriod)accessPeriod.get(i);
			if(acessPeriodValue.equals(Integer.toString(i+1)))
			{
				return (accessPeriodObj.getStartAccessPeriod() + " - " + accessPeriodObj.getEndAccessPeriod());
				//System.out.println((i+1) + ". Starting Access Period: " + accessPeriodObj.getStartAccessPeriod() + ", Ending Access Period: " + accessPeriodObj.getEndAccessPeriod());
			}
		}
		System.out.println("Invalid Value");
		return "nill";	
	}

	public static void main(String[] args) throws IOException {
		ArrayList 	accessPeriodList = GlobalAccessPeriodTextRepository.readAccessPeriod();
		getAccessPeriod(accessPeriodList, "5");
	}
		
}
