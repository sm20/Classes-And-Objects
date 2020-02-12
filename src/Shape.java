
/**
 * Superclass that creates object that holds a reference to Point, as well as
 * creates outlines for the concrete classes Circle and Rectangle
 */
public class Shape {

	private Point origin;
	private double shapeDistance;

	/**
	 * protected because we are not asked to make a getter method for them so we
	 * need subclasses to be able to access them
	 */
	protected double area, circumference;

	public Shape(double x, double y) {
		/**
		 * 'new' instantiates an object. Usually it is stored in such as 'Point
		 * abc' but, as shown a reference to the object can also be stored in a
		 * variable, in this case, origin. So, origin is storing the instance
		 * variables of the class Point, which can be called upon later for use.
		 * Origin is a 'reference' to the Point object
		 */
		origin = new Point(x, y);
	}

	public Shape() {
		/**
		 * To call one constructor in another, you can use 'this' keyword
		 * followed by the cosntructor parameters for the constructor that you
		 * want to use.
		 */
		this(0, 0);
	}

	public void setOrigin(double x, double y) {
		origin.setXY(x, y);
	}

	/**
	 * returns of type 'Point', similar to if you wanted a return of type int,
	 * double, etc.
	 */
	public Point getOrigin() {
		return origin;
	}

	public void move(double dX, double dY) {
		/**
		 * When Shape.move(5,5) is called, it sets the above parameters to
		 * move(5,5). Then what happens below is, it is set to origin.move(5,5).
		 * Recall, that origin is a 'reference' to a Point object. Now what
		 * happens is the 'move' method from the Point class is called with 'mX'
		 * and 'mY' set to 5 and 5 respectively. This changes the X and Y
		 * coordinates of the Point
		 */
		origin.move(dX, dY);
	}

	public double shapeDistance(Shape newOrigin)// shape passed in as parameter
	{

		/**
		 * shape newOrigin is associating a variable name with an object type.
		 * In the argument, a 'something' of type Shape is needed, such as the s1 in 'Shape s1 = new Shape(3,4)', OR the element 'shpArray[0]'.
		 * These coordinates (3,4) are then stored in newOrigin.
		 * Then newOrigin.origin.getX() is doing the following:
		 * - origin is an object that references to the Point class, so origin.getX() is calling the method from the point class, and
		 * Applying it to the thing passed in, in the argument, which is newOrigin, which is of type shape.
		 * -newOrigin.origin.getX() returns the xCo according to the method in point. Here the coordinate is (3,4), so 4 is returned
		 * -newOrigin.origin.getY() does something similar, returns 4
		 * So, as an ex, the code below for coordinates (3,4) would look like this: this.origin.distance(3, 4)
		 * - this.origin is the first origin created and initialized in the constructors in the Shape class . ex. (1,1)
		 * - the point (1,1) and the point (3,4) have there distance compared in this way
		 * Overall, The distance method is being called from the Point class.
		 */
		shapeDistance = this.origin.distance(newOrigin.origin.getX(), newOrigin.origin.getY());
		return shapeDistance;
	}

	public double area() {
		return area;
	}

	public double circumference() {

		return circumference;
	}

	public String toString() {
		return String.format(" ");
	}
}
