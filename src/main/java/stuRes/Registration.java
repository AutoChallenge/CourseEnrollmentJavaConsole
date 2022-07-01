package stuRes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Registration 
{
	public String 	firstName;
	public String 	lastName;
	public int 	    mobileNumber;
	public String 	state;
	public String 	email;
	public String 	paswd;
	public String 	course;
	
	protected List<String> CSA = new ArrayList <String>();
	protected HashMap<Integer,List <String>> CSL = new HashMap <Integer,List <String>>();
	protected HashMap<Integer, Registration> RG = new HashMap <Integer,Registration>();
	
	
	Registration(){
		
	}
	
	
	public Registration (String firstName, String lastName, int mobileNumber,String state,String email,String paswd){
        this.firstName 		= firstName;
        this.lastName 		= lastName;
        this.mobileNumber 	= mobileNumber;
        this.state			= state;
        this.email			= email;
        this.paswd			= paswd;
    }
	
	/*
	 * public void list01() { System.out.println(RG); }
	 */
	
	
	public String toString()
	{
		return firstName+"  |  "+lastName+"  |  "+mobileNumber+"  |  "+state+"   |  "+email+"  |  "+paswd;
	}
}
