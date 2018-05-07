/*
6.	Write a C program to create Stack, write function to PUSH, POP and List Elements.

Concept: define an integer array for stack of mazimum size 100
		In push operation: addition of element at the top till overflow condition
		In pop operation  : deletion of element from the top till underflow condition
		In listing operation: display all the elements of the stack if list is not empty
*/


#include<stdio.h>				//contains all preprecessor directives and standard input output functions
int stack[100];					//declaring integer stack of length 100
int top=-1;						//initializing the top value
void Push(int number)			//function for entering element in stack
{
	if(top+1==100)				//checking overflow condition		
	printf("Overflow condition");
	else
	{
		top++;					//increasing the value of top
		stack[top]=number;		//storing the number in stack
		printf("%d is inserted\n",number);
	}
}
void List()						//function for displaying elements of stack
{
	int i;						//iterators
	if(top==-1)
	printf("Stack is empty\n");
	else
	{
	printf("\nStack elements are: ");
	for(i=0;i<=top;i++)
	printf("%d ",stack[i]);
	}
}
void Pop()
{
	if(top==-1)				//checking the underflow condition
	printf("Underflow condition");
	else
	{
	printf("%d is deleted",stack[top]);
	top--;						//decreasing the value of top
	}
}

int integerCheck(char *inputValue)
{
	int lengthFirst = strlen(inputValue);
	int lengthSecond = strlen(itoa(atoi(inputValue),inputValue,10));
	if(lengthFirst == lengthSecond)
	{
		if(lengthFirst ==1 && atoi(inputValue)==0)
		return 0;		//integer check is false
		else return 1;	//integer check is true
	}
	return 0;
}
int main()
{
	int choice,number;			//defined for choice and push number resp
	char inputValue[10],tempString[10];		//string value of push number and choice
	printf("Integer Stack Implementation");
	do
	{	start:printf("\nPlease select your choice:");
		printf("\n1 for Push");
		printf("\n2 for Pop");
		printf("\n3 for listing");
		printf("\n4 for exit\n");
		printf("Choice\n");
		scanf("%s",tempString);			//string value of choice
			if(integerCheck(tempString))
					{
			
		choice = atoi(tempString);			// integer value of choice
		switch(choice)
		{
			case 1: 
					first:printf("Enter a number to Push\n");
					scanf("%s",inputValue);			//integer value from user
					
					if(integerCheck(inputValue))	//function calling for integer check
					{
					number = atoi(inputValue);	//string into integer value
					Push(number);		//Pushing the given number
					}
					else 
					{
					printf("Invalid Input\n");
					goto first;		//conditional Jump to first
					}
					break;
			case 2:Pop();break;	//Pop function calling
			case 3: List();break;	//List function calling
			case 4:return 0;		//exit condition
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
