/*Write a class Time to represent Time with the following data members:
 *  Hours, minutes,seconds and methods to add seconds, minutes, hours,
 *   display, time etc. Use appropriate get/set properties.
 */




/*
 * Abstract class time is defined for getting and setting time
 */
abstract class Time {
	
	/*
	 * class vairables  ared hours,minutes and second for storing resp value
	 */
	int hours;
	int minutes;
	int seconds;
	
	
	/*
	 * Method for calculating the time
	 */
	public void set()
	{
		long milliSeconds = System.currentTimeMillis();
		seconds = (int)((milliSeconds / 1000) % 60);
		minutes = (int)((milliSeconds / (1000 * 60)+30) % 60);
		hours = (int)((milliSeconds / (1000 * 60 * 60)+5) % 24);
		//Our time is faster from UTC time by 5 hours and 30 minutes
		
	}
	
	/*
	 * Method for displaying Time
	 */
	public void get()
	{
		System.out.printf("Time is %d hours %d minutes and %d seconds",hours,minutes,seconds);
	
	}
	
	
	/*
	 * Default Constructor for initializing values of hours, minutes and seconds
	 */
	Time(){
		hours=0;
		minutes=0;
		seconds=0;
	}
}




/*
 * TimeCalculator class is defined which extends the Time class to get
 * and set the time.
 */
public class TimeCalculator extends Time{

	public static void main(String[] args) {

		TimeCalculator timeCalculator = new TimeCalculator();
		timeCalculator.set();//for calculating the current Time
		timeCalculator.get();//for displaying the Time

	}

}



