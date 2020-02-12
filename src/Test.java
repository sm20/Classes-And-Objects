
//REMEMBER NEED TO CALL METHODS LIKE .circumference() before the value will change in the print methods
//classes marked final cannot be subclassed
/*
 SAJID CHOUDHRY
 10063503
 CPSC 233- Assignment 3- 
 L01-T03
 
 
EXTENDED CLASSES PROGRAM (v1.0)
 
 
 
 FEATURES
 
 v1.0
 This program allows a user to create circle and rectangle objects. These objects can then be manipulated to create their origin point, to move their origin point
 , to move their origin points, to set the length and width and/or radius of the objects, to display the current state of any/all objects that have been created
 , as well as to calculate the distance between any two objects. All of this is done through a provided menu through which the user selects various options. Statistics such as
 the length, width, radius, circumference, origin location, and Area are displayed.
 
 The program is limited in that when an object is deleted from the array, its location cannot be filled again until the program is exited and restarted. Also, when option [1] 
 is selected to create an object, option [1],[2], and [3] must be entered by the user twice before the program registers them. This is perhaps due to the need of a
 .nextLine() method somewhere in the program. 
*/

import java.util.Scanner;

public final class Test {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		/**
		 * MAX used for making the shpArray and making sure it does not exceed
		 * 10 elements counter used to assign each new created Shape (either a
		 * rectangle or a Circle) to a value in the shpArray. It is used in the
		 * switch loop
		 */
		int MAX = 10;
		int counter = 0;

		/** Creates an empty array of type 'Shape' with length 10 */
		Shape[] shpArray = new Shape[MAX];

		/**
		 * I created the variable 'quit' to have a false value, so that when the
		 * value of quit is changed to true, then the loop below will exit.
		 */
		boolean quit = false;

		/**
		 * start of the loop that controls everything. While 'not quit'(quit is
		 * equal to false) is true(that is, the value in the brackets is equal
		 * to false, and boolean quit is equal to false, so therefore the value
		 * in the brackets will come out as true), keep running the loop. When
		 * the value of quit is changed to false. when 9 is selected, then the
		 * variable quit becomes 'true' and 'not quit' becomes 'false'. Since
		 * the while loop is now while(false), the loop stops repeating
		 */
		while (!quit) {
			/** runs this menu everytime break is encountered. */
			System.out.println("\n[1]Create a Circle or Rectangle Object"
					+ "\n[2]Set the Origin Point for a Created Object" + "\n[3]Set the Dimensions for any object"
					+ "\n[4]Display the Current State of the Object" + "\n[5]Move an Object a Specified Distance"
					+ "\n[6]Compute and Display the Distance Between Any Two Objects" + "\n[7]Destroy any Object"
					+ "\n[8]List the Current State for all Objects in the Array" + "\n[9]Quit the Program");

			/** takes the choice entered and sets it to the integer choice */
			int choice = sc.nextInt();
			sc.nextLine();

			/** begins loops depending on what the value of choice is */
			switch (choice) {

			case 9: {
				System.out.println("Exiting Program...");
				quit = true;
				break;
			}

				/**
				 * when 1 is selected by user, then they are given the menu
				 * below, where they can create a shape. The menu is reshown
				 * after every user entry
				 */
			case 1: {

				System.out.println(
						"Press [1] to add a circle or [2] to add a rectangle or [3] to return to the main menu");
				int shapeInput = sc.nextInt();
				/**
				 * error checking to make sure value entered is between 1 and 10
				 */
				while (shapeInput < 1 || shapeInput > 3) {
					System.out.println("Enter a valid value");
					shapeInput = sc.nextInt();
				}

				if (shapeInput == 1) {
					/**
					 * counter starts at zero the first time the first time the
					 * program runs. in the index [0], a Circle object is
					 * created if the user has selected 1 the counter++ is then
					 * increased in value to create the next object in the next
					 * index.
					 */
					shpArray[counter] = new Circle();
					counter++;
					System.out.println("Created 1 new Circle object");
					break;
				} else if (shapeInput == 2) {
					shpArray[counter] = new Rectangle();
					counter++;
					System.out.println("Created 1 new Rectangle object");
					break;
				} else if (shapeInput == 3)
					/** option 3 breaks the loop and reshows the menu */
					System.out.println("Returning to Main Menu...");
					break;
			}

				/**
				 * Allows the user to enter a value of an exiting shape and the
				 * program then shows the user the details of that one shape
				 */
			case 4: {
				System.out.println("Choose a Shape between 1-10 to view its details");
				int i = sc.nextInt();
				while (i < 1 || i > 10) {
					System.out.println("Invalid Value, Enter a value between 1 and 10");
					i = sc.nextInt();
				}

				/**
				 * because arrays start at index [0] and not 1, the value
				 * entered by the user needs to be decreased by one. This loop
				 * checks to make sure that the index element under question was
				 * actually created, and isn't empty. If it is empty, the
				 * program moves to the else statement.
				 * 
				 * Printing an object (ex. shpArray[0] might be an object circle from the circle class)
				 *  automatically points to the toString method of that objects 
				 * class (refer to toString method of Circle and rectangle). For ex. printing
				 * an int from the Integer class uses the toString method in the Integer class.
				 */
				if (shpArray[i - 1] != null)
					// prints the details of the element selected
					System.out.println(shpArray[i - 1]);
				else
					System.out.println("There is no Shape stored in that location");

				break;
			}

				/** prints details of all shapes that have been created */
			case 8: {
				System.out.println("\nCurrent State for All objects is as follows:");

				/**
				 * enhanced for loop from notes, iterates through entire array
				 * 'i' here is the entire element. ex. 'i' would be shpArray[0]
				 * for the first one, instead of just being '0'
				 */
				for (Shape i : shpArray) {
					/**
					 * a check so that only created elements are iterated
					 * through. If it is a null, then it is not printed ex of
					 * first one: if(shpArray[0] != null) then go to toString
					 * method of whatever element is in shpArray[0] (which
					 * depends on if it is rectangle or Circle) and print it
					 */
					if (i != null)
						System.out.println(i);
				}
				break;
			}

				/** deletes a selected object */
			case 7: {
				System.out.println("Select an object to delete from 1-10");
				int i = sc.nextInt();
				while (i > 10 || i < 1) {
					System.out.println("Please enter a value between 1 and 10");
					i = sc.nextInt();
				}
				if (shpArray[i - 1] != null) {
					/**
					 * Sets the object the user seleted to null which is the
					 * same as deleting it
					 */
					shpArray[i - 1] = null;
					System.out.printf("Object %d was deleted.", i);
					break;
				} else {
					System.out.println("That item already doesn't exist, nothing was deleted");
					break;
				}
			}

				/** sets the coordinates of the origin */
			case 2: {
				System.out.println("Select a Shape to set the origin for between 1-10");
				int i = sc.nextInt();
				while (i < 1 || i > 10) {
					System.out.println("Please enter a value between 1 and 10");
					i = sc.nextInt();
				}

				if (shpArray[i - 1] != null) {
					System.out.println("Enter a value to set the xCoordinate");
					double j = sc.nextDouble();
					System.out.println("Enter a value to set the yCoordinate");
					double k = sc.nextDouble();

					/**
					 * As opposed to creating a variable and storing shpArray
					 * below in it, we do this directly and in one step.
					 * .setOrigin is the method from the Shape superclass which
					 * is the same for both concrete Circle and Rectangle
					 * classes
					 */
					shpArray[i - 1].setOrigin(j, k);
					;
					System.out.printf("The origin for object %d was set.", (i - 1));
					break;
				} else {
					System.out.println("That item doesn't exist");
					break;
				}

			}

				/**
				 * Sets the dimensions for a selected object
				 * 
				 */
			case 3: {
				System.out.println("Select a Shape to set the dimensions for between 1-10");
				int i = sc.nextInt();
				while (i < 1 || i > 10) {
					System.out.println("Please enter a value between 1 and 10");
					i = sc.nextInt();
				}

				if (shpArray[i - 1] != null) {
					/**
					 * instance of checks to see if that specific element
					 * belongs to the class that follows , in the case below it
					 * checks to see whether it is a Circle or a Rectangle This
					 * is needed because the Rec has dimensions that have L and
					 * W whereas a Cir has dimensions of just a Radius
					 */
					if (shpArray[i - 1] instanceof Rectangle) {
						System.out.println("Enter a value to set the length of the rectangle");
						double j = sc.nextDouble();
						System.out.println("Enter a value to set the width of the rectangle");
						double k = sc.nextDouble();
						/**
						 * This cast from a superclass(Shape) to a subclass
						 * (Rectangle) is needed because 'setLW' is NOT a method
						 * in Shape, it is a method in the subclass Rectangle.
						 * In this step, a varaible is not needed, it is done in
						 * one step, and the method setLW is called in the same
						 * step
						 */
						((Rectangle) shpArray[i - 1]).setLW(j, k);
						System.out.printf("\nThe dimesnsions for the object %d were set.\n", (i - 1));
						break;
					} else if (shpArray[i - 1] instanceof Circle) {
						System.out.println("Enter a value to set the radius of the circle");
						double j = sc.nextDouble();
						((Circle) shpArray[i - 1]).setRad(j);
						System.out.printf("The radius for the object %d was set.", (i - 1));
						break;
					}
				} else {
					System.out.println("That item doesn't exist");
					break;
				}

			}

				/**
				 * Uses the .move method in the Shape superclass to move the x
				 * and y values of the origin of the shape selected by the User
				 */
			case 5: {
				System.out.println("Select a Shape to move between 1-10");
				int i = sc.nextInt();
				while (i < 1 || i > 10) {
					System.out.println("Please enter a value between 1 and 10");
					i = sc.nextInt();
				}
				if (shpArray[i - 1] != null) {
					System.out.println("Enter value by which to move the xCoordinate of the origin");
					double j = sc.nextDouble();
					System.out.println("Enter value by which to move the yCoordinate of the origin");
					double k = sc.nextDouble();
					shpArray[i - 1].move(j, k);
					break;

				} else {
					System.out.println("That item doesn't exist");
					break;
				}
			}

				/**
				 * Asks the user twice to select shapes. It then uses the
				 * distanceShape method in the Shape class to calculate the
				 * distance and then displays the distance
				 */
			case 6: {

				System.out.println("Select the first Shape to calculate the distance for between 1-10");
				int i = sc.nextInt();
				while (i < 1 || i > 10) {
					System.out.println("Please enter a value between 1 and 10");
					i = sc.nextInt();
				}
				System.out.println("Select the second Shape to calculate the distance for between 1-10");
				int j = sc.nextInt();
				while (j < 1 || j > 10) {
					System.out.println("Please enter a value between 1 and 10");
					j = sc.nextInt();
				}

				if ((shpArray[i - 1] != null) & (shpArray[j - 1] != null)) {
					double dist = shpArray[i - 1].shapeDistance(shpArray[j - 1]);
					System.out.printf("The Distance between the two shapes is: %.2f units\n", dist);
					break;
				}

			}

			}

		}

	}
}
