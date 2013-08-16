package logic;

import java.text.SimpleDateFormat;

public class CallerFactory {
	public static Caller CreateCaller(String CustomerName, String StartTime, String EndTime, String Note)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
        try
        {
			Caller caller = new Caller();
			
			caller.setCustomerName(CustomerName);
			caller.setNote(Note);
			
			caller.setStartTime(formatter.parse(StartTime));
			caller.setEndTime(formatter.parse(EndTime));
		
		
			return caller;
        }
        catch(Exception e)
        {
        	
        }
        
        return null;
	}
}
