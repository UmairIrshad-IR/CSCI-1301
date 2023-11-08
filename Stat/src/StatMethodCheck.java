
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * A class designed to help students in CSCI 1301 at UGA
 * during their implementation of the Stat class in 
 * the Stat lab. This class uses reflection to examine 
 * the Stat class and checks that methods are properly declared. 
 * Included checks are:
 * -method name
 * -return type
 * -parameters
 * An important note: 
 * 		This class does not test for correct functionality
 * 
 */
public class StatMethodCheck {

	public static void main(String[] args) {
		
		//Constructor objects
		Constructor<Stat> defaultConstructor = null,
						  	dConstructor = null;
		
		/*NOTE: we don't check for the toString method, because whether it's defined 
		or not, it will still exist b/c inherited from Object
		*/
		//Method objects
		Method 
				setDataDouble  = null, //
				getDataMethod  = null, //
				equalsMethod   = null, //
				minMethod      = null, //
				maxMethod      = null, //
				averageMethod  = null, //
				modeMethod     = null; //
		
		//default
		try {
			defaultConstructor = Stat.class.getConstructor();
		} catch (Exception e) {}

		//double[] constructor
		try {
			dConstructor = Stat.class.getConstructor(double[].class);
		} catch (Exception e) {}
		
		
		//////////check for methods\\\\\\\\\\
		
	
		//setData(double[])
		try{
			setDataDouble = Stat.class.getMethod("setData", new Class[] {double[].class});
		} catch (Exception e){}
		
		//getData
		try {
			getDataMethod = Stat.class.getMethod("getData", (Class<?> []) null);
		} catch (NoSuchMethodException e) {}

		//equals
		try {
			equalsMethod = Stat.class.getMethod("equals", new Class[]{Stat.class});
		} catch (NoSuchMethodException e) {}
		
		//min
		try {
			minMethod = Stat.class.getMethod("min", (Class<?> []) null);
		} catch (NoSuchMethodException e) {}
		
		//max
		try {
			maxMethod = Stat.class.getMethod("max", (Class<?> []) null);
		} catch (NoSuchMethodException e) {}
		
		//average
		try {
			averageMethod = Stat.class.getMethod("average", (Class<?> []) null);
		} catch (NoSuchMethodException e) {}
		
		//mode
		try {
			modeMethod = Stat.class.getMethod("mode", (Class<?> []) null);
		} catch (NoSuchMethodException e) {}

		/////////////////// test and printout
		System.out.println("*****   Stat   *****\n");
		checkFields(Stat.class);
		
		/*
		 * Pass the Constructor object along with their string name to the 
		 * testing method
		 */
		testConstructor("Stat()", defaultConstructor);
		testConstructor("Stat(double[])", dConstructor);
		
		/*
		 * Pass the Method object along to the check method along with their 
		 * string name and return type
		 * 
		 * NOTE: a blank file will still pass a toString test because it inherently
		 * exists from Object. For this reason, we don't test for toString
		 */
		
		/*testMethod("methodName", Method object, return type)*/
		testMethod("setData(double[])", setDataDouble, Void.TYPE);
		
		testMethod("getData()", getDataMethod, double[].class);
		
		testMethod("equals(Stat)", equalsMethod, Boolean.TYPE);
			
		testMethod("min()", minMethod, Double.TYPE);
		
		testMethod("max()", maxMethod, Double.TYPE);
		
		testMethod("average()", averageMethod, Double.TYPE);
		
		testMethod("mode()", modeMethod, Double.TYPE);
		
	}
	
	

    /**
     * Method for checking if a method is correctly declared in a Stat class
     * @param methodName - the String representation of the method - only used for printing in the test
     * @param method - the Method object that we are testing. Prints an error if the method is null, 
     * which would result from improper spelling or improper parameters. Prints an error if the method
     * has incorrect return type
     * @param type - the return type of the method being testing
     */
    private static void testMethod(String methodName, Method method, java.lang.reflect.Type type){
        System.out.print(methodName + ":\t"); 
        
        System.out.print(addTabs(methodName));
         
        if (method == null) 
            System.out.println("failed\n *incorrect parameters, incorrectly spelled, or non-existent*");
        else if
            (!method.getReturnType().equals(type)) System.out.println("failed\n *incorrect return type*");
        else
            System.out.println("passed");
         
        System.out.println("\n----------------------");
    }
    
    /**
     * Method for testing is a constructor is correctly declared in a Stat class
     * @param constructorName - the String representation of the constructor - only used for printing in the test
     * @param constructor - the Constructor object being tested. If the constructor was positively found the test
     * prints a success, otherwise prints a failure with possible reasons for failing
     */
    private static void testConstructor(String constructorName, Constructor<Stat> constructor){
    	System.out.print(constructorName + ":\t\t");
    	
    	if (constructorName.length() < 7) System.out.print("\t");
        
        if (constructor == null)
        	System.out.println("failed\n *incorrect parameters, incorrectly spelled, or non-existent*");
        else
            System.out.println("passed");
         
        System.out.println("\n----------------------");
    }
    /**
     * This is just to help the formatting of the printing
     */
    private static String addTabs(String s){
    	if (s.equals("getData()") || s.equals("equals(Stat)") || s.equals("reset()") 
    			|| s.equals("append(int[])")|| s.equals("isEmpty()")
    			|| s.equals("average()") || s.equals("variance()") || s.equals("setData(int[])")
    			 || s.equals("append(long[])") || s.equals("stdDev()") )
    		return "\t";
    	
    	else if (s.equals("min()") || s.equals("max()") || s.equals("mode()")) 
    			return "\t\t";
    	
    	else return "";
    }
    /**
     * A method to check all the instance variables of a class to see if they 
     * correspond to the given UML
     * @param clazz - the class to check; will always be Stat in this case
     */
    private static void checkFields(Class<?> clazz){
    	System.out.println(clazz.getSimpleName() + " instance variables:");
    	//array of all Fields in the class
    	Field[] fields = clazz.getDeclaredFields();
    	//2 ArrayLists to hold the types of the Fields and the names of the Fields
		List<Class<?>> fieldTypes = new ArrayList<Class<?>>();
		List<String> fieldNames = new ArrayList<String>();
		
		//populate both ArrayLists
		for (Field f : fields){
			//System.out.println(f.getName() + ": " + f.getType());
			fieldTypes.add(f.getType());
			fieldNames.add(f.getName());
		}
		boolean data = false;
		
		System.out.print("double[] data\t\t");
		try{
			
			if (fieldTypes.get(fieldNames.indexOf("data")).equals(double[].class)){
				System.out.println("passed");
				data = true;
			} else System.out.println("failed");
				
		}catch(Exception e){
			System.out.println("failed");
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
		
		//if the variable data exists and there is another variable created
		if (data && fields.length > 1){
			System.err.println("You should not declare any more instance variables other than double[] data.");
			System.exit(0);
		}
		
    }
}
