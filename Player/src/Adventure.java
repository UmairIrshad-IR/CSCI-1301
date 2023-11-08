/*
 * [Adventure].java
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
import java.util.Scanner; 

public class Adventure {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		// declaring variables
		Map map = new Map();
		Player player = new Player(map);
		Chest chest = new Chest();
		Lamp lamp = new Lamp();

		Room room = map.getRoom(0, 0);
		boolean exit = false;
		boolean win = false;
		String command;

		System.out.println("Welcome to UGA Adventures: Episode I\n"
				+ "The Adventure of the Cave of Redundancy Adventure\n" + "By: Umair Irshad and Rebekah Won\n");

		System.out.println(room.getDescription());

		while (exit != true && win != true){
			
			command = keyboard.nextLine();
			
			//equips lamp
			if (command.equalsIgnoreCase("get lamp")) 
			{
				if (room.getLamp() != null) {
					player.setLamp(lamp);
					room.clearLamp();
					System.out.println("OK");
				} 
				else {
					System.out.println("No lamp present");
				}
			} 
			// turns lamp on
			else if (command.equalsIgnoreCase("light lamp")) {
				if (player.getLamp() != null) {
					lamp.setlightOn(true);
					System.out.println("OK");
				} 
				else {//cant light lamp
					System.out.println("You don't have the lamp to light");

				}
			} 
			
			else if (command.equalsIgnoreCase("north")) {
				if (room.isDark() != false
						&& (player.getLamp() == null || player.getLamp() != null && lamp.getlightOn() == false)) {
					System.out.println("You have stumbled into a passing grue, and have been eaten");
					exit = true;
				} 
				else {
					if (room.canGoNorth() == true) {//allows user to go north
						player.setX(player.getX() - 1);
						room = map.getRoom(player.getX(), player.getY());
						if (room.isDark() == true && (player.getLamp() == null
								|| (player.getLamp() != null && lamp.getlightOn() == false))) {
							System.out
									.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
						} 
						else {
							room = map.getRoom(player.getX(), player.getY());
							System.out.println(room.getDescription());
						}
					}
					else {//user not allowed to go north
						System.out.println("Can't go that way");
					}

				}
			} 
			else if (command.equalsIgnoreCase("south")) {
				if (room.isDark() == true
						&& (player.getLamp() == null || player.getLamp() != null && lamp.getlightOn() == false)) {
					System.out.println("You have stumbled into a passing grue, and have been eaten");
					exit = true;
				} 
				else {
					if (room.canGoSouth() == true) {//allows user to go south
						player.setX(player.getX() + 1);
						room = map.getRoom(player.getX(), player.getY());
						if (room.isDark() == true && (player.getLamp() == null
								|| (player.getLamp() != null && lamp.getlightOn() == false))) {
							System.out
									.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
						} else {
							room = map.getRoom(player.getX(), player.getY());
							System.out.println(room.getDescription());
						}
					} else {//user not allowed to go south
						System.out.println("Can't go that way");
					}

				}
			} 
			else if (command.equalsIgnoreCase("east")) {
				if (room.isDark() == true
						&& (player.getLamp() == null || player.getLamp() != null && lamp.getlightOn() == false)) {
					System.out.println("You have stumbled into a passing grue, and have been eaten");
					exit = true;
				} 
				else {
					if (room.canGoEast() == true) {//allows user to go east
						player.setY(player.getY() + 1);
						room = map.getRoom(player.getX(), player.getY());
						if (room.isDark() == true && (player.getLamp() == null
								|| (player.getLamp() != null && lamp.getlightOn() == false))) {
							System.out
									.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
						} 
						else {
							room = map.getRoom(player.getX(), player.getY());
							System.out.println(room.getDescription());
						}
					} 
					else {//user not allowed to go east
						System.out.println("Can't go that way");
					}

				}

			} 
			else if (command.equalsIgnoreCase("west")) { //allows user to go west
				if (room.isDark() == true
						&& (player.getLamp() == null || player.getLamp() != null && lamp.getlightOn() == false)) {
					System.out.println("You have stumbled into a passing grue, and have been eaten");
					exit = true; // user dies
				} 
				else {
					if (room.canGoWest() == true) {
						player.setY(player.getY() - 1);
						room = map.getRoom(player.getX(), player.getY());
						if (room.isDark() == true && (player.getLamp() == null
								|| (player.getLamp() != null && lamp.getlightOn() == false))) {
							System.out
									.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
						} 
						else {
							room = map.getRoom(player.getX(), player.getY());
							System.out.println(room.getDescription());
						}
					} 
					else {//user not allowed to go west
						System.out.println("Can't go that way");
					}

				}
			} 
			else if (command.equalsIgnoreCase("look")) {
				if (room.isDark() == true
						&& (player.getLamp() == null || (player.getLamp() != null && lamp.getlightOn() == false))) {
					System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
				} 
				else {
					System.out.println(room.getDescription()); //room description
					if (room.getLamp() != null) {
						System.out.println("There is an old oil lamp here that was made long ago");
					}
					if (room.getKey() != null) {
						System.out.println("You see the outline of a key on a dusty shelf that's covered in dust.");
					}
					if (room.getChest() != null) {
						System.out.println(
								"There is a large, wooden, massive, oaken chest here with the word “CHEST” carved into it");
					}
					
					//EXITS
					System.out.print("Exits are: ");
					if (room.canGoNorth() == true) {
						System.out.println("north");
					}
					if (room.canGoSouth() == true) {
						System.out.println("south");
					}
					if (room.canGoEast() == true) {
						System.out.println("east");
					}
					if (room.canGoWest() == true) {
						System.out.println("west");
					}
				}
			} 
			else if (command.equalsIgnoreCase("get key")) { //Player equips key
				if (room.getKey() != null) {
					player.setKey(map.getRoom(player.getX(), player.getY()).getKey());
					room.clearKey();
					System.out.println("OK");

				} 
				else { //key not available 
					System.out.println("No key present");
				}
			} 
			else if (command.equalsIgnoreCase("open chest")) { // command to open chest
				if (room.getChest() != null && !(map.getRoom(player.getX(), player.getX()).getChest().isLocked())) {
					System.out.println(room.getChest().getContents());
					win = true;
				} 
				else if (room.getChest() == null) { // chest no present
					System.out.println("No chest present");
				} 
				else if (chest.isLocked() == true) {// Chest locked
					System.out.println("The chest is locked");
				}
			}
			else if (command.equalsIgnoreCase("unlock chest")) {
				if (player.getKey() != null && room.getChest() != null) {
					player.getKey().use(map.getRoom(player.getX(), player.getY()).getChest());
					System.out.println("OK");
				} 
				else if (player.getKey() == null) {//key required to unlock chest
					System.out.println("Need a key to do any unlocking");
				} 
				else if (room.getChest() == null) {// chest no present
					System.out.println("No chest to unlock");
				}
			} 
			else {
				System.out.println("I'm sorry, I don't know how to do that");
			}
		}
		keyboard.close();
	}

} //end of Adventure