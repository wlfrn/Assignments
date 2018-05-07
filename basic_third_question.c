
/*
Compute the factorial of the given number.

Concept: Use of recursion for finding factorial of given number
Base condition is when number<=1 then return 1
Normal flow is return product of number and factorial(number-1)
*/

// Input number only between 1 and 25 because after 25 overflow will occur while calculating the factorial


#include<stdio.h>				//contains all precessor directives and standard input output functions

long long factorial(int number)		//recursive function for finding factorial
{
	if(number<=1)				//base condition for recursive function
	return 1;
	else
	return number*factorial(number-1);	//recursive calling
}
int integerCheck(char *inputValue)
{
	int lengthFirst = strlen(inputValue);	//length of input string
	//length of input string after converting into integer value
	int lengthSecond = strlen(itoa(atoi(inputValue),inputValue,10));
	if(lengthFirst == lengthSecond)	//when both length are same
	{
		if(lengthFirst ==1 && atoi(inputValue)==0)
		return 0;	
		else return 1;
	}
	return 0;
}

int main()						//start of main function
{
	int number;		//declare a number for finding factorial
	char inputValue[10];
	start:printf("Enter a Integral number between 1 and 25\n");
	scanf("%s",inputValue);		//user input for number
	if(integerCheck(inputValue) & atoi(inputValue)>0 & atoi(inputValue)<=25)
	{
		printf("%lld",factorial(atoi(inputValue)));		//displaying the required factorial value
	}
	else
	{
		printf("Invalid Input\n");
		goto start;
	}
	return 0;
}								//end of main function
