/* Implement a class List to hold numbers. The class should support the following operations: 
 * (a) Void add(int x)
 * (b) Boolean delete(int x) 
 * (c) Int delete(long index) 
 * (d) Void deleteAll() 
 * (e) Boolean search(int x) 
 * (f) Void insert(int x, int index) 
 * (g) List sort() (h) Void append(int x) 
 * (i) Void display() 
 * (j) Int get(int index) 
 */



import java.util.Scanner;

/* This Abstract class List is created for defining all the above operations */
abstract class List {
	protected int[] array;	//for storing list
	protected int top;		//for keeping track of element
	protected int size;		//size of list from user input
	
	
	
	/* 
	 * Method for addition of element at end
	 */
	protected void add(int x)
	{
		if(top + 1==size)//overflow condition
		{
			System.out.printf("Overflow condition, %d cannot be entered",x);
		}
		else			//normal flow condition
		{
			top++;		//increasing the value of top by 1
			array[top]=x;//update the list
			System.out.printf("\n%d is added successfully",x);
		}
	}
	
	
	
	/*
	 * Method for displaying all the elements of list
	 */
	protected void display()
	{
		if(top==-1)	//if list is empty
			System.out.println("List is empty\n");
		else		//list is not empty
		{
			System.out.print("List elements are: ");
			for(int i=0;i<=top;i++)	//traverse over the complete list
				System.out.printf("%d ", array[i]);	//print the individual elements
		}
	}
	
	
	
	/*
	 * Method for finding the index of given number
	 */
	protected int searchIndex(int number)
	{
		int index=-1;	//making index to null
		for(int i=0;i<=top;i++)	//traversing over the list elements
		{
			if(array[i]==number)//if list element and given number are equal
				index=i;        //update the index value
		}
		return index;			//return the index value
	}
	
	
	
	/*
	 * Method for searching a given number in list
	 */
	protected boolean search(int number)

	{
		int flag=0;//used for checking presence of given element in list
		for(int i=0;i<=top;i++)//traversing over the required list
		{
			if(array[i]==number)//if list element and given number is equal
				flag=1;			//update the flag value
		}
		if(flag==1)				//element is found
			return true;
		else
			return false;		//element is not found
	}
	
	
	
	/*
	 * Method for deleting the given number from list
	 */
	protected boolean delete(int number)
	{
		int index = searchIndex(number);//before deletion element have to be searched
		if(index>=0)	//if the given index to be deleted is greater= than 0
			{
			
			for(int i=index;i<top;i++)//traversing over the required list
			{
				array[i]=array[i+1];//shifting the elements to left
			}
			top--;return true;		//decreasing the value of top by 1
			}
		else
			return false;
	}
	
	
	
	/*
	 * Method for deleting element at given index from the list
	 */
	protected int delete(long index)
	{
		 if(index>top) return 0;	//deletion index greater than all list elements
		else
		{
			for(int i=(int)index;i<top;i++)//traversing over the required list elements
				array[i]=array[i+1];		//updating the adjacent elements
			top--;							//decreasing the value of top
			return 1;
		}
	}
	
	
	/*
	 * Method for sorting the list is ascending order,Binary Sort is used
	 */
	protected void sort()	//function for sorting
	{
		for(int i=0;i<top;i++)	//outer loop for traversing all the elements
		{
			for(int j=0;j<=top-i-1;j++) //inner loop for swapping
			{
				if(array[j]>array[j+1]) //first element is greater than second element
				{
					int temp;			//swapping element using third variable
					temp = array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
		}
		display();
	}
	
	
	
	/*
	 * Method for inserting given number at given index
	 */
	protected void insert(int number,int index) {
		if(top + 1==size)	//condition of overflow
		System.out.printf("\nOverflow condition, %d cannot be inserted",number);
		else if(index >=size)	//index greater than zero
		{
			System.out.printf("\nOverflow condition, %d cannot be inserted",number);
		}
		else if(index >top & index <=size)	//when index greater than top
		{
			array[index]=number;
			top = index;
		}
		else
		{
			for(int i=top;i>=index;i--) //traversing over the required elements
			{
				array[i+1]=array[i];	//shifting the elements to right
			}
			array[index]=number;		//updating the element at index
			top++;						//increasing the value of top
			System.out.println("Element successfully inserted");
		}
	}
	
	
	
	/*
	 * Method for finding the index of given element from list
	 */
	protected int get(int index)
	{
		if(index>=size) return -1010101010;	//index greater than size
		else return array[index];		//return the element at particular index
	}
}






public class ListCreator extends List {
	
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
	            System.out.printf("Invalid Iput. Try again.");

	    } while (number < min || number > max);
	    //scan.close();
	    	return number;
	    }
	ListCreator(int length)
	{
		array = new int[length];//allocating memory to queue from user input
		top=-1;				//making it null
		size = length;			//size of queue

		System.out.printf("List of size %d is created",length);
	}
	public static void main(String[] args)//start of main function
	{
		int size = readInt("Please enter the size of the list",0,Integer.MAX_VALUE);
		
		ListCreator listCreator = new ListCreator(size);//user input for size of queue
		int choice;
		int number,index;
		do {
			
			System.out.println("\nPlease select your option: ");
			System.out.println("1 for add");
			System.out.println("2 for delete");
			System.out.println("3 for deletion at index");
			System.out.println("4 for deleteAll");
			System.out.println("5 for search");
			System.out.println("6 for insert at index");
			System.out.println("7 for sort");
			System.out.println("8 for append");
			System.out.println("9 for display");
			System.out.println("10 for get element at index");
			System.out.println("11 for exit");
			choice = readInt("Your Choice",0,11);
			switch(choice)
			{
			case 1: // for addition of integer value
					number = readInt("Please enter an element to add",Integer.MIN_VALUE,Integer.MAX_VALUE);
					listCreator.add(number);
					break;
						
					
			case 2: //for deletion of given number
					System.out.println();
					number = readInt("Please enter element to be deleted",Integer.MIN_VALUE,Integer.MAX_VALUE);
					if(listCreator.delete(number))
						System.out.println("Successfully deleted");
					else
						System.out.println("Element is not present so can't be deleted");
					break;
					
					
			case 3: //for deletion at given index
					index = readInt("Please enter index to be deleted",0,Integer.MAX_VALUE);
					int flag = listCreator.delete(((long)index));
					if(flag==1)
						System.out.println("Successfully deleted");
					else
						System.out.println("Index is greater or equal to the size of list,So can't be deleted");
					break;
						
					
			
			case 4://for deletion of all the elements from list
					System.out.println("All elements successfully deleted");
					listCreator.top=-1;
					break;			
						
			
			case 5: //for searching given element in the list
					number = readInt("Enter number to search",Integer.MIN_VALUE,Integer.MAX_VALUE);
					if(listCreator.search(number))
					System.out.println("Element is found in list");
					else
					System.out.println("Element is not found in list");	
					break;
					
					
			case 6://for insertion given element at given index
					number = readInt("Please enter element",Integer.MIN_VALUE,Integer.MAX_VALUE);
					index = readInt("Please enter the index",0,Integer.MAX_VALUE);
					listCreator.insert(number,index);
					break;
					
					
			case 7://for sorting all the elements in ascending order
					listCreator.sort();
					break;
					
					
			case 8: //for append the element 
					number = readInt("Please enter an element to append",Integer.MIN_VALUE,Integer.MAX_VALUE);
					listCreator.add(number);
					break;
					
					
			case 9://for displaying all the element in the list
					listCreator.display();
					break;
					
					
			case 10://for getting the element at given index
					index = readInt("Please enter index to be found",0,Integer.MAX_VALUE);
					index = listCreator.get(index);
					if(index == -1010101010) {
						System.out.println("Index out of Range of list");}
					else
						System.out.printf("Element at given index is %d",index);
					break;
					
					
			case 11://exit condition from Program
					System.out.println("Program is exited");
			break;
					default: System.out.println("You have entered wrong choice");
				
			}
		}while(choice!=11);
		
			
	}

}



