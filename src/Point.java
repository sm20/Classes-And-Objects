
import java.lang.Math;

/** Class that Shape gets most of its methods from */
public class Point {

	/** Instance variables */
	private double xCoordinate;
	private double yCoordinate;

	/** Class variables */
	private static double distance;
	private static int activeInstances = 0;

	private static int count = 0;
	private int ID = 1;

	/**
	 * First constructor that allows the user to specify the x and y coordinates
	 */
	public Point(double x, double y) {
		/** increases count BEFORE assigning it to ID */
		ID = ++count;

		xCoordinate = x;
		yCoordinate = y;

		activeInstances++;

	}

	/** printing method to display the original three coordinates */
	public void somePrint() {
		System.out.printf("     *You entered the point: (%.3f,%.3f) with ID: %d*\n\n\n", xCoordinate, yCoordinate,
				count);
	}

	/** Second constructor that initiates the x and y coordinates to 0.0 */
	public Point() {
		xCoordinate = 0;
		yCoordinate = 0;

		activeInstances++;
		ID = ++count;
	}

	/**
	 * Instance setter methods to set the values for the x, the y, and the x and
	 * y coordinates.
	 */
	public void setX(double xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public void setY(double yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public void setXY(double xCoordinate, double yCoordinate) {
		setX(xCoordinate);
		setY(yCoordinate);
	}

	/**
	 * Instance getter methods to get teh values for the x, and the y
	 * coordinates
	 */
	public double getX() {
		return xCoordinate;
	}

	public double getY() {
		return yCoordinate;
	}

	/**
	 * a move instance method to shift the original coordinates by a user
	 * inputed amount.
	 */
	public void move(double mX, double mY) {
		xCoordinate = xCoordinate + mX;
		yCoordinate = yCoordinate + mY;

	}

	/**
	 * a distance instance method to find the distance between a point and the
	 * origin
	 */
	public double distance(double pointTwoX, double pointTwoY) {
		distance = Math.sqrt((Math.pow((pointTwoX - xCoordinate), 2)) + (Math.pow((pointTwoY - yCoordinate), 2)));
		return distance;
	}

	/**
	 * an instance toString method for displaying the coordinates of the points
	 * entered
	 */

	public String toString() {
		return String.format("Coordinates for set  %d: (%.3f,%.3f)", ID, xCoordinate, yCoordinate);
	}

	/** getID method */
	public int getID() {
		return ID;
	}

	/** A class method to return the number of active instances. */
	public static int activeInstances() {
		return activeInstances;
	}

	/**
	 * A class distance method to calculate the distance when 2 different points
	 * are entered
	 */
	public static double distance(double xCo, double yCo, double newX, double newY) {
		distance = Math.sqrt((Math.pow((newX - xCo), 2)) + (Math.pow((newY - yCo), 2)));
		return distance;
	}

	/** Calculates the average for a specified set */
	public double avgPoint(double x1, double x2, double x3) {

		double avgPt;

		avgPt = (x1 + x2 + x3) / 3;

		return avgPt;

	}

	/**
	 * This method is from The Java Programming Language 3rd Ed., by Arnold,
	 * Gosling and Holmes, published by Addison-Wesley in 2000. This method is
	 * found on page 319. Garbage collector method
	 */

	public static void fullGC() {
		Runtime rt = Runtime.getRuntime();
		long isFree = rt.freeMemory();
		long wasFree;
		do {
			wasFree = isFree;
			rt.runFinalization();
			rt.gc();
			isFree = rt.freeMemory();
			/**
			 * This line was added by me because when this garbage colelctor
			 * method is called, we need to reduce the number of activeInstances
			 * by the number of objects garbage collected.
			 */
			activeInstances--;
		} while (isFree > wasFree);
	}
}
