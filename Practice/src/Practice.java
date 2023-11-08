/*
* [RockPaperScissors].java
* Author: [Zhizheng Wang]
* Statement of Academic Honesty: *
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied
* or modified code from anywhere other than the authorized
* sources. I recognize that any unauthorized sharing, assistance,
* or plagiarism will be handled in accordance with both the
* University of Georgia's Academic Honesty Policy and the
* policies of this course. I recognize that my work is based on
* an assignment created by the Department of Computer
* Science at the University of Georgia. Any publishing or posting
* of source code at any time for this project is prohibited. */

import java.util.Scanner; 
public class Practice {

	public static void main(String[] args) {
		// import Scanner
		Scanner stdin = new Scanner(System.in);
		// declare variables
		int wins;
		int userPoints = 0;
		int computerPoints = 0;
		String userMove;
		String computerMove = ComputerOpponent.getMove();

		System.out.print("Points to win: ");
		wins = stdin.nextInt();
		stdin.nextLine();
		while (userPoints < wins && computerPoints < wins) {
			computerMove = ComputerOpponent.getMove();
			System.out.print("Rock, paper, or scissors? ");
			userMove = stdin.nextLine();
			userMove = userMove.trim(); // trim user input 
				if(userMove.equalsIgnoreCase(computerMove)) { // tie 
					System.out.println ("The computer chose " + computerMove + ", so it's a tie. " + "(" + userPoints + "-" + computerPoints + ")");	
				} else if (userMove.equalsIgnoreCase("Rock")){
					if (computerMove.equalsIgnoreCase("Scissors")){
						userPoints += 1; // add points for user 
						System.out.println("The computer chose " + computerMove + ", so you win! " + "(" + userPoints + "-" + computerPoints + ")");
					} else {
						computerPoints += 1; // add points for computer 
						System.out.println("The computer chose " + computerMove + ", so you lose. " + "(" + userPoints + "-" + computerPoints + ")");
					}
				} else if (userMove.equalsIgnoreCase("Paper")){
					if (computerMove.equalsIgnoreCase("Rock")){
						userPoints += 1; 
						System.out.println("The computer chose " + computerMove + ", so you win! " + "(" + userPoints + "-" + computerPoints + ")");
					} else {
						computerPoints += 1; 
						System.out.println("The computer chose " + computerMove + ", so you lose. " + "(" + userPoints + "-" + computerPoints + ")");
					}
				} else if (userMove.equalsIgnoreCase("Scissors")){
					if (computerMove.equalsIgnoreCase("Paper")){
						userPoints += 1;
						System.out.println("The computer chose " + computerMove + ", so you win! " + "(" + userPoints + "-" + computerPoints + ")");
					} else {
						computerPoints += 1;
						System.out.println("The computer chose " + computerMove + ", so you lose. " + "(" + userPoints + "-" + computerPoints + ")");
					}
				} else {
					System.out.println("Invalid Input Try Again.");
				}
		} // end of while loop (wins)
		stdin.close();
		if (userPoints == wins) { // if user wins 
			System.out.println("Congratulations! You won!");
		} else { // if user lose 
		System.out.println("Sorry, you lost. Better luck next time!");
		}

	} // end class main

} // end of class RockPaperScissors 