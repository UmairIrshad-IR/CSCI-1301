
import java.util.Scanner;

public class DrawingShapes {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		int length;
		int height;
		String shape;
		String s = "*";

		System.out.println("Enter a shape: r t h o p");
		shape = keyboard.nextLine();

		if (!(shape.equals("r") || shape.equals("t") || shape.equals("h") ||shape.equals("o")||shape.equals("p"))) {
			
			System.out.println("Invalid shape\nGoodbye!");
			System.exit(0);
		}


		if (shape.equals("r")) {

			System.out.println("Enter a length");
			length = keyboard.nextInt();

			if (length>1) {

				System.out.println("Enter a height");
				height = keyboard.nextInt();

				if (height >1) {

					System.out.println("Below is a "+length+" by "+height+ " rectangle of *");

					//Draw a Rectangle

					for (int i = 0; i<height ; i++){
						for (int j = 0; j < length; j++){

							System.out.print(s);
						}

						System.out.println("");
					}

				}


				else {
					System.out.println("Height must be greater than 1\n"+"GoodBye!");
					System.exit(0);
				}
			} 

			else {
				System.out.println("Length must be greater than 1\n" + "Goodbye!");
				System.exit(0);

			}
		}

		//Triangle
		if (shape.equals("t")) {

			System.out.println("Enter a length");
			length = keyboard.nextInt();
			if(length>1) {
				System.out.println("Below is a triangle with two side length of "+length+" *");
				for (int i = 1; i <=length;i++) {
					for (int j = (length - i); j>=1 ; j--) {
						System.out.print("");
					}

					for ( int k = 1; k<=(i * 2)-1 ; k++) {
						System.out.print(s);
					}
					System.out.print("\n");					
				}
			}
			else if (length<1){
				System.out.println("Length must be greater than 1\n" + "Goodbye!");
				System.exit(0);

			}

		}

		//Hexagon
		if (shape.equals("h")) {

			System.out.println("Enter a Length");
			length = keyboard.nextInt();
			if (length>1) {
				System.out.println("Below is a hexagon with side lengths of " + length + " *");
				for(int i=1;i<=length;i++)
	            {
	                for(int j=length-i;j>0;j--)
	                {
	                    System.out.print(" ");
	                }
	                for(int j=0;j<2*i+length-2;j++)
	                {
	                    System.out.print(s);
	                }
	                System.out.println();
	            }
	            for(int i=length-1;i>0;i--)
	            {
	                for(int j=length-i;j>0;j--)
	                {
	                    System.out.print(" ");
	                }
	                for(int j=0;j<2*i+length-2;j++)
	                {
	                    System.out.print(s);
	                }
	                System.out.println();
	            }

			} else {
				System.out.println("Length must be greater than 1\nGoodbye!");
				System.exit(0);
			}
		}

		//Octagon
		if (shape.equals("o")) {

			System.out.println("Enter a length");
			length = keyboard.nextInt();



			if (length <= 1) {

				System.out.println("Length must be greather than 1\nGoodBye!");
			}
			if (length>1) {

				System.out.println("Below is a octagon with side lengths of " + length + " *");

				for(int i=1;i<length;i++)
				{
					for(int j=length-i;j>0;j--)
					{
						System.out.print(" ");
					}
					for(int j=0;j<2*i+length-2;j++)
					{
						System.out.print(s);
					}
					System.out.println();
				}
				for(int i=0;i<length;i++)
				{
					for(int j=0;j<3*length-2;j++)
					{
						System.out.print(s);
					}
					System.out.println();
				}
				for(int i=length-1;i>0;i--)
				{
					for(int j=length-i;j>0;j--)
					{
						System.out.print(" ");
					}
					for(int j=0;j<2*i+length-2;j++)
					{
						System.out.print(s);
					}
					System.out.println();
				}

			}
		}

		if(shape.equals("p")) {
			System.out.println("Enter a length");
			length = keyboard.nextInt();

			if (length <= 1) {

				System.out.println("Length must be greather than 1\nGoodBye!");
			}
			if (length>1) {
				System.out.println("Below is a pentagon with 4 side lengths of "+length+" *");
				for(int i=1;i<length;i++)
				{
					for(int j=length-i;j>0;j--)
					{
						System.out.print(" ");
					}
					for(int j=0;j<2*i-1;j++)
					{
						System.out.print(s);
					}

					System.out.println();
				}
				for(int i=0;i<length;i++)
				{
					for(int j=0;j<2*length-1;j++)
					{
						System.out.print(s);
					}
					System.out.println();
				}


			}




		}


	} 
}





