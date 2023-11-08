/*
 * [FindTheSums].java
 * Author:  [Umair Irshad] 
 * Submission Date:  [04/27/2023]
 *
 *
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course web-page
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
public class FindTheSums {
	
	public static String arrayToString(int[][] a) { // Array to string
	    String result = "";
	    for (int i = 0; i < a.length; i++) {
	        for (int j = 0; j < a[i].length; j++) {
	            result += a[i][j];
	            if (j < a[i].length - 1) {
	                result += " ";
	            }
	        }
	        if (i < a.length - 1) {
	            result += "\n";
	        }
	    }
	    return result;
	}


	public static int[][] horizontalSums(int[][] a, int sumToFind) { // horizontal summation
		int[][] array = new int[a.length][a[0].length];
		for (int row = 0; row < a.length; row++) { 
			for (int column = 0; column < a[0].length; column++) { 
				int sum = 0;
				int counter = 0;
				for (int i = column; i < a[0].length; i++) {
					if (sum < sumToFind) {
						sum += a[row][i]; 
						counter++;
					}
				}
				if (sum == sumToFind) { 
					for (int j = 0; j < counter; j++) {
						array[row][column + j] = a[row][column + j];
					}
				}
			} 
		} 
		return array;
	} 
	

	public static int[][] verticalSums(int[][] a, int sumToFind) { // vertical summation
		int[][] array = new int[a.length][a[0].length];
		for (int column = 0; column < a.length; column++) { 
			for (int row = 0; row < a.length; row++) { 
				int sum = 0;
				int counter = 0;
				for (int i = row; i < a.length; i++) {
					if (sum < sumToFind) {
						sum += a[i][column]; 
						counter++;
					}
				}
				if (sum == sumToFind) { 
					for (int j = 0; j < counter; j++) {
						array[row + j][column] = a[row + j][column];
					}
				} 
			} 
		} 
		return array;
	}
}
	
