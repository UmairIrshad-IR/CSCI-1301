/*
 * [ClassifyMessage].java
 * Author:  [Umair Irshad] 
 * Submission Date:  [2/17/2023]
 *
 * Purpose: This program takes user inputs for a formatted message and gives it a category latitude 
 * and longitude coordinates etc.
 *
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 * or the course textbook. I recognize that any unauthorized
 * assistance or plagiarism will be handled in accordance with
 * the University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based
 * on an assignment created by the Department of Computer
 * Science at the University of Georgia. Any publishing 
 * or posting of source code for this assignment is strictly
 * prohibited unless you have written consent from the Department
 * of Computer Science at the University of Georgia.  
 */
import java.util.Scanner;
public class ClassifyMessage {
	

		//Enum to hold category
		enum MessageCategory
		{
			NEED,OFFER,ALERT,INFO,UNKNOWN;
		}

		static String catString;
		static String payLoad;
		static double latitude;
		static double longitude;
		static boolean isInRange;
		static MessageCategory category;
		//Constants
		
		static final double south=39.882343; //southernmost latitude
		static final double north=40.231315; //northernmost latitude
		static final double west=-105.743511; //westernmost longitude
		static final double east=-104.907864; ////easternmost longitude
		
		public static void main(String args[])
		{


		//Get user input
		Scanner keyboard =new Scanner(System.in);
		System.out.println("Please enter a formatted message:");
		catString=keyboard.next();
		latitude=keyboard.nextDouble();
		longitude=keyboard.nextDouble();
		payLoad=keyboard.nextLine().trim();
		
		
		//Check and assign category
		if(catString.equalsIgnoreCase("Fire")||catString.equalsIgnoreCase("Smoke"))
			category=MessageCategory.ALERT;
		
		else if(catString.equalsIgnoreCase("need"))
			category=MessageCategory.NEED;
		
		else if(catString.equalsIgnoreCase("offer"))
			category=MessageCategory.OFFER;
		
		else if(catString.equalsIgnoreCase("Structure")||catString.equalsIgnoreCase("Road")||
				catString.equalsIgnoreCase("Photo")||catString.equalsIgnoreCase("evac"))
			category=MessageCategory.INFO;
		
		else
			category=MessageCategory.UNKNOWN;
		
		
		
		//Check and assign isInRange
		if(latitude>=south && latitude<=north && longitude>=west && longitude<=east)
			isInRange=true;
		
		
		//Display details
		System.out.println("Category:\t"+category);
		System.out.println("Raw Cat:\t"+catString);
		System.out.println("Message:\t"+payLoad);
		System.out.println("Latitude:\t"+latitude);
		System.out.println("Longitude:\t"+longitude);
		System.out.println("In Range:\t"+isInRange);
		keyboard.close();
	}
}