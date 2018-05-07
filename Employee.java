/*Write class Employee which should have constructors and 
 * methods as given below 
 * 
 * Public Employee(String name, double salary)
 * Public void raiseSalary(double byPercent)
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
 * Class Employee is created to store name and salary of Employee along with
 * two Method 
 * Public Employee(String name, double salary)
 * Public void raiseSalary(double byPercent)
 */
public class Employee {
	String name;	//for storing name
	double salary;	//for storing salary
	
	public Employee() {}//default constructor
	
	
	
	/*
	 * Constructor for initializing the name and salary of Employee
	 */
	public Employee(String tempName,double tempSalary)
	{
		this.name = tempName;
		this.salary =tempSalary;
	}
	
	
	
	
	/*
	 * Method for increasing the salary of Employee
	 */
	public void raiseSalary(double byPercent)
	{
		this.salary = salary + (byPercent * salary)/100;
	}
	
	
	
	/*
	 * Method for displaying the details of Employee
	 */
	public void getDetails()//printing details of Employee
	{
		System.out.printf("\nName : %s",this.name);
		System.out.printf("\nSalary : %.4f\n",this.salary);
	}

}
