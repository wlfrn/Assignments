/*
 * Write a class “ThreeDimObject” and define overloaded methods name volume() to calculate
 *  the volumes of various 3D-Objects (cube, cuboid, sphere and cylinder) 
 */


import java.util.Scanner;




/* Abstract class ThreeDimObject is defined for calculating the Volume of 
 * Cube,Cuboid,Sphere,Cylinder using overloaded methods
 */
abstract class ThreeDimObject {
	public void Volume(double side)
	{
		System.out.printf("Volume of cube with side %.2f is : %.2f\n\n",side ,side* side * side);
	}
	public void Volume(double length, double breadth, double height)
	{
		System.out.printf("\nVolume of cuboid with dimension %.2f , %.2f, %.2f is : %.2f \n\n",length,breadth,height, length * breadth * height);
	}
	public void Volume(double radius, char s)
	{
		System.out.printf("\nVolume of Sphere with radius %.2f is: %.2f\n\n",radius, ((4.0 * 22 * radius * radius * radius)/(3 * 21)));
	}
	public void Volume(double radius, double height)
	{
		System.out.printf("\nVolume of Cylinder with radius %.2f and height %.2f is: %.2f\n\n",radius,height, ( 22 * radius * radius * height)/3);
	}
}






/* VolumeCalculator is defined which extends the ThreeDimObject
 * 
 */
public class VolumeCalculator extends ThreeDimObject{
	
	/* Method readInt is defined for validation of Integeral Value on given limit 
	 */
	 public static int readInt(String prompt, int min, int max)
	    {
		 Scanner scan = new Scanner(System.in);
	    int number = 0;
	    //Run once and loop until the input is within the specified range.
	    do 
	    {
	        //Print users message.
	        System.out.printf("\n%s > ", prompt);
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
	            System.out.printf("Invalid Iput. Try again.");

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
	 
	public static void main(String args[])
	{
	    
		VolumeCalculator volumeCalculator = new VolumeCalculator();
		int choice=0;//for storing the choice of user from given 5 choices
		double side,length,breadth,height,radius;//for storing dimensions of 3D objects
		while(choice!=5)
		{
			System.out.println("You want Volume calculator for");
			System.out.println("1 for Cube");
			System.out.println("2 for Cuboid");
			System.out.println("3 for Sphere");
			System.out.println("4 for Cylinder");
			System.out.println("5 for Exit");
			choice = readInt("Your choice",1,5);
			switch(choice)
			{
			
			case 1: //Cube
			side = readDouble("Please enter the side of Cube",0.0,99999999.0);
			volumeCalculator.Volume(side);//Method calling for Volume
			break;
			
			
			case 2: //Cuboid
				length = readDouble("Please enter the Length of Cuboid",0.0,99999999.0);
				breadth = readDouble("Please enter the Breadth of Cuboid",0.0,99999999.0);
				height = readDouble("Please enter the Heigth of Cuboid",0.0,99999999.0);
				volumeCalculator.Volume(length,breadth,height);//Method calling for Volume
				break;
				
			
			case 3: //Sphere
				radius = readDouble("Please enter the radius of Sphere",0.0,99999999.0);
				volumeCalculator.Volume(radius,'S');//Method calling for Volume
				break;
				
				
			case 4: //Cylinder
				radius = readDouble("Please enter the radius of Cylinder",0.0,99999999.0);
				height = readDouble("Please enter the height of Cylinder",0.0,99999999.0);
				volumeCalculator.Volume(radius,height); //Method calling for Volume
				break;
			case 5:System.out.println("Program exited");
				
			}
		}
			
			
			
			
			
			
			
	}
}
