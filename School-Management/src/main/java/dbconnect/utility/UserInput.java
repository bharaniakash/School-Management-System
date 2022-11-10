package dbconnect.utility;


public class UserInput {
	
	public static boolean checkString(Object obj )
	{
		if(obj.getClass().equals(null))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

}
