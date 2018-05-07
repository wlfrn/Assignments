/*
5.	Reverse a given integer number.

Concept: A number can also be stored in char array in which individual char is storing single digit of given number
and then display the char array from last first which will reverse the number
*/

#include<stdio.h>			//contains all preprecessor directives and standard input output functions
#include<string.h>			//contains functions for strlen
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
int main()					//start of main function
{
	char inputValue[100],i=0;		//declaring character array for storing number make easiest for reversing
	start:printf("Please enter a number: ");	//jump label
	scanf("%s",inputValue);			//input string for number
	if(integerCheck(inputValue))	//function calling for validation of input number
	{
		printf("Reverse of given Number is\n");
		for(i= strlen(inputValue);i>=0;i--)
		printf("%c",inputValue[i]);			//display the number
	}
	else
	{
		printf("Invalid Input\n");		//display invalid input
		goto start;						//conditional jump to start
	}

		
	return 0;
	
}//end of main function
