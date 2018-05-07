import java.util.Scanner;

/*Write class Employee which should have constructors and 
 * methods as given below 
 * 
 * Public Employee(String name, double salary)
 * Public void raiseSalary(double byPercent
 * 
 * Define class Manager by
 * extending class Employee. The manager also gets bonus in
 * addition to salary, so the class must have an extra property
 * to set bonus. The get property of salary of manager class\
 * computes salary as sum of base salary and bonus.
 * Also define appropriate properties if required.
 * 
 * Write a Program to instantiate object of the class Employee and
 * Manager and store them in an array of type pointer of Employee.
 * The program must finally display the
 * details of each employee.
 */





/*
 * Class Manager is created which extends the Employee class along
 * with added class memebers bonus
 */
public class Manager extends Employee {
	double bonus;	//for storing bonus of Managers
	
	
	
	/*
	 * initializing the name,salary and bonus of manager
	 */
	public Manager(String tempName,double tempSalary,double tempBonus)
	{
		this.name = tempName;
		this.salary = tempSalary;
		this.bonus = tempBonus;

	}
	
	
	/*
	 * Method for displaying details of Managers
	 */
	public void getDetails()//for printing details of Managers
	{
		System.out.printf("\nName : %s",this.name);
		System.out.printf("\nSalary : %.4f\n",this.salary+this.bonus);
		System.out.println("Manager\n");
	}
	
	
	
	
	/* Method readInt is defined for validation of integral value on given limit 
	 */

	 public static int readInt(String prompt, int min, int max)
	    {
		 Scanner scan = new Scanner(System.in);
	    int number = 0;
	    //Run once and loop until the input is within the specified range.
	    do 
	    {
	        //Print users message.
	        System.out.printf("%s > ", prompt);
	        //Prevent string input crashing the program.
	        while (!scan.hasNextInt()) 
	        {
	            System.out.printf("Invalid Input. Try again.");
	            System.out.printf("\n%s > ", prompt);
	            scan.next(); 
	        }
	        //Set the number.
	        number = scan.nextInt();
	        //If the number is outside range print an error message.
	        if (number < min || number > max)
	            System.out.printf("Invalid Input. Try again.");

	    } while (number < min || number > max);
	    //scan.close();
	    	return number;
	    }
	
	
	
	 
		/* Method readDouble is defined for validation of Decimal and integral value on given limit 
		 */

	 public static double readDouble(String prompt, double min, double max)
	    {
		 Scanner scan = new Scanner(System.in);
	    double number = 0;
	    //Run once and loop until the input is within the specified range.
	    do 
	    {
	        //Print users message.
	        System.out.printf("\n%s > ", prompt);
	        //Prevent string input crashing the program.
	        while (!scan.hasNextDouble()) 
	        {
	        	System.out.printf("Invalid Input. Try again.");
	            System.out.printf("\n%s > ", prompt);
	            scan.next(); 
	        }
	        //Set the number.
	        number = scan.nextDouble();
	        //If the number is outside range print an error message.
	        if (number < min || number > max)
	            System.out.printf("Invalid Input. Try again.");

	    } while (number < min || number > max);
	    	//scan.close();
	    	return number;
	    }
	 
	 /* Method readName is defined for validation of given Name 
		 */
	public static String readName(String prompt)
	{
		Scanner scanner = new Scanner(System.in);
		String name;//for storing temporary name
		while(true)//loop until valid name is not found
			{
			
			name=scanner.nextLine();
		if (!name.matches("[a-zA-Z_ ]+"))//if name is not valid
		    {System.out.println("Invalid name,Try again");
		       System.out.printf("\n%s > ", prompt);
		    }
		   else
		    break;//if name is valid break the loop
		}
		return name;//return name to caller
	}
	
	
	
	
	//start of execution of Program
	 public static void main(String[] args) {
		 //totalEmployee is for taking total no of employee from user
		int totalEmployee = readInt("Please enter total number of Employee",1,Integer.MAX_VALUE);
		
		
		
		/*
		 * Creating an array of Employee to store both object
		 */
		Employee employee[] = new Employee[totalEmployee];
		System.out.println("Please enter the details of Employee");
		String name;//for storing name
		double salary;//for storing salary
		int flag;//for checking whethe employee is Manager or not
		double bonus;//for storing bonus of Manager
		Scanner scanner = new Scanner(System.in);
		
		
		
		/*
		 * iterate for total no of employees and store the details of all
		 * in Employee refernce by creating object of their respective class
		 */
		for(int i=0;i<totalEmployee;i++)
		{
			System.out.printf("For Employee %d",i+1);
			System.out.println("\nName");
			name = readName("Name");//validation for Name
			
			//validation for double and integer salary
			salary = readDouble("Salary",0,Double.MAX_VALUE);
			
			//checking whether employee is manager or not
			flag = readInt("Is this employee a manager\nIf Manager then type 1 else 0",0,1);
			if(flag==0)//employee is not a manager
				{employee[i]=new Employee(name,salary);}
			else//employee is a manager
				{
				bonus = readDouble("Please enter bounus of this Manager",0,Double.MAX_VALUE);
				employee[i]=new Manager(name,salary,bonus);
				}
			
		}
		int choice,employeeNumber;
		double byPercent;
		do
		{
			System.out.println("Please select Your choice");
			System.out.println("1 for Details of Employee");
			System.out.println("2 for Raising salary of Employee");
			System.out.println("3 for Exit");
			choice = readInt("Your choice",1,3);
			switch(choice)
			{
			case 1: //details of Employee
				/*
				 * Printing the details of all employee
				 */
				System.out.println("Details of Employee are");
				for(int i=0;i<totalEmployee;i++)
				{
					employee[i].getDetails();
				}
				break;
				
				
			case 2: //increasing the salary of Employee
				employeeNumber = readInt("Please enter Employee Number as 1,2,3 for increasing salary",1,totalEmployee);
				byPercent = readDouble("Please enter by how much % salary to be increased",0,100);
				employee[employeeNumber].raiseSalary(byPercent);
				
			}
			
		}while(choice!=3);
		scanner.close();
		
		

	}

}//end of program
