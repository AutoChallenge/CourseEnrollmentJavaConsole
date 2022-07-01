package stuRes;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuOptions extends Registration
{

	// Declaring ANSI_RESET so that we can reset the color
	//public static final String ANSI_RESET = "\u001B[0m";

	// Declaring the color
	// Custom declaration
	//public static final String ANSI_YELLOW = "\u001B[33m";

	static Scanner sc = new Scanner(System.in);

	public static String 	firstName;
	public static String 	lastName;
	public static int 	mobileNumber;
	public static String 	state;
	public static String 	email;
	public static String 	paswd;
	public static int 	courseNo;
	public static int 	loginReg;

	public static boolean loginSuccess;

	public void registration() {
		System.out.println("\u2663 "+"1-Student Registration : "); 
		System.out.println("\nEnter firstName");
		firstName = sc.next();

		System.out.println("\nEnter lastName");
		lastName = sc.next();

		System.out.println("\nEnter mobileNumber");
		mobileNumber = sc.nextInt();

		System.out.println("\nEnter state");
		state = sc.next();

		System.out.println("\nEnter email");
		email = sc.next();

		System.out.println("\nEnter paswd");
		paswd = sc.next();

		RG.put(mobileNumber,new Registration(firstName, lastName, mobileNumber, state, email, paswd));
		System.out.println(RG);

	}

	public boolean login() {
		loginSuccess=false;
		System.out.println("\u2663 "+"2-Student Login : "); 

		System.out.println("\nEnter mobileNumber");
		mobileNumber = sc.nextInt();

		System.out.println("\nEnter paswd");
		paswd = sc.next();
		try {
			if((RG.get(mobileNumber).paswd).equals(paswd)) {
				System.out.println(" Successfully login into student portal :: Welcome "+ firstName);
			}
			else {
				System.out.println(" Please enter the Correct Password ");
			}
		}
		catch(Exception e) {
			System.out.println(" Please enter the Correct mobileNumber "+RG);
			e.printStackTrace();
			main();
		}
		loginSuccess=true;
		return loginSuccess;

	}

	public void courseDetails() {
		//Map<Integer,String> result = new HashMap<>();
		new CourseDetails().CS.entrySet()
		.stream()
		.forEach(entry -> System.out.println(entry.getKey()+"."+entry.getValue()));
		System.out.println("\u2663 "+"3-Choose Course Number: "); 
		courseNo = sc.nextInt();

		String cname="";

		var wrapper = new Object(){ String value = ""; };

		new CourseDetails().CS.entrySet()
		.stream()
		.filter(entry -> entry.getKey() == courseNo)
		.forEach(entry ->
		{
			System.out.println(entry.getValue().toString());
			String cname1=entry.getValue().toString();
			{
				{ wrapper.value += cname1; }
			}
		});
		cname=wrapper.value;

		CSA.add(cname);
		CSL.put(mobileNumber, CSA);

	}

	public void studentDetails() {
		System.out.println("\u2663 "+"4-Student Details : "); 
		System.out.println("\nEnter Student UserName/MobileNumber");
		mobileNumber = sc.nextInt();
		Registration re=new Registration("John1","Willam1",12,"CA1","jw1@gmail.com","121");
		RG.put(23, new Registration("John1","Willam1",12,"CA1","jw1@gmail.com","121"));
		System.out.println(re.RG);
		System.out.println(RG.get(mobileNumber));
		System.out.println("***");
		RG.entrySet()
		.stream()
		.filter(entry -> entry.getKey() == mobileNumber)
		.forEach(entry -> System.out.println(entry.getKey()+"."+entry.getValue()));


		CSL.entrySet()
		.stream()
		.filter(entry -> entry.getKey() == mobileNumber)
		.forEach(entry -> System.out.println(entry.getKey()+"."+entry.getValue()));

		System.out.println("***");
	}

	public void courseCancellation() {
		System.out.println("\u2663 "+"5-Course Cancellation : "); 
		System.out.println("\nEnter Student UserName/MobileNumber");
		mobileNumber = sc.nextInt();

		CSL.entrySet()
		.stream()
		.filter(entry -> entry.getKey() == mobileNumber)
		.forEach(entry -> System.out.println(entry.getKey()+"."+entry.getValue()));

		System.out.println("You have registered No. of courses : " +CSL.get(mobileNumber).size());

		System.out.println("Please enter the One course Name at a time to Cancel");

		course = sc.next();
		CSL.get(mobileNumber).removeIf(language -> language.equalsIgnoreCase(course));     // Its remove all element which satisfied predicate condition.
		System.out.println(CSL.get(mobileNumber));
	}







	public static void main(String... g)
	{
		new MenuOptions().m1();
	}
	public void m1() {
		//new Registration();
		RG.put(12, new Registration("John","Willam",12,"CA","jw@gmail.com","12"));
		RG.put(23, new Registration("Rober","Trimble",23,"WA","rt@gmail.com","23"));
		System.out.println(RG.get(12));
		int ch = 0;
		String ct="";

		M1:while(true)
		{
			System.out.println(ANSIConstants.ANSI_BLUE+"Main Menu");
			System.out.println("1: Student Registration ");
			System.out.println("2: Student Login");
			System.out.println("3: Choose Course");
			System.out.println("4: Student Details");
			System.out.println("5: Course Cancellation");

			System.out.println("\nEnter your choice : ");

			ch = sc.nextInt();

			switch(ch)
			{
			//1: Student Registration 
			case 1: 
				registration();	
				break;
				//2: Student Login
			case 2:
				login();
				break;

				//3: Choose Course
			case 3:	

				if(loginSuccess) {
					courseDetails();
				}
				else {
					System.out.println("\n Please choose \n 1. Login \n 2. Registration");
					loginReg = sc.nextInt();
					if(loginReg==1) {
						login();
					}
					else if(loginReg==2) {
						registration();	
					}
					courseDetails();
				}
				break;
				//4: Student Details
			case 4:
				studentDetails();
				break;
				//5: Course Cancellation
			case 5:	         
				courseCancellation();
				break;

			}
			System.out.println("\nDo you want to continue: [y/n]");
			ct = sc.next(); // if there is another number  

			if(ct.equals("N") || ct.equals("n"))
			{
				System.exit(0);

			}  // end if

		} // end while 

	}	// end main
} // end class
