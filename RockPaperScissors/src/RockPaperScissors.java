/*
 * [RockPaperScissors].java
 * Author:  [Umair irshad] 
 * Submission Date:  [Mar 17 2023]
 *
 * Purpose: It is a game of Rock Paper Scissors against the computer.
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

public class RockPaperScissors {

    public static void main(String[] args) {

        // required variables
        int pointsToWin;
        Scanner keyboard = new Scanner(System.in);
        String playerMove = "";
        String computerMove;
        int playerPoints = 0;
        int computerPoints = 0;

        // ask user to enter points for a win
        System.out.print("Points to win: ");
        pointsToWin = keyboard.nextInt();

        // while loop until computer or user wins the games first
        while (playerPoints != pointsToWin && computerPoints != pointsToWin) {
            // ask to enter Rock, paper or scissors
           
            
        	while (playerPoints!= pointsToWin && computerPoints!= pointsToWin)
    		{
    	
    			
    			boolean proper= false;
    			while (!proper) {
    				System.out.print("Rock, paper, or scissors?");
    				playerMove = keyboard.next();
    				
    				if (playerMove.equalsIgnoreCase("rock") ||playerMove.equalsIgnoreCase("paper") 
    						|| playerMove.equalsIgnoreCase("scissors"))
    					proper = true;
    				else 
    					proper = false;
    			}
    				

            

            // call computer move
            computerMove = ComputerOpponent.getMove();

            if (playerMove.equalsIgnoreCase("rock") && computerMove.equalsIgnoreCase("paper")) {
                computerPoints = computerPoints + 1;
                
                System.out.println( ", so you lose. (" + playerPoints + "-" + computerPoints + ")");
            }
                
            else if (playerMove.equalsIgnoreCase("rock") && computerMove.equalsIgnoreCase("scissors")) {
                playerPoints = playerPoints + 1;
                System.out.println(", so you win! (" + playerPoints + "-" + computerPoints + ")");
            }
            else if (playerMove.equalsIgnoreCase("rock") && computerMove.equalsIgnoreCase("rock")) {
                System.out.println(", so it's a tie. (" + playerPoints + "-" + computerPoints + ")");
            }
            else if (playerMove.equalsIgnoreCase("paper") && computerMove.equalsIgnoreCase("paper")) {
                System.out.println(", so it's a tie. (" + playerPoints + "-" + computerPoints + ")");
            }
            else if (playerMove.equalsIgnoreCase("paper") && computerMove.equalsIgnoreCase("scissors")) {
                computerPoints = computerPoints + 1;
                System.out.println( ", so you lose. (" + playerPoints + "-" + computerPoints + ")");
            }
            else if (playerMove.equalsIgnoreCase("paper") && computerMove.equalsIgnoreCase("rock")) {
                playerPoints = playerPoints + 1;
                System.out.println(", so you win! (" + playerPoints + "-" + computerPoints + ")");
            }
            else if (playerMove.equalsIgnoreCase("scissors") && computerMove.equalsIgnoreCase("paper")) {
                playerPoints = playerPoints + 1;
                System.out.println(", so you win! (" + playerPoints
                        + "-" + computerPoints + ")");
            }
            else if (playerMove.equalsIgnoreCase("scissors") && computerMove.equalsIgnoreCase("scissors")) {
                System.out.println(", so it's a tie. (" + playerPoints + "-" + computerPoints + ")");
            }
            else if (playerMove.equalsIgnoreCase("scissors") && computerMove.equalsIgnoreCase("rock")) {
                computerPoints = computerPoints + 1;
                System.out.println(", so you lose. (" + playerPoints + "-" + computerPoints + ")");
            }
            // if user input is not correct
            else {
                //System.out.println("Rock, paper, or scissors?");
            }

        }
        // if user won the game
        if (playerPoints == pointsToWin) {
            System.out.println("Congratulations! You won!");
        }
        // otherwise
        else {
            System.out.println("Sorry, You lost. Better luck next time!");
        }
    }
}}
