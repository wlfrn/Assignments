/*Implement class Queue. The class should implement the following operations: 
 * Void add(int x); 
 * Int delete; 
 * Boolean isQueueEmpty() 
 * Boolean isQueueFull() 
 * Void Display 
 * Write a menu driven program which makes use of the Queue class to create the queue
 * of the desired size. The program should prompt the user to select the desired
 * option and then take appropriate action based on the user choice.
 * The user should be provided exit functionality.import java.util.Scanner;
 */

import java.util.Scanner;



/*
 * Abstract class Queue is defined for above functionalities
 */
abstract class Queue{

	/*
	 * class members array,tail and size is used for initializing the queue
	 */
	protected int[] array;	//used for queue
	protected int tail;		//for updating the tail of queue
	protected int size;		//size of queue from user input
	
	
	/*
	 * Method for addition of element in queue
	 */
	protected void add(int x)	//function for addition of element at end
	{
		if(tail + 1==size)		//overflow condition
		{
			System.out.printf("Overflow condition, %d cannot be entered",x);
		}
		else					//normal flow condition
		{
			tail++;
			array[tail]=x;		//increasing the size of queue
			System.out.printf("\n%d is added successfully",x);
		}
	}
	
	
	
	/*
	 * Method for displaying all the elements of queue
	 */
	protected void Display()
	{
		if(tail==-1)			//Empty condition
			System.out.println("Queue is empty\n");
		else					//normal flow condition
		{
			System.out.print("Queue elements are: ");
			for(int i=0;i<=tail;i++)//iterating over queue to print elements
				System.out.printf("%d ", array[i]);
		}
	}
	
	
	
	/*
	 * Method for Checking if queue is empty or not
	 */
	protected boolean isQueueEmpty()
	{
		if(tail==-1)	//if tail of queue is null
			return false;
		else
			return true;
	}
	
	
	
	/*
	 * Method for checking if queue is full or not
	 */
	protected boolean isQueueFull()
	{
		if(tail==size-1)	//if tail of queue is equal to its size
			return false;
		else
			return true;
	}
	
	
	/*
	 * Method for deleting head of queue
	 */
	protected int delete()
	{
		if(tail==-1)		//condition for underflow
			return -1010101010;
		else
		{
			int temp=array[0];		//head of queue
			for(int i=0;i<tail;i++)
			{
				array[i]=array[i+1];	//updating the adjacent elements of queue
			}
			tail--;					//decreasing the value of tail
			return temp;
			
		}
	}
	
}



/*
 * QueueCreator class which extends the Queue abstract class is used to define all the 
 * queue operations
 */
public class QueueCreator extends Queue {
	QueueCreator(int length)
	{
		array = new int[length];//allocating memory to queue from user input
		tail=-1;				//making it null
		size = length;			//size of queue

		System.out.printf("Queue of size %d is created",length);
	}
	
	
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
	public static void main(String[] args)//start of main function
	{
		int size = readInt("Please enter the size of Queue",1,Integer.MAX_VALUE);
		QueueCreator queueCreator = new QueueCreator(size);
		int choice;//for storing choice of user from given all choices
		int number;//for storing number from user for entering into queue
		do {
			
			System.out.println("\nPlease select your choice: ");
			System.out.println("1 for add");
			System.out.println("2 for delete");
			System.out.println("3 for isQueueEmpty");
			System.out.println("4 for isQueueFull");
			System.out.println("5 for display");
			System.out.println("6 for exit");
			choice = readInt("Your choice",1,6);//input validation call
			switch(choice)
			{
			case 1: //for adding the given element into queue
					number = readInt("Please enter an element to add",Integer.MIN_VALUE,Integer.MAX_VALUE);
					queueCreator.add(number);
					break;
					
					
			case 2: //for deletion of head of queue
					number = queueCreator.delete();
					if(number==-1010101010)
						System.out.println("\nUnderflow condition");
					else
						System.out.printf("\n%d is deleted", number);
					break;
					
					
			case 3: //for checking if queue is empty or not
					if(queueCreator.isQueueEmpty())
						System.out.println("Queue is empty");
					else
						System.out.println("Queue is not empty");
					break;
					
			case 4: //for checking if queue is full or not
					if(queueCreator.isQueueFull())
						System.out.println("Queue is full");
					else
						System.out.println("Queue is not full");
					break;
					
			case 5: //for dispalying all elements of queue
					queueCreator.Display();
					break;
					
			case 6://Exit condition for Program
					System.out.println("Program Exited");break;
			}
		}while(choice!=6);
		
			
	}

}

