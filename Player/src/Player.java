/*
 * [Player].java
 * Author:  [Umair Irshad / Rebekah Won] 
 * Submission Date:  [APR 21 2023]
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
public class Player {
	
	private Lamp lamp;
	private Key KeyForChest;
	private int x, y;
	private int X_cord;
	private int Y_cord;
	
	public Player (Map m) {
		if (m.getRoom(0,0).canGoEast()) {
			//X_cord = 4;
			//Y_cord = 4;
		
			
		}
		else {
			X_cord = 1;
			Y_cord = 1;
		
					
		}
	}
	//get + set Lamp
	public Lamp getLamp() {
		return lamp;
	}
	public void setLamp(Lamp lamp) {
		this.lamp = lamp;
	}
	//get + set Key
	public Key getKey() {
		return KeyForChest;
	}
	public void setKey(Key KeyForChest) {
		this.KeyForChest = KeyForChest;
	}
	
	//get + set x and y
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
		
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}