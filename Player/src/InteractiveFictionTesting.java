/*
 * Author: Karen Aguar
 * CSCI 1301
 * 
 * This class runs a variety of tests on the Chest, Lamp, and Player classes.
 * To test a class before others are implemented, simply comment out the methods
 * you have yet to implement and its method call in main.
 * 
 * Though this class tests a variety of functionality, it does not guarantee
 * that your project is correct.
 * 
 */
public class InteractiveFictionTesting {

	public static void main(String[] args) {
		
		boolean passed;
		
		//Test the Chest class
		passed = testChestClass();
		if(!passed) return;
		System.out.println("The Chest class has passed all tests\n");

		//Test the Lamp class
		passed = testLampClass();
		if(!passed) return;
		System.out.println("The Lamp class has passed all tests\n");
	
		
		//Test the Player class
		passed = testPlayerClass();
		if(!passed) return;
		System.out.println("The Player class has passed all tests\n");
		
		System.out.println("You are ready to run your Adventure class!");
		
	}
	
	/**
	 * Tests the Chest class
	 * 
	 * @return boolean true if all the tests pass
	 */
	private static boolean testChestClass() {
		
		//Testing get/set contents
		Chest chest = new Chest();
		chest.setContents("contents");
		if(!(chest.getContents().equals("contents")))
		{
			System.out.println("Chest.java: The getContents() method did not return the expected value");
			return false;
		}
		
		//Testing lock
		Key key = new Key();
		chest.lock(key);
		if(!chest.isLocked())
		{
			System.out.println("Chest.java: the isLocked() method did not return the expected value after locking");
			return false;
		}
		
		//Testing unlock
		chest.unLock(key);
		if(chest.isLocked())
		{
			System.out.println("Chest.java: the isLocked() method did not return the expected value after unlocking");
			return false;
		}	
		return true; //if all passed
	}
	
	/**
	 * Tests the Lamp class
	 * 
	 * @return boolean true if all the tests pass
	 */
	private static boolean testLampClass() {
		
		//Test set/get Lamp when lighting
		Lamp lamp = new Lamp();
		lamp.setIsLit(true);
		if(!lamp.getIsLit())
		{
			System.out.println("Lamp.java: the getIsLit() method did not return the expected value after lighting");
			return false;
		}
		
		//Test set/get Lamp when darkening
		lamp.setIsLit(false);
		if(lamp.getIsLit())
		{
			System.out.println("Lamp.java: the getIsLit() method did not return the expected value after darkening");
			return false;
		}
		
		return true; //if all passed
	}
	
	/**
	 * Tests the Player class
	 * 
	 * @return boolean true if all the tests pass
	 */
	private static boolean testPlayerClass() {
		
		//Testing set/get X and Y
		Player player = new Player();
		player.setX(0);
		player.setY(0);
		
		if(player.getX()!=0 || player.getY()!=0)
		{
			System.out.println("Player.java: the getX() or getY() method did not return the expected value after setting X and Y.");
			System.out.println("Expected: 0,0 \nActual: "+ player.getX() + "," + player.getY());
			return false;
		}
		
		//Testing getRoom() method with getX() and getY() as coordinates
		Map map = new Map();
		Room firstRoom = map.getRoom(0,0);
		Room playersRoom = map.getRoom(player.getX(), player.getY());
		if(firstRoom != playersRoom)
		{
			System.out.println("Player.java: the getRoom() method of the Map class did not return the correct room");
			return false;
		}
		
		
		//Testing init. values of lamp & key are null
		if(player.getLamp()!=null)
		{
			System.out.println("Player.java: Your Lamp object should initially be null");
			return false;
		}
		
		if(player.getKey()!=null)
		{
			System.out.println("Player.java: Your Key object should initially be null");
			return false;
		}
		
		//Testing set/get Lamp
		Lamp lamp = new Lamp();
		player.setLamp(lamp);
		if(player.getLamp() != lamp)
		{
			System.out.println("Player.java: the getLamp() method did not return the expected value.");
			return false;
		}
		
		//Testing set/get Key
		Key key = new Key();
		player.setKey(key);
		if(player.getKey() != key)
		{
			System.out.println("Player.java: the getKey() method did not return the expected value.");
			return false;
		}

		return true; //if all passed
	}
}
