/*Implement a class Complex which should provide methods to perform the following operations
 * on complex numbers 
 *Addition, Subtraction 
 *Implement using static as well as non-static (instance) methods
 */

import java.util.Scanner;




/*Abstract class Complex is defined for calculating the addition and substraction of 
 * two given imaginary numbers.It contain static method for addition and non static method for 
 * substraction of two imaginary numbers
 */
abstract class Complex {
	
	//Defined for addition of two imaginary numbers
	public static void Addition(double firstNumberReal,double firstNumberImg,double secondNumberReal,double secondNumberImg)
	{
		System.out.print("Addition of given two complex numbers is: ");
		System.out.print((firstNumberReal+secondNumberReal)+" + " + (firstNumberImg+secondNumberImg)+"i");
	}
	
	
	//Defined for substraction of two imaginary numbers
	public void Substraction(double firstNumberReal,double firstNumberImg,double secondNumberReal,double secondNumberImg)
	{
		if(firstNumberImg >= secondNumberImg)
		{
		System.out.print("\nSubstraction of given two complex numbers is: ");
		System.out.print((firstNumberReal-secondNumberReal)+" + " + (firstNumberImg-secondNumberImg)+"i");
		}
		else
			{
			System.out.print("\nSubstraction of given two complex numbers is: ");
			System.out.print((firstNumberReal-secondNumberReal)+" " + (firstNumberImg-secondNumberImg)+"i");
			}
			}
		
}


public class ComplexCalculator extends Complex
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
	 //allocating memory to complexCalculator object
	 ComplexCalculator complexCalculator = new ComplexCalculator();
	 
	 double firstNumberReal,secondNumberReal;//storing real part of two numbers
	 double firstNumberImg,secondNumberImg;//storing imaginary part of two numbers
	 
	 /* readDouble function is used for storing the value of all with validation
	  * 
	  */
	 
	 
	 firstNumberReal = readDouble("Please enter real part of first number",Double.MIN_VALUE,Double.MAX_VALUE);
	 firstNumberImg = readDouble("Please enter imaginary part of first number",Double.MIN_VALUE,Double.MAX_VALUE);
	 secondNumberReal = readDouble("Please enter real part of second number",Double.MIN_VALUE,Double.MAX_VALUE);
	 secondNumberImg = readDouble("Please enter real part of second number",Double.MIN_VALUE,Double.MAX_VALUE);
	 
	 
	 /*call of static Addition function
	  */
	 Addition(firstNumberReal, firstNumberImg, secondNumberReal, secondNumberImg);
	 
	 
	 /*call of non static Substraction function
	  */
	 complexCalculator.Substraction(firstNumberReal, firstNumberImg, secondNumberReal, secondNumberImg);
	 
 }
 
}
