/*
 * [GradeCalculator].java
 * Author:  [Umair Irsahd] 
 * Submission Date:  [02/24/2023]
 *
 * Purpose: This programs takes user inputs for grades and tells you your current letter grade and average needed to get the target letter grade.
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
 * or posting of source code for this project is strictly
 * prohibited unless you have written consent from the Department
 * of Computer Science at the University of Georgia.  
 */
import java.util.Scanner;
public class GradeCalculator {

	public static void main(String[] args) {

	  
		//VARIABLES
		
		 int Exam1_Score;
		 int Exam2_Score;
		 int finalExamScore;
		 int LabScore;
		 int projectScore;
		 int participationScore; 
		 int quizScore;
		 
		 int exam1Weight;
		 int exam2Weight;
		 int finalExamWeight;
		 int labsWeight;
		 int projectsWeight;
		 int participationWeight;	
		 int quizzesWeight;

		 double finalOverallScore = 0;
	     double avgToFinalLetterGrade; 
	     double totalKnownGradeWeight = 0;
	     double currentScore; 
	     double currentScoreTop = 0;
	     
	     //SCANNER
		 Scanner keyboard = new Scanner(System.in);

	     String letterGrade;
	     String yesNo;
	     
	     System.out.println("Grading Scale:");
		 System.out.println("A\t 90 - 100"); 
		 System.out.println("B\t 80 - 89"); 
		 System.out.println("C\t 70 - 79"); 
		 System.out.println("D\t 60 - 69"); 
		 System.out.println("F\t below 60"); 
		 
		 //TARGET LETTER GRADE
		 System.out.print("What letter grade do you want to achieve for the course?: ");
		 letterGrade = keyboard.nextLine();
		 	if(letterGrade.equals("A")) {
 	        	finalOverallScore = 90;
		 	} else if (letterGrade.equals("B")) {
 	        	finalOverallScore = 80;

		 	} else if (letterGrade.equals("C")) {
 	        	finalOverallScore = 70;

		 	} else if (letterGrade.equals("D")) {
 	        	finalOverallScore = 60;

		 	} else if (letterGrade.equals("F")) {
 	        	finalOverallScore = 0;
		 	} else { 
		 		System.out.println("The input is invalid.");
		 		System.exit(0);
		 	}
		 	
		 	
		 	//WEIGHTS
				System.out.println("Enter percentage weights below.");
				System.out.print("Exam 1:\t\t");
			 	exam1Weight = keyboard.nextInt();		
				System.out.print("Exam 2:\t\t");
			 	exam2Weight = keyboard.nextInt();		
			 	System.out.print("Final Exam:\t");
			 	finalExamWeight = keyboard.nextInt();		
				System.out.print("Labs:\t\t");
				labsWeight = keyboard.nextInt();		
				System.out.print("Projects:\t");
				projectsWeight = keyboard.nextInt();		
				System.out.print("Participation:\t");
				participationWeight = keyboard.nextInt();		
				System.out.print("Quizzes:\t");
				quizzesWeight = keyboard.nextInt();
				keyboard.nextLine();
				
				
				//COMPUTATION/scores
				int weights = exam1Weight + exam2Weight + finalExamWeight + labsWeight + projectsWeight + participationWeight + quizzesWeight;
					if (weights == 100) {
						System.out.print("Do you know your exam 1 score? ");
						yesNo = keyboard.nextLine();
						if(yesNo.equalsIgnoreCase("y") || yesNo.equalsIgnoreCase("yes")){	
							System.out.print("Score received on exam 1: ");
							Exam1_Score = keyboard.nextInt();
							keyboard.nextLine();
							totalKnownGradeWeight += exam1Weight;
							currentScoreTop += (exam1Weight * Exam1_Score);
							System.out.print("Do you know your exam 2 score? ");
							yesNo = keyboard.nextLine();
			 				if(yesNo.equalsIgnoreCase("y") || yesNo.equalsIgnoreCase("yes")){	
			 					System.out.print("Score received on exam 2: ");
			 					Exam2_Score = keyboard.nextInt();
			 					keyboard.nextLine();									
								totalKnownGradeWeight += exam2Weight;
					            currentScoreTop += (exam2Weight * Exam2_Score);
			 					System.out.print("Do you know your final exam score? ");
			 					yesNo = keyboard.nextLine();
			 					if(yesNo.equalsIgnoreCase("y") || yesNo.equalsIgnoreCase("yes")){	
			 						System.out.print("Score received on final exam: ");
			 						finalExamScore = keyboard.nextInt();
			 						keyboard.nextLine();				 						
			 						totalKnownGradeWeight += finalExamWeight;
			 						currentScoreTop += (finalExamWeight * finalExamScore);
			 					} 
			 				}
						}
						
						//SCORE AVERAGE
					System.out.print("Do you know your lab average? ");
						yesNo = keyboard.nextLine();
						if(yesNo.equalsIgnoreCase("y") || yesNo.equalsIgnoreCase("yes")){	
 							System.out.print("Average lab grade: ");
 							LabScore = keyboard.nextInt(); 
 							keyboard.nextLine();							
 							totalKnownGradeWeight += labsWeight;
 				            currentScoreTop += (labsWeight * LabScore);
						}			
					System.out.print("Do you know your project average? ");
					yesNo = keyboard.nextLine();
						if(yesNo.equalsIgnoreCase("y") || yesNo.equalsIgnoreCase("yes")){	
							System.out.print("Average project grade: ");
							projectScore = keyboard.nextInt(); 
 							keyboard.nextLine();
 							
 							totalKnownGradeWeight += projectsWeight;
 				            currentScoreTop += (projectsWeight * projectScore);				      
						}
					System.out.print("Do you know your participation average? ");
					yesNo = keyboard.nextLine();
						if(yesNo.equalsIgnoreCase("y") || yesNo.equalsIgnoreCase("yes")){	
							System.out.print("Average participation grade: ");
							participationScore = keyboard.nextInt(); 
 							keyboard.nextLine();							
 				            totalKnownGradeWeight += participationWeight;
 				            currentScoreTop += (participationWeight * participationScore);				            
						}
					System.out.print("Do you know your quiz average? ");
					yesNo = keyboard.nextLine();
						if(yesNo.equalsIgnoreCase("y") || yesNo.equalsIgnoreCase("yes")){	
							System.out.print("Average quiz grade: ");
							quizScore = keyboard.nextInt(); 
 							keyboard.nextLine(); 							
 				            totalKnownGradeWeight += quizzesWeight;
 				            currentScoreTop += (quizzesWeight * quizScore);	            
						} 	
					keyboard.close(); //scanner closed
				    currentScore = (currentScoreTop / totalKnownGradeWeight);
				    avgToFinalLetterGrade = ((100 * finalOverallScore - currentScoreTop))/(100 - totalKnownGradeWeight);
				    System.out.printf("Current grade score: %.2f\n", currentScore);										
				    if (currentScore >= 90 && currentScore <= 100 ){
				    	System.out.println("Your current letter grade: A");
				    } else if (currentScore >= 80 && currentScore < 90 ){
				    	System.out.println("Your current letter grade: B");
				    } else if (currentScore >= 70 && currentScore < 80 ){
				        System.out.println("Your current letter grade: C");
				    } else if (currentScore >= 60 && currentScore < 70 ){
				    	System.out.println("Your current letter grade: D");
				    } else if (currentScore < 60 ){
				        System.out.println("Your current letter grade: F");
				    } 						    
				    if (currentScore < finalOverallScore && avgToFinalLetterGrade >= 0 && avgToFinalLetterGrade <= 100){
				    	System.out.println("In order to receive a grade of " + letterGrade);
				    	System.out.printf("you need to score an average greater than\nor equal to %.2f" + " in the rest of the grade items.", avgToFinalLetterGrade);
				    } else if (avgToFinalLetterGrade > 100) {
				    	System.out.println("Unfortunately, a grade of " + letterGrade + " is not possible.");
				    } else {
				    	if (totalKnownGradeWeight == 100) {
				    		System.out.println("Congratulations! You received the " + letterGrade + " that you wanted!");
				    	} else { 
				    		System.out.println("You will receive at least a grade of " + letterGrade + ".");
				    	}
				    }
				    
					} else { 
						System.out.println("Weights don’t add up to 100, program exiting...");
						System.exit(0);
					} 				
	}
}