/*
7.	Write a C program to implement Queue, write function to ENQ, DEQ and List Elements. 

Concept: use of integer array to implement queue of size 100
		In enque operation : addition of element at the end of queue
		In deque operation: deletion of element from front end of queue
		list operation: display all the elements of queue if queue is not empty
*/


#include<stdio.h>				//contains all preprecessor directives and standard input output functions
int queue[100];					//declaring integer queue of length 100
int top=-1;						//initializing the top value
void Enque(int number)			//function for entering element in queue
{
	if(top+1==100)				
	printf("Overflow condition");//checking overflow condition
	else
	{
		top++;					//increasing the value of top
		queue[top]=number;		//storing the number in queue
		printf("%d is inserted\n",number);
	}
}
void List()						//function for displaying elements of queue
{
	int i;						//iterators
	if(top==-1)				//check for empty queue
	printf("Queue is empty\n");
	else
	{
	printf("\nQueue elements are: ");
	for(i=0;i<=top;i++)			//iterate over queue to dispaly elements
	{
	printf("%d ",queue[i]);
	}
	}
}
void Deque()
{
	if(top==-1)				//checking the underflow condition
	printf("Underflow condition");
	else
	{
	int i=0;
	printf("%d is deleted",queue[0]);
	for(i=0;i<top;i++)
	queue[i]=queue[i+1];
	top--;
	}
}

int integerCheck(char *inputValue)
{
	int lengthFirst = strlen(inputValue);
	int lengthSecond = strlen(itoa(atoi(inputValue),inputValue,10));
	if(lengthFirst == lengthSecond)
	{
		if(lengthFirst ==1 && atoi(inputValue)==0)
		return 0;
		else return 1;
	}
	return 0;
}
int main()
{
	int choice,number;
	char inputValue[10],tempString[10];		//string value of enque number and choice
	printf("Integer Queue Implementation");
	do
	{	start:printf("\nPlease select your choice:");
		printf("\n1 for enquing");
		printf("\n2 for dequing");
		printf("\n3 for listing");
		printf("\n4 for exit\n");
		printf("Choice\n");
		scanf("%s",tempString);
			if(integerCheck(tempString))
					{
			
		choice = atoi(tempString);			// integer value of choice
		switch(choice)
		{
			case 1: 
					first:printf("Enter a number to Enque\n");
					scanf("%s",inputValue);			//integer value from user
					
					if(integerCheck(inputValue))	//function calling for integer check
					{
					number = atoi(inputValue);	//string into integer value
					Enque(number);		//Enqueing the given number
					}
					else 
					{
					printf("Invalid Input\n");
					goto first;		//conditional Jump to first
					}
					break;
			case 2:Deque();break;	//Deque function calling
			case 3: List();break;	//List function calling
			case 4:return 0;
			default: printf("Please enter a valid choice");	
		}

}
					else 
					{
					printf("\nPlease enter a valid choice");
					goto start;		//conditional Jump to start
					}
	}while(choice!=4);	//exit condition
		
	return 0;
}	//end of main function
