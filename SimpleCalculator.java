/*Write a class Calculator to implement the following simple arithmetic operations:
 * Addition, Subtraction, Division and Multiplication All the methods should be static
 *  Also make sure that it should not possible to instantiate the class
 */


import java.util.Scanner;




/*Abstract class Simple is defined for calculating the addition and substraction,multiplicaton
 * and division of 
 * two given numbers.It contain static method for all the different operations
 * 
 */
abstract class Simple {
	
	//static method defined for addition of two numbers
	public static void Addition(double firstNumber,double secondNumber)
	{
		System.out.print("Addition of given two numbers is: ");
		System.out.print((firstNumber+secondNumber));
	}
	
	
	//static method defined for substraction of two numbers
	public static void Substraction(double firstNumber,double secondNumber)
	{
			System.out.print("\nSubstraction of given two numbers is: ");
			System.out.print((firstNumber-secondNumber));	
	}
	

	//static method defined for multiplication of two numbers
		public static void Multiplication(double firstNumber,double secondNumber)
		{
				System.out.print("\nMultiplication of given two numbers is: ");
				System.out.print((firstNumber*secondNumber));	
		}
		
		
		//static method defined for division of two numbers
				public static void Division(double firstNumber,double secondNumber)
				{
						if(secondNumber==0)
							System.out.println("Division by zero error");
						else
							{
							System.out.print("\nSubstraction of given two numbers is: ");
						System.out.print((firstNumber-secondNumber));	
							}
				}
}


public class SimpleCalculator extends Simple
{
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
 
 
 
 
 //start of main function
 public static void main(String args[])
 {
	  double firstNumber,secondNumber;//storing two numbers
	 
	 /* readDouble function is used for storing the value of all with validation
	  * 
	  */
	 
	 
	 firstNumber = readDouble("Please enter first number",Double.MIN_VALUE,Double.MAX_VALUE);
	 secondNumber = readDouble("Please enter second number",Double.MIN_VALUE,Double.MAX_VALUE);
	 
	 
	 /*call of static Addition function
	  */
	 Addition(firstNumber,secondNumber);
	 
	 
	 /*call of static Substraction function
	  */
	 Substraction(firstNumber, secondNumber);
	 
	 
	 /*call of static Multiplication function
	  */
	 Multiplication(firstNumber, secondNumber);
	 
	 
	 /*call of static Division function
	  */
	 Division(firstNumber, secondNumber);
	 
 }
 
}
