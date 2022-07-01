package stuRes;

import java.util.HashMap;

public class CourseDetails 
{
	public static HashMap<Integer, String>  CS = null ;
	
	static
	{
		CS = new HashMap<Integer, String>();
	}
	
	CourseDetails()
	
	{	
		CS.put(1, "DataEngineer");
		CS.put(2, "JavaFullstackMicroservicesDeveloper");
		CS.put(3, "MachineLearning");
			
	}	
}
