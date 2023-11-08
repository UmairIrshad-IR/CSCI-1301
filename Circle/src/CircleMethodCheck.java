
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A class designed to help students in CSCI 1301 at UGA
 * during their implementation of the Circle lab. This class
 * uses reflection to examine the Circle class and checks 
 * that methods are properly declared. 
 * Included checks are:
 * -method name
 * -return type
 * -parameters
 * An important note: 
 * 		This class does not test for correct functionality
 * 
 */

@SuppressWarnings("rawtypes")
public class CircleMethodCheck {

	//parameter variables to aid readability
	static Class<?> [] _void = null;
	static Class[] _double = new Class[] {double.class};
	static Class[] _boolean = new Class[] {boolean.class};
	static Class[] _String = new Class[] {String.class};
	static Class[] _Circle = new Class [] {Circle.class};

	public static void main(String[] args){

		//all the methods that should be in Circle, represented by a private class
		MyMethod[] methods = new MyMethod[] {

				//String methodName, Class[] parameters, Type returnType
				new MyMethod("setX", 		_double, Void.TYPE),
				new MyMethod("setName", 	_String, Void.TYPE),
				new MyMethod("setY", 		_double, Void.TYPE),
				new MyMethod("setRadius",	_double, Void.TYPE),

				new MyMethod("getX",		_void, Double.TYPE),
				new MyMethod("getName", 	_void, String.class),
				new MyMethod("getY", 		_void, Double.TYPE),
				new MyMethod("getRadius",	_void, Double.TYPE),

				new MyMethod("diameter",	_void, Double.TYPE),
				new MyMethod("area", 		_void, Double.TYPE),
				new MyMethod("perimeter", 	_void, Double.TYPE),
				new MyMethod("isUnitCircle", _void, Boolean.TYPE),
				
				/*
				 * NOTE: this is unnecessary because toString is inherited
				 * from Object, so it will always be there even if it's not
				 * explicitly declared
				 */
				new MyMethod("toString", 	_void, String.class),

				new MyMethod("intersects", 	_Circle, Boolean.TYPE),
				new MyMethod("equals", 		_Circle, Boolean.TYPE),
				new MyMethod("compareTo", 	_Circle, Integer.TYPE),
				new MyMethod("isSmaller", 	_Circle, Boolean.TYPE),
				new MyMethod("distance", 	_Circle, Double.TYPE),

		};
		
		
		checkFields(Circle.class);			//check the instance variables
			
		
		for (MyMethod m : methods) {		//check the methods

			try {

				/*
				 * If Circle.class.getMethod(...) doesn't throw an exception, then
				 * the method is declared properly and we can check if it has the 
				 * correct return type
				 * 
				 * If an exception is thrown, it means the method is improperly declared
				 * testMethod(...) will perform the output if you pass it a null Method object
				 */
				testMethod(m.methodName, Circle.class.getMethod(m.methodName, m.parameters), m.returnType);

			} catch (NoSuchMethodException e) {

				testMethod(m.methodName, (Method)null, m.returnType);
			}
		}

	}


	/**
	 * Tests a method's return type against the provided correct answer.
	 * If there is an error, attempt to provide a cause 
	 * 
	 * @param methodName - the String representation of the method - only used for printing in the test; needed in case Method object is null
	 * @param method - the Method object that we are testing. Prints an error if the method is null, 
	 * which would result from improper spelling or improper parameters. Prints an error if the method
	 * has incorrect return type
	 * @param type - the return type of the method being testing
	 */
	private static void testMethod(String methodName, Method method, java.lang.reflect.Type type){
		System.out.print(methodName + ":\t"); 

		
		if(methodName.length() < 7) 		//just for looking good
			System.out.print("\t");

		if (method == null) 
			System.out.println("failed\n *incorrect parameters, incorrectly spelled, or non-existent*");
		
		else if ( ! method.getReturnType().equals(type)) 
			System.out.println("failed\n *incorrect return type*");
		
		else 
			System.out.println("passed");

		System.out.println("\n----------------------");
	}

	/**
	 * A method to check all the instance variables of a class to see if they 
	 * correspond to the given UML; checks against a private class that has proper 
	 * variables 
	 * 
	 * @param clazz - the Class to check
	 */
	private static void checkFields(Class<?> clazz){

		System.out.println(clazz.getSimpleName() + " instance variables:");

		for (Field f: Fields.class.getDeclaredFields()) {
			
			if(f.getName().equals("this$0")) continue; //ignore field from private class

			//print the type of the field (shorten java.lang.String to String)
			System.out.print((f.getType().equals(java.lang.String.class)? "String" 
					: f.getType()) + " " + f.getName() + ":\t");

			if (contains(clazz, f)) //check if their class has the field (only type & name are checked)
				System.out.println("passed");
			
			else
				System.out.println("failed");

			System.out.println("~~~~~~~~~~~~~~~~~~~~~~");

		}

		//subtract 1 from clazz's field count to compensate for THRESHOLD variable in Circle
		//subtract 1 from Fields' field count to compensate for private class field
		if (clazz.getDeclaredFields().length - 1 > Fields.class.getDeclaredFields().length - 1 
				&& containsAll(clazz, Fields.class.getDeclaredFields())){

			System.err.print("You should not declare any more instance variables other than ");

			//print all required fields for alert message
			for (Field f : Fields.class.getDeclaredFields()) {
				if(f.getName().equals("this$0")) continue; //ignore field from private class

				System.err.print(f.getName() + " ");
			}
			System.exit(0);
		}

	}





	/**
	 * Search the given class's fields to see if the given field is contained in it
	 * with a shallow comparison: data type & name are all that's checked
	 * @param clazz - the class to search
	 * @param field - the field to search for
	 * @return {@code true} if the field is contained within the class {@code false} otherwise
	 */
	private static boolean contains(Class<?> clazz, Field field) {
		for (Field f : clazz.getDeclaredFields())
			if (fieldsEqual(f,field))
				return true;

		return false;
	}

	/**
	 * Check the given class's fields to see if all fields are contained in it
	 * with a shallow comparison: data type & name are all that's checked
	 * @param clazz - the class to search
	 * @param fields - the fields to search for
	 * @return {@code true} if all the fields are contained within the class {@code false} otherwise
	 */
	private static boolean containsAll(Class<?> clazz, Field[] fields) {
		for (Field f: fields) {
			if(f.getName().equals("this$0")) continue; //ignore field from private class
			if (! contains(clazz,f))
				return false;
		}
		return true;
	}

	/**
	 * Allows us to do a shallow comparison instead of calling .equals
	 * @param field1
	 * @param field2
	 * @return {@code true} if the two fields have the same type and name, {@code false} otherwise
	 */
	private static boolean fieldsEqual(Field field1, Field field2) {
		return field1.getType().equals(field2.getType()) && field1.getName().equals(field2.getName());
	}
	
	/**
	 * Private class to hold all the relevant attributes we need to check for
	 * when checking methods
	 * No need to modify this class
	 */
	static class MyMethod{
		String methodName;
		Class[] parameters;
		java.lang.reflect.Type returnType;

		MyMethod(String methodName, Class[] parameters, Type returnType) {
			this.methodName = methodName;
			this.parameters = parameters;
			this.returnType = returnType;
		}
	}

	/**
	 * Circle class fields are checked against these fields, order doesn't matter
	 * but the fields will print in the order they are declared here, access 
	 * modifiers also don't matter
	 */
	final class Fields{
		String name;       
		double radius;       
		double x;      
		double y;
		//String test;
	}
}