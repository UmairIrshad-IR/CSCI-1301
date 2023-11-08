//*******************************************************
// Circle.java
//
// 

/*
 * [ClassifyMessage].java
 * Author:  [Umair Irshad] 
 * Submission Date:  [3/07/2023]
 *
 * Purpose: In this program we define basic classes and method structures that we use using the circleTester file.
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
 *///*******************************************************
public class Circle {

	private String name;      // declare the private String instance  name
	private double radius;       // declare the private double instance  radius
	private double x;         // declare the private double instance  x
	private double y;        // declare the private double instance  y



	//Used to compare doubles.  Remember, don't compare doubles directly using ==
	public static final double THRESHOLD = 0.000000001;


	//----------------------------------------------
	// getName - returns the value of name
	//----------------------------------------------
	public String getName() {
		return name;
		// Your code goes here	
	}

	//----------------------------------------------
	// getX - returns the value of x
	//----------------------------------------------
	public double getX() {
		return x;

	}


	//----------------------------------------------
	// getY - returns the value of y
	//----------------------------------------------
	public double getY() {
		return y;
	}

	//----------------------------------------------
	// getRadius - returns the value of radius
	//----------------------------------------------
	public double getRadius() {
		return radius;
	}

	//----------------------------------------------
	// setName - assigns a new value to name
	//----------------------------------------------
	public void setName(String name) {
		this.name = name;
		// Your code goes here	
	}

	//----------------------------------------------
	// setX - assigns a new value to x
	//----------------------------------------------
	public void setX(double x) {
		this.x = x;
		// Your code goes here	
	}

	//----------------------------------------------
	// setY - assigns a new value to y
	//----------------------------------------------
	public void setY(double y) {
		this.y = y;
		// Your code goes here	
	}


	//----------------------------------------------
	// setRadius - assigns a new value to radius
	//----------------------------------------------
	public void setRadius(double radius) {
		if (radius >= 0.0) {
			this.radius = radius;
		}

	}

	//--------------------------------------------------------
	// area - returns the area of the circle
	//--------------------------------------------------------
	public double area() {
		return Math.PI*radius*radius;
		// Your code goes here	
	}

	//--------------------------------------------------------
	// perimeter - returns the perimeter of the circle
	//--------------------------------------------------------
	public double perimeter() {
		return 2*Math.PI*radius;
		// Your code goes here	
	}

	//--------------------------------------------------------
	// diameter - calculates the diameter of the circle
	//--------------------------------------------------------
	public double diameter() {
		return 2*radius;
		// Your code goes here	
	}


	//--------------------------------------------------------
	// isUnitCircle - return true if the radius of this circle
	//                is 1 and its center is (0,0) and false
	//      	      otherwise.
	//--------------------------------------------------------
	public boolean isUnitCircle() {

		if (Math.abs(radius - 1.0) > 1e-6) {
			return false;
		}

		if (Math.abs(x) > 1e-6 || Math.abs(y) > 1e-6) {
			return false;
		}

		return true;
	}

	//--------------------------------------------------------
	// toString - return a String representation of
	//            this circle in the following format:
	//			  name: name
	//            center:(x,y)
	//            radius: r
	//--------------------------------------------------------
	public String toString() {

		return "name: " + name + "\ncenter:(" + x + "," + y + ")\nradius :" + radius;
	}


	public boolean equals(Circle anotherCircle) {
		return (Math.abs(radius - anotherCircle.getRadius()) < THRESHOLD) &&
				(Math.abs(x - anotherCircle.getX()) < THRESHOLD) &&
				(Math.abs(y - anotherCircle.getY()) < THRESHOLD);
	}


	public double distance(Circle anotherCircle) {
		double xa = anotherCircle.x; 
		double ya = anotherCircle.y; 
		double distance = Math.sqrt(Math.pow(x - xa, 2) + Math.pow(y - ya, 2));
		return distance;
	}

	public boolean isSmaller(Circle anotherCircle) {

		if(this.diameter() < anotherCircle.diameter()) {
			return true;
		}
		else {
			return false;
		}
	}

	public int compareTo(Circle anotherCircle) {

		if(isSmaller(anotherCircle)) {
			return -1;

		} else if (anotherCircle.isSmaller(this)) {
			return 1;

		} else {
			return 0;
		}
	}


	public boolean intersects(Circle anotherCircle) {

		double sumOfRadius = radius + anotherCircle.radius;

		if(distance(anotherCircle) < sumOfRadius) {
			return true;   
		} 
		else{
			return false;
		}
	} 










}
